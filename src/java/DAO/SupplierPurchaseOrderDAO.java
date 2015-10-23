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
                    + "(poNumber,itemCode,inventoryType, supplier,volumeQty,unitPrice, dateMade, deliveryDate, preparedBy, approvedBy, receivingStatus, reconcileStatus, note) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newSupplierPurchaseOrder.getPoNumber());
            pstmt.setInt(2, newSupplierPurchaseOrder.getItemCode());
            pstmt.setString(3, newSupplierPurchaseOrder.getInventoryType());
            pstmt.setInt(4, newSupplierPurchaseOrder.getSupplier());
            pstmt.setDouble(5, newSupplierPurchaseOrder.getVolumeQty());
            pstmt.setDouble(6, newSupplierPurchaseOrder.getUnitPrice());
            pstmt.setDate(7, newSupplierPurchaseOrder.getDateMade());
            pstmt.setDate(8, newSupplierPurchaseOrder.getDeliveryDate());
            pstmt.setInt(9, newSupplierPurchaseOrder.getPreparedBy());
            pstmt.setInt(10, newSupplierPurchaseOrder.getApprovedBy());
            pstmt.setString(11, newSupplierPurchaseOrder.getReceivingStatus());
            pstmt.setString(12, newSupplierPurchaseOrder.getReconcileStatus());
            pstmt.setString(13, newSupplierPurchaseOrder.getNote());

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
                temp.setInventoryType(rs.getString("inventoryType"));
                temp.setSupplier(rs.getInt("supplier"));
                temp.setVolumeQty(rs.getInt("volumeQty"));
                temp.setUnitPrice(rs.getDouble("unitPrice"));
                temp.setDateMade();
                temp.setDeliveryDate(rs.getDate("deliveryDate"));
                temp.setPreparedBy(rs.getInt("preparedBy"));
                temp.setApprovedBy(rs.getInt("approvedBy"));
                temp.setReceivingStatus(rs.getString("receivingStatus"));
                temp.setReconcileStatus(rs.getString("reconcileStatus"));
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
