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
                newSupplierDeliveryReceipt.setReceivedBy(rs.getInt("receivedBy"));
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
                temp.setReceivedBy(rs.getInt("receivedBy"));
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
  public ArrayList<SupplierDeliveryReceipt> GetDeliveryReceipt(String poNumber) throws ParseException {

        ArrayList<SupplierDeliveryReceipt> DeliveryReceipt = new ArrayList<SupplierDeliveryReceipt>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from supplier_delivery_receipt where poNumber = ?");
             pstmt.setString(1, poNumber);
            ResultSet rs = pstmt.executeQuery();
           
            while (rs.next()) {

                SupplierDeliveryReceipt temp = new SupplierDeliveryReceipt();
                
                 temp.setDrNumber(rs.getInt("drNumber"));
                temp.setPoNumber(rs.getInt("poNumber"));
                temp.setItemCode(rs.getInt("itemCode"));
                temp.setReceivedQty(rs.getDouble("receivedQty"));
                temp.setRejectedQty(rs.getDouble("rejectedQty"));
                temp.setDateReceived(rs.getDate("dateRecieved"));
                temp.setReceivedBy(rs.getInt("receivedBy"));
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
  
  public boolean UpdateSupplierDeliveryReceipt(SupplierDeliveryReceipt newSupplierDeliveryReceipt) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "update supplier_delivery_receipt"
                    + " SET receivedQty = ?, rejectedQty = ?, status = ? where drNumber = ? AND poNumber = ? AND itemCode = ?";

            String query2 = "update supplier_purchase_order"
                    + " SET receivingStatus = ? where poNumber = ? AND itemCode = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            PreparedStatement pstmt2 = conn.prepareStatement(query2);
            
            pstmt.setDouble(1, newSupplierDeliveryReceipt.getReceivedQty());
            pstmt.setDouble(2, newSupplierDeliveryReceipt.getRejectedQty());
            pstmt.setString(3, newSupplierDeliveryReceipt.getStatus());
            pstmt.setInt(4, newSupplierDeliveryReceipt.getDrNumber());
            pstmt.setInt(5, newSupplierDeliveryReceipt.getPoNumber());
            pstmt.setInt(6, newSupplierDeliveryReceipt.getItemCode());
            
            pstmt2.setString(1, newSupplierDeliveryReceipt.getStatus());
            pstmt2.setInt(2, newSupplierDeliveryReceipt.getPoNumber());
            pstmt2.setInt(3, newSupplierDeliveryReceipt.getItemCode());
            pstmt.executeUpdate();
            pstmt2.executeUpdate();
            
            pstmt.close();
            pstmt2.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
 public ArrayList<SupplierDeliveryReceipt> GetDeliveryReceiptForCuttingReport() throws ParseException {

        ArrayList<SupplierDeliveryReceipt> DeliveryReceipt = new ArrayList<SupplierDeliveryReceipt>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT SPO.poNumber, SDR.drNumber, SPO.itemCode, I.itemName, SDR.receivedQty, SDR.rejectedQty, SPO.volumeQty, SPO.dateMade, \n" +
            "		SPO.deliveryDate,U.lastName as preparedbyLastName, U.firstName as preparedbyFirstName, \n" +
"        S.unitPrice, I.unitMeasurement, I.inventoryType, SPO.receivingStatus, SPO.notes\n" +
"FROM supplier_purchase_order SPO\n" +
"JOIN supplier_delivery_receipt SDR\n" +
"ON	SPO.poNumber = SDR.poNumber\n" +
"AND SPO.itemCode = SDR.itemCode\n" +
"JOIN ref_supplier S\n" +
"ON SPO.itemCode = S.itemCode\n" +
"AND SPO.supplier = S.supplierID\n" +
"JOIN ref_item I \n" +
"ON S.itemCode = I.itemCode\n" +
"JOIN user U \n" +
"ON SPO.preparedBy = U.employeeID\n" +
"WHERE I.inventoryType = 'production' AND SPO.receivingStatus = 'completed';");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                SupplierDeliveryReceipt temp = new SupplierDeliveryReceipt();
                
                temp.setDrNumber(rs.getInt("drNumber"));
                temp.setPoNumber(rs.getInt("poNumber"));
                temp.setItemCode(rs.getInt("itemCode"));
                temp.setReceivedQty(rs.getDouble("receivedQty"));
                temp.setRejectedQty(rs.getDouble("rejectedQty"));
                temp.setDateReceived(rs.getDate("dateRecieved"));
                temp.setReceivedBy(rs.getInt("receivedBy"));
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

}
