/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ProductionInventory;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shermainesy
 */
public class ProductionInventoryDAOTest {
    
    public ProductionInventoryDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of UpdateInventory method, of class ProductionInventoryDAO.
     */
    @Test
    public void testUpdateInventory() {
        System.out.println("UpdateInventory");
        ProductionInventory newProductionInventory = null;
        ProductionInventoryDAO instance = new ProductionInventoryDAO();
        boolean expResult = false;
        boolean result = instance.UpdateInventory(newProductionInventory);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetBoutiqueInventory method, of class ProductionInventoryDAO.
     */
    @Test
    public void testGetBoutiqueInventory() throws Exception {
        System.out.println("GetBoutiqueInventory");
        ProductionInventoryDAO instance = new ProductionInventoryDAO();
        ArrayList<ProductionInventory> expResult = null;
        ArrayList<ProductionInventory> result = instance.GetBoutiqueInventory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
