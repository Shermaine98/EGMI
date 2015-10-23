package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author MikeDaniel
 */
public class SubconPurchaseOrder {

    private int poNumber;
    private int productionNumber;
    private int productID;
    private String size;
    private int qty;
    private int unitPrice;
    private java.sql.Date dateMade;
    private java.sql.Date deliveryDate;
    private int preparedBy;
    private int approvedby;
    private String receivingStatus;
    private String reconcileStatus;
    private int subcon;
    private String service;

    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    //THIS IS A LINE DIVIDING VARIABLES FROM GETTERS AND SETTERS//
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
     * @return the subcon
     */
    public int getSubcon() {
        return subcon;
    }

    /**
     *
     * @param subcon the subcon to set
     */
    public void setSubcon(int subcon) {
        this.subcon = subcon;
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
     *
     * @return the service
     */
    public String getService() {
        return service;
    }

    /**
     *
     * @param service the service to set
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     *
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     *
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.setUnitPrice(unitPrice);
    }

    /**
     *
     * @return the dateMade
     */
    public java.sql.Date getDateMade() {
        return dateMade;
    }

    /**
     *
     * @param dateMade the dateMade to set
     * @throws ParseException
     */
    public void setDateMade() throws ParseException {
        @SuppressWarnings("deprecation")
        java.util.Date madeDate0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date madeDate1 = getFormatter().parse(df.format(madeDate0));
        java.sql.Date sqlreceivedDate1 = new java.sql.Date(madeDate1.getTime());
        this.setDateMade(sqlreceivedDate1);
    }

    /**
     *
     * @return the preparedBy
     */
    public int getPreparedBy() {
        return preparedBy;
    }

    /**
     *
     * @param preparedBy the preparedBy to set
     */
    public void setPreparedBy(int preparedBy) {
        this.preparedBy = preparedBy;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the deliveryDate
     */
    public java.sql.Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(String deliveryDate) throws ParseException {
        @SuppressWarnings("deprecation")
        java.util.Date deliveryDate2 = formatter.parse(deliveryDate);
        java.sql.Date deliveryDate1 = new java.sql.Date(deliveryDate2.getTime());
        this.setDeliveryDate(deliveryDate1);
    }

    /**
     * @return the approvedby
     */
    public int getApprovedby() {
        return approvedby;
    }

    /**
     * @param approvedby the approvedby to set
     */
    public void setApprovedby(int approvedby) {
        this.approvedby = approvedby;
    }

    /**
     * @return the receivingStatus
     */
    public String getReceivingStatus() {
        return receivingStatus;
    }

    /**
     * @param receivingStatus the receivingStatus to set
     */
    public void setReceivingStatus(String receivingStatus) {
        this.receivingStatus = receivingStatus;
    }

    /**
     * @return the reconcileStatus
     */
    public String getReconcileStatus() {
        return reconcileStatus;
    }

    /**
     * @param reconcileStatus the reconcileStatus to set
     */
    public void setReconcileStatus(String reconcileStatus) {
        this.reconcileStatus = reconcileStatus;
    }

    /**
     * @return the formatter
     */
    public DateFormat getFormatter() {
        return formatter;
    }

    /**
     * @param formatter the formatter to set
     */
    public void setFormatter(DateFormat formatter) {
        this.formatter = formatter;
    }

    /**
     * @param dateMade the dateMade to set
     */
    public void setDateMade(java.sql.Date dateMade) {
        this.dateMade = dateMade;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(java.sql.Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
