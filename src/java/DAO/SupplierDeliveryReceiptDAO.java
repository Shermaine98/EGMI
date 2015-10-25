package DAO;

import Database.DBConnectionFactory;
import Model.SupplierDeliveryReceipt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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
public class SupplierDeliveryReceiptDAO {

    public boolean EncodeSupplierDeliveryReceipt(SupplierDeliveryReceipt newSupplierDeliveryReceipt) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into supplier_delivery_receipt"
                    + "(drNumber,poNumber,itemCode,receivedQty,rejectedQty,receivedBy,approvedby,status,dateRecieved,notes) "
                    + "values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newSupplierDeliveryReceipt.getDrNumber());
            pstmt.setInt(2, newSupplierDeliveryReceipt.getPoNumber());
            pstmt.setInt(3, newSupplierDeliveryReceipt.getItemCode());
            pstmt.setDouble(4, newSupplierDeliveryReceipt.getReceivedQty());
            pstmt.setDouble(5, newSupplierDeliveryReceipt.getRejectedQty());
            pstmt.setInt(6, newSupplierDeliveryReceipt.getReceivedBy());
            pstmt.setInt(7, newSupplierDeliveryReceipt.getApprovedBy());
            pstmt.setString(8, newSupplierDeliveryReceipt.getStatus());
             pstmt.setDate(9, newSupplierDeliveryReceipt.getDateReceived());
              pstmt.setString(10, newSupplierDeliveryReceipt.getNotes());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<SupplierDeliveryReceipt> MonitorDeliveryReceipt() throws ParseException {
        ArrayList<SupplierDeliveryReceipt> supplierDeliveryReceipt = new ArrayList<SupplierDeliveryReceipt>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM supplier_delivery_receipt");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SupplierDeliveryReceipt newSupplierDeliveryReceipt = new SupplierDeliveryReceipt();

                newSupplierDeliveryReceipt.setDrNumber(rs.getInt("drNumber"));
                newSupplierDeliveryReceipt.setPoNumber(rs.getInt("poNumber"));
                newSupplierDeliveryReceipt.setItemCode(rs.getInt("itemCode"));
                newSupplierDeliveryReceipt.setReceivedQty(rs.getDouble("receivedQty"));
                newSupplierDeliveryReceipt.setRejectedQty(rs.getDouble("rejectedQty"));
                newSupplierDeliveryReceipt.setDateReceived(rs.getDate("dateRecieved"));
                newSupplierDeliveryReceipt.setReceivedBy(rs.getInt("recievedBy"));
                newSupplierDeliveryReceipt.setApprovedBy(rs.getInt("approvedBy"));
                newSupplierDeliveryReceipt.setStatus(rs.getString("status"));
                newSupplierDeliveryReceipt.setStatus(rs.getString("notes"));

                supplierDeliveryReceipt.add(newSupplierDeliveryReceipt);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return supplierDeliveryReceipt;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<SupplierDeliveryReceipt> GetDeliveryReceiptList() throws ParseException {

        ArrayList<SupplierDeliveryReceipt> DeliveryReceipt = new ArrayList<SupplierDeliveryReceipt>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from supplier_delivery_receipt");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                SupplierDeliveryReceipt temp = new SupplierDeliveryReceipt();
                
                temp.setDrNumber(rs.getInt("drNumber"));
                temp.setPoNumber(rs.getInt("poNumber"));
                temp.setItemCode(rs.getInt("itemCode"));
                temp.setReceivedQty(rs.getDouble("receivedQty"));
                temp.setRejectedQty(rs.getDouble("rejectedQty"));
                temp.setDateReceived(rs.getDate("dateRecieved"));
                temp.setReceivedBy(rs.getInt("recievedBy"));
                temp.setApprovedBy(rs.getInt("approvedBy"));
                temp.setStatus(rs.getString("status"));
                temp.setStatus(rs.getString("notes"));


                DeliveryReceipt.add(temp);
            }
            pstmt.close();
            conn.close();

            return DeliveryReceipt;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Integer getSupplierDeliveryReceipt() throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();
        Integer i = 0;
        String query = "SELECT MAX(drNumber) from supplier_delivery_receipt";
        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            i = rs.getInt("MAX(drNumber)");
        }
        if (i == 0) {
            i = 60000000;
        } else if (i==69999999)
            i=-1;
        else {
            i += 1;
        }

        rs.close();
        return i;
    }
    
     public boolean check(String poNumber) throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();
        
        String query = "SELECT poNumber from supplier_delivery_receipt where poNumber = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, poNumber);
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
          return true;
         }
       
        return false;
    }
}
