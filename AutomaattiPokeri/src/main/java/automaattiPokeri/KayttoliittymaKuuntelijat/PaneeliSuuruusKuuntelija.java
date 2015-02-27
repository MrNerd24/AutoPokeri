/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.KayttoliittymaKuuntelijat;

import automaattiPokeri.Interfaces.KoonMuuttaja;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 *
 * @author Juuso
 */
public class PaneeliSuuruusKuuntelija implements ComponentListener {

    private int y;
    private int x;
    private KoonMuuttaja muutettava;

    /**
     * Luo uuden paneelin suuruus kuuntelijan
     *
     * @param muutettava muutettava olio
     */
    public PaneeliSuuruusKuuntelija(KoonMuuttaja muutettava) {
        this.muutettava = muutettava;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        hankiArvot(e);
    }

    private void hankiArvot(ComponentEvent e) {
        x = e.getComponent().getWidth();
        y = e.getComponent().getHeight();
        palautaArvot();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
//        hankiArvot(e);
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    /**
     * Palauttaa korkeuden
     *
     * @return korkeus
     */
    public int getY() {
        return y;
    }

    /**
     * palauttaa leveyden
     *
     * @return leveys
     */
    public int getX() {
        return x;
    }

    private void palautaArvot() {
        muutettava.muutaKokoa(y, x);
    }

}
