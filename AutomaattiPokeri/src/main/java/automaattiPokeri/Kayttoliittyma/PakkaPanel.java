/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automaattiPokeri.Kayttoliittyma;

import automaattiPokeri.Interfaces.KoonMuuttaja;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Juuso
 */
public class PakkaPanel extends JPanel implements KoonMuuttaja {

    public PakkaPanel() {
        this.setBackground(Color.YELLOW);
    }

    @Override
    public void muutaKokoa(int y, int x) {
        double v = 0.05;
        double uusiX = (0.2*(1-6*v)*x);
        double uusiY = (7*(1-6*v)*x)/25;
        this.setPreferredSize(new Dimension((int) uusiX, (int) uusiY));
    }
    
}
