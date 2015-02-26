/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automaattiPokeri.Interfaces;

/**
 *
 * @author Juuso
 */
public interface KoonMuuttaja {

    /**
     * Paneeli muuttaa kokoaan jonkin ylemmän paneelin koon mukaan.
     * @param y kutsujan antama oma korkeus
     * @param x kutsujan antama oma leveys
     */
    public void muutaKokoa(int y, int x);
}
