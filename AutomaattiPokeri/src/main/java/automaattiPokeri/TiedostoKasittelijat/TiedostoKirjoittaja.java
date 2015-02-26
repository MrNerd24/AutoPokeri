/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.TiedostoKasittelijat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Juuso
 */
public class TiedostoKirjoittaja {

    private String tiedostoNimi;
    private boolean append;
    private BufferedWriter writer;
    private File tiedosto;
    private final String POLKU = "AutomaattiPokeriTallenteita\\";
    private String kansio;

    /**
     * Luo uuden tiedostokirjoittajan
     * @param tiedostoNimi Tiedoston nimi johon kirjoitetaan. Luokka voi luoda tiedoston jos sitä ei ole olemassa.
     * @param kansio Kansio mihin tiedosto tallennetaan
     * @param append Jos tiedosto on olemassa: false niin vanha tiedosto pyyhitaan, true niin kirjoitetaan tiedoston loppuun.
     */
    public TiedostoKirjoittaja(String tiedostoNimi, String kansio, boolean append) {
        this.tiedostoNimi = tiedostoNimi;
        this.kansio = kansio;
        this.append = append;
    }

    /**
     * Palauttaa kaytettavan kansion
     * @return Kansio
     */
    public String getKansio() {
        return kansio;
    }

    /**
     * Asettaa kaytettavan kansion
     * @param kansio uuden kansion nimi.
     */
    public void setKansio(String kansio) {
        this.kansio = kansio;
    }

    /**
     * Palauttaa tiedoston nimen.
     * @return Tiedoston nimi.
     */
    public String getTiedostoNimi() {
        return tiedostoNimi;
    }

    /**
     * Asettaa uuden tiedostonnimen.
     * @param tiedostoNimi Uusi tiedostonnimi.
     */
    public void setTiedostoNimi(String tiedostoNimi) {
        this.tiedostoNimi = tiedostoNimi;
    }

    /**
     * Keroo kirjoitetaanko olemassa olevan tiedoston peraan vai ei.
     * @return true jos kirjoitetaan, false jos ei.
     */
    public boolean isAppend() {
        return append;
    }

    /**
     * Asettaa kirjoitetaanko olemassa olevan tiedoston peraan vai ei
     * @param append true jos kirjoitetaan peraan, false jos vanha pyyhitaan.
     */
    public void setAppend(boolean append) {
        this.append = append;

    }

    /**
     * Kirjoittaa tiedostoon annetut rivit
     * @param rivit Kirjoitettavat rivit. jokainen String listassa saa oman rivin.
     */
    public void Kirjoita(ArrayList<String> rivit) {
        luoFileWriter();
        try {
            if (rivit.get(0) == null) {
                writer.write("Tnull");
            } else {
                writer.write(rivit.get(0));
            }
            for (int i = 1; i < rivit.size(); i++) {
                writer.newLine();
                if (rivit.get(i) == null) {
                    writer.write("Tnull");
                } else {
                    writer.write(rivit.get(i));
                }
            }
            writer.close();
        } catch (IOException ex) {
            throw new Error(ex.getCause());
        }
    }

    private void luoFileWriter() {
        luoFile();

        try {
            this.writer = new BufferedWriter(new FileWriter(tiedosto, append));

        } catch (IOException ex) {
            throw new Error(ex.getCause());
        }
    }

    private void luoFile() {
        String polku = POLKU + kansio + "\\" + tiedostoNimi + ".txt";
        tiedosto = new File(polku);
        if (!tiedosto.exists()) {
            tiedosto.getParentFile().mkdirs();
            try {
                tiedosto.createNewFile();
            } catch (IOException ex) {
                throw new Error(ex.getMessage());
            }
        }
    }



}
