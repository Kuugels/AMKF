/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import model.AMKFKone;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samuli Käkönen
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
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
     * Test of initialize method, of class LoginController.
     */
    
    @Test
    public void dummyTest() {
        System.out.println("Dummy test");
    }
    
   /*@Test
    public void testInitialize() {
        AMKFKone kone = new AMKFKone();
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        LoginController instance = new LoginController();
        //instance.initialize(url, rb);

        String[] maakunnat = kone.getAsuinalueet();
        System.out.println("jotain testaus kommenttii höhö");
        assertEquals("Maakuntien haku epäonnistui", maakunnat != null);
        
        System.out.println("Eka testi");
        // TODO review the generated test code and remove the default call to fail.
    }*/

    /**
     * Test of closeButtonAction method, of class LoginController.
     */
    /*@Test
    public void testCloseButtonAction() {
        System.out.println("closeButtonAction");
        LoginController instance = new LoginController();
        instance.closeButtonAction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
