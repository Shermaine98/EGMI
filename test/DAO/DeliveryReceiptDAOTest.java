/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.DeliveryReceipt;
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
public class DeliveryReceiptDAOTest {
    
    public DeliveryReceiptDAOTest() {
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
     * Test of EncodeDeliveryReceipt method, of class DeliveryReceiptDAO.
     */
    @Test
    public void testEncodeDeliveryReceipt() {
        System.out.println("EncodeDeliveryReceipt");
        DeliveryReceipt newDeliveryReceipt = null;
        DeliveryReceiptDAO instance = new DeliveryReceiptDAO();
        boolean expResult = false;
        boolean result = instance.EncodeDeliveryReceipt(newDeliveryReceipt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetDeliveryReceiptList method, of class DeliveryReceiptDAO.
     */
    @Test
    public void testGetDeliveryReceiptList() throws Exception {
        System.out.println("GetDeliveryReceiptList");
        DeliveryReceiptDAO instance = new DeliveryReceiptDAO();
        ArrayList<DeliveryReceipt> expResult = null;
        ArrayList<DeliveryReceipt> result = instance.GetDeliveryReceiptList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeliveryReceiptNumber method, of class DeliveryReceiptDAO.
     */
    @Test
    public void testGetDeliveryReceiptNumber() throws Exception {
        System.out.println("getDeliveryReceiptNumber");
        DeliveryReceiptDAO instance = new DeliveryReceiptDAO();
        Integer expResult = null;
        Integer result = instance.getDeliveryReceiptNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
