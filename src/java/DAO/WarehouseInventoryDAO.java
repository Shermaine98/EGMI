package DAO;

import Database.DBConnectionFactory;
import Model.WarehouseInventory;
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
public class WarehouseInventoryDAO {

    public boolean UpdateInventory(WarehouseInventory newWarehouseInventory) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into warehouse_inventory(drNumber, poNumber, productionNumber, productID, sizeType,dateUpdated, qty, updatedBy) "
                    + "values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newWarehouseInventory.getDrNumber());
            pstmt.setInt(2, newWarehouseInventory.getPoNumber());
            pstmt.setInt(3, newWarehouseInventory.getProductionNumber());
            pstmt.setInt(4, newWarehouseInventory.getProductID());
            pstmt.setString(5, newWarehouseInventory.getSizeType());
            pstmt.setDate(6, newWarehouseInventory.getDateUpdated());
            pstmt.setDouble(7, newWarehouseInventory.getQty());
            pstmt.setInt(8, newWarehouseInventory.getUpdatedBy());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<WarehouseInventory> GetWarehouseInventory() throws ParseException {
        ArrayList<WarehouseInventory> WarehouseInventory = new ArrayList<WarehouseInventory>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM warehouse_inventory");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                WarehouseInventory newWarehouseInventory= new WarehouseInventory();
                
                newWarehouseInventory.setDrNumber(rs.getInt("drNumber"));
                newWarehouseInventory.setPoNumber(rs.getInt("poNumber"));
                newWarehouseInventory.setProductionNumber(rs.getInt("productionNumber"));
                newWarehouseInventory.setProductID(rs.getInt("prductID"));
                newWarehouseInventory.setSizeType(rs.getString("sizeType"));
                newWarehouseInventory.getDateUpdated();
                newWarehouseInventory.setQty(rs.getInt("qty"));
                newWarehouseInventory.setUpdatedBy(rs.getInt("UpdatedBy"));
            
                WarehouseInventory.add(newWarehouseInventory);
            }
                
            pstmt.close();
            rs.close();
            conn.close();

            return WarehouseInventory;
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
