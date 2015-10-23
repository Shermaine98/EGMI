/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.SupplierPurchaseOrder;
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
public class SupplierPurchaseOrderDAOTest {
    
    public SupplierPurchaseOrderDAOTest() {
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
     * Test of EncodeSupplierPurchaseOrder method, of class SupplierPurchaseOrderDAO.
     */
    @Test
    public void testEncodeSupplierPurchaseOrder() {
        System.out.println("EncodeSupplierPurchaseOrder");
        SupplierPurchaseOrder newSupplierPurchaseOrder = null;
        SupplierPurchaseOrderDAO instance = new SupplierPurchaseOrderDAO();
        boolean expResult = false;
        boolean result = instance.EncodeSupplierPurchaseOrder(newSupplierPurchaseOrder);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetAllSupplierPurchaseOrder method, of class SupplierPurchaseOrderDAO.
     */
    @Test
    public void testGetAllSupplierPurchaseOrder() throws Exception {
        System.out.println("GetAllSupplierPurchaseOrder");
        SupplierPurchaseOrderDAO instance = new SupplierPurchaseOrderDAO();
        ArrayList<SupplierPurchaseOrder> expResult = null;
        ArrayList<SupplierPurchaseOrder> result = instance.GetAllSupplierPurchaseOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSupplierPurchaseOrderNumber method, of class SupplierPurchaseOrderDAO.
     */
    @Test
    public void testGetSupplierPurchaseOrderNumber() throws Exception {
        System.out.println("getSupplierPurchaseOrderNumber");
        SupplierPurchaseOrderDAO instance = new SupplierPurchaseOrderDAO();
        Integer expResult = null;
        Integer result = instance.getSupplierPurchaseOrderNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
