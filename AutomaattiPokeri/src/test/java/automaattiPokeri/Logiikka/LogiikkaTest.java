/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Logiikka;

import automaattiPokeri.Objektit.Kasi;
import automaattiPokeri.Objektit.Kortti;
import java.util.ArrayList;
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
public class LogiikkaTest {

    public LogiikkaTest() {
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
    public void testGetKadenKoodit() {
        Logiikka instance = new Logiikka(10);
        instance.taytaKasi();
        String[] result = instance.getKadenKoodit();
        assertEquals(false, result[0] == null);
    }

    @Test
    public void testTaytaKasi() {
        Logiikka instance = new Logiikka(10);
        assertEquals(true, instance.getKadenKoodit()[0] == null);
        instance.taytaKasi();
        assertEquals(false, instance.getKadenKoodit()[0] == null);

    }

    @Test
    public void testPalautaPakkaan_ArrayList() {
        ArrayList<Integer> indexit = new ArrayList<Integer>();
        indexit.add(2);
        indexit.add(3);
        Logiikka instance = new Logiikka(10);
        instance.taytaKasi();
        assertEquals(false, instance.getKadenKoodit()[2] == null);
        assertEquals(false, instance.getKadenKoodit()[3] == null);
        assertEquals(false, instance.getKadenKoodit()[1] == null);
        instance.palautaPakkaan(indexit);
        assertEquals(true, instance.getKadenKoodit()[2] == null);
        assertEquals(true, instance.getKadenKoodit()[3] == null);
        assertEquals(false, instance.getKadenKoodit()[1] == null);
    }

    @Test
    public void testPalautaPakkaan_int() {
        int index = 2;
        Logiikka instance = new Logiikka(10);
        instance.taytaKasi();
        assertEquals(false, instance.getKadenKoodit()[2] == null);
        instance.palautaPakkaan(index);
        assertEquals(true, instance.getKadenKoodit()[2] == null);

    }

    @Test
    public void testTyhjennaKasi() {
        Logiikka instance = new Logiikka(10);
        instance.taytaKasi();
        assertEquals(false, instance.getKadenKoodit()[2] == null);
        assertEquals(false, instance.getKadenKoodit()[4] == null);
        instance.tyhjennaKasi();
        assertEquals(true, instance.getKadenKoodit()[2] == null);
        assertEquals(true, instance.getKadenKoodit()[1] == null);
    }

    @Test
    public void testGetRahaaKaytossa() {
        Logiikka instance = new Logiikka(13);
        double expResult = 13;
        double result = instance.getRahaaKaytossa();
        assertEquals(expResult, result, 0.01);

    }

    @Test
    public void testSetRahaaKaytossa() {
        int rahaaKaytossa = 0;
        Logiikka instance = new Logiikka(1);
        instance.setRahaaKaytossa(15);
        double expResult = 15;
        double result = instance.getRahaaKaytossa();
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testGetPanos() {
        Logiikka instance = new Logiikka(10);
        instance.setPanos(2);
        double expResult = 2;
        double result = instance.getPanos();
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testSetPanos() {
        int panos = 4;
        Logiikka instance = new Logiikka(10);
        instance.setPanos(panos);
        assertEquals(panos, instance.getPanos(), 0.01);
    }

    @Test
    public void testLisaaRahaa() {
        int maara = 0;
        Logiikka instance = new Logiikka(10);
        assertEquals(true, instance.lisaaRahaa(3));
        assertEquals(false, instance.lisaaRahaa(-14));
        assertEquals(13, instance.getRahaaKaytossa(), 0.01);
        
    }

    @Test
    public void testPalkitse() {
        Logiikka instance = new Logiikka(10);
        Kasi kasi = instance.getKasi();
        kasi.lisaaKortti(new Kortti(2, Kortti.MAA_HERTTA));
        kasi.lisaaKortti(new Kortti(3, Kortti.MAA_HERTTA));
        kasi.lisaaKortti(new Kortti(4, Kortti.MAA_HERTTA));
        kasi.lisaaKortti(new Kortti(5, Kortti.MAA_HERTTA));
        kasi.lisaaKortti(new Kortti(6, Kortti.MAA_HERTTA));
        instance.setPanos(2);
        instance.palkitse();
        assertEquals(90, instance.getRahaaKaytossa(), 0.01);
    }

}
