/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.WarehouseInventory;
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
public class WarehouseInventoryDAOTest {
    
    public WarehouseInventoryDAOTest() {
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
     * Test of UpdateInventory method, of class WarehouseInventoryDAO.
     */
    @Test
    public void testUpdateInventory() {
        System.out.println("UpdateInventory");
        WarehouseInventory newWarehouseInventory = null;
        WarehouseInventoryDAO instance = new WarehouseInventoryDAO();
        boolean expResult = false;
        boolean result = instance.UpdateInventory(newWarehouseInventory);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetWarehouseInventory method, of class WarehouseInventoryDAO.
     */
    @Test
    public void testGetWarehouseInventory() throws Exception {
        System.out.println("GetWarehouseInventory");
        WarehouseInventoryDAO instance = new WarehouseInventoryDAO();
        ArrayList<WarehouseInventory> expResult = null;
        ArrayList<WarehouseInventory> result = instance.GetWarehouseInventory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
