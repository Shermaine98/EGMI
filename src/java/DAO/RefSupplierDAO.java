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
                    + "(supplierID,itemCode,itemName,companyName,companyAddress,contactPerson,contactNumber) "
                    + "values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, newRefSupplier.getSupplierID());
            pstmt.setInt(2, newRefSupplier.getItemCode());
            pstmt.setString(3, newRefSupplier.getItemName());
            pstmt.setString(4, newRefSupplier.getCompanyName());
            pstmt.setString(5, newRefSupplier.getCompanyAddress());
            pstmt.setString(6, newRefSupplier.getContactPerson());
            pstmt.setFloat(7, newRefSupplier.getContactNumber());

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
    
     public ArrayList<String> GetSupplierName() {
        ArrayList<String> refSupplier = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT companyName FROM `ref_supplier` group by companyName");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                RefSupplier newRefSupplier = new RefSupplier();
                newRefSupplier.setCompanyName(rs.getString("companyName"));
                refSupplier.add(newRefSupplier.getCompanyName());
            
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

        String query = "SELECT * FROM `ref_supplier` WHERE companyName LIKE '%"+ supplierName + "%' group by companyName ";
        PreparedStatement ps = conn.prepareStatement(query);
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

        String query = "SELECT * FROM `ref_supplier` WHERE companyName = "+company +" and itemName Like '%"+itemName+"%'";
        PreparedStatement ps = conn.prepareStatement(query);
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
    
}
