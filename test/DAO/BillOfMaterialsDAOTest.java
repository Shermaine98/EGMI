/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.BillOfMaterials;
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
public class BillOfMaterialsDAOTest {
    
    public BillOfMaterialsDAOTest() {
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
     * Test of EncodeBillOfMaterials method, of class BillOfMaterialsDAO.
     */
    @Test
    public void testEncodeBillOfMaterials() {
        System.out.println("EncodeBillOfMaterials");
        BillOfMaterials newBillOfMaterials = null;
        BillOfMaterialsDAO instance = new BillOfMaterialsDAO();
        boolean expResult = false;
        boolean result = instance.EncodeBillOfMaterials(newBillOfMaterials);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MonitorBillOfMaterials method, of class BillOfMaterialsDAO.
     */
    @Test
    public void testMonitorBillOfMaterials() {
        System.out.println("MonitorBillOfMaterials");
        BillOfMaterialsDAO instance = new BillOfMaterialsDAO();
        ArrayList<BillOfMaterials> expResult = null;
        ArrayList<BillOfMaterials> result = instance.MonitorBillOfMaterials();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchProduct method, of class BillOfMaterialsDAO.
     */
    @Test
    public void testSearchProduct() throws Exception {
        System.out.println("searchProduct");
        String productID = "";
        BillOfMaterialsDAO instance = new BillOfMaterialsDAO();
        ArrayList<BillOfMaterials> expResult = null;
        ArrayList<BillOfMaterials> result = instance.searchProduct(productID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductNumber method, of class BillOfMaterialsDAO.
     */
    @Test
    public void testGetProductNumber() throws Exception {
        System.out.println("getProductNumber");
        BillOfMaterialsDAO instance = new BillOfMaterialsDAO();
        Integer expResult = null;
        Integer result = instance.getProductNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
