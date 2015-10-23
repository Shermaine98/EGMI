package DAO;

import Database.DBConnectionFactory;
import Model.ProductionInventory;
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
public class ProductionInventoryDAO {

    public boolean UpdateInventory(ProductionInventory newProductionInventory) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into production_inventory(productionNumber, "
                    + "productID, sizeType, drNumber, poNumber, itemCode, dateUpdated, qty, updatedBy) "
                    + "values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newProductionInventory.getProductionNUmber());
            pstmt.setInt(2, newProductionInventory.getProductID());
            pstmt.setString(3, newProductionInventory.getSizeType());
            pstmt.setInt(4, newProductionInventory.getDrNumber());
            pstmt.setInt(5, newProductionInventory.getPoNumber());
            pstmt.setDouble(6, newProductionInventory.getItemCode());
            pstmt.setDate(7, newProductionInventory.getDateUpdated());
            pstmt.setInt(8, newProductionInventory.getQty());
            pstmt.setInt(9, newProductionInventory.getUpdatedBy());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<ProductionInventory> GetBoutiqueInventory() throws ParseException {
        ArrayList<ProductionInventory> ProductionInventory = new ArrayList<ProductionInventory>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM production_inventory");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductionInventory newProductionInventory= new ProductionInventory();
                
                newProductionInventory.setProductionNUmber(rs.getInt("productionNumber"));
                newProductionInventory.setProductID(rs.getInt("productID"));
                newProductionInventory.setSizeType(rs.getString("sizeType"));
                newProductionInventory.setDrNumber(rs.getInt("drNumber"));
                newProductionInventory.setPoNumber(rs.getInt("poNumber"));
                newProductionInventory.setItemCode(rs.getInt("itemCode"));
                newProductionInventory.setDateUpdated();
                newProductionInventory.setQty(rs.getInt("qty"));
                newProductionInventory.setUpdatedBy(rs.getInt("updatedBy"));
            
                ProductionInventory.add(newProductionInventory);
            }
                
            pstmt.close();
            rs.close();
            conn.close();

            return ProductionInventory;
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
