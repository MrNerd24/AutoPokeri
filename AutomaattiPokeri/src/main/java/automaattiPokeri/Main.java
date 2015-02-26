package automaattiPokeri;

import automaattiPokeri.Kayttoliittyma.Kayttoliittyma;

/**
 *
 * @author Juuso
 */
public class Main {

    /**
     * Main kaynnistaa kayttoliittyman ja ajaa sen.
     * @param args nuthing really...
     */
    public static void main(String[] args) {
        Kayttoliittyma kali = new Kayttoliittyma();
        kali.run();
    }
}
