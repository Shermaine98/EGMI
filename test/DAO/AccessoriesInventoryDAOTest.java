/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AccessoriesInventory;
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
public class AccessoriesInventoryDAOTest {
    
    public AccessoriesInventoryDAOTest() {
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
     * Test of UpdateInventory method, of class AccessoriesInventoryDAO.
     */
    @Test
    public void testUpdateInventory() {
        System.out.println("UpdateInventory");
        AccessoriesInventory newAccessoriesInventory = null;
        AccessoriesInventoryDAO instance = new AccessoriesInventoryDAO();
        boolean expResult = false;
        boolean result = instance.UpdateInventory(newAccessoriesInventory);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetAccessoriesInventory method, of class AccessoriesInventoryDAO.
     */
    @Test
    public void testGetAccessoriesInventory() throws Exception {
        System.out.println("GetAccessoriesInventory");
        AccessoriesInventoryDAO instance = new AccessoriesInventoryDAO();
        ArrayList<AccessoriesInventory> expResult = null;
        ArrayList<AccessoriesInventory> result = instance.GetAccessoriesInventory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
