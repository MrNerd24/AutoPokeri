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

    KasiPanel(int x, int y, Peli peli) {
        this.peli = peli;
        koodit = new String[5];
        paneelit = new KorttiPanel[5];
        this.y = y;
        this.alkx = x;
        this.x = Math.min(x, 1500);
        this.setPreferredSize(new Dimension(y / 2, x));
        this.setOpaque(false);
        //test:

        //test end
        flow = new FlowLayout(FlowLayout.LEFT, (int) (v * this.x), 0);
        this.setLayout(flow);
        lisaaPaneelit();
        paivitaNakyma();
        muutaKokoa(y, x);
    }

    public void MuutaKortti(int index, String koodi) {
        koodit[index] = koodi;
        paivitaNakyma();
    }

    public void paivitaNakyma() {
        for (int i = 0; i < paneelit.length; i++) {
            flow.setHgap((int) (v * this.x));
            paneelit[i].setPreferredSize(new Dimension((int) ((-6 * v + 1) * x) / 5, (int) (7 * ((-6 * v + 1) * x)) / 25));
            paneelit[i].paivitaLeveys(x);
            paneelit[i].setTaustaKuva(koodit[i]);
        }
        this.revalidate();
    }

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
            paneelit[i].addMouseListener(new KorttiKuuntelija(peli,i));
            this.add(paneelit[i]);
        }
    }
    
    public void aktivoiKortti(int index) {
        paneelit[index].valinta();
    }

}
