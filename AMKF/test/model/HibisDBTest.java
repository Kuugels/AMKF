/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samuli Käkönen
 */
public class HibisDBTest {
    
    public HibisDBTest() {
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
     * Test of sulje method, of class HibisDB.
     */
    /*
    @Test
    public void testSulje() {
        System.out.println("sulje");
        HibisDB instance = new HibisDB();
        instance.sulje();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of readKäyttäjä method, of class HibisDB.
     */
    
    @Test
    public void testReadKäyttäjä() {
        System.out.println("readK\u00e4ytt\u00e4j\u00e4");
        int id = 1;
        HibisDB instance = new HibisDB();
        String expResult = "Mikko";
        Käyttäjä käyttäjä = instance.readKäyttäjä(id);
        String result = käyttäjä.getNimi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of readKoulu method, of class HibisDB.
     */
    /*
    @Test
    public void testReadKoulu() {
        System.out.println("readKoulu");
        int id = 1;
        HibisDB instance = new HibisDB();
        String expResult = "Metropolia";
        String result = instance.readKoulu(id).getNimi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    */
    /**
     * Test of readKoulutukset method, of class HibisDB.
     */
    
    @Test
    public void testReadKoulutukset() {
        System.out.println("readKoulutukset");
        HibisDB instance = new HibisDB();
        String expResult = "Tieto- ja viestintätekniikka";
        Koulutus[] koulutuslista = instance.readKoulutukset();
        String result = koulutuslista[0].getNimi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    

    /**
     * Test of readMielenkiinnot method, of class HibisDB.
     */
    /*
    @Test
    public void testReadMielenkiinnot() {
        System.out.println("readMielenkiinnot");
        HibisDB instance = new HibisDB();
        Mielenkiinto[] expResult = null;
        Mielenkiinto[] result = instance.readMielenkiinnot();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of readAsuinalueet method, of class HibisDB.
     */
    
    @Test
    public void testReadAsuinalueet() {
        System.out.println("readAsuinalueet");
        HibisDB instance = new HibisDB();
        String expResult = "Uusimaa";
        Asuinalue[] asuinaluelista = instance.readAsuinalueet();
        String result = asuinaluelista[0].getNimi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    

    /**
     * Test of lisääPisteitä method, of class HibisDB.
     */
    
    @Test
    public void testLisääPisteitä() {
        System.out.println("lis\u00e4\u00e4Pisteit\u00e4");
        int pisteet = 0;
        String tagi = "Kielet";
        HibisDB instance = new HibisDB();
        boolean expResult = true;
        boolean result = instance.lisääPisteitä(pisteet, tagi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    

    /**
     * Test of resetAllPisteet method, of class HibisDB.
     */
    /*
    @Test
    public void testResetAllPisteet() {
        System.out.println("resetAllPisteet");
        HibisDB instance = new HibisDB();
        instance.resetAllPisteet();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of getTopKoulutukset method, of class HibisDB.
     */
    /*
    @Test
    public void testGetTopKoulutukset() {
        System.out.println("getTopKoulutukset");
        int topMäärä = 0;
        HibisDB instance = new HibisDB();
        Koulutus[] expResult = null;
        Koulutus[] result = instance.getTopKoulutukset(topMäärä);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of erotteleTagit method, of class HibisDB.
     */
    /*
    @Test
    public void testErotteleTagit() {
        System.out.println("erotteleTagit");
        Koulutus koulutus = null;
        HibisDB instance = new HibisDB();
        String[] expResult = null;
        String[] result = instance.erotteleTagit(koulutus);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    
}
