package DAO;

import Database.DBConnectionFactory;
import Model.BillOfMaterials;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class BillOfMaterialsDAO {

    public boolean EncodeBillOfMaterials(BillOfMaterials newBillOfMaterials) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into bill_of_materials"
                    + "(productID, itemCode, sizeName, productName, itemConsumption, unitMeasurement) "
                    + "values (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newBillOfMaterials.getProductID());
            pstmt.setInt(2, newBillOfMaterials.getItemCode());
            pstmt.setString(3, newBillOfMaterials.getSizeName());
            pstmt.setString(4, newBillOfMaterials.getProductName());
            pstmt.setDouble(5, newBillOfMaterials.getItemConsumption());
            pstmt.setString(6, newBillOfMaterials.getUnitMeasurement());

            int rows = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(BillOfMaterialsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<BillOfMaterials> MonitorBillOfMaterials() {
        ArrayList<BillOfMaterials> billOfMaterials = new ArrayList<BillOfMaterials>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM bill_of_materials");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BillOfMaterials newBillOfMaterials = new BillOfMaterials();

                newBillOfMaterials.setProductID(rs.getInt("productID"));
                newBillOfMaterials.setItemCode(rs.getInt("itemCode"));
                newBillOfMaterials.setSizeName(rs.getString("sizeName"));
                newBillOfMaterials.setProductName(rs.getString("productName"));
                newBillOfMaterials.setItemConsumption(rs.getDouble("itemConsumption"));
                newBillOfMaterials.setUnitMeasurement(rs.getString("unitMeasurement"));

                billOfMaterials.add(newBillOfMaterials);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return billOfMaterials;
        } catch (SQLException ex) {
            Logger.getLogger(BillOfMaterialsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<BillOfMaterials> searchProduct(String productID) throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();

        String search = productID + "%";

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM `bill_of_materials` WHERE productName LIKE ?");
        ps.setString(1, search);

        ArrayList<BillOfMaterials> BillOfMaterialsList = new ArrayList();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            BillOfMaterials newBillOfMaterials = new BillOfMaterials();
            newBillOfMaterials.setProductID(rs.getInt("productID"));
            newBillOfMaterials.setItemCode(rs.getInt("itemCode"));
            newBillOfMaterials.setSizeName(rs.getString("sizeName"));
            newBillOfMaterials.setProductName(rs.getString("productName"));
            newBillOfMaterials.setItemConsumption(rs.getDouble("itemConsumption"));
            newBillOfMaterials.setUnitMeasurement(rs.getString("unitMeasurement"));

            BillOfMaterialsList.add(newBillOfMaterials);

        }
        ps.close();
        rs.close();
        conn.close();
        return BillOfMaterialsList;

    }

    public Integer getProductNumber() throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Integer i;
        try (Connection conn = myFactory.getConnection()) {
            i = 0;
            String query = "SELECT MAX(productID) from bill_of_materials";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                i = rs.getInt("MAX(productID)");
            }   if (i == 0) {
                i = 200000000;
            } else if (i == 299999999) {
                i = -1;
            } else {
                i += 1;
            }  
            conn.close();
            pstmt.close();
            rs.close();
        }
        return i;
    }

}
