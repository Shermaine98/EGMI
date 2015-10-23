/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.PickingForm;
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
public class PickingFormDAOTest {
    
    public PickingFormDAOTest() {
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
     * Test of EncodepickingForm method, of class PickingFormDAO.
     */
    @Test
    public void testEncodepickingForm() {
        System.out.println("EncodepickingForm");
        PickingForm newPickingForm = null;
        PickingFormDAO instance = new PickingFormDAO();
        boolean expResult = false;
        boolean result = instance.EncodepickingForm(newPickingForm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetAllPickingForm method, of class PickingFormDAO.
     */
    @Test
    public void testGetAllPickingForm() throws Exception {
        System.out.println("GetAllPickingForm");
        PickingFormDAO instance = new PickingFormDAO();
        ArrayList<PickingForm> expResult = null;
        ArrayList<PickingForm> result = instance.GetAllPickingForm();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
