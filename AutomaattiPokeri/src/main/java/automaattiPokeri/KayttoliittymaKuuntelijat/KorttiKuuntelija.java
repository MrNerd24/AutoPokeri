/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automaattiPokeri.KayttoliittymaKuuntelijat;

import automaattiPokeri.Kayttoliittyma.Peli;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Juuso
 */
public class KorttiKuuntelija implements MouseListener {

    
    private Peli peli;
    private int index;
    
    /**
     * Luo uuden kortin klikkaus kuuntelijan
     * @param peli pelin ilmentymä
     * @param index kortin index, johon kuuntelija on liitetty.
     */
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
