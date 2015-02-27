package automaattiPokeri.Logiikka;

import automaattiPokeri.Objektit.Pelaaja;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Juuso
 */
public class TulosLista {

    private ArrayList<Pelaaja> pelaajat;
    private boolean voitonMukaan = false;

    /**
     * Tekee uuden tuloslistan.
     */
    public TulosLista() {
        pelaajat = new ArrayList<Pelaaja>();
        luePelaajat();
    }

    /**
     * Kertoo jarjestetaanko tuloslista voiton mukaan.
     *
     * @return true jos jarjestetaan voiton mukaan, false jos jarjestetaan
     * suurimman rahamaaran mukaan.
     */
    public boolean isVoitonMukaan() {
        return voitonMukaan;
    }

    /**
     * Asettaa tuloslistan jarjestys kriteerin.
     *
     * @param voitonMukaan true jos jarjestetaan voiton mukaan, false jos
     * jarjestetaan rahamaaran mukaan.
     */
    public void setVoitonMukaan(boolean voitonMukaan) {
        this.voitonMukaan = voitonMukaan;
        muutaSortPeruste();
    }

    private void luePelaajat() {
        File pelaajatKansio = new File("AutomaattiPokeriTallenteita/pelaajat");
        for (File file : pelaajatKansio.listFiles()) {
            String nimi = file.getName();

            nimi = nimi.substring(0, nimi.length() - 4);

            pelaajat.add(new Pelaaja(nimi));
        }
    }

    /**
     * Palauttaa pelaajien suurimmat rahamaarat. Jarjestys on joko suurimman
     * rahamaaran mukaan tai suurimman voiton mukaan
     *
     * @return Lista rahamaaria.
     */
    public ArrayList<String> getRahaStringit() {
        ArrayList<String> rahaStringit = new ArrayList<String>();
        muutaSortPeruste();

        Collections.sort(pelaajat, Collections.reverseOrder());
        for (Pelaaja pelaaja : pelaajat) {
            rahaStringit.add(String.valueOf(pelaaja.getSuurinRahaMaara()));
        }
        return rahaStringit;

    }

    /**
     * Palauttaa pelaajien suurimmat voitot. Jarjestys on joko suurimman
     * rahamaaran mukaan tai suurimman voiton mukaan
     *
     * @return Lista suurimpia voittoja.
     */
    public ArrayList<String> getVoittoStringit() {
        ArrayList<String> voittoStringit = new ArrayList<String>();
        muutaSortPeruste();
        Collections.sort(pelaajat, Collections.reverseOrder());
        for (Pelaaja pelaaja : pelaajat) {
            voittoStringit.add(String.valueOf(pelaaja.getSuurinVoitto()));
        }
        return voittoStringit;

    }

    /**
     * Palauttaa pelaajien nimet listana. Jarjestys on joko suurimman rahamaaran
     * mukaan tai suurimman voiton mukaan.
     *
     * @return Pelaajien nimilista.
     */
    public ArrayList<String> getPelaajaStringit() {
        ArrayList<String> pelaajaStringit = new ArrayList<String>();
        muutaSortPeruste();
        Collections.sort(pelaajat, Collections.reverseOrder());
        for (Pelaaja pelaaja : pelaajat) {
            pelaajaStringit.add(pelaaja.toString());
        }
        return pelaajaStringit;

    }

    private void muutaSortPeruste() {
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.setJarjestaSuurimmanVoitonMukaan(voitonMukaan);
        }
    }

}
