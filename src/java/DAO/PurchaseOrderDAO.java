/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DBConnectionFactory;
import Model.PurchaseOrder;
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
 * @author shermainesy
 */
public class PurchaseOrderDAO {

    public ArrayList<PurchaseOrder> GetAllPurchaseOrder() throws ParseException {
        ArrayList<PurchaseOrder> purchaseOrder = new ArrayList<PurchaseOrder>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT poNumber, dateMade, deliveryDate, preparedBy, approvedBy, receivingStatus, reconcileStatus\n"
                    + "FROM supplier_purchase_order\n"
                    + "WHERE receivingStatus != 'complete'\n"
                    + "GROUP BY poNumber\n"
                    + "UNION ALL\n"
                    + "SELECT poNumber, dateMade, deliveryDate, preparedBy, approvedBy, receivingStatus, reconcileStatus\n"
                    + "FROM subcon_purchase_order\n"
                    + "WHERE receivingStatus != 'complete'\n"
                    + "GROUP BY poNumber;");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                PurchaseOrder newPurchaseOrder = new PurchaseOrder();
                newPurchaseOrder.setPoNumber(rs.getInt("poNumber"));
                newPurchaseOrder.setDateMade(rs.getDate("dateMade"));
                newPurchaseOrder.setDeliveryDate(rs.getDate("deliveryDate"));
                newPurchaseOrder.setPreparedBy(rs.getInt("preparedBy"));
                newPurchaseOrder.setApprovedBy(rs.getInt("approvedBy"));
                newPurchaseOrder.setReceivingStatus(rs.getString("receivingStatus"));
                newPurchaseOrder.setReconcileStatus(rs.getString("reconcileStatus"));
                purchaseOrder.add(newPurchaseOrder);

            }
            pstmt.close();
            rs.close();
            conn.close();

            return purchaseOrder;
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<PurchaseOrder> GetWarehousePurchaseOrder() throws ParseException {
        ArrayList<PurchaseOrder> purchaseOrder = new ArrayList<PurchaseOrder>();
        return purchaseOrder;

    }

    public ArrayList<PurchaseOrder> GetAccessoriesPurchaseOrder() throws ParseException {
        ArrayList<PurchaseOrder> purchaseOrder = new ArrayList<PurchaseOrder>();
        return purchaseOrder;

    }

    public ArrayList<PurchaseOrder> GetProductionPurchaseOrder() throws ParseException {
        ArrayList<PurchaseOrder> purchaseOrder = new ArrayList<PurchaseOrder>();
        return purchaseOrder;

    }
}
