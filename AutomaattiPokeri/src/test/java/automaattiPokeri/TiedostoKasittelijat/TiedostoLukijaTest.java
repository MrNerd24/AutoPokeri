/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automaattiPokeri.TiedostoKasittelijat;

import java.util.ArrayList;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juuso
 */
public class TiedostoLukijaTest {
    
    public TiedostoLukijaTest() {
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

    @Test
    public void testGetKansio() {
        TiedostoLukija instance = new TiedostoLukija("Test", "testaus");
        String expResult = "testaus";
        String result = instance.getKansio();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetKansio() {
        String kansio = "toinenKansio";
        TiedostoLukija instance = new TiedostoLukija("Test", "testaus");
        assertEquals("testaus", instance.getKansio());
        instance.setKansio(kansio);
        assertEquals("toinenKansio", instance.getKansio());
    }

    @Test
    public void testGetRivit() {
        ArrayList<String> rivit = new ArrayList<String>();
        int random = new Random().nextInt(100);
        rivit.add(String.valueOf(random));
        rivit.add("Tämä");
        rivit.add("tiedosto");
        rivit.add("testaa");
        rivit.add("tiedostoon");
        rivit.add("kirjoittamista");
        TiedostoKirjoittaja instance = new TiedostoKirjoittaja("Test", "testaus", false);
        instance.kirjoita(rivit);
        TiedostoLukija lukija = new TiedostoLukija("Test", "testaus");
        ArrayList<String> luetut = lukija.getRivit();
        assertEquals(String.valueOf(random), luetut.get(0));
        assertEquals("kirjoittamista", luetut.get(luetut.size()-1));
    }

    @Test
    public void testGetTiedostoNimi() {
        TiedostoLukija instance = new TiedostoLukija("Test", "testaus");
        String expResult = "Test";
        String result = instance.getTiedostoNimi();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetTiedostoNimi() {
        String tiedostoNimi = "toinenNimi";
        TiedostoLukija instance = new TiedostoLukija("Test", "testaus");
        assertEquals("Test", instance.getTiedostoNimi());
        instance.setTiedostoNimi(tiedostoNimi);
        assertEquals("toinenNimi", instance.getTiedostoNimi());
    }

    @Test
    public void testTiedostoOlemassa() {
        TiedostoLukija instance = new TiedostoLukija("Testi", "testaus");
        boolean expResult = false;
        boolean result = instance.tiedostoOlemassa();
        assertEquals(expResult, result);
        instance.setTiedostoNimi("Test");
        expResult = true;
        result = instance.tiedostoOlemassa();
        assertEquals(expResult, result);
    }
    
}
