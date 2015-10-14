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
public class ReplenishmentRequest {

    private java.sql.Date dateMade;
    private int requestedQty;
    private int madeBy;
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
     * @return the requestedBy
     */
    public int getRequestedQty() {
        return requestedQty;
    }

    /**
     * @param requestedQty the requestedBy to set
     */
    public void setRequestedQty(int requestedQty) {
        this.requestedQty = requestedQty;
    }

    /**
     * @return the madeBy
     */
    public int getMadeBy() {
        return madeBy;
    }

    /**
     * @param madeBy the madeBy to set
     */
    public void setMadeBy(int madeBy) {
        this.madeBy = madeBy;
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
