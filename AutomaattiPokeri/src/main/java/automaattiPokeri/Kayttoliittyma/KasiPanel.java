/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Kayttoliittyma;

import automaattiPokeri.KayttoliittymaKuuntelijat.KorttiKuuntelija;
import automaattiPokeri.Interfaces.KoonMuuttaja;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author Juuso
 */
public class KasiPanel extends JPanel implements KoonMuuttaja {

    private String[] koodit;
    private KorttiPanel[] paneelit;
    private int y;
    private int x;
    private int alkx;
    private double v = 0.01;
    FlowLayout flow;
    private Peli peli;

    /**
     * Tekee uuden kasi paneelin.
     * @param x vanhemman leveys
     * @param y vanhemman korkeus
     * @param peli pelin ilmentymä.
     */
    public KasiPanel(int x, int y, Peli peli) {
        this.peli = peli;
        this.y = y;
        this.alkx = x;
        this.x = Math.min(x, 1500);
        asetaArvot(y, x);
        setup(y, x);
    }

    private void setup(int y, int x) {
        lisaaPaneelit();
        muutaKokoa(y, x);
    }

    private void asetaArvot(int y, int x) {
        koodit = new String[5];
        paneelit = new KorttiPanel[5];
        this.setPreferredSize(new Dimension(y / 2, x));
        this.setOpaque(false);
        flow = new FlowLayout(FlowLayout.LEFT, (int) (v * this.x), 0);
        this.setLayout(flow);
    }

    /**
     * Muuttaa kortin kuva koodin.
     * @param index kortin index
     * @param koodi kuvan koodi (tiedostonimi)
     */
    public void MuutaKortti(int index, String koodi) {
        koodit[index] = koodi;
    }

    /**
     * Päivittää korttien kuvat niiden koodien mukaisiksi.
     */
    public void paivitaNakyma() {
        for (int i = 0; i < paneelit.length; i++) {
            flow.setHgap((int) (v * this.x));
            paneelit[i].setPreferredSize(new Dimension((int) ((-6 * v + 1) * x) / 5, (int) (7 * ((-6 * v + 1) * x)) / 25));
            paneelit[i].setTaustaKuva(koodit[i]);
        }
        this.repaint();
        this.revalidate();
    }

    /**
     * Muuttaa paneelin kokoa vanhemman leveyden ja korkeuden mukaan.
     * @param y vanhemman korkeus
     * @param x vanhemman leveys
     */
    @Override
    public void muutaKokoa(int y, int x) {
        this.y = y;
        this.alkx = x;
        this.x = Math.min(x, 1500);
        this.setBounds(((alkx - this.x) / 2), this.y - 100 - (int) (7 * ((-6 * v + 1) * this.x)) / 25, this.x, (int) (7 * ((-6 * v + 1) * this.x)) / 25);
        paivitaNakyma();
    }

    private void lisaaPaneelit() {
        for (int i = 0; i < 5; i++) {
            paneelit[i] = new KorttiPanel(koodit[i], x);
            paneelit[i].setPreferredSize(new Dimension((int) ((-6 * v + 1) * x) / 5, (int) (7 * ((-6 * v + 1) * x)) / 25));
            paneelit[i].addMouseListener(new KorttiKuuntelija(peli, i));
            this.add(paneelit[i]);
        }
    }

    /**
     * Aktivoi kortin.
     * @param index aktivoitavan kortin index.
     */
    public void aktivoiKortti(int index) {
        paneelit[index].valinta();
    }

}
