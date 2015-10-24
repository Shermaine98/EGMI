package DAO;

import Database.DBConnectionFactory;
import Model.SubconDeliveryReceipt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class SubconDeliveryReceiptDAO {

    public boolean EncodeSubconDeliveryReceipt(SubconDeliveryReceipt newSubconDeliveryReceipt) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into subcon_delivery_receipt"
                    + "(drNumber,poNumber,productionNumber,productID,size,dateReceived,"
                    + "qty,receivedBy,approvedBy,status) "
                    + "values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newSubconDeliveryReceipt.getDrNumber());
            pstmt.setInt(2, newSubconDeliveryReceipt.getPoNumber());
            pstmt.setInt(3, newSubconDeliveryReceipt.getProductionNumber());
            pstmt.setInt(4, newSubconDeliveryReceipt.getProductID());
            pstmt.setString(5, newSubconDeliveryReceipt.getSize());
            pstmt.setDate(6, newSubconDeliveryReceipt.getDateReceived());
            pstmt.setInt(7, newSubconDeliveryReceipt.getQty());
            pstmt.setInt(8, newSubconDeliveryReceipt.getReceivedBy());
            pstmt.setInt(9, newSubconDeliveryReceipt.getApprovedBy());
            pstmt.setString(10, newSubconDeliveryReceipt.getStatus());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SubconDeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<SubconDeliveryReceipt> MonitorDeliveryReceipt() throws ParseException {
        ArrayList<SubconDeliveryReceipt> SubconDeliveryReceipt = new ArrayList<SubconDeliveryReceipt>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM subcon_delivery_receipt");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SubconDeliveryReceipt newSubconDeliveryReceipt = new SubconDeliveryReceipt();

                newSubconDeliveryReceipt.setDrNumber(rs.getInt("drNumber"));
                newSubconDeliveryReceipt.setProductionNumber(rs.getInt("productionNumber"));
                newSubconDeliveryReceipt.setProductID(rs.getInt("productID"));
                newSubconDeliveryReceipt.setSize(rs.getString("size"));
                newSubconDeliveryReceipt.setPoNumber(rs.getInt("poNumber"));
                newSubconDeliveryReceipt.setDateReceived(rs.getDate("dateReceived"));
                newSubconDeliveryReceipt.setReceivedBy(rs.getInt("receivedBy"));
                newSubconDeliveryReceipt.setAppovedBy(rs.getInt("approvedBy"));
                newSubconDeliveryReceipt.setStatus(rs.getString("status"));
                newSubconDeliveryReceipt.setQty(rs.getInt("qty"));

                SubconDeliveryReceipt.add(newSubconDeliveryReceipt);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return SubconDeliveryReceipt;
        } catch (SQLException ex) {
            Logger.getLogger(SubconDeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
