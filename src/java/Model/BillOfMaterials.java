package Model;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class BillOfMaterials {

    private int productID;
    private int itemCode;
    private String productName;
    private double itemConsumption;
    private String unitMeasurement;
    private String sizeName;

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
     * @return the itemConsumption
     */
    public double getItemConsumption() {
        return itemConsumption;
    }

    /**
     * @param itemConsumption the itemConsumption to set
     */
    public void setItemConsumption(double itemConsumption) {
        this.itemConsumption = itemConsumption;
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
     * @return the sizeName
     */
    public String getSizeName() {
        return sizeName;
    }

    /**
     * @param sizeName the sizeName to set
     */
    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

}
