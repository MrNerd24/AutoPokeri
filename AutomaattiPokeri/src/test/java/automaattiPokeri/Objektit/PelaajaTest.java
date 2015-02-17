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
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300", "0");
        assertEquals(new Long(42), instance.getKaynnissa_rahaMaara());
        instance.setKaynnissa_rahaMaara(36L);
        assertEquals(new Long(36), instance.getKaynnissa_rahaMaara());
    }

    @Test
    public void testSetKaynnissa_panos() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300", "0");
        assertEquals(new Integer(7), instance.getKaynnissa_panos());
        instance.setKaynnissa_panos(14);
        assertEquals(new Integer(14), instance.getKaynnissa_panos());
    }

    @Test
    public void testSetSuurinRahaMaara() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300", "0");
        assertEquals(1337L, instance.getSuurinRahaMaara());
        instance.setSuurinRahaMaara(2000L);
        assertEquals(2000L, instance.getSuurinRahaMaara());
    }

    @Test
    public void testSetSuurinVoitto() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300", "0");
        assertEquals(300L, instance.getSuurinVoitto());
        instance.setSuurinVoitto(500L);
        assertEquals(500L, instance.getSuurinVoitto());
    }

    @Test
    public void testGetKayttajaTunnus() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300", "0");
        assertEquals("Uolevi", instance.getKayttajaTunnus());
    }

    @Test
    public void testGetKaynnissa_rahaMaara() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300", "0");
        assertEquals(new Long(42), instance.getKaynnissa_rahaMaara());
    }

    @Test
    public void testGetKaynnissa_panos() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300", "0");
        assertEquals(new Integer(7), instance.getKaynnissa_panos());
    }

    @Test
    public void testGetSuurinRahaMaara() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300", "0");
        assertEquals(1337L, instance.getSuurinRahaMaara());
    }

    @Test
    public void testGetSuurinVoitto() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300", "0");
        assertEquals(300L, instance.getSuurinVoitto());
    }

    @Test
    public void testGetAikaPelattuMins() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300", "5473642");
        assertEquals(new BigInteger("5473642"), instance.getAikaPelattuMins());
    }

    @Test
    public void testTallennaTiedot() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300", "5473642");
        instance.tallennaTiedot();
        File tiedosto = new File("PeliTallenteita\\pelaajat\\Uolevi.txt");
        assertEquals(true, tiedosto.exists());
    }

    @Test
    public void testCompareTo() {
        Pelaaja kapistelija = new Pelaaja("Uolevi", "42", "7", "1337", "300", "5473642");
        Pelaaja vanhus = new Pelaaja("Irmeli", "62851", "2000", "5486873524", "200", "9769764753656585426");
        assertEquals(1, vanhus.compareTo(kapistelija));
        vanhus.setJarjestaSuurimmanVoitonMukaan(true);
        assertEquals(-1, vanhus.compareTo(kapistelija));
        
    }

    @Test
    public void testIsJarjestaSuurimmanVoitonMukaan() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300", "5473642");
        assertEquals(false, instance.isJarjestaSuurimmanVoitonMukaan());
    }

    @Test
    public void testSetJarjestaSuurimmanVoitonMukaan() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300", "5473642");
        assertEquals(false, instance.isJarjestaSuurimmanVoitonMukaan());
        instance.setJarjestaSuurimmanVoitonMukaan(true);
        assertEquals(true, instance.isJarjestaSuurimmanVoitonMukaan());
    }

    @Test
    public void testToString() {
        Pelaaja instance = new Pelaaja("Uolevi", "42", "7", "1337", "300", "5473642");
        assertEquals("Uolevi", instance.toString());
    }

}
