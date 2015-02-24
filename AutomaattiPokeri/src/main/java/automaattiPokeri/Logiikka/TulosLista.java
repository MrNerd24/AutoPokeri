/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Logiikka;

import automaattiPokeri.Objektit.Pelaaja;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Juuso
 */
public class TulosLista {

    private ArrayList<Pelaaja> pelaajat;
    private boolean voitonMukaan = false;

    /**
     *
     */
    public TulosLista() {
        pelaajat = new ArrayList<Pelaaja>();
        luePelaajat();
    }

    /**
     *
     * @return
     */
    public boolean isVoitonMukaan() {
        return voitonMukaan;
    }

    /**
     *
     * @param voitonMukaan
     */
    public void setVoitonMukaan(boolean voitonMukaan) {
        this.voitonMukaan = voitonMukaan;
        muutaSortPeruste();
    }

    private void luePelaajat() {
        File PelaajatKansio = new File("AutomaattiPokeriTallenteita\\pelaajat");
        for (File file : PelaajatKansio.listFiles()) {
            String nimi = file.getName();

            nimi = nimi.substring(0, nimi.length() - 4);

            pelaajat.add(new Pelaaja(nimi));
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getRahaStringit() {
        ArrayList<String> rahaStringit = new ArrayList<String>();
        muutaSortPeruste();
        
        Collections.sort(pelaajat, Collections.reverseOrder());
        for (Pelaaja pelaaja : pelaajat) {
            rahaStringit.add(String.valueOf(pelaaja.getSuurinRahaMaara()));
        }
        return rahaStringit;
        
    }
    
    /**
     *
     * @return
     */
    public ArrayList<String> getVoittoStringit() {
        ArrayList<String> VoittoStringit = new ArrayList<String>();
        muutaSortPeruste();
        Collections.sort(pelaajat, Collections.reverseOrder());
        for (Pelaaja pelaaja : pelaajat) {
            VoittoStringit.add(String.valueOf(pelaaja.getSuurinVoitto()));
        }
        return VoittoStringit;
        
    }
    
    /**
     *
     * @return
     */
    public ArrayList<String> getPelaajaStringit() {
        ArrayList<String> PelaajaStringit = new ArrayList<String>();
        muutaSortPeruste();
        Collections.sort(pelaajat, Collections.reverseOrder());
        for (Pelaaja pelaaja : pelaajat) {
            PelaajaStringit.add(pelaaja.toString());
        }
        return PelaajaStringit;
        
    }

    private void muutaSortPeruste() {
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.setJarjestaSuurimmanVoitonMukaan(voitonMukaan);
        }
    }

}
