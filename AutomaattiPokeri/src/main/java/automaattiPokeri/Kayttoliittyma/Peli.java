/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automaattiPokeri.Kayttoliittyma;

import automaattiPokeri.Interfaces.KoonMuuttaja;
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
    
    public Peli() {
        super();
        this.setBackground(Color.green);
        this.setOpaque(true);
        this.setLayout(null);
        
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
        this.add(kasi);
    }

    @Override
    public void muutaKokoa(int y, int x) {
        this.setPreferredSize(new Dimension(x,y));
    }
    
}
