package DAO;

import Database.DBConnectionFactory;
import Model.RefItem;
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
public class RefItemDAO {

    public boolean UpdateInventory(RefItem newRefItem) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into ref_item(itemCode, "
                    + "sizeName, inventoryType) "
                    + "values (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newRefItem.getitemCode());
            pstmt.setString(2, newRefItem.getItemName());
            pstmt.setString(3, newRefItem.getInventoryType());
         
            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(RefItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<RefItem> GetBoutiqueInventory() throws ParseException {
        ArrayList<RefItem> RefItem = new ArrayList<RefItem>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ref_item");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                RefItem newRefItem= new RefItem();
                
                newRefItem.setItemCode(rs.getInt("itemCode"));
                newRefItem.setItemName(rs.getString("itemName"));
                newRefItem.setInventoryType(rs.getString("inventoryType"));
               
            
                RefItem.add(newRefItem);
            }
                
            pstmt.close();
            rs.close();
            conn.close();

            return RefItem;
        } catch (SQLException ex) {
            Logger.getLogger(RefItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public ArrayList<RefItem> searchItemName(String itemName) throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();
        
        String query = "SELECT * FROM `ref_item` WHERE itemName LIKE '%"+ itemName + "%'";
        PreparedStatement ps = conn.prepareStatement(query);
        ArrayList<RefItem> RefItem = new ArrayList();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
             RefItem RefItemN = new RefItem();
             RefItemN.setItemCode(rs.getInt("itemCode"));
             RefItemN.setItemName(rs.getString("itemName"));
             RefItemN.setInventoryType(rs.getString("inventoryType"));
           
                 RefItem.add(RefItemN);  
        }
        rs.close();
        return RefItem;

    }
    
}
