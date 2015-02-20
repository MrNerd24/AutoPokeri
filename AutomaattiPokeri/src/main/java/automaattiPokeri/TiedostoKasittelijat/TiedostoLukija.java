/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.TiedostoKasittelijat;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
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
    private final String POLKU = "AutomaattiPokeriTallenteita\\";
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
        this.kansio = kansio;
    }

    /**
     *
     * @return
     */
    public String getKansio() {
        return kansio;
    }

    /**
     *
     * @param kansio
     */
    public void setKansio(String kansio) {
        this.kansio = kansio;
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
        if (tiedosto == null) {
            return false;
        }
        return tiedosto.exists();
    }

    private void luoFile() {
        String polku = POLKU + kansio + "\\" + tiedostoNimi + ".txt";
        tiedosto = new File(polku);
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
        rivit = new ArrayList<String>();
        luoScanner();
        if (lukija == null) {
            return;
        }
        
        while (lukija.hasNext()) {
            String rivi = lukija.nextLine();
            rivit.add(rivi);
        }
    }

}
