/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automaattiPokeri.KayttoliittymaKuuntelijat;

import automaattiPokeri.Kayttoliittyma.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Juuso
 */
public class palautusKuuntelija implements ActionListener {
    
    private boolean uusiJako = false;
    private Peli peli;
    
    public palautusKuuntelija(Peli peli) {
        this.peli = peli;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        peli.alaNappulaPainallus(uusiJako);
        uusiJako = !uusiJako;
    }
    
}
