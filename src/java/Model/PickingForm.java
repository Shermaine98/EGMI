package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */

public class PickingForm {
    private java.sql.Date dateMade;
    private int requestedQty;
    private int approvedQty;
    private int approvedBy;
    private int promo;
    private String location;
    private int productID;
    private String size;

    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    /**
     * @return the dateMade
     */
    public java.sql.Date getDateMade() {
        return dateMade;
    }

    /**
     * @param dateMade the dateMade to set
     */
    public void setDateMade() throws ParseException {
       java.util.Date dateMadeE = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateMadeE1 = formatter.parse(df.format(dateMadeE));
        java.sql.Date sqlDate = new java.sql.Date(dateMadeE1.getTime());
        this.dateMade = sqlDate;
    }

    /**
     * @return the requestedQty
     */
    public int getRequestedQty() {
        return requestedQty;
    }

    /**
     * @param requestedQty the requestedQty to set
     */
    public void setRequestedQty(int requestedQty) {
        this.requestedQty = requestedQty;
    }

    /**
     * @return the approvedQty
     */
    public int getApprovedQty() {
        return approvedQty;
    }

    /**
     * @param approvedQty the approvedQty to set
     */
    public void setApprovedQty(int approvedQty) {
        this.approvedQty = approvedQty;
    }

    /**
     * @return the approvedBy
     */
    public int getApprovedBy() {
        return approvedBy;
    }

    /**
     * @param approvedBy the approvedBy to set
     */
    public void setApprovedBy(int approvedBy) {
        this.approvedBy = approvedBy;
    }

    /**
     * @return the promo
     */
    public int getPromo() {
        return promo;
    }

    /**
     * @param promo the promo to set
     */
    public void setPromo(int promo) {
        this.promo = promo;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }
    
}
