package automaattiPokeri.Objektit;

import automaattiPokeri.TiedostoKasittelijat.TiedostoKirjoittaja;
import automaattiPokeri.TiedostoKasittelijat.TiedostoLukija;
import java.util.ArrayList;

/**
 *
 * @author Juuso
 */
public class Pelaaja implements Comparable<Pelaaja> {

    private String kayttajaTunnus;
    private Double Kaynnissa_rahaMaara;
    private Double Kaynnissa_panos;
    private Double suurinRahaMaara;
    private Double suurinVoitto;
    private boolean jarjestaSuurimmanVoitonMukaan = false;

    /**
     * Luo uuden pelaajan
     * @param kayttajaTunnus Pelaajan kayttajatunnus
     * @param Kaynnissa_rahaMaara tamanhetkinen rahamaara
     * @param Kaynnissa_panos tamanhetkinen panos
     * @param suurinRahaMaara suurin rahamaara
     * @param suurinVoitto suurin voitto.
     */
    public Pelaaja(String kayttajaTunnus, String Kaynnissa_rahaMaara, String Kaynnissa_panos, String suurinRahaMaara, String suurinVoitto) {
        this.kayttajaTunnus = kayttajaTunnus;
        annaTiedot(Kaynnissa_rahaMaara, Kaynnissa_panos, suurinRahaMaara, suurinVoitto);
    }

    private void annaTiedot(String Kaynnissa_rahaMaara, String Kaynnissa_panos, String suurinRahaMaara, String suurinVoitto) throws NumberFormatException {
        this.Kaynnissa_rahaMaara = Double.parseDouble(Kaynnissa_rahaMaara);
        this.Kaynnissa_panos = Double.parseDouble(Kaynnissa_panos);
        this.suurinRahaMaara = Double.parseDouble(suurinRahaMaara);
        this.suurinVoitto = Double.parseDouble(suurinVoitto);
    }

    /**
     * Alustaa pelaajan ja lukee tilastot tiedostosta.
     * @param kayttajaTunnus pelaajan nimi.
     */
    public Pelaaja(String kayttajaTunnus) {
        this.kayttajaTunnus = kayttajaTunnus;
        TiedostoLukija lukija = new TiedostoLukija(kayttajaTunnus, "pelaajat");
        if (!lukija.tiedostoOlemassa()) {
            annaTiedot("5", "1", "0", "0");
        } else {
            ArrayList<String> rivit = lukija.getRivit();
            annaTiedot(rivit.get(1), rivit.get(2), rivit.get(3), rivit.get(4));
        }

    }

    /**
     * Asettaa kaytettavassa olean rahamaaran.
     * @param Kaynnissa_rahaMaara Asetettava rahamaara
     */
    public void setKaynnissa_rahaMaara(Double Kaynnissa_rahaMaara) {
        this.Kaynnissa_rahaMaara = Kaynnissa_rahaMaara;
    }

    /**
     * Asettaa kaytettavissa olevan panoksen.
     * @param Kaynnissa_panos Asetettava panos.
     */
    public void setKaynnissa_panos(Double Kaynnissa_panos) {
        this.Kaynnissa_panos = Kaynnissa_panos;
    }

    /**
     * Asettaa suurimman rahamaaran. Toplistaa varten!
     * @param suurinRahaMaara Asetettava maara.
     */
    public void setSuurinRahaMaara(Double suurinRahaMaara) {
        this.suurinRahaMaara = suurinRahaMaara;
    }

    /**
     * Asettaa suurimman voiton. Toplistaa varten!
     * @param suurinVoitto Asetettava voitto.
     */
    public void setSuurinVoitto(Double suurinVoitto) {
        this.suurinVoitto = suurinVoitto;
    }

    /**
     * Palauttaa pelaajan nimen.
     * @return Pelaajan nimi.
     */
    public String getKayttajaTunnus() {
        return kayttajaTunnus;
    }

    /**
     * Palauttaa kaynnissa olevan rahamaaran.
     * @return Pelaajan rahamaara.
     */
    public Double getKaynnissa_rahaMaara() {
        return Kaynnissa_rahaMaara;
    }

    /**
     * Palauttaa kaynnissa olevan panoksen
     * @return Pelaajan panos.
     */
    public Double getKaynnissa_panos() {
        return Kaynnissa_panos;
    }

    /**
     * Palauttaa pelaajan suurimman rahamaaran.
     * @return Pelaajan suurin rahamaara.
     */
    public Double getSuurinRahaMaara() {
        return suurinRahaMaara;
    }

    /**
     * Palauttaa pelaajan suurimman voiton.
     * @return Pelaajan suurin voitto.
     */
    public Double getSuurinVoitto() {
        return suurinVoitto;
    }


    /**
     * Tallentaa pelaajan tiedot tiedostoon.
     */
    public void tallennaTiedot() {
        TiedostoKirjoittaja kirjoittaja = new TiedostoKirjoittaja(kayttajaTunnus, "pelaajat", false);
        ArrayList<String> rivit = new ArrayList<String>();
        rivit.add(kayttajaTunnus);
        rivit.add(Kaynnissa_rahaMaara.toString());
        rivit.add(Kaynnissa_panos.toString());
        rivit.add(suurinRahaMaara.toString());
        rivit.add(suurinVoitto.toString());
        kirjoittaja.Kirjoita(rivit);
    }

    @Override
    public int compareTo(Pelaaja o) {
        if (jarjestaSuurimmanVoitonMukaan) {
            if (this.suurinVoitto.compareTo(o.getSuurinVoitto()) != 0) {
                return this.suurinVoitto.compareTo(o.getSuurinVoitto());
            }
            return this.suurinRahaMaara.compareTo(o.getSuurinRahaMaara());
        } else {
            if (this.suurinRahaMaara.compareTo(o.getSuurinRahaMaara()) != 0) {
                return this.suurinRahaMaara.compareTo(o.getSuurinRahaMaara());
            }
            return this.suurinVoitto.compareTo(o.getSuurinVoitto());
        }
    }

    /**
     * Kertoo jarjestetaanko pelaajia suurimman voiton mukaan.
     * @return true, jos jarjestetaan suurimman voiton mukaan, false jos jarjestetaan suurimman rahamaaran mukaan.
     */
    public boolean isJarjestaSuurimmanVoitonMukaan() {
        return jarjestaSuurimmanVoitonMukaan;
    }

    /**
     * Asettaa pelaajien jarjestys tavan.
     * @param jarjestaSuurimmanVoitonMukaan True jotta jarjestaa suurimman voiton mukaan, false jotta jarjestaa suurimman rahamaaran mukaan.
     */
    public void setJarjestaSuurimmanVoitonMukaan(boolean jarjestaSuurimmanVoitonMukaan) {
        this.jarjestaSuurimmanVoitonMukaan = jarjestaSuurimmanVoitonMukaan;
    }

    @Override
    public String toString() {
        return this.getKayttajaTunnus();
    }

}
