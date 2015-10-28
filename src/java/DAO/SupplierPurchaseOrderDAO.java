package DAO;

import Database.DBConnectionFactory;
import Model.SupplierDeliveryReceipt;
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

    public ArrayList<SupplierPurchaseOrder> GetSupplierPurchaseOrders(String poNumber) throws ParseException {

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

    public ArrayList<SupplierPurchaseOrder> GetSupplierPurchaseOrder(String poNumber) throws ParseException, SQLException {

        ArrayList<SupplierPurchaseOrder> newPurchaseOrder = new ArrayList<SupplierPurchaseOrder>();
        SupplierDeliveryReceiptDAO supplierDeliveryReceiptDAO = new SupplierDeliveryReceiptDAO();
        boolean x = supplierDeliveryReceiptDAO.check(poNumber);

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            //no DR

            if (x == false) {
                PreparedStatement pstmt = conn.prepareStatement(
                        "SELECT SPO.poNumber, SPO.itemCode, S.companyName, SPO.volumeQty, S.companyName, SPO.dateMade, \n"
                        + "SPO.deliveryDate, U.lastName as preparedbyLastName , U.firstName as preparedbyFirstName, \n"
                        + "S.unitPrice,I.itemName, I.unitMeasurement, I.inventoryType, SPO.notes, SPO.receivingStatus\n"
                        + "FROM supplier_purchase_order SPO\n"
                        + "JOIN ref_supplier S\n"
                        + "ON SPO.itemCode = S.itemCode\n"
                        + "AND SPO.supplier = S.supplierID\n"
                        + "JOIN ref_item I\n"
                        + "ON S.itemCode = I.itemCode\n"
                        + "JOIN user U\n"
                        + "ON SPO.preparedBy = U.employeeID\n"
                        + "WHERE  SPO.poNumber = ? AND SPO.receivingStatus != 'complete';");
                pstmt.setString(1, poNumber);

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    SupplierPurchaseOrder temp = new SupplierPurchaseOrder();
                    temp.setPoNumber(rs.getInt("poNumber"));
                    temp.setItemCode(rs.getInt("itemCode"));
                    temp.setCompanyName(rs.getString("companyName"));
                    temp.setDateMade(rs.getDate("dateMade"));
                    temp.setDeliveryDate(rs.getDate("deliveryDate"));
                    temp.setItemName(rs.getString("itemName"));
                    temp.setVolumeQty(rs.getDouble("volumeQty"));
                    temp.setPreaparedLastName(rs.getString("preparedbyLastName"));
                    temp.setPreparedFirstName(rs.getString("preparedbyFirstName"));
                    temp.setUnitPrice(rs.getInt("unitPrice"));
                    temp.setUnitMeasurement(rs.getString("unitMeasurement"));
                    temp.setInventoryType(rs.getString("inventoryType"));
                    temp.setReceivingStatus(rs.getString("receivingStatus"));
                    temp.setNote(rs.getString("notes"));
                    newPurchaseOrder.add(temp);
                }
                pstmt.close();
                conn.close();
                rs.close();
            } // if exsiting, get delivery number with received
            else if (x == true) {
                PreparedStatement pstmt = conn.prepareStatement(
                        "SELECT  SPO.poNumber, SDR.drNumber, SPO.itemCode, S.companyName, I.itemName, SDR.receivedQty, SDR.rejectedQty, SPO.volumeQty, SPO.dateMade, \n"
                        + "SPO.deliveryDate,U.lastName as preparedbyLastName, U.firstName as preparedbyFirstName, \n"
                        + "S.unitPrice, I.unitMeasurement, I.inventoryType, SPO.receivingStatus, SPO.notes\n"
                        + "FROM supplier_purchase_order SPO\n"
                        + "JOIN supplier_delivery_receipt SDR\n"
                        + "ON	SPO.poNumber = SDR.poNumber\n"
                        + "AND SPO.itemCode = SDR.itemCode\n"
                        + "JOIN ref_supplier S\n"
                        + "ON SPO.itemCode = S.itemCode\n"
                        + "AND SPO.supplier = S.supplierID\n"
                        + "JOIN ref_item I \n"
                        + "ON S.itemCode = I.itemCode\n"
                        + "JOIN user U \n"
                        + "ON SPO.preparedBy = U.employeeID\n"
                        + "WHERE SPO.poNumber = ? AND SPO.receivingStatus != 'complete';");

                pstmt.setString(1, poNumber);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    SupplierPurchaseOrder temp = new SupplierPurchaseOrder();
                    temp.setPoNumber(rs.getInt("poNumber"));
                    temp.setDrNumber(rs.getInt("drNumber"));
                    temp.setItemCode(rs.getInt("itemCode"));
                    temp.setItemName(rs.getString("itemName"));
                    temp.setReceivedQty(rs.getDouble("receivedQty"));
                    temp.setRejectedQty(rs.getDouble("rejectedQty"));
                    temp.setVolumeQty(rs.getDouble("volumeQty"));
                    temp.setDateMade(rs.getDate("dateMade"));
                    temp.setDeliveryDate(rs.getDate("deliveryDate"));
                    temp.setCompanyName(rs.getString("companyName"));
                    temp.setPreaparedLastName(rs.getString("preparedbyLastName"));
                    temp.setPreparedFirstName(rs.getString("preparedbyFirstName"));
                    temp.setUnitPrice(rs.getInt("unitPrice"));
                    temp.setUnitMeasurement(rs.getString("unitMeasurement"));
                    temp.setInventoryType(rs.getString("inventoryType"));
                    temp.setReceivingStatus(rs.getString("receivingStatus"));
                    temp.setNote(rs.getString("notes"));
                    newPurchaseOrder.add(temp);
                }
                pstmt.close();
                conn.close();
                rs.close();
            }
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
        } else if (i == 79999999) {
            i = -1;
        } else {
            i += 1;
        }

        rs.close();
        return i;
    }
}
