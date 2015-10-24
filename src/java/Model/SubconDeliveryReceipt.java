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
public class SubconDeliveryReceipt {

    private int drNumber;
    private int productionNumber;
    private int productID;
    private String size;
    private int poNumber;
    private java.sql.Date dateReceived;
    private int approvedBy;
    private int receivedBy;
    private String status;
    private int qty;

    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    //THIS IS A LINE DIVIDING VARIABLES FROM GETTERS AND SETTERS//
    /**
     *
     * @return the drNumber
     */
    public int getDrNumber() {
        return drNumber;
    }

    /**
     *
     * @param drNumber the drNumber to set
     */
    public void setDrNumber(int drNumber) {
        this.drNumber = drNumber;
    }

    /**
     *
     * @return the productionNumber
     */
    public int getProductionNumber() {
        return productionNumber;
    }

    /**
     *
     * @param productionNumber the productionNumber to set
     */
    public void setProductionNumber(int productionNumber) {
        this.productionNumber = productionNumber;
    }

    /**
     *
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     *
     * @param productID the productID to set
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     *
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     *
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     *
     * @return the poNumber
     */
    public int getPoNumber() {
        return poNumber;
    }

    /**
     *
     * @param poNumber the poNumber to set
     */
    public void setPoNumber(int poNumber) {
        this.poNumber = poNumber;
    }

    /**
     *
     * @return the dateReceived
     */
    public java.sql.Date getDateReceived() {
        return dateReceived;
    }

    /**
     *
     * @param dateReceived the dateReceived to set
     * @throws ParseException
     */
    public void setDateReceived(java.util.Date dateReceived) throws ParseException {
        @SuppressWarnings("deprecation")
        java.util.Date madeDate0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date madeDate1 = formatter.parse(df.format(madeDate0));
        java.sql.Date sqlreceivedDate1 = new java.sql.Date(madeDate1.getTime());
        this.dateReceived = sqlreceivedDate1;
    }

    /**
     *
     * @return the receivedBy
     */
    public int getReceivedBy() {
        return receivedBy;
    }

    /**
     *
     * @param receivedBy the receivedBy to set
     */
    public void setReceivedBy(int receivedBy) {
        this.receivedBy = receivedBy;
    }

    /**
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     *
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the appovedBy
     */
    public int getApprovedBy() {
        return approvedBy;
    }

    /**
     * @param appovedBy the appovedBy to set
     */
    public void setAppovedBy(int approvedBy) {
        this.approvedBy = approvedBy;
    }

}
