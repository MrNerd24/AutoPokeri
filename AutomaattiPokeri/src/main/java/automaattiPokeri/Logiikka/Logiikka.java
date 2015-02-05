/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Logiikka;

import automaattiPokeri.Objektit.Kasi;
import automaattiPokeri.Objektit.Kortti;
import automaattiPokeri.Objektit.Pakka;
import java.util.ArrayList;



/**
 *
 * @author Juuso
 */
public class Logiikka {

    private Pakka pakka;
    private Kasi kasi;
    private double rahaaKaytossa = 0;
    private double panos = 0;
    private int[] arvostaKerroin;
    
    /**
     * Hai kerroin
     */
    public static final int KERROIN_HAI = 0;

    /**
     * Pari kerroin
     */
    public static final int KERROIN_PARI = 1;

    /**
     * Kaksiparia kerroin
     */
    public static final int KERROIN_KAKSIPARIA = 2;

    /**
     * Kolmoset kerroin
     */
    public static final int KERROIN_KOLMOSET = 2;

    /**
     * Suora kerroin
     */
    public static final int KERROIN_SUORA = 3;

    /**
     * Vari kerroin
     */
    public static final int KERROIN_VARI = 4;

    /**
     * Taysikasi kerroin
     */
    public static final int KERROIN_TAYSKASI = 7;

    /**
     * Neloset kerroin
     */
    public static final int KERROIN_NELOSET = 15;

    /**
     * Varisuora kerroin
     */
    public static final int KERROIN_VARISUORA = 40;

    /**
     * Reeti kerroin
     */
    public static final int KERROIN_REETI = 100;

    /**
     * Konstruktoi logiikan, annetaan alku rahamaara.
     * @param alkuRahaMaara Rahamaara alussa.
     */
    public Logiikka(double alkuRahaMaara) {
        pakka = new Pakka(true);
        kasi = new Kasi();
        paritaArvotJaKertoimet();
        setRahaaKaytossa(alkuRahaMaara);
    }

    /**
     *
     * @return Logiikan kayttama kasi
     */
    public Kasi getKasi() {
        return kasi;
    }

    /**
     * Luo ja palauttaa arrayn korttien koodeja, joita voi käyttää korttin tunnistamiseen
     * @return Array korttien koodeja
     */
    public String[] getKadenKoodit() {
        String[] koodit = new String[5];
        Kortti[] kortit = kasi.getKortit();
        for (int i = 0; i < kortit.length; i++) {
            if (kortit[i] != null) {
                koodit[i] = kortit[i].getKoodi();
            }
        }
        return koodit;
    }

    // Maailman ymmärretävin koodi ikinää:

    /**
     * Tayttaa logiikan kayttaman kaden sattumanvaraisilla korteilla, ei poista jo kadessa olevia kortteja.
     */
        public void taytaKasi() {
        pakka.sekoitaKortit();
        while (kasi.voiLisata()) {
            kasi.lisaaKortti(pakka.otaKortti());
        }
    }

    /**
     * Poistaa kadesta kortteja ja laittaa ne takaisin pakkaan.
     * @param indexit ArrayList palautettavien korttien indexeista.
     */
    public void palautaPakkaan(ArrayList<Integer> indexit) {
        for (int i = 0; i < indexit.size(); i++) {
            palautaPakkaan(indexit.get(i));
        }
    }

    /**
     * Poistaa kadesta yhden kortin ja palauttaa sen pakkaan
     * @param index plautettavan kortin index
     */
    public void palautaPakkaan(int index) {

        Kortti kortti = kasi.getKortti(index);
        if (kortti == null) {
            return;
        }
        pakka.lisaaKortti(kortti);
        kasi.poistaKortti(kortti);

    }
    
    /**
     * Palauttaa kaikki kortit pakkaan.
     */
    public void tyhjennaKasi() {
        for (int i = 0; i < 5; i++) {
            palautaPakkaan(i);
        }
    }

    /**
     *
     * @return palauttaa kaytossa olevan rahan maaran
     */
    public double getRahaaKaytossa() {
        return rahaaKaytossa;
    }

    /**
     * Asettaa kaytettavan rahan maaran
     * @param rahaaKaytossa Rahamaara joka logiikalle asetetaan.
     */
    public void setRahaaKaytossa(double rahaaKaytossa) {
        this.rahaaKaytossa = rahaaKaytossa;
    }

    /**
     *
     * @return Palauttaa tamanhetkisen panoksen.
     */
    public double getPanos() {
        return panos;
    }

    /**
     * asettaa kaytettavan panoksen
     * @param panos asetettava panos
     */
    public void setPanos(double panos) {
        this.panos = panos;
    }

    

    private void paritaArvotJaKertoimet() {
        arvostaKerroin = new int[]{Logiikka.KERROIN_REETI, Logiikka.KERROIN_VARISUORA, Logiikka.KERROIN_NELOSET, Logiikka.KERROIN_TAYSKASI, Logiikka.KERROIN_VARI, Logiikka.KERROIN_SUORA, Logiikka.KERROIN_KOLMOSET, Logiikka.KERROIN_KAKSIPARIA, Logiikka.KERROIN_PARI, Logiikka.KERROIN_HAI};
    }

    /**
     * Lisaa kaytettavaa rahaa
     * @param maara Lisattava maara
     * @return Palauttaa true jos mahdollista lisata, eli ei mene alle nollan, muuten false.
     */
    public boolean lisaaRahaa(double maara) {
        if (rahaaKaytossa + maara < 0) {
            return false;
        } else {
            rahaaKaytossa += maara;
            return true;
        }

    }

    /**
     * Laskee kaden arvon, laskee voitot panoksen perusteella ja lisää voiton rahamaaraan.
     */
    public void palkitse() {
        int arvo = kasi.getArvo();
        double voitto = panos * arvostaKerroin[arvo];
        lisaaRahaa(voitto);
    }

}
