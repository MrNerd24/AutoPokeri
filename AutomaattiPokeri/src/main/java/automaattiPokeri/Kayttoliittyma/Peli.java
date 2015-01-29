/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automaattiPokeri.Kayttoliittyma;

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
public class Peli extends JPanel {

    public Peli() {
        super();
//        this.setBackground(Color.red);
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        
        lisaaPakka();
        lisaaKasi();
    }

    private void lisaaPakka() {
        PakkaPanel pakka = new PakkaPanel();
        ComponentListener kokoKuuntelija = new PaneeliSuuruusKuuntelija(pakka);
        this.addComponentListener(kokoKuuntelija);
        this.add(pakka);
    }

    private void lisaaKasi() {
        KasiPanel kasi = new KasiPanel();
        this.add(kasi);
    }
    
}
