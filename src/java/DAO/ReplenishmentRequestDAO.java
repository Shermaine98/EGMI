package DAO;

import Database.DBConnectionFactory;
import Model.ReplenishmentRequest;
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
public class ReplenishmentRequestDAO {

    public boolean EncodeReplenishmentRequest(ReplenishmentRequest newReplenishmentRequest) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into replenishment_request (dateMade, "
                    + "requestedQty, madeBy, promo, location, productID, size) "
                    + "values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setDate(1, newReplenishmentRequest.getDateMade());
            pstmt.setInt(2, newReplenishmentRequest.getRequestedQty());
            pstmt.setInt(3, newReplenishmentRequest.getMadeBy());
            pstmt.setInt(4, newReplenishmentRequest.getPromo());
            pstmt.setString(5, newReplenishmentRequest.getLocation());
            pstmt.setInt(6, newReplenishmentRequest.getProductID());
            pstmt.setString(7, newReplenishmentRequest.getSize());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ReplenishmentRequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<ReplenishmentRequest> GetReplenishmentRe() throws ParseException {
        ArrayList<ReplenishmentRequest> PickingForm = new ArrayList<ReplenishmentRequest>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM replenishment_request");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ReplenishmentRequest newReplenishmentRequest = new ReplenishmentRequest();

                newReplenishmentRequest.setDateMade();
                newReplenishmentRequest.setRequestedQty(rs.getInt("requestedQty"));
                newReplenishmentRequest.setMadeBy(rs.getInt("madeBy"));
                newReplenishmentRequest.setPromo(rs.getInt("promo"));
                newReplenishmentRequest.setLocation(rs.getString("location"));
                newReplenishmentRequest.setProductID(rs.getInt("productID"));
                newReplenishmentRequest.setSize(rs.getString("size"));

                PickingForm.add(newReplenishmentRequest);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return PickingForm;
        } catch (SQLException ex) {
            Logger.getLogger(ReplenishmentRequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
