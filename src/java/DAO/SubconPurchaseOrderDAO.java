package DAO;

import Database.DBConnectionFactory;
import Model.SubconPurchaseOrder;
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
public class SubconPurchaseOrderDAO {

    public boolean EncodeSubconPurchaseOrder(SubconPurchaseOrder newSubconPurchaseOrder) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into subcon_purchase_order"
                    + "(poNumber,productionNumber,approvedBy,productID,sizeType,subcon,service,dateMade,"
                    + "deliveryDate,preparedBy,receivingStatus, reconcileStatus) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newSubconPurchaseOrder.getPoNumber());
            pstmt.setInt(2, newSubconPurchaseOrder.getProductionNumber());
            pstmt.setInt(3, newSubconPurchaseOrder.getApprovedby());
            pstmt.setInt(4, newSubconPurchaseOrder.getProductID());
            pstmt.setString(5, newSubconPurchaseOrder.getSize());
            pstmt.setInt(6, newSubconPurchaseOrder.getSubcon());
            pstmt.setString(7, newSubconPurchaseOrder.getService());
            pstmt.setDate(8, newSubconPurchaseOrder.getDateMade());
            pstmt.setDate(9, newSubconPurchaseOrder.getDeliveryDate());
            pstmt.setDouble(10, newSubconPurchaseOrder.getPreparedBy());
            pstmt.setString(11, newSubconPurchaseOrder.getReceivingStatus());
            pstmt.setString(12, newSubconPurchaseOrder.getReconcileStatus());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SubconPurchaseOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<SubconPurchaseOrder> MonitorSubconPurchaseOrder() throws ParseException {
        ArrayList<SubconPurchaseOrder> SubconPurchaseOrder = new ArrayList<SubconPurchaseOrder>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM subcon_purchase_order");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SubconPurchaseOrder newSubconPurchaseOrder = new SubconPurchaseOrder();

                newSubconPurchaseOrder.setPoNumber(rs.getInt("poNumber"));
                newSubconPurchaseOrder.setProductionNumber(rs.getInt("productionNumber"));
                newSubconPurchaseOrder.setProductID(rs.getInt("productID"));
                newSubconPurchaseOrder.setSize(rs.getString("sizeType"));
                newSubconPurchaseOrder.setDateMade(rs.getDate("dateMade"));
                newSubconPurchaseOrder.setDeliveryDate(rs.getString("deliveryDate"));
                newSubconPurchaseOrder.setPreparedBy(rs.getInt("preparedBy"));
                newSubconPurchaseOrder.setApprovedby(rs.getInt("approvedBy"));
                newSubconPurchaseOrder.setReceivingStatus(rs.getString("receivingStatus"));
                newSubconPurchaseOrder.setReconcileStatus(rs.getString("reconcileStatus"));
                newSubconPurchaseOrder.setSubcon(rs.getInt("subcon"));
                newSubconPurchaseOrder.setService(rs.getString("service"));

                SubconPurchaseOrder.add(newSubconPurchaseOrder);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return SubconPurchaseOrder;
        } catch (SQLException ex) {
            Logger.getLogger(SubconPurchaseOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
      public ArrayList<SubconPurchaseOrder> getSubconPurchaseOrder(String poNumber) throws ParseException {
        ArrayList<SubconPurchaseOrder> SubconPurchaseOrder = new ArrayList<SubconPurchaseOrder>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM subcon_purchase_order where poNumber = ?");
            pstmt.setString(1, poNumber);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SubconPurchaseOrder newSubconPurchaseOrder = new SubconPurchaseOrder();

                newSubconPurchaseOrder.setPoNumber(rs.getInt("poNumber"));
                newSubconPurchaseOrder.setProductionNumber(rs.getInt("productionNumber"));
                newSubconPurchaseOrder.setProductID(rs.getInt("productID"));
                newSubconPurchaseOrder.setSize(rs.getString("sizeType"));
                newSubconPurchaseOrder.setDateMade(rs.getDate("dataMade"));
                newSubconPurchaseOrder.setDeliveryDate(rs.getString("deliveryDate"));
                newSubconPurchaseOrder.setPreparedBy(rs.getInt("preparedBy"));
                newSubconPurchaseOrder.setApprovedby(rs.getInt("approvedBy"));
                newSubconPurchaseOrder.setReceivingStatus(rs.getString("receivingStatus"));
                newSubconPurchaseOrder.setReconcileStatus(rs.getString("reconcilingStatus"));
                newSubconPurchaseOrder.setSubcon(rs.getInt("subcon"));
                newSubconPurchaseOrder.setService(rs.getString("service"));

                SubconPurchaseOrder.add(newSubconPurchaseOrder);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return SubconPurchaseOrder;
        } catch (SQLException ex) {
            Logger.getLogger(SubconPurchaseOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Integer getSubconPurchaseOrderNumber() throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();
        Integer i = 0;
        String query = "SELECT MAX(poNumber) from subcon_purchase_order";
        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            i = rs.getInt("MAX(poNumber)");
        }
        if (i == 0) {
            i = 50000000;
        } else if (i==59999999)
            i=-1;
        else {
            i += 1;
        }

        rs.close();
        return i;
    }
}
