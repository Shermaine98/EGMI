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
public class SupplierPurchaseOrder {

    private int poNumber;
    private int itemCode;
    private int supplier;
    private double volumeQty;
    private java.sql.Date dateMade;
    private java.sql.Date deliveryDate;
    private int preparedBy;
    private int approvedBy;
    private String receivingStatus;
    private String reconcileStatus;
    private String note;
    //Receving
    
    private String companyName;
    private double unitPrice;
    private String itemName;
    private String preaparedLastName;
    private String  preaparedfirstName;
    private String unitMeasurement;
    private String inventoryType;
    
    //
    private int drNumber;
    private double receivedQty;
    private double rejectedQty;
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @return the poNumber
     */
    public int getPoNumber() {
        return poNumber;
    }
    
    
    /**
     * @param poNumber the poNumber to set
     */
    public void setPoNumber(int poNumber) {
        this.poNumber = poNumber;
    }

    /**
     * @return the itemCode
     */
    public int getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

   

    /**
     * @return the supplier
     */
    public int getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }

    /**
     * @return the volumeQty
     */
    public Double getVolumeQty() {
        return volumeQty;
    }

    /**
     * @param volumeQty the volumeQty to set
     */
    public void setVolumeQty(double volumeQty) {
        this.volumeQty = volumeQty;
    }

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
        @SuppressWarnings("deprecation")
        java.util.Date madeDate0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date madeDate1 = formatter.parse(df.format(madeDate0));
        java.sql.Date sqlreceivedDate1 = new java.sql.Date(madeDate1.getTime());
        this.dateMade = sqlreceivedDate1;
    }
    
         /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDateMade(java.util.Date dateMade) throws ParseException {
        @SuppressWarnings("deprecation")
        java.util.Date madeDate0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date madeDate1 = formatter.parse(df.format(madeDate0));
        java.sql.Date sqlreceivedDate1 = new java.sql.Date(madeDate1.getTime());
        this.dateMade = sqlreceivedDate1;
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
    public void setDeliveryDate(java.util.Date deliveryDate) throws ParseException {
        @SuppressWarnings("deprecation")
        java.util.Date madeDate0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date madeDate1 = formatter.parse(df.format(madeDate0));
        java.sql.Date sqlreceivedDate1 = new java.sql.Date(madeDate1.getTime());
        this.deliveryDate = sqlreceivedDate1;
    }
    
       /**
     * @param deliveryDate the deliveryDate to set
     * @throws java.text.ParseException
     */
    public void setDeliveryDate(String deliveryDate) throws ParseException {
        @SuppressWarnings("deprecation")
        java.util.Date deliveryDate2 = formatter.parse(deliveryDate);
        java.sql.Date deliveryDate1 = new java.sql.Date(deliveryDate2.getTime());
        this.setDeliveryDate(deliveryDate1);
    }
    
    public void setDeliveryDate(java.sql.Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
   
    /**
     * @return the preparedBy
     */
    public int getPreparedBy() {
        return preparedBy;
    }

    /**
     * @param preparedBy the preparedBy to set
     */
    public void setPreparedBy(int preparedBy) {
        this.preparedBy = preparedBy;
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
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the preaparedLastName
     */
    public String getPreaparedLastName() {
        return preaparedLastName;
    }

    /**
     * @param preaparedLastName the preaparedLastName to set
     */
    public void setPreaparedLastName(String preaparedLastName) {
        this.preaparedLastName = preaparedLastName;
    }

    /**
     * @return the firstName
     */
    public String getPreparedFirstName() {
        return preaparedfirstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setPreparedFirstName(String firstName) {
        this.preaparedfirstName = preaparedfirstName;
    }

    /**
     * @return the unitMeasurement
     */
    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    /**
     * @param unitMeasurement the unitMeasurement to set
     */
    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    /**
     * @return the inventoryType
     */
    public String getInventoryType() {
        return inventoryType;
    }

    /**
     * @param inventoryType the inventoryType to set
     */
    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    /**
     * @return the drNumber
     */
    public int getDrNumber() {
        return drNumber;
    }

    /**
     * @param drNumber the drNumber to set
     */
    public void setDrNumber(int drNumber) {
        this.drNumber = drNumber;
    }

    /**
     * @return the receivedQty
     */
    public double getReceivedQty() {
        return receivedQty;
    }

    /**
     * @param receivedQty the receivedQty to set
     */
    public void setReceivedQty(double receivedQty) {
        this.receivedQty = receivedQty;
    }

    /**
     * @return the rejectedQty
     */
    public double getRejectedQty() {
        return rejectedQty;
    }

    /**
     * @param rejectedQty the rejectedQty to set
     */
    public void setRejectedQty(double rejectedQty) {
        this.rejectedQty = rejectedQty;
    }

}
