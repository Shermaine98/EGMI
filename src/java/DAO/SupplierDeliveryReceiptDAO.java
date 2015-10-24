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
                    + "(drNumber,poNumber,itemCode,dateReceived,qty,"
                    + "receivedBy,approvedBy,status) "
                    + "values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newSupplierDeliveryReceipt.getDrNumber());
            pstmt.setInt(2, newSupplierDeliveryReceipt.getPoNumber());
            pstmt.setInt(3, newSupplierDeliveryReceipt.getItemCode());
            pstmt.setDate(4, newSupplierDeliveryReceipt.getDateReceived());
            pstmt.setInt(5, newSupplierDeliveryReceipt.getQty());
            pstmt.setInt(6, newSupplierDeliveryReceipt.getReceivedBy());
            pstmt.setInt(7, newSupplierDeliveryReceipt.getApprovedBy());
            pstmt.setString(8, newSupplierDeliveryReceipt.getStatus());

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
                newSupplierDeliveryReceipt.setDateReceived(rs.getDate("dateReceived"));
                newSupplierDeliveryReceipt.setQty(rs.getInt("qty"));
                newSupplierDeliveryReceipt.setReceivedBy(rs.getInt("recievedBy"));
                newSupplierDeliveryReceipt.setApprovedBy(rs.getInt("approvedBy"));
                newSupplierDeliveryReceipt.setStatus(rs.getString("status"));

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
                temp.setDateReceived(rs.getDate("dateReceived"));
                temp.setQty(rs.getInt("qty"));
                temp.setReceivedBy(rs.getInt("receivedBy"));
                temp.setApprovedBy(rs.getInt("approvedBy"));
                temp.setStatus(rs.getString("status"));

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
