/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.DeliveryOrder;
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
public class DeliveryOrderDAOTest {
    
    public DeliveryOrderDAOTest() {
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
     * Test of EncodeDeliveryOrder method, of class DeliveryOrderDAO.
     */
    @Test
    public void testEncodeDeliveryOrder() {
        System.out.println("EncodeDeliveryOrder");
        DeliveryOrder newDeliveryOrder = null;
        DeliveryOrderDAO instance = new DeliveryOrderDAO();
        boolean expResult = false;
        boolean result = instance.EncodeDeliveryOrder(newDeliveryOrder);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetDeliveryOrderList method, of class DeliveryOrderDAO.
     */
    @Test
    public void testGetDeliveryOrderList() throws Exception {
        System.out.println("GetDeliveryOrderList");
        DeliveryOrderDAO instance = new DeliveryOrderDAO();
        ArrayList<DeliveryOrder> expResult = null;
        ArrayList<DeliveryOrder> result = instance.GetDeliveryOrderList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeliveryOrderNumber method, of class DeliveryOrderDAO.
     */
    @Test
    public void testGetDeliveryOrderNumber() throws Exception {
        System.out.println("getDeliveryOrderNumber");
        DeliveryOrderDAO instance = new DeliveryOrderDAO();
        Integer expResult = null;
        Integer result = instance.getDeliveryOrderNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
