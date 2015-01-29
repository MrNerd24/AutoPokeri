/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Objektit;

import automaattiPokeri.Objektit.Kortti;
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
public class KorttiTest {
    
    @Rule
     public ExpectedException thrown= ExpectedException.none();

    public KorttiTest() {
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
    private boolean UusiKorttiTiedotOikeat(int numero, int maa) {
        Kortti kortti = new Kortti(numero, maa);
        if (kortti.getNumero() == numero && kortti.getMaa() == maa) {
            return true;
        }
        return false;
    }

    @Test
    public void hertta8LuontiTesti() {
        assertEquals(true, UusiKorttiTiedotOikeat(8, Kortti.MAA_HERTTA));
    }

    @Test
    public void ristiAssaLuontiTesti() {
        assertEquals(true, UusiKorttiTiedotOikeat(Kortti.NUMERO_ASSA, Kortti.MAA_RISTI));
    }
    
    @Test
    public void RajanYlittavaLuontiTesti() {
        thrown.expect(Error.class);
        UusiKorttiTiedotOikeat(20,9);
    }
    
    @Test
    public void RajanYlittavaLuontiTesti2() {
        thrown.expect(Error.class);
        UusiKorttiTiedotOikeat(0,4);
    }


    @Test
    public void toStringToimii() {
        Kortti kortti = new Kortti(5, Kortti.MAA_RUUTU);
        assertEquals("Ruutu 5", kortti.toString());
    }
    
    @Test
    public void toStringToimii2() {
        Kortti kortti = new Kortti(Kortti.NUMERO_KUNINGAS, Kortti.MAA_RISTI);
        assertEquals("Risti kuningas", kortti.toString());
    }
    
    @Test
    public void getKoodiTesti() {
        Kortti kortti = new Kortti(4, Kortti.MAA_PATA);
        assertEquals("4_0", kortti.getKoodi());
    }
    
    @Test
    public void equalsToimii() {
        Kortti kortti1 = new Kortti(2, Kortti.MAA_HERTTA);
        Kortti kortti2 = new Kortti(2, Kortti.MAA_HERTTA);
        
        assertEquals(true, kortti1.equals(kortti2));
    }
    
    @Test
    public void equalsToimiiJosMaaEri() {
        Kortti kortti1 = new Kortti(8, Kortti.MAA_HERTTA);
        Kortti kortti2 = new Kortti(8, Kortti.MAA_RISTI);
        
        assertEquals(false, kortti1.equals(kortti2));
    }
    
    @Test
    public void equalsToimiiJosNumeroEri() {
        Kortti kortti1 = new Kortti(Kortti.NUMERO_KUNINGAS, Kortti.MAA_PATA);
        Kortti kortti2 = new Kortti(3, Kortti.MAA_PATA);
        
        assertEquals(false, kortti1.equals(kortti2));
    }
    
    @Test
    public void cloonausToimii() {
        Kortti kortti = new Kortti(7, Kortti.MAA_RUUTU);
        Kortti klooni = kortti.clone();
        assertEquals(true, kortti.equals(klooni));
        // Tässä olis kiva jos voisi muuttaa alkuperäistä ja kattoo tuleeko muutos klooniin. Mutta Korttia ei voi muuttaa, aka semi immutable.
    }
}
