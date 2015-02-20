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
public class TiedostoKirjoittajaTest {

    public TiedostoKirjoittajaTest() {
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
        TiedostoKirjoittaja instance = new TiedostoKirjoittaja("Test", "testaus", false);
        String expResult = "testaus";
        String result = instance.getKansio();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetKansio() {
        String kansio = "toinenKansio";
        TiedostoKirjoittaja instance = new TiedostoKirjoittaja("Test", "testaus", false);
        assertEquals("testaus", instance.getKansio());
        instance.setKansio(kansio);
        assertEquals("toinenKansio", instance.getKansio());
    }

    @Test
    public void testGetTiedostoNimi() {
        TiedostoKirjoittaja instance = new TiedostoKirjoittaja("Test", "testaus", false);
        String expResult = "Test";
        String result = instance.getTiedostoNimi();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetTiedostoNimi() {
        String tiedosto = "toinenTiedosto";
        TiedostoKirjoittaja instance = new TiedostoKirjoittaja("Test", "testaus", false);
        assertEquals("Test", instance.getTiedostoNimi());
        instance.setTiedostoNimi(tiedosto);
        assertEquals("toinenTiedosto", instance.getTiedostoNimi());
    }

    @Test
    public void testIsAppend() {
        TiedostoKirjoittaja instance = new TiedostoKirjoittaja("Test", "testaus", false);
        boolean expResult = false;
        boolean result = instance.isAppend();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetAppend() {
        boolean append = true;
        TiedostoKirjoittaja instance = new TiedostoKirjoittaja("Test", "testaus", false);
        assertEquals(false, instance.isAppend());
        instance.setAppend(append);
        assertEquals(true, instance.isAppend());
    }

    @Test
    public void testKirjoita() {
        ArrayList<String> rivit = new ArrayList<String>();
        int random = new Random().nextInt(100);
        rivit.add(String.valueOf(random));
        rivit.add("Tämä");
        rivit.add("tiedosto");
        rivit.add("testaa");
        rivit.add("tiedostoon");
        rivit.add("kirjoittamista");
        TiedostoKirjoittaja instance = new TiedostoKirjoittaja("Test", "testaus", false);
        instance.Kirjoita(rivit);
        TiedostoLukija lukija = new TiedostoLukija("Test", "testaus");
        ArrayList<String> luetut = lukija.getRivit();
        assertEquals(String.valueOf(random), luetut.get(0));
    }

}
