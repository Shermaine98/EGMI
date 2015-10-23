/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.RefSupplier;
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
public class RefSupplierDAOTest {
    
    public RefSupplierDAOTest() {
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
     * Test of EncodeRefSupplier method, of class RefSupplierDAO.
     */
    @Test
    public void testEncodeRefSupplier() {
        System.out.println("EncodeRefSupplier");
        RefSupplier newRefSupplier = null;
        RefSupplierDAO instance = new RefSupplierDAO();
        boolean expResult = false;
        boolean result = instance.EncodeRefSupplier(newRefSupplier);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MonitorRefSupplier method, of class RefSupplierDAO.
     */
    @Test
    public void testMonitorRefSupplier() {
        System.out.println("MonitorRefSupplier");
        RefSupplierDAO instance = new RefSupplierDAO();
        ArrayList<RefSupplier> expResult = null;
        ArrayList<RefSupplier> result = instance.MonitorRefSupplier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchSupplier method, of class RefSupplierDAO.
     */
    @Test
    public void testSearchSupplier() throws Exception {
        System.out.println("searchSupplier");
        String supplierName = "";
        RefSupplierDAO instance = new RefSupplierDAO();
        ArrayList<RefSupplier> expResult = null;
        ArrayList<RefSupplier> result = instance.searchSupplier(supplierName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchSupplierItem method, of class RefSupplierDAO.
     */
    @Test
    public void testSearchSupplierItem() throws Exception {
        System.out.println("searchSupplierItem");
        String itemName = "";
        String company = "";
        RefSupplierDAO instance = new RefSupplierDAO();
        ArrayList<RefSupplier> expResult = null;
        ArrayList<RefSupplier> result = instance.searchSupplierItem(itemName, company);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSupplierItem method, of class RefSupplierDAO.
     */
    @Test
    public void testSetSupplierItem() throws Exception {
        System.out.println("setSupplierItem");
        String itemName = "";
        String company = "";
        RefSupplierDAO instance = new RefSupplierDAO();
        ArrayList<RefSupplier> expResult = null;
        ArrayList<RefSupplier> result = instance.setSupplierItem(itemName, company);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
