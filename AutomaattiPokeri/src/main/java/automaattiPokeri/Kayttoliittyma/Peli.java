/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automaattiPokeri.Kayttoliittyma;

import automaattiPokeri.Interfaces.KoonMuuttaja;
import automaattiPokeri.Logiikka.Logiikka;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;
import javax.swing.JPanel;

/**
 *
 * @author Juuso
 */
public class Peli extends JPanel implements KoonMuuttaja {

    private PakkaPanel pakka;
    private KasiPanel kasi;
    private Logiikka logiikka;
    private int x;
    private int y;
    
    public Peli() {
        super();
        this.setBackground(Color.green);
        this.setOpaque(true);
        this.setLayout(null);
        
        logiikka = new Logiikka(10);
        this.y = this.getHeight();
        this.x = this.getWidth();
        lisaaPakka();
        lisaaKasi();
    }

    private void lisaaPakka() {
        pakka = new PakkaPanel();
        ComponentListener kokoKuuntelija = new PaneeliSuuruusKuuntelija(pakka);
        this.addComponentListener(kokoKuuntelija);
        this.add(pakka);
    }

    private void lisaaKasi() {
        kasi = new KasiPanel();
        kasi.setBounds(0, this.y/5, this.x, this.y/3);
        this.add(kasi);
    }

    @Override
    public void muutaKokoa(int y, int x) {
        this.y = y;
        this.x = x;
        this.setPreferredSize(new Dimension(x,y));
    }
    
}
