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

/**
 *
 * @author Juuso
 */
public class TiedostoLukija {

    private ArrayList<String> rivit;
    private String tiedostoNimi;
    private final String POLKU = "AutomaattiPokeriTallenteita/";
    private File tiedosto;
    private Scanner lukija;
    private String kansio;

    /**
     * Luo uuden tiedostolukijan
     * @param tiedostoNimi luettavan tiedoston nimi
     * @param kansio tiedoston kansio
     */
    public TiedostoLukija(String tiedostoNimi, String kansio) {
        this.tiedostoNimi = tiedostoNimi;
        this.kansio = kansio;
    }

    /**
     * Palauttaa kaytettavan kansion
     * @return kansion nimi
     */
    public String getKansio() {
        return kansio;
    }

    /**
     * Asettaa kaytettavan kansion
     * @param kansio kansion nimi
     */
    public void setKansio(String kansio) {
        this.kansio = kansio;
    }

    /**
     * Palautaa tiedoston rivit
     * @return lista riveja
     */
    public ArrayList<String> getRivit() {
        lueTiedosto();
        return rivit;
    }

    /**
     * Palauttaa tiedoston nimen
     * @return tiedoston nimi
     */
    public String getTiedostoNimi() {
        return tiedostoNimi;
    }

    /**
     * Asettaa tiedoston nimen
     * @param tiedostoNimi luettavan tiedoston nimi
     */
    public void setTiedostoNimi(String tiedostoNimi) {
        this.tiedostoNimi = tiedostoNimi;
    }
    
    /**
     * Kertoo onko tiedosto olemassa kuvatussa polussa
     * @return true jos on olemassa-
     */
    public boolean tiedostoOlemassa() {
        luoFile();
        if (tiedosto == null) {
            return false;
        }
        return tiedosto.exists();
    }

    private void luoFile() {
        String polku = POLKU + kansio + "/" + tiedostoNimi + ".txt";
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
