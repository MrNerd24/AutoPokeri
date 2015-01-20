/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objektit;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Juuso
 */
public class Pakka {
    ArrayList<Kortti> kortit = new ArrayList<Kortti>();
    
    public Pakka(boolean taytaKortit) {
        if (taytaKortit) {
            taytaKortit();
        }
    }

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
    
    public Kortti otaKortti() {
        if (kortit.isEmpty()) {
            throw new Error("Korttipakka on tyhjä, mutta yritit ottaa kortin.");
        }
        return kortit.remove(kortit.size()-1);
    }
    
    public void lisaaKortti(Kortti kortti) {
        if (kortit.contains(kortti)) {
            throw new Error("Yritit lisätä kortin joka oli jo pakassa");
        }
        kortit.add(kortti);
    }
    
    public void jarjestaKortit() {
        Collections.sort(kortit);
    }
    
    public void sekoitaKortit() {
        Collections.shuffle(kortit);
    }
}
