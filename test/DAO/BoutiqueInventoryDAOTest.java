/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.BoutiqueInventory;
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
public class BoutiqueInventoryDAOTest {
    
    public BoutiqueInventoryDAOTest() {
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
     * Test of UpdateInventory method, of class BoutiqueInventoryDAO.
     */
    @Test
    public void testUpdateInventory() {
        System.out.println("UpdateInventory");
        BoutiqueInventory newBoutiqueInventory = null;
        BoutiqueInventoryDAO instance = new BoutiqueInventoryDAO();
        boolean expResult = false;
        boolean result = instance.UpdateInventory(newBoutiqueInventory);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetBoutiqueInventory method, of class BoutiqueInventoryDAO.
     */
    @Test
    public void testGetBoutiqueInventory() throws Exception {
        System.out.println("GetBoutiqueInventory");
        BoutiqueInventoryDAO instance = new BoutiqueInventoryDAO();
        ArrayList<BoutiqueInventory> expResult = null;
        ArrayList<BoutiqueInventory> result = instance.GetBoutiqueInventory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ProductReplenishment method, of class BoutiqueInventoryDAO.
     */
    @Test
    public void testProductReplenishment() throws Exception {
        System.out.println("ProductReplenishment");
        BoutiqueInventoryDAO instance = new BoutiqueInventoryDAO();
        ArrayList<BoutiqueInventory> expResult = null;
        ArrayList<BoutiqueInventory> result = instance.ProductReplenishment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
