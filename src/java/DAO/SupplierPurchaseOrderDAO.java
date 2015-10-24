package DAO;

import Database.DBConnectionFactory;
import Model.SupplierPurchaseOrder;
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

public class SupplierPurchaseOrderDAO {

    public boolean EncodeSupplierPurchaseOrder(SupplierPurchaseOrder newSupplierPurchaseOrder) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into supplier_purchase_order"
                    + "(poNumber,itemCode, supplier,volumeQty, dateMade, deliveryDate, preparedBy, approvedBy, receivingStatus, reconcileStatus, notes) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newSupplierPurchaseOrder.getPoNumber());
            pstmt.setInt(2, newSupplierPurchaseOrder.getItemCode());
            pstmt.setInt(3, newSupplierPurchaseOrder.getSupplier());
            pstmt.setDouble(4, newSupplierPurchaseOrder.getVolumeQty());
            pstmt.setDate(5, newSupplierPurchaseOrder.getDateMade());
            pstmt.setDate(6, newSupplierPurchaseOrder.getDeliveryDate());
            pstmt.setInt(7, newSupplierPurchaseOrder.getPreparedBy());
            pstmt.setInt(8, newSupplierPurchaseOrder.getApprovedBy());
            pstmt.setString(9, newSupplierPurchaseOrder.getReceivingStatus());
            pstmt.setString(10, newSupplierPurchaseOrder.getReconcileStatus());
            pstmt.setString(11, newSupplierPurchaseOrder.getNote());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierPurchaseOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<SupplierPurchaseOrder> GetAllSupplierPurchaseOrder() throws ParseException {

        ArrayList<SupplierPurchaseOrder> newPurchaseOrder = new ArrayList<SupplierPurchaseOrder>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from supplier_purchase_order");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                 SupplierPurchaseOrder temp = new SupplierPurchaseOrder();
                temp.setPoNumber(rs.getInt("poNumber"));
                temp.setItemCode(rs.getInt("itemCode"));
                temp.setSupplier(rs.getInt("supplier"));
                temp.setDateMade(rs.getDate("dateMade"));
                temp.setDeliveryDate(rs.getDate("deliveryDate"));
                temp.setPreparedBy(rs.getInt("preparedBy"));
                temp.setApprovedBy(rs.getInt("approvedBy"));
                temp.setReceivingStatus(rs.getString("receivingStatus"));
                temp.setReconcileStatus(rs.getString("reconcileStatus"));
                temp.setNote(rs.getString("notes"));
                newPurchaseOrder.add(temp);
            }
            pstmt.close();
            conn.close();

            return newPurchaseOrder;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierPurchaseOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
      public ArrayList<SupplierPurchaseOrder> GetSupplierPurchaseOrder(String poNumber) throws ParseException {

        ArrayList<SupplierPurchaseOrder> newPurchaseOrder = new ArrayList<SupplierPurchaseOrder>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from supplier_purchase_order where poNumber = ?");
            pstmt.setString(1, poNumber);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SupplierPurchaseOrder temp = new SupplierPurchaseOrder();
                temp.setPoNumber(rs.getInt("poNumber"));
                temp.setItemCode(rs.getInt("itemCode"));
                temp.setSupplier(rs.getInt("supplier"));
                temp.setDateMade(rs.getDate("dateMade"));
                temp.setDeliveryDate(rs.getDate("deliveryDate"));
                temp.setPreparedBy(rs.getInt("preparedBy"));
                temp.setApprovedBy(rs.getInt("approvedBy"));
                temp.setReceivingStatus(rs.getString("receivingStatus"));
                temp.setReconcileStatus(rs.getString("reconcileStatus"));
                temp.setNote(rs.getString("notes"));
                newPurchaseOrder.add(temp);
            }
            pstmt.close();
            conn.close();
            rs.close();

            return newPurchaseOrder;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierPurchaseOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
      public Integer getSupplierPurchaseOrderNumber() throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();
        Integer i = 0;
        String query = "SELECT MAX(poNumber) from supplier_purchase_order";
        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            i = rs.getInt("MAX(poNumber)");
        }
        if (i == 0) {
            i = 70000000;
        } else if (i==79999999)
            i=-1;
        else {
            i += 1;
        }

        rs.close();
        return i;
    }
}
