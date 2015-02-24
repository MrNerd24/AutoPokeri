/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automaattiPokeri.KayttoliittymaKuuntelijat;

import automaattiPokeri.Kayttoliittyma.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Juuso
 */
public class KorttiKuuntelija implements MouseListener {

    
    private Peli peli;
    private int index;
    
    public KorttiKuuntelija(Peli peli, int index) {
        this.peli = peli;
        this.index = index;
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!peli.peliloppu) {
            peli.korttiPainettu(index);
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
