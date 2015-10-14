/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DBConnectionFactory;
import Model.DeliveryOrder;
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
 * @author Gerard
 */
public class DeliveryOrderDAO {

    public boolean EncodeDeliveryOrder(DeliveryOrder newDeliveryOrder) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into delivery_order"
                    + "(doNumber, qty, deliveryDate, promo, location, productID, size) "
                    + "values (?,?,?,?,?,?,?,?) ";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newDeliveryOrder.getDoNumber());
            pstmt.setInt(2, newDeliveryOrder.getQty());
            pstmt.setDate(3, newDeliveryOrder.getDeliveryDate());
            pstmt.setDate(4, newDeliveryOrder.getDateMade());
            pstmt.setInt(5, newDeliveryOrder.getPromo());
            pstmt.setString(6, newDeliveryOrder.getLocation());
            pstmt.setInt(7, newDeliveryOrder.getProductID());
            pstmt.setString(8, newDeliveryOrder.getSize());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<DeliveryOrder> GetDeliveryOrderList() throws ParseException {

        ArrayList<DeliveryOrder> DeliveryOrder = new ArrayList<DeliveryOrder>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from delivery_order");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DeliveryOrder temp = new DeliveryOrder();
                temp.setDoNumber(rs.getInt("doNumber"));
                temp.setQty(rs.getInt("qty"));
                temp.setDeliveryDate(rs.getDate("deliveryDate"));
                temp.setDateMade();
                temp.setPromo(rs.getInt("promo"));
                temp.setLocation(rs.getString("location"));
                temp.setProductID(rs.getInt("productID"));
                temp.setSize(rs.getString("size"));

                DeliveryOrder.add(temp);
            }
            pstmt.close();
            conn.close();

            return DeliveryOrder;
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer getDeliveryOrderNumber() throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();
        Integer i = 0;
        String query = "SELECT MAX(doNumber) from delivery_order";
        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            i = rs.getInt("MAX(doNumber)");
        }
        if (i == 0) {
            i = 80000000;
        } else if (i == 89999999) {
            i = -1;
        } else {
            i += 1;
        }

        rs.close();
        return i;
    }
}
