/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.SubconPurchaseOrder;
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
public class SubconPurchaseOrderDAOTest {
    
    public SubconPurchaseOrderDAOTest() {
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
     * Test of EncodeSubconPurchaseOrder method, of class SubconPurchaseOrderDAO.
     */
    @Test
    public void testEncodeSubconPurchaseOrder() {
        System.out.println("EncodeSubconPurchaseOrder");
        SubconPurchaseOrder newSubconPurchaseOrder = null;
        SubconPurchaseOrderDAO instance = new SubconPurchaseOrderDAO();
        boolean expResult = false;
        boolean result = instance.EncodeSubconPurchaseOrder(newSubconPurchaseOrder);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MonitorSubconPurchaseOrder method, of class SubconPurchaseOrderDAO.
     */
    @Test
    public void testMonitorSubconPurchaseOrder() throws Exception {
        System.out.println("MonitorSubconPurchaseOrder");
        SubconPurchaseOrderDAO instance = new SubconPurchaseOrderDAO();
        ArrayList<SubconPurchaseOrder> expResult = null;
        ArrayList<SubconPurchaseOrder> result = instance.MonitorSubconPurchaseOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubconPurchaseOrderNumber method, of class SubconPurchaseOrderDAO.
     */
    @Test
    public void testGetSubconPurchaseOrderNumber() throws Exception {
        System.out.println("getSubconPurchaseOrderNumber");
        SubconPurchaseOrderDAO instance = new SubconPurchaseOrderDAO();
        Integer expResult = null;
        Integer result = instance.getSubconPurchaseOrderNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
