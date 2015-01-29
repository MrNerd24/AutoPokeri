/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Objektit;

import automaattiPokeri.Objektit.Kasi;
import automaattiPokeri.Objektit.Kortti;
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
public class KasiTest {

    public KasiTest() {
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
    public void KasiTyhjaLuonnninJalkeen() {
        Kasi kasi = new Kasi();
        assertEquals(0, kasi.size());
    }

    @Test
    public void KorttiLisays1() {
        Kasi kasi = new Kasi();
        kasi.lisaaKortti(new Kortti(6, Kortti.MAA_RISTI));
        Kortti[] kortit = kasi.getKortit();
        assertEquals("6_1", kortit[0].getKoodi());
    }

    public int testaaArvo(int[][] korttiArvot) {
        Kasi kasi = new Kasi();
        for (int i = 0; i < korttiArvot.length; i++) {
            kasi.lisaaKortti(new Kortti(korttiArvot[i][0], korttiArvot[i][1]));
        }
        return kasi.getArvo();
    }

    @Test
    public void haiToimii() {
        int[][] kortit = new int[][]{{3, Kortti.MAA_PATA}, {4, Kortti.MAA_RISTI}, {8, Kortti.MAA_PATA}, {Kortti.NUMERO_KUNINGAS, Kortti.MAA_HERTTA}, {Kortti.NUMERO_ASSA, Kortti.MAA_RUUTU}};
        assertEquals(Kasi.ARVO_HAI, testaaArvo(kortit));
    }

    @Test
    public void pariToimii() {
        int[][] kortit = new int[][]{{3, Kortti.MAA_PATA}, {4, Kortti.MAA_RISTI}, {3, Kortti.MAA_RISTI}, {Kortti.NUMERO_KUNINGAS, Kortti.MAA_HERTTA}, {Kortti.NUMERO_ASSA, Kortti.MAA_RUUTU}};
        assertEquals(Kasi.ARVO_PARI, testaaArvo(kortit));
    }

    @Test
    public void kaksiPariaToimii() {
        int[][] kortit = new int[][]{{3, Kortti.MAA_PATA}, {4, Kortti.MAA_RISTI}, {3, Kortti.MAA_PATA}, {Kortti.NUMERO_KUNINGAS, Kortti.MAA_HERTTA}, {Kortti.NUMERO_KUNINGAS, Kortti.MAA_RUUTU}};
        assertEquals(Kasi.ARVO_KAKSIPARIA, testaaArvo(kortit));
    }

    @Test
    public void kolmosetToimii() {
        int[][] kortit = new int[][]{{3, Kortti.MAA_PATA}, {3, Kortti.MAA_RISTI}, {3, Kortti.MAA_RUUTU}, {Kortti.NUMERO_KUNINGAS, Kortti.MAA_HERTTA}, {Kortti.NUMERO_ASSA, Kortti.MAA_RISTI}};
        assertEquals(Kasi.ARVO_KOLMOSET, testaaArvo(kortit));
    }

    @Test
    public void suoraToimii() {
        int[][] kortit = new int[][]{{3, Kortti.MAA_PATA}, {4, Kortti.MAA_RISTI}, {5, Kortti.MAA_RUUTU}, {6, Kortti.MAA_HERTTA}, {7, Kortti.MAA_RISTI}};
        assertEquals(Kasi.ARVO_SUORA, testaaArvo(kortit));
    }

    @Test
    public void suoraToimii2() {
        int[][] kortit = new int[][]{{Kortti.NUMERO_ASSA, Kortti.MAA_PATA}, {Kortti.NUMERO_KUNINGAS, Kortti.MAA_RISTI}, {Kortti.NUMERO_KUNINGATAR, Kortti.MAA_RUUTU}, {Kortti.NUMERO_JATKA, Kortti.MAA_HERTTA}, {10, Kortti.MAA_RISTI}};
        assertEquals(Kasi.ARVO_SUORA, testaaArvo(kortit));
    }

    @Test
    public void variToimii() {
        int[][] kortit = new int[][]{{3, Kortti.MAA_PATA}, {4, Kortti.MAA_PATA}, {Kortti.NUMERO_ASSA, Kortti.MAA_PATA}, {6, Kortti.MAA_PATA}, {7, Kortti.MAA_PATA}};
        assertEquals(Kasi.ARVO_VARI, testaaArvo(kortit));
    }

    @Test
    public void variSuoraToimii() {
        int[][] kortit = new int[][]{{3, Kortti.MAA_PATA}, {4, Kortti.MAA_PATA}, {5, Kortti.MAA_PATA}, {6, Kortti.MAA_PATA}, {7, Kortti.MAA_PATA}};
        assertEquals(Kasi.ARVO_VARISUORA, testaaArvo(kortit));
    }

    @Test
    public void tayskasiToimii() {
        int[][] kortit = new int[][]{{3, Kortti.MAA_PATA}, {3, Kortti.MAA_RISTI}, {3, Kortti.MAA_RUUTU}, {6, Kortti.MAA_HERTTA}, {6, Kortti.MAA_RISTI}};
        assertEquals(Kasi.ARVO_TAYSIKASI, testaaArvo(kortit));
    }

    @Test
    public void nelosetToimii() {
        int[][] kortit = new int[][]{{3, Kortti.MAA_PATA}, {3, Kortti.MAA_RISTI}, {3, Kortti.MAA_RUUTU}, {3, Kortti.MAA_HERTTA}, {6, Kortti.MAA_RISTI}};
        assertEquals(Kasi.ARVO_NELOSET, testaaArvo(kortit));
    }

    @Test
    public void reetiToimii() {
        int[][] kortit = new int[][]{{10, Kortti.MAA_PATA}, {Kortti.NUMERO_JATKA, Kortti.MAA_PATA}, {Kortti.NUMERO_KUNINGAS, Kortti.MAA_PATA}, {Kortti.NUMERO_KUNINGATAR, Kortti.MAA_PATA}, {Kortti.NUMERO_ASSA, Kortti.MAA_PATA}};
        assertEquals(Kasi.ARVO_REETI, testaaArvo(kortit));
    }
    
    

}
