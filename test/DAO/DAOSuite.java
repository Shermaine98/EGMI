/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author shermainesy
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({DAO.DeliveryOrderDAOTest.class, DAO.BoutiqueInventoryDAOTest.class, DAO.UserDAOTest.class, DAO.PurchaseOrderDAOTest.class, DAO.PickingFormDAOTest.class, DAO.WarehouseInventoryDAOTest.class, DAO.ProductionInventoryDAOTest.class, DAO.BillOfMaterialsDAOTest.class, DAO.SubconPurchaseOrderDAOTest.class, DAO.AccessoriesInventoryDAOTest.class, DAO.RefSubconDAOTest.class, DAO.DeliveryReceiptDAOTest.class, DAO.RefSupplierDAOTest.class, DAO.ConsumptionReportDAOTest.class, DAO.mainTest.class, DAO.SupplierPurchaseOrderDAOTest.class, DAO.RefItemDAOTest.class, DAO.ReplenishmentRequestDAOTest.class})
public class DAOSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
