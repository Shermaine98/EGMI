/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AccessoriesInventory;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author shermainesy
 */
public class main {
    public static void main (String args[]) throws SQLException, ParseException{
   PurchaseOrderDAO refsupplier = new PurchaseOrderDAO();
    refsupplier.GetAllPurchaseOrder();
    System.out.print(refsupplier.GetAllPurchaseOrder());
    
    }
    
}
