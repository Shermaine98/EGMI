/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DBConnectionFactory;
import Model.DeliveryReceipt;
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
public class DeliveryReceiptDAO {

    public boolean EncodeDeliveryReceipt(DeliveryReceipt newDeliveryReceipt) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into deliver_receipt"
                    + "(drNumber, doNumber, promo, location, deliveryDate) "
                    + "values (?,?,?,?,?,?) ";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newDeliveryReceipt.getDrNumber());
            pstmt.setInt(2, newDeliveryReceipt.getDoNumber());
            pstmt.setInt(3, newDeliveryReceipt.getPromo());
            pstmt.setString(4, newDeliveryReceipt.getLocation());
            pstmt.setDate(7, newDeliveryReceipt.getDateMade());
            pstmt.setDate(8, newDeliveryReceipt.getDeliveryDate());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<DeliveryReceipt> GetDeliveryReceiptList() throws ParseException {

        ArrayList<DeliveryReceipt> DeliveryReceipt = new ArrayList<DeliveryReceipt>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from deliver_receipt");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DeliveryReceipt temp = new DeliveryReceipt();
                temp.setDrNumber(rs.getInt("drNumber"));
                temp.setDoNumber(rs.getInt("doNumber"));
                temp.setPromo(rs.getInt("promo"));
                temp.setLocation(rs.getString("location"));
                temp.setDateMade();
                temp.setDeliveryDate(rs.getDate("deliveryDate"));
                DeliveryReceipt.add(temp);
            }
            pstmt.close();
            conn.close();

            return DeliveryReceipt;
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Integer getDeliveryReceiptNumber() throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();
        Integer i = 0;
        String query = "SELECT MAX(drNumber) from delivery_receipt";
        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            i = rs.getInt("MAX(drNumber)");
        }
        if (i == 0) {
            i = 90000000;
        } else if (i == 99999999) {
            i = -1;
        } else {
            i += 1;
        }

        rs.close();
        return i;
    }
}
