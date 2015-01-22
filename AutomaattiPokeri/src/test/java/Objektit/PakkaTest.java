/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objektit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Juuso
 */
public class PakkaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public PakkaTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void tyhjanLuonti() {
        Pakka pakka = new Pakka(false);
        thrown.expect(Error.class);
        pakka.otaKortti();

    }
    
    @Test
    public void taydenLuonti() {
        Pakka pakka = new Pakka(true);
        assertEquals("13_3", pakka.otaKortti().getKoodi());
    }
    
    @Test
    public void kortinLisays() {
        Pakka pakka = new Pakka(false);
        pakka.lisaaKortti(new Kortti(Kortti.NUMERO_JATKA, Kortti.MAA_RISTI));
        assertEquals(1, pakka.size());
    }
    
    @Test
    public void kortinLisaysJaPoista() {
        Pakka pakka = new Pakka(false);
        pakka.lisaaKortti(new Kortti(Kortti.NUMERO_JATKA, Kortti.MAA_RISTI));
        assertEquals("11_1", pakka.otaKortti());
    }
}
