package Model;

import java.sql.Date;
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
public class ConsumptionReport {

    private int productionNumber;
    private int productID;
    private int itemCode;
    private String sizeName;
    private String sizeType;
    private int volumeQty;
    private java.sql.Date dateMade;
    private int preparedBy;
    private String productName;
    
    //added 
    private String itemName;
    private Double itemConsumption;
    
   

    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @return the productionNumber
     */
    public int getProductionNumber() {
        return productionNumber;
    }

    /**
     * @param productionNumber set the productionNumber
     */
    public void setProductionNumber(int productionNumber) {
        this.productionNumber = productionNumber;
    }

    /**
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @param productID set the productID
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * @return the itemCode
     */
    public int getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode set the itemCode
     */
    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the size
     */
    public String getSizeName() {
        return sizeName;
    }

    /**
     * @param size set the size
     */
    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    /**
     * @return the volumeQty
     */
    public int getVolumeQty() {
        return volumeQty;
    }

    /**
     * @param volumeQty set the volumeQty
     */
    public void setVolumeQty(int volumeQty) {
        this.volumeQty = volumeQty;
    }

    /**
     * @return the dateMade
     */
    public Date getDateMade() {
        return dateMade;
    }

    /**
     * @param dateMade set the dateMade
     */
    public void setDateMade() throws ParseException {
        java.util.Date currentDate = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date currentDate1 = getFormatter().parse(df.format(currentDate));
        java.sql.Date sqlDate = new java.sql.Date(currentDate1.getTime());
        this.setDateMade(sqlDate);
    }

    /**
     * @return the preparedBy
     */
    public int getPreparedBy() {
        return preparedBy;
    }

    /**
     * @param preparedBy set the preparedBy
     */
    public void setPreparedBy(int preparedBy) {
        this.preparedBy = preparedBy;
    }

    /**
     * @return the sizeType
     */
    public String getSizeType() {
        return sizeType;
    }

    /**
     * @param sizeType the sizeType to set
     */
    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    /**
     * @param dateMade the dateMade to set
     */
    public void setDateMade(java.sql.Date dateMade) {
        this.dateMade = dateMade;
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
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
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
     * @return the itemConsumption
     */
    public Double getItemConsumption() {
        return itemConsumption;
    }

    /**
     * @param itemConsumption the itemConsumption to set
     */
    public void setItemConsumption(Double itemConsumption) {
        this.itemConsumption = itemConsumption;
    }
    
}
