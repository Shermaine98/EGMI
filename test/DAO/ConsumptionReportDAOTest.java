/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ConsumptionReport;
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
public class ConsumptionReportDAOTest {
    
    public ConsumptionReportDAOTest() {
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
     * Test of EncodeConsumptionReport method, of class ConsumptionReportDAO.
     */
    @Test
    public void testEncodeConsumptionReport() {
        System.out.println("EncodeConsumptionReport");
        ConsumptionReport newConsumptionReport = null;
        ConsumptionReportDAO instance = new ConsumptionReportDAO();
        boolean expResult = false;
        boolean result = instance.EncodeConsumptionReport(newConsumptionReport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetConsumptionReportList method, of class ConsumptionReportDAO.
     */
    @Test
    public void testGetConsumptionReportList() throws Exception {
        System.out.println("GetConsumptionReportList");
        int productionNumber = 0;
        ConsumptionReportDAO instance = new ConsumptionReportDAO();
        ArrayList<ConsumptionReport> expResult = null;
        ArrayList<ConsumptionReport> result = instance.GetConsumptionReportList(productionNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetConsumptionReportListGroupBy method, of class ConsumptionReportDAO.
     */
    @Test
    public void testGetConsumptionReportListGroupBy() throws Exception {
        System.out.println("GetConsumptionReportListGroupBy");
        ConsumptionReportDAO instance = new ConsumptionReportDAO();
        ArrayList<ConsumptionReport> expResult = null;
        ArrayList<ConsumptionReport> result = instance.GetConsumptionReportListGroupBy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductionNumber method, of class ConsumptionReportDAO.
     */
    @Test
    public void testGetProductionNumber() throws Exception {
        System.out.println("getProductionNumber");
        ConsumptionReportDAO instance = new ConsumptionReportDAO();
        Integer expResult = null;
        Integer result = instance.getProductionNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchProductName method, of class ConsumptionReportDAO.
     */
    @Test
    public void testSearchProductName() throws Exception {
        System.out.println("searchProductName");
        String productName = "";
        ConsumptionReportDAO instance = new ConsumptionReportDAO();
        ArrayList<ConsumptionReport> expResult = null;
        ArrayList<ConsumptionReport> result = instance.searchProductName(productName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
