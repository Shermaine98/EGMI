/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
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
public class UserDAOTest {
    
    public UserDAOTest() {
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
     * Test of register method, of class UserDAO.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        User newUser = null;
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.register(newUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of authenticate method, of class UserDAO.
     */
    @Test
    public void testAuthenticate() {
        System.out.println("authenticate");
        User User = null;
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.authenticate(User);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastEmpNumber method, of class UserDAO.
     */
    @Test
    public void testGetLastEmpNumber() {
        System.out.println("getLastEmpNumber");
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.getLastEmpNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class UserDAO.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        String username = "";
        String password = "";
        UserDAO instance = new UserDAO();
        User expResult = null;
        User result = instance.getUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
