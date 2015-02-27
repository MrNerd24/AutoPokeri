/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.KayttoliittymaKuuntelijat;

import automaattiPokeri.Kayttoliittyma.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Juuso
 */
public class PalautusKuuntelija implements ActionListener {

    private boolean uusiJako = false;
    private Peli peli;

    /**
     * Luo uuden palautuskuuntelijan. kuuntelee pelissa vaihda kortit tai uusi
     * jako nappulaa.
     *
     * @param peli pelin ilmentyma
     */
    public PalautusKuuntelija(Peli peli) {

        this.peli = peli;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!peli.peliloppu) {
            peli.alaNappulaPainallus(uusiJako);
            uusiJako = !uusiJako;
        }

    }

}
