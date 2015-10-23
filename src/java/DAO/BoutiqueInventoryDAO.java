package DAO;

import Database.DBConnectionFactory;
import Model.BoutiqueInventory;
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
public class BoutiqueInventoryDAO {

    public boolean UpdateInventory(BoutiqueInventory newBoutiqueInventory) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into boutique_inventory(dateupdated, "
                    + "qty, promo, location, productID,size) "
                    + "values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setDate(1, newBoutiqueInventory.getDateUpdated());
            pstmt.setInt(2, newBoutiqueInventory.getQty());
            pstmt.setInt(3, newBoutiqueInventory.getPromo());
            pstmt.setString(4, newBoutiqueInventory.getLocation());
            pstmt.setInt(5, newBoutiqueInventory.getProductID());
            pstmt.setString(6, newBoutiqueInventory.getSize());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(BoutiqueInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<BoutiqueInventory> GetBoutiqueInventory() throws ParseException {
        ArrayList<BoutiqueInventory> InventoryReport = new ArrayList<BoutiqueInventory>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM boutique_inventory");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BoutiqueInventory newBoutiqueInventory = new BoutiqueInventory();
                newBoutiqueInventory.setDateUpdated();
                newBoutiqueInventory.setQty(rs.getInt("qty"));
                newBoutiqueInventory.setPromo(rs.getInt("promo"));
                newBoutiqueInventory.setLocation(rs.getString("location"));
                newBoutiqueInventory.setProductID(rs.getInt("productID"));
                newBoutiqueInventory.setSize(rs.getString("size"));
                InventoryReport.add(newBoutiqueInventory);
            }
            pstmt.close();
            rs.close();
            conn.close();

            return InventoryReport;
        } catch (SQLException ex) {
            Logger.getLogger(BoutiqueInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<BoutiqueInventory> ProductReplenishment() throws ParseException {
        ArrayList<BoutiqueInventory> InventoryReport = new ArrayList<BoutiqueInventory>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM boutique_inventory where qty < 10");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BoutiqueInventory newBoutiqueInventory = new BoutiqueInventory();
                newBoutiqueInventory.setDateUpdated();
                newBoutiqueInventory.setQty(rs.getInt("qty"));
                newBoutiqueInventory.setPromo(rs.getInt("promo"));
                newBoutiqueInventory.setLocation(rs.getString("location"));
                newBoutiqueInventory.setProductID(rs.getInt("productID"));
                newBoutiqueInventory.setSize(rs.getString("size"));

                InventoryReport.add(newBoutiqueInventory);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return InventoryReport;
        } catch (SQLException ex) {
            Logger.getLogger(BoutiqueInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
