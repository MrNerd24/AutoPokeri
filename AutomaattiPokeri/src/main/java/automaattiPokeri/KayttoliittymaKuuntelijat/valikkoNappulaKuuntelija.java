/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automaattiPokeri.KayttoliittymaKuuntelijat;

import automaattiPokeri.Kayttoliittyma.MainPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Juuso
 */
public class valikkoNappulaKuuntelija implements ActionListener {
    
    private MainPanel panel;

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.muutaPanel(e.getActionCommand());
        
    }

    /**
     * Asettaa Mainpaneelin ilmentyman.
     * @param panel main paneeli
     */
    public void annaMainPanel(MainPanel panel) {
        this.panel = panel;
    }
    
}
