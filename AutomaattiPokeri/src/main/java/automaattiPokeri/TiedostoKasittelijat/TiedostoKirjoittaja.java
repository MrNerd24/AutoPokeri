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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juuso
 */
public class TiedostoKirjoittaja {

    private String tiedostoNimi;
    private boolean append;
    private BufferedWriter writer;
    private File tiedosto;
    private final String POLKU = "PeliTallenteita\\";
    private String kansio;

    /**
     *
     * @param tiedostoNimi
     * @param kansio
     * @param append
     */
    public TiedostoKirjoittaja(String tiedostoNimi, String kansio, boolean append) {
        this.tiedostoNimi = tiedostoNimi;
        this.kansio = kansio;
        this.append = append;
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
    public boolean isAppend() {
        return append;
    }

    /**
     *
     * @param append
     */
    public void setAppend(boolean append) {
        this.append = append;

    }

    /**
     *
     * @param rivit
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
        if (!tiedosto.exists()) {
            try {
                tiedosto.createNewFile();
            } catch (IOException ex) {
                throw new Error(ex.getMessage());
            }
        }
        try {
            this.writer = new BufferedWriter(new FileWriter(tiedosto, append));

        } catch (IOException ex) {
            throw new Error(ex.getCause());
        }
    }

    private void luoFile() {
        tiedosto = new File(POLKU + kansio + "\\" + tiedostoNimi + ".txt");
    }

}
