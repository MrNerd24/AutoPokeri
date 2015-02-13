/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.TiedostoKasittelijat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juuso
 */
public class TiedostoLukija {

    private ArrayList<String> rivit;
    private String tiedostoNimi;
    private final String POLKU = "PeliTallenteita\\";
    private File tiedosto;
    private Scanner lukija;
    private String kansio;

    /**
     *
     * @param tiedostoNimi
     * @param kansio
     */
    public TiedostoLukija(String tiedostoNimi, String kansio) {
        this.tiedostoNimi = tiedostoNimi;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getRivit() {
        lueTiedosto();
        return rivit;
    }

    /**
     *
     * @return
     */
    public String getTiedostoNimi() {
        return tiedostoNimi;
    }

    /**
     *
     * @param tiedostoNimi
     */
    public void setTiedostoNimi(String tiedostoNimi) {
        this.tiedostoNimi = tiedostoNimi;
    }
    
    /**
     *
     * @return
     */
    public boolean tiedostoOlemassa() {
        luoFile();
        return tiedosto.exists();
    }

    private void luoFile() {
        tiedosto = new File(POLKU + kansio + "\\" + tiedostoNimi + ".txt");
    }

    private void luoScanner() {
        luoFile();
        try {
            lukija = new Scanner(tiedosto);
        } catch (FileNotFoundException ex) {
            lukija = null;
        }
    }

    private void lueTiedosto() {
        luoScanner();
        if (lukija == null) {
            return;
        }
        
        while (lukija.hasNext()) {
            String rivi = lukija.nextLine();
            if (rivi == "Tnull") {
                rivi = null;
            }
            rivit.add(rivi);
        }
    }

}
