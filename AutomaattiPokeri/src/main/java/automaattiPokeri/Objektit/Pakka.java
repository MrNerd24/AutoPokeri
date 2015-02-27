/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Objektit;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Juuso
 */
public class Pakka {

    ArrayList<Kortti> kortit = new ArrayList<Kortti>();

    /**
     * Luo pakan
     *
     * @param taytaKortit True, jos haluat etta pakka taytetaan kaikilla
     * korteilla, muuten false.
     */
    public Pakka(boolean taytaKortit) {
        if (taytaKortit) {
            taytaKortit();
        }
    }

    /**
     * Tayttaa pakkaan puuttuvan kortit.
     */
    public void taytaKortit() {
        for (int maa = 0; maa < 4; maa++) {
            for (int numero = 1; numero <= 13; numero++) {
                Kortti kortti = new Kortti(numero, maa);
                if (!kortit.contains(kortti)) {
                    kortit.add(kortti);
                }
            }
        }
    }

    /**
     * Palauttaa pakkaan viimeisimmäksi lisatyn arvon ja poistaa sen pakasta.
     * Jos haluat sattumanvaraisen kortin, pitää pakka sekoittaa ensin.
     *
     * @throws Error jos pakka on tyhja.
     * @return Palauttaa kortin pakasta.
     */
    public Kortti otaKortti() {
        if (kortit.isEmpty()) {
            throw new Error("Korttipakka on tyhjä, mutta yritit ottaa kortin.");
        }
        return kortit.remove(kortit.size() - 1);
    }

    /**
     * Lisaa kortin pakkaan.
     *
     * @throws Error jos kortti oli jo pakassa.
     * @param kortti Lisattava kortti.
     */
    public void lisaaKortti(Kortti kortti) {
        if (kortit.contains(kortti)) {
            throw new Error("Yritit lisätä kortin joka oli jo pakassa");
        }
        kortit.add(kortti);
    }

    /**
     * Jarjestaa kortit. Jarjestaa ensin maan mukaan, ja maan sisalla numeron
     * mukaan.
     */
    public void jarjestaKortit() {
        Collections.sort(kortit);
    }

    /**
     * Sekoittaa kortit.
     */
    public void sekoitaKortit() {
        Collections.shuffle(kortit);
    }

    /**
     *
     * @return Palauttaa pakan koon.
     */
    public int size() {
        return kortit.size();
    }
}
