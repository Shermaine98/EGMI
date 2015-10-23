/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.RefItem;
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
public class RefItemDAOTest {
    
    public RefItemDAOTest() {
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
     * Test of UpdateInventory method, of class RefItemDAO.
     */
    @Test
    public void testUpdateInventory() {
        System.out.println("UpdateInventory");
        RefItem newRefItem = null;
        RefItemDAO instance = new RefItemDAO();
        boolean expResult = false;
        boolean result = instance.UpdateInventory(newRefItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetBoutiqueInventory method, of class RefItemDAO.
     */
    @Test
    public void testGetBoutiqueInventory() throws Exception {
        System.out.println("GetBoutiqueInventory");
        RefItemDAO instance = new RefItemDAO();
        ArrayList<RefItem> expResult = null;
        ArrayList<RefItem> result = instance.GetBoutiqueInventory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchItemName method, of class RefItemDAO.
     */
    @Test
    public void testSearchItemName() throws Exception {
        System.out.println("searchItemName");
        String itemName = "";
        RefItemDAO instance = new RefItemDAO();
        ArrayList<RefItem> expResult = null;
        ArrayList<RefItem> result = instance.searchItemName(itemName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
