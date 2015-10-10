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
    private String inventoryType;
    private int supplier;
    private double volumeQty;
    private double unitPrice;
    private java.sql.Date dateMade;
    private java.sql.Date deliveryDate;
    private int preparedBy;
    private int approvedBy;
    private String receivingStatus;
    private String reconcileStatus;
    private String note;

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
     * @return the intPrice
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the intPrice to set
     */
    public void setUnitPrice(double intPrice) {
        this.unitPrice = intPrice;
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

}
