/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automaattiPokeri.Kayttoliittyma;

import automaattiPokeri.Interfaces.KoonMuuttaja;
import java.awt.Color;
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
    private double v = 0.05;
    
    KasiPanel() {
        koodit = new String[5];
        paneelit = new KorttiPanel[5];
        //test:
        this.setBackground(Color.yellow);
        koodit[0] = "3_1";
        koodit[1] = "3_1";
        koodit[2] = "3_1";
        koodit[3] = "3_1";
        koodit[4] = "3_1";
        
        
        //test end
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, (int) (0.05*x)));
        lisaaPaneelit();
        paivitaNakyma();
    }
    
    public void MuutaKortti(int index, String koodi) {
        koodit[index] = koodi;
        paivitaNakyma();
    }

    private void paivitaNakyma() {
        for (int i = 0; i < paneelit.length; i++) {
            paneelit[i].paivitaLeveys(x);
            paneelit[i].setTaustaKuva(koodit[i]);
            paneelit[i].setPreferredSize(new Dimension((int) ((6*v-1)*x)/5,(int) (7*((6*v-1)*x))/25));
        }
    }

    @Override
    public void muutaKokoa(int y, int x) {
        this.y = y;
        this.x = x;
    }

    private void lisaaPaneelit() {
        for (int i = 0; i < 5; i++) {
            paneelit[i] = new KorttiPanel(koodit[i], x);
            paneelit[i].setPreferredSize(new Dimension((int) ((6*v-1)*x)/5,(int) (7*((6*v-1)*x))/25));
            this.add(paneelit[i]);
        }
    }
    
    
    
}
