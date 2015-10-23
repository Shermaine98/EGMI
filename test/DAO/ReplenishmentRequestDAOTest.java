/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ReplenishmentRequest;
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
public class ReplenishmentRequestDAOTest {
    
    public ReplenishmentRequestDAOTest() {
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
     * Test of EncodeReplenishmentRequest method, of class ReplenishmentRequestDAO.
     */
    @Test
    public void testEncodeReplenishmentRequest() {
        System.out.println("EncodeReplenishmentRequest");
        ReplenishmentRequest newReplenishmentRequest = null;
        ReplenishmentRequestDAO instance = new ReplenishmentRequestDAO();
        boolean expResult = false;
        boolean result = instance.EncodeReplenishmentRequest(newReplenishmentRequest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetReplenishmentRe method, of class ReplenishmentRequestDAO.
     */
    @Test
    public void testGetReplenishmentRe() throws Exception {
        System.out.println("GetReplenishmentRe");
        ReplenishmentRequestDAO instance = new ReplenishmentRequestDAO();
        ArrayList<ReplenishmentRequest> expResult = null;
        ArrayList<ReplenishmentRequest> result = instance.GetReplenishmentRe();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
