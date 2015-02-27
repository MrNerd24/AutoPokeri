/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Objektit;

import java.math.BigInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import automaattiPokeri.Objektit.Pelaaja;
import java.io.File;

/**
 *
 * @author Juuso
 */
public class PelaajaTest {

    public PelaajaTest() {
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
    public void testSetKaynnissa_rahaMaara() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300");
        assertEquals(42D, instance.getKaynnissaRahaMaara(), 0.01);
        instance.setKaynnissaRahaMaara(36D);
        assertEquals(36D, instance.getKaynnissaRahaMaara(), 0.01);
    }

    @Test
    public void testSetKaynnissa_panos() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300");
        assertEquals(7D, instance.getKaynnissaPanos(), 0.01);
        instance.setKaynnissaPanos(14D);
        assertEquals(14D, instance.getKaynnissaPanos(), 0.01);
    }

    @Test
    public void testSetSuurinRahaMaara() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300");
        assertEquals(1337D, instance.getSuurinRahaMaara(), 0.01);
        instance.setSuurinRahaMaara(2000D);
        assertEquals(2000D, instance.getSuurinRahaMaara(),0.01);
    }

    @Test
    public void testSetSuurinVoitto() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300");
        assertEquals(300D, instance.getSuurinVoitto(), 0.01);
        instance.setSuurinVoitto(500D);
        assertEquals(500D, instance.getSuurinVoitto(), 0.01);
    }

    @Test
    public void testGetKayttajaTunnus() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300");
        assertEquals("Uolevi", instance.getKayttajaTunnus());
    }

    @Test
    public void testGetKaynnissa_rahaMaara() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300");
        assertEquals(42D, instance.getKaynnissaRahaMaara(), 0.01);
    }

    @Test
    public void testGetKaynnissa_panos() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300");
        assertEquals(7D, instance.getKaynnissaPanos(), 0.01);
    }

    @Test
    public void testGetSuurinRahaMaara() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300");
        assertEquals(1337D, instance.getSuurinRahaMaara(), 0.01);
    }

    @Test
    public void testGetSuurinVoitto() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300");
        assertEquals(300D, instance.getSuurinVoitto(), 0.01);
    }


    @Test
    public void testTallennaTiedot() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300");
        instance.tallennaTiedot();
        File tiedosto = new File("AutomaattiPokeriTallenteita\\pelaajat\\Uolevi.txt");
        assertEquals(true, tiedosto.exists());
    }

    @Test
    public void testCompareTo() {
        Pelaaja kapistelija = new Pelaaja("Uolevi", "42", "7", "1337", "300");
        Pelaaja vanhus = new Pelaaja("Irmeli", "62851", "2000", "5486873524", "200");
        assertEquals(1, vanhus.compareTo(kapistelija));
        vanhus.setJarjestaSuurimmanVoitonMukaan(true);
        assertEquals(-1, vanhus.compareTo(kapistelija));
        
    }

    @Test
    public void testIsJarjestaSuurimmanVoitonMukaan() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300");
        assertEquals(false, instance.isJarjestaSuurimmanVoitonMukaan());
    }

    @Test
    public void testSetJarjestaSuurimmanVoitonMukaan() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300");
        assertEquals(false, instance.isJarjestaSuurimmanVoitonMukaan());
        instance.setJarjestaSuurimmanVoitonMukaan(true);
        assertEquals(true, instance.isJarjestaSuurimmanVoitonMukaan());
    }

    @Test
    public void testToString() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300");
        assertEquals("Uolevi", instance.toString());
    }

}
