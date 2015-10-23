/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.PurchaseOrder;
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
public class PurchaseOrderDAOTest {
    
    public PurchaseOrderDAOTest() {
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
     * Test of GetAllPurchaseOrder method, of class PurchaseOrderDAO.
     */
    @Test
    public void testGetAllPurchaseOrder() throws Exception {
        System.out.println("GetAllPurchaseOrder");
        PurchaseOrderDAO instance = new PurchaseOrderDAO();
        ArrayList<PurchaseOrder> expResult = null;
        ArrayList<PurchaseOrder> result = instance.GetAllPurchaseOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
