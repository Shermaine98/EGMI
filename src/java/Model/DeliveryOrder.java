/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Gerard
 */
public class DeliveryOrder {
    private int doNumber;
    private int qty;
    private Date deliveryDate; //not yet sure what kind of date? haha
    private Date dateMade;
    private int promo;
    private String location;
    private int productID;
    private String size;
    
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    /**
     * @return the doNumber
     */
    public int getDoNumber(){
        return doNumber;
    }
    
    /**
     * @param doNumber set a value to doNumber
     */
    public void setDoNumber(int doNumber){
        this.doNumber = doNumber;
    }
    
    /**
     * @return the qty
     */
    public int getQty(){
        return qty;
    }
    
    /**
     * @param qty set qty
     */
    public void setQty(int qty){
        this.qty = qty;
    }
    
    /**
     * @return the deliveryDate
     */
    public Date getDeliveryDate(){
        return deliveryDate;
    }
    
    /**
     * @param deliveryDate set the deliveryDate
     */
    public void setDeliveryDate(java.util.Date deliveryDate) throws ParseException{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = formatter.parse(df.format(deliveryDate));
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        this.deliveryDate = sqlDate;
    }
    
    /**
     * @return the dateMade
     */
    public java.sql.Date getDateMade(){
        return dateMade;
    }
    
    /**
     * @param dateMade set the dateMade
     */
    public void setDateMade() throws ParseException{
        java.util.Date currentDate = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date currentDate1 = formatter.parse(df.format(currentDate));
        java.sql.Date sqlDate = new java.sql.Date(currentDate1.getTime());
        this.dateMade = sqlDate;
    }
    
    /**
     * @return the promo
     */
    public int getPromo(){
        return promo;
    }
    
    /**
     * @param promo set the promo
     */
    public void setPromo(int promo){
        this.promo = promo;
    }
    
    /**
     * @return the location
     */
    public String getLocation(){
        return location;
    }
    
    /**
     * @param location set the location
     */
    public void setLocation(String location){
        this.location = location;
    }
    
    /**
     * @return the productID
     */
    public int getProductID(){
        return productID;
    }
    
    /**
     * @param productID set the productID
     */
    public void setProductID(int productID){
        this.productID = productID;
    }
    
    /**
     * @return the size
     */
    public String getSize(){
        return size;
    }
    
    /**
     * @param size set size
     */
    public void setSize(String size){
        this.size = size;
    }
    
}
