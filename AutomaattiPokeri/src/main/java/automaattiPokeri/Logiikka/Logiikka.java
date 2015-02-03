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

    public Logiikka(double alkuRahaMaara) {
        pakka = new Pakka(true);
        kasi = new Kasi();
        paritaArvotJaKertoimet();
        setRahaaKaytossa(alkuRahaMaara);
    }

    public Kasi getKasi() {
        return kasi;
    }

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
    public void taytaKasi() {
        pakka.sekoitaKortit();
        while (kasi.voiLisata()) {
            kasi.lisaaKortti(pakka.otaKortti());
        }
    }

    public void palautaPakkaan(ArrayList<Integer> indexit) {
        for (int i = 0; i < indexit.size(); i++) {
            palautaPakkaan(indexit.get(i));
        }
    }

    public void palautaPakkaan(int index) {

        Kortti kortti = kasi.getKortti(index);
        if (kortti == null) {
            return;
        }
        pakka.lisaaKortti(kortti);
        kasi.poistaKortti(kortti);

    }
    
    public void tyhjennaKasi() {
        for (int i = 0; i < 5; i++) {
            palautaPakkaan(i);
        }
    }

    public double getRahaaKaytossa() {
        return rahaaKaytossa;
    }

    public void setRahaaKaytossa(double rahaaKaytossa) {
        this.rahaaKaytossa = rahaaKaytossa;
    }

    public double getPanos() {
        return panos;
    }

    public void setPanos(double panos) {
        this.panos = panos;
    }

    public static final int KERROIN_HAI = 0;
    public static final int KERROIN_PARI = 1;
    public static final int KERROIN_KAKSIPARIA = 2;
    public static final int KERROIN_KOLMOSET = 2;
    public static final int KERROIN_SUORA = 3;
    public static final int KERROIN_VARI = 4;
    public static final int KERROIN_TAYSKASI = 7;
    public static final int KERROIN_NELOSET = 15;
    public static final int KERROIN_VARISUORA = 40;
    public static final int KERROIN_REETI = 100;

    private void paritaArvotJaKertoimet() {
        arvostaKerroin = new int[]{Logiikka.KERROIN_REETI, Logiikka.KERROIN_VARISUORA, Logiikka.KERROIN_NELOSET, Logiikka.KERROIN_TAYSKASI, Logiikka.KERROIN_VARI, Logiikka.KERROIN_SUORA, Logiikka.KERROIN_KOLMOSET, Logiikka.KERROIN_KAKSIPARIA, Logiikka.KERROIN_PARI, Logiikka.KERROIN_HAI};
    }

    public boolean lisaaRahaa(double maara) {
        if (rahaaKaytossa + maara < 0) {
            return false;
        } else {
            rahaaKaytossa += maara;
            return true;
        }

    }

    public void palkitse() {
        int arvo = kasi.getArvo();
        double voitto = panos * arvostaKerroin[arvo];
        lisaaRahaa(voitto);
    }

}
