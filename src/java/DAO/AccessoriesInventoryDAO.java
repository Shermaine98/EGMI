package DAO;

import Database.DBConnectionFactory;
import Model.AccessoriesInventory;
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
public class AccessoriesInventoryDAO {

    public boolean UpdateInventory(AccessoriesInventory newAccessoriesInventory) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            int rows;
            try (Connection conn = myFactory.getConnection()) {
                String query = "insert into accessories_inventory(drNumber, "
                        + "poNumber, itemCode, dateUpdated, qty,updatedBy) "
                        + "values (?,?,?,?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, newAccessoriesInventory.getDrNumber());
                pstmt.setInt(2, newAccessoriesInventory.getPoNumber());
                pstmt.setInt(3, newAccessoriesInventory.getItemCode());
                pstmt.setDate(4, newAccessoriesInventory.getDateUpdated());
                pstmt.setDouble(5, newAccessoriesInventory.getQty());
                pstmt.setInt(6, newAccessoriesInventory.getUpdatedBy());
                rows = pstmt.executeUpdate();
            }
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(AccessoriesInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<AccessoriesInventory> GetAccessoriesInventory() throws ParseException {
        ArrayList<AccessoriesInventory> AccessoriesInventory = new ArrayList<>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            try (Connection conn = myFactory.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM accessories_inventory")) {

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    AccessoriesInventory newAccessoriesInventory = new AccessoriesInventory();

                    newAccessoriesInventory.setQty(rs.getInt("drNumber"));
                    newAccessoriesInventory.setPoNumber(rs.getInt("poNumber"));
                    newAccessoriesInventory.setItemCode(rs.getInt("itemCode"));
                    newAccessoriesInventory.setDateUpdated(rs.getDate("dateUpdated"));
                    newAccessoriesInventory.setQty(rs.getDouble("qty"));
                    newAccessoriesInventory.setUpdatedBy(rs.getInt("UpdatedBy"));
                    AccessoriesInventory.add(newAccessoriesInventory);
                }

            }

            return AccessoriesInventory;
        } catch (SQLException ex) {
            Logger.getLogger(AccessoriesInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
