/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logiikka;

import Objektit.Kasi;
import Objektit.Kortti;
import Objektit.Pakka;
import java.util.ArrayList;

/**
 *
 * @author Juuso
 */
public class Logiikka {
    private Pakka pakka;
    private Kasi kasi;
    private int rahaaKaytossa;
    
    public Logiikka() {
        pakka = new Pakka(true);
        kasi = new Kasi();
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
    private void taytaKasi() {
        pakka.sekoitaKortit();
        while (kasi.voiLisata()) {
            kasi.lisaaKortti(pakka.otaKortti());
        }
    }
    
    public void palautaPakkaan(ArrayList<Integer> indexit) {
        for (int i = 0; i < indexit.size(); i++) {
            Kortti kortti = kasi.getKortti(indexit.get(i));
            pakka.lisaaKortti(kortti);
            kasi.poistaKortti(kortti);
        }
    }
    
    
}
