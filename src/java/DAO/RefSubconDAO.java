package DAO;

import Model.RefSubcon;
import Database.DBConnectionFactory;
import Model.RefSupplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class RefSubconDAO {

    public boolean EncodeRefSubcon(RefSubcon newRefSubcon) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into ref_subcon"
                    + "(subconID,service,companyName,companyAddress,contactPerson,contactNumber) "
                    + "values (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newRefSubcon.getSubconID());
            pstmt.setString(2, newRefSubcon.getService());
            pstmt.setString(3, newRefSubcon.getCompanyName());
            pstmt.setString(4, newRefSubcon.getCompanyAddress());
            pstmt.setString(5, newRefSubcon.getContactPerson());
            pstmt.setFloat(6, newRefSubcon.getContactNumber());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(RefSubconDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<RefSubcon> MonitorRefSubcon() {
        ArrayList<RefSubcon> refSubcon = new ArrayList<RefSubcon>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ref_subcon");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                RefSubcon newRefSubcon = new RefSubcon();

                newRefSubcon.setSubconID(rs.getInt("subconID"));
                newRefSubcon.setService(rs.getString("service"));
                newRefSubcon.setCompanyName(rs.getString("companyName"));
                newRefSubcon.setCompanyAddress(rs.getString("companyAddress"));
                newRefSubcon.setContactPerson(rs.getString("contactPerson"));
                newRefSubcon.setContactNumber(rs.getInt("contactNumber"));
                refSubcon.add(newRefSubcon);

                System.out.println(refSubcon.get(0).getCompanyName());

            }

            pstmt.close();
            rs.close();
            conn.close();

            return refSubcon;
        } catch (SQLException ex) {
            Logger.getLogger(RefSubconDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<RefSubcon> getSubcon(int subconID) throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();

        String query = "SELECT * FROM `ref_subcon`";
        PreparedStatement ps = conn.prepareStatement(query);
        //   ps.setInt(0, supplierID);
        ArrayList<RefSubcon> RefSubconList = new ArrayList();
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            RefSubcon RefSubconListN = new RefSubcon();
            RefSubconListN.setSubconID(rs.getInt("subconID"));
            RefSubconListN.setService(rs.getString("service"));
            RefSubconListN.setCompanyName(rs.getString("companyName"));
            RefSubconListN.setCompanyAddress(rs.getString("companyAddress"));
            RefSubconListN.setContactPerson(rs.getString("contactPerson"));
            RefSubconListN.setContactNumber(rs.getInt("contactNumber"));
            if (RefSubconListN.getSubconID() == subconID) {
                RefSubconList.add(RefSubconListN);
            }
        }
        rs.close();
        return RefSubconList;

    }

    public ArrayList<RefSubcon> searchSubcon(String subconName) throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();
        
        String search = subconName + "%";

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM `ref_subcon` WHERE companyName LIKE ? group by companyName");
        ps.setString(1, search);
        ArrayList<RefSubcon> RefSubconList = new ArrayList();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            RefSubcon RefSubconListN = new RefSubcon();
            RefSubconListN.setSubconID(rs.getInt("subconID"));
            RefSubconListN.setService(rs.getString("service"));
            RefSubconListN.setCompanyName(rs.getString("companyName"));
            RefSubconListN.setCompanyAddress(rs.getString("companyAddress"));
            RefSubconListN.setContactPerson(rs.getString("contactPerson"));
            RefSubconListN.setContactNumber(rs.getInt("contactNumber"));

            RefSubconList.add(RefSubconListN);
        }
        rs.close();
        return RefSubconList;

    }
    
    public ArrayList<RefSubcon> searchSubconAll(String subconName) throws SQLException {
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
        Connection conn = myFactory.getConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM `ref_subcon` WHERE companyName ='" + subconName + "'");
        ArrayList<RefSubcon> RefSubconList = new ArrayList();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            RefSubcon RefSubconListN = new RefSubcon();
            RefSubconListN.setSubconID(rs.getInt("subconID"));
            RefSubconListN.setService(rs.getString("service"));
            RefSubconListN.setCompanyName(rs.getString("companyName"));
            RefSubconListN.setCompanyAddress(rs.getString("companyAddress"));
            RefSubconListN.setContactPerson(rs.getString("contactPerson"));
            RefSubconListN.setContactNumber(rs.getInt("contactNumber"));

            RefSubconList.add(RefSubconListN);
        }
        rs.close();
        return RefSubconList;

    }
}
