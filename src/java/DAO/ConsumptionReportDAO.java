package DAO;

import Database.DBConnectionFactory;
import Model.ConsumptionReport;
import java.sql.*;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        int i = 0;
        String query = "SELECT MAX(productionNumber) from consumption_report";
        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            i = rs.getInt("MAX(productionNumber)");
        }
        if (i == 0) {
            i = 300000000;
        } else {
            i += 1;
        }

        rs.close();
        return i;
    }
}
