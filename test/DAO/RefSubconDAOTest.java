/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.RefSubcon;
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
public class RefSubconDAOTest {
    
    public RefSubconDAOTest() {
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
     * Test of EncodeRefSubcon method, of class RefSubconDAO.
     */
    @Test
    public void testEncodeRefSubcon() {
        System.out.println("EncodeRefSubcon");
        RefSubcon newRefSubcon = null;
        RefSubconDAO instance = new RefSubconDAO();
        boolean expResult = false;
        boolean result = instance.EncodeRefSubcon(newRefSubcon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MonitorRefSubcon method, of class RefSubconDAO.
     */
    @Test
    public void testMonitorRefSubcon() {
        System.out.println("MonitorRefSubcon");
        RefSubconDAO instance = new RefSubconDAO();
        ArrayList<RefSubcon> expResult = null;
        ArrayList<RefSubcon> result = instance.MonitorRefSubcon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubcon method, of class RefSubconDAO.
     */
    @Test
    public void testGetSubcon() throws Exception {
        System.out.println("getSubcon");
        int subconID = 0;
        RefSubconDAO instance = new RefSubconDAO();
        ArrayList<RefSubcon> expResult = null;
        ArrayList<RefSubcon> result = instance.getSubcon(subconID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchSubcon method, of class RefSubconDAO.
     */
    @Test
    public void testSearchSubcon() throws Exception {
        System.out.println("searchSubcon");
        String subconName = "";
        RefSubconDAO instance = new RefSubconDAO();
        ArrayList<RefSubcon> expResult = null;
        ArrayList<RefSubcon> result = instance.searchSubcon(subconName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchSubconAll method, of class RefSubconDAO.
     */
    @Test
    public void testSearchSubconAll() throws Exception {
        System.out.println("searchSubconAll");
        String subconName = "";
        RefSubconDAO instance = new RefSubconDAO();
        ArrayList<RefSubcon> expResult = null;
        ArrayList<RefSubcon> result = instance.searchSubconAll(subconName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
