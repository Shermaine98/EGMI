package Model;

public class RefItem {
    
    private int itemCode;
    private String itemName;
    private String inventoryType;

    /**
     * @return the itemNumber
     */
    public int getitemCode() {
        return itemCode;
    }

    /**
     * @param itemNumber the itemNumber to set
     */
    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
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
}
