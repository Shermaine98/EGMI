package DAO;

import Model.RefSupplier;
import Database.DBConnectionFactory;
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
public class RefSupplierDAO {

    public boolean EncodeRefSupplier(RefSupplier newRefSupplier) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into `ref_supplier`"
                    + "(supplierID,itemCode,itemName,unitPrice,companyName,companyAddress,contactPerson,contactNumber) "
                    + "values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, newRefSupplier.getSupplierID());
            pstmt.setInt(2, newRefSupplier.getItemCode());
            pstmt.setString(3, newRefSupplier.getItemName());
            pstmt.setDouble(4, newRefSupplier.getUnitPrice());
            pstmt.setString(5, newRefSupplier.getCompanyName());
            pstmt.setString(6, newRefSupplier.getCompanyAddress());
            pstmt.setString(7, newRefSupplier.getContactPerson());
            pstmt.setFloat(8, newRefSupplier.getContactNumber());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(RefSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<RefSupplier> MonitorRefSupplier() {
        ArrayList<RefSupplier> refSupplier = new ArrayList<RefSupplier>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM `ref_supplier`");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                RefSupplier newRefSupplier = new RefSupplier();

                newRefSupplier.setSupplierID(rs.getInt("supplierID"));
                newRefSupplier.setItemCode(rs.getInt("itemCode"));
                 newRefSupplier.setUnitPrice(rs.getDouble("unitPrice"));
                newRefSupplier.setItemName(rs.getString("itemName"));
                newRefSupplier.setCompanyName(rs.getString("companyName"));
                newRefSupplier.setCompanyAddress(rs.getString("companyAddress"));
                newRefSupplier.setContactPerson(rs.getString("contactPerson"));
                newRefSupplier.setContactNumber(rs.getInt("contactNumber"));
                
                refSupplier.add(newRefSupplier);
            }

            pstmt.close();
            rs.close();
            conn.close();

            return refSupplier;
            
        } catch (SQLException ex) {
            Logger.getLogger(RefSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
  
     public ArrayList<RefSupplier> searchSupplier(String supplierName) throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();
        
        String search = supplierName + "%";

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM `ref_supplier` WHERE companyName LIKE ? group by companyName");
        ps.setString(1, search);
        
        ArrayList<RefSupplier> RefSupplierList = new ArrayList();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
             RefSupplier RefSupplierN = new RefSupplier();
             RefSupplierN.setSupplierID(rs.getInt("supplierID"));
             RefSupplierN.setItemCode(rs.getInt("itemCode"));
             RefSupplierN.setItemName(rs.getString("itemName"));
             RefSupplierN.setCompanyName(rs.getString("companyName"));
             RefSupplierN.setCompanyAddress(rs.getString("companyAddress"));
             RefSupplierN.setContactPerson(rs.getString("contactPerson"));
             RefSupplierN.setContactNumber(rs.getFloat("contactNumber"));
             
             RefSupplierList.add(RefSupplierN);  
        }
        rs.close();
        return RefSupplierList;

    }
     
      public ArrayList<RefSupplier> searchSupplierItem(String itemName,String company) throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM `ref_supplier` WHERE companyName = '"+ company +"' and itemName LIKE '%"+ itemName + "%'");
        ArrayList<RefSupplier> RefSupplierList = new ArrayList();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
             RefSupplier RefSupplierN = new RefSupplier();
             RefSupplierN.setSupplierID(rs.getInt("supplierID"));
             RefSupplierN.setItemCode(rs.getInt("itemCode"));
             RefSupplierN.setUnitPrice(rs.getInt("unitPrice"));
             RefSupplierN.setItemName(rs.getString("itemName"));
             RefSupplierN.setCompanyName(rs.getString("companyName"));
             RefSupplierN.setCompanyAddress(rs.getString("companyAddress"));
             RefSupplierN.setContactPerson(rs.getString("contactPerson"));
             RefSupplierN.setContactNumber(rs.getFloat("contactNumber"));
             
             RefSupplierList.add(RefSupplierN);  
        }
        rs.close();
        return RefSupplierList;

    }
   public ArrayList<RefSupplier> setSupplierItem(String itemName,String company) throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM `ref_supplier` WHERE companyName = '"+ company +"' and itemName ='"+ itemName + "'");
        ArrayList<RefSupplier> RefSupplierList = new ArrayList();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
             RefSupplier RefSupplierN = new RefSupplier();
             RefSupplierN.setSupplierID(rs.getInt("supplierID"));
             RefSupplierN.setItemCode(rs.getInt("itemCode"));
              RefSupplierN.setUnitPrice(rs.getDouble("unitPrice"));
             RefSupplierN.setItemName(rs.getString("itemName"));
             RefSupplierN.setCompanyName(rs.getString("companyName"));
             RefSupplierN.setCompanyAddress(rs.getString("companyAddress"));
             RefSupplierN.setContactPerson(rs.getString("contactPerson"));
             RefSupplierN.setContactNumber(rs.getFloat("contactNumber"));
             
             RefSupplierList.add(RefSupplierN);  
        }
        rs.close();
        return RefSupplierList;

    }  
}
