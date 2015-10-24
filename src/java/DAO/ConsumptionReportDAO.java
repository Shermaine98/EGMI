package DAO;

import Database.DBConnectionFactory;
import Model.ConsumptionReport;
import java.awt.Dimension;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class ConsumptionReportDAO {

    public boolean EncodeConsumptionReport(ConsumptionReport newConsumptionReport) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into consumption_report"
                    + "(productionNumber, productID, sizeName, sizeType, itemCode, sizeVolumeQty, dateMade, preparedBy)"
                    + " values (?,?,?,?,?,?,?,?) ";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newConsumptionReport.getProductionNumber());
            pstmt.setInt(2, newConsumptionReport.getProductID());
            pstmt.setString(3, newConsumptionReport.getSizeName());
            pstmt.setString(4, newConsumptionReport.getSizeType());
            pstmt.setInt(5, newConsumptionReport.getItemCode());
            pstmt.setInt(6, newConsumptionReport.getVolumeQty());
            pstmt.setDate(7, newConsumptionReport.getDateMade());
            pstmt.setInt(8, newConsumptionReport.getPreparedBy());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ConsumptionReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<ConsumptionReport> GetConsumptionReportList(int productionNumber) throws ParseException {

        ArrayList<ConsumptionReport> ConsumptionReport = new ArrayList<ConsumptionReport>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT cr.productionNumber, cr.productID, bm.productName, cr.sizeType, cr.itemCode, cr.sizeName, cr.sizeVolumeQty, cr.preparedBy, cr.dateMade\n"
                    + "FROM consumption_report cr JOIN bill_of_materials bm ON cr.productID=bm.productID  where cr.productionNumber =" + productionNumber + "\n"
                    + "Order by cr.productID;");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                ConsumptionReport temp = new ConsumptionReport();
                temp.setProductionNumber(rs.getInt("productionNumber"));
                temp.setProductName(rs.getString("productName"));
                temp.setProductID(rs.getInt("productID"));
                temp.setSizeName(rs.getString("sizeName"));
                temp.setSizeType(rs.getString("sizeType"));
                temp.setItemCode(rs.getInt("itemCode"));
                temp.setVolumeQty(rs.getInt("sizeVolumeQty"));
                temp.setDateMade(rs.getDate("dateMade"));
                temp.setPreparedBy(rs.getInt("preparedBy"));
                ConsumptionReport.add(temp);
            }
            pstmt.close();
            conn.close();

            return ConsumptionReport;
        } catch (SQLException ex) {
            Logger.getLogger(ConsumptionReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<ConsumptionReport> GetConsumptionReportListGroupBy() throws ParseException {

        ArrayList<ConsumptionReport> ConsumptionReport = new ArrayList<ConsumptionReport>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT cr.productionNumber, cr.productID, cr.sizeName,cr.dateMade, cr.preparedBy\n"
                    + "FROM consumption_report cr\n"
                    + "Group By cr.productionNumber;");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                ConsumptionReport temp = new ConsumptionReport();
                temp.setProductionNumber(rs.getInt("productionNumber"));
                temp.setProductID(rs.getInt("productID"));
                temp.setSizeName(rs.getString("sizeName"));
                temp.setDateMade(rs.getDate("dateMade"));
                temp.setPreparedBy(rs.getInt("preparedBy"));
                ConsumptionReport.add(temp);
            }
            pstmt.close();
            conn.close();

            return ConsumptionReport;
        } catch (SQLException ex) {
            Logger.getLogger(ConsumptionReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer getProductionNumber() throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();
        Integer i = 0;
        String query = "SELECT MAX(productionNumber) from consumption_report";
        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            i = rs.getInt("MAX(productionNumber)");
        }
        if (i == 0) {
            i = 300000000;
        } else if (i == 399999999) {
            i = -1;
        } else {
            i += 1;
        }

        rs.close();
        return i;
    }

    public ArrayList<ConsumptionReport> searchProductName(String productName) throws ParseException {

        ArrayList<ConsumptionReport> ConsumptionReport = new ArrayList<ConsumptionReport>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            String search = productName + "%";
            PreparedStatement pstmt = conn.prepareStatement("SELECT cr.productionNumber, cr.productID, bm.productName, cr.sizeType, cr.itemCode, cr.sizeName, cr.sizeVolumeQty, cr.preparedBy, cr.dateMade\n"
                    + "FROM consumption_report cr JOIN bill_of_materials bm ON cr.productID=bm.productID  where bm.productName LIKE ? Order by cr.productID;");

            pstmt.setString(1, search);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                ConsumptionReport temp = new ConsumptionReport();
                temp.setProductionNumber(rs.getInt("productionNumber"));
                temp.setProductName(rs.getString("productName"));
                temp.setProductID(rs.getInt("productID"));
                temp.setSizeName(rs.getString("sizeName"));
                temp.setSizeType(rs.getString("sizeType"));
                temp.setItemCode(rs.getInt("itemCode"));
                temp.setVolumeQty(rs.getInt("sizeVolumeQty"));
                temp.setDateMade(rs.getDate("dateMade"));
                temp.setPreparedBy(rs.getInt("preparedBy"));
                ConsumptionReport.add(temp);
            }
            pstmt.close();
            conn.close();

            return ConsumptionReport;
        } catch (SQLException ex) {
            Logger.getLogger(ConsumptionReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void showReport(int productionNumber) {

        //Path to your .jasper file in your package
        String reportName = "../Reports/ConsumptionReport.jasper";

        //Get a stream to read the file
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);

        Map parametersMap = new HashMap();
        parametersMap.put("prodNum", productionNumber);

        try {

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            
            //Fill the report with parameter, connection and the stream reader     
            JasperPrint jp = JasperFillManager.fillReport(is, parametersMap, conn);

            //Viewer for JasperReport
            JRViewer jv = new JRViewer(jp);

            //Insert viewer to a JFrame to make it showable
            JFrame jf = new JFrame();
            jf.getContentPane().add(jv);
            jf.validate();
            jf.setVisible(true);
            jf.setSize(new Dimension(800, 600));
            jf.setLocation(300, 100);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }

}
