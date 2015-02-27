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
    private Double kaynnissaRahaMaara;
    private Double kaynnissaPanos;
    private Double suurinRahaMaara;
    private Double suurinVoitto;
    private boolean jarjestaSuurimmanVoitonMukaan = false;

    /**
     * Luo uuden pelaajan
     *
     * @param kayttajaTunnus Pelaajan kayttajatunnus
     * @param kaynnissaRahaMaara tamanhetkinen rahamaara
     * @param kaynnissaPanos tamanhetkinen panos
     * @param suurinRahaMaara suurin rahamaara
     * @param suurinVoitto suurin voitto.
     */
    public Pelaaja(String kayttajaTunnus, String kaynnissaRahaMaara, String kaynnissaPanos, String suurinRahaMaara, String suurinVoitto) {
        this.kayttajaTunnus = kayttajaTunnus;
        annaTiedot(kaynnissaRahaMaara, kaynnissaPanos, suurinRahaMaara, suurinVoitto);
    }

    private void annaTiedot(String kaynnissaRahaMaara, String kaynnissaPanos, String suurinRahaMaara, String suurinVoitto) throws NumberFormatException {
        this.kaynnissaRahaMaara = Double.parseDouble(kaynnissaRahaMaara);
        this.kaynnissaPanos = Double.parseDouble(kaynnissaPanos);
        this.suurinRahaMaara = Double.parseDouble(suurinRahaMaara);
        this.suurinVoitto = Double.parseDouble(suurinVoitto);
    }

    /**
     * Alustaa pelaajan ja lukee tilastot tiedostosta.
     *
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
     *
     * @param kaynnissaRahaMaara Asetettava rahamaara
     */
    public void setKaynnissaRahaMaara(Double kaynnissaRahaMaara) {
        this.kaynnissaRahaMaara = kaynnissaRahaMaara;
    }

    /**
     * Asettaa kaytettavissa olevan panoksen.
     *
     * @param kaynnissaPanos Asetettava panos.
     */
    public void setKaynnissaPanos(Double kaynnissaPanos) {
        this.kaynnissaPanos = kaynnissaPanos;
    }

    /**
     * Asettaa suurimman rahamaaran. Toplistaa varten!
     *
     * @param suurinRahaMaara Asetettava maara.
     */
    public void setSuurinRahaMaara(Double suurinRahaMaara) {
        this.suurinRahaMaara = suurinRahaMaara;
    }

    /**
     * Asettaa suurimman voiton. Toplistaa varten!
     *
     * @param suurinVoitto Asetettava voitto.
     */
    public void setSuurinVoitto(Double suurinVoitto) {
        this.suurinVoitto = suurinVoitto;
    }

    /**
     * Palauttaa pelaajan nimen.
     *
     * @return Pelaajan nimi.
     */
    public String getKayttajaTunnus() {
        return kayttajaTunnus;
    }

    /**
     * Palauttaa kaynnissa olevan rahamaaran.
     *
     * @return Pelaajan rahamaara.
     */
    public Double getKaynnissaRahaMaara() {
        return kaynnissaRahaMaara;
    }

    /**
     * Palauttaa kaynnissa olevan panoksen
     *
     * @return Pelaajan panos.
     */
    public Double getKaynnissaPanos() {
        return kaynnissaPanos;
    }

    /**
     * Palauttaa pelaajan suurimman rahamaaran.
     *
     * @return Pelaajan suurin rahamaara.
     */
    public Double getSuurinRahaMaara() {
        return suurinRahaMaara;
    }

    /**
     * Palauttaa pelaajan suurimman voiton.
     *
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
        rivit.add(kaynnissaRahaMaara.toString());
        rivit.add(kaynnissaPanos.toString());
        rivit.add(suurinRahaMaara.toString());
        rivit.add(suurinVoitto.toString());
        kirjoittaja.kirjoita(rivit);
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
     *
     * @return true, jos jarjestetaan suurimman voiton mukaan, false jos
     * jarjestetaan suurimman rahamaaran mukaan.
     */
    public boolean isJarjestaSuurimmanVoitonMukaan() {
        return jarjestaSuurimmanVoitonMukaan;
    }

    /**
     * Asettaa pelaajien jarjestys tavan.
     *
     * @param jarjestaSuurimmanVoitonMukaan True jotta jarjestaa suurimman
     * voiton mukaan, false jotta jarjestaa suurimman rahamaaran mukaan.
     */
    public void setJarjestaSuurimmanVoitonMukaan(boolean jarjestaSuurimmanVoitonMukaan) {
        this.jarjestaSuurimmanVoitonMukaan = jarjestaSuurimmanVoitonMukaan;
    }

    @Override
    public String toString() {
        return this.getKayttajaTunnus();
    }

}
