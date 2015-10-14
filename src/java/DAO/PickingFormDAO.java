package DAO;

import Database.DBConnectionFactory;
import Model.PickingForm;
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
public class PickingFormDAO {

    public boolean EncodepickingForm(PickingForm newPickingForm) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into picking_form (dateMade, "
                    + "requestedQty, approvedQty, approvedBy, promo, location, productID,size) "
                    + "values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setDate(1, newPickingForm.getDateMade());
            pstmt.setInt(2, newPickingForm.getRequestedQty());
            pstmt.setInt(3, newPickingForm.getApprovedBy());
            pstmt.setInt(4, newPickingForm.getApprovedQty());
            pstmt.setInt(5, newPickingForm.getPromo());
            pstmt.setString(6, newPickingForm.getLocation());
            pstmt.setInt(7, newPickingForm.getProductID());
            pstmt.setString(8, newPickingForm.getSize());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(PickingFormDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<PickingForm> GetAllPickingForm() throws ParseException {
        ArrayList<PickingForm> PickingForm = new ArrayList<PickingForm>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM picking_form");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                PickingForm newPickingForm = new PickingForm();
                newPickingForm.setDateMade();
                newPickingForm.setRequestedQty(rs.getInt("requestedQty"));
                newPickingForm.setApprovedQty(rs.getInt("approvedQty"));
                newPickingForm.setApprovedBy(rs.getInt("approvedBy"));
                newPickingForm.setPromo(rs.getInt("promo"));
                newPickingForm.setLocation(rs.getString("location"));
                newPickingForm.setProductID(rs.getInt("productID"));
                newPickingForm.setSize(rs.getString("size"));

                PickingForm.add(newPickingForm);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return PickingForm;
        } catch (SQLException ex) {
            Logger.getLogger(PickingFormDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   
}
