package automaattiPokeri.Objektit;

import automaattiPokeri.TiedostoKasittelijat.TiedostoKirjoittaja;
import automaattiPokeri.TiedostoKasittelijat.TiedostoLukija;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Juuso
 */
public class Pelaaja implements Comparable<Pelaaja> {

    private String kayttajaTunnus;
    private Long Kaynnissa_rahaMaara;
    private Integer Kaynnissa_panos;
    private Long suurinRahaMaara;
    private Long suurinVoitto;
    private BigInteger aikaPelattuMins;
    private boolean jarjestaSuurimmanVoitonMukaan = false;

    /**
     *
     * @param kayttajaTunnus
     * @param Kaynnissa_rahaMaara
     * @param Kaynnissa_panos
     * @param suurinRahaMaara
     * @param suurinVoitto
     * @param aikaPelattuMins
     */
    public Pelaaja(String kayttajaTunnus, String Kaynnissa_rahaMaara, String Kaynnissa_panos, String suurinRahaMaara, String suurinVoitto, String aikaPelattuMins) {
        this.kayttajaTunnus = kayttajaTunnus;
        annaTiedot(Kaynnissa_rahaMaara, Kaynnissa_panos, suurinRahaMaara, suurinVoitto, aikaPelattuMins);
    }

    private void annaTiedot(String Kaynnissa_rahaMaara, String Kaynnissa_panos, String suurinRahaMaara, String suurinVoitto, String aikaPelattuMins) throws NumberFormatException {
        this.Kaynnissa_rahaMaara = Long.parseLong(Kaynnissa_rahaMaara);
        this.Kaynnissa_panos = Integer.parseInt(Kaynnissa_panos);
        this.suurinRahaMaara = Long.parseLong(suurinRahaMaara);
        this.suurinVoitto = Long.parseLong(suurinVoitto);
        this.aikaPelattuMins = new BigInteger(aikaPelattuMins);
    }

    /**
     *
     * @param kayttajaTunnus
     */
    public Pelaaja(String kayttajaTunnus) {
        TiedostoLukija lukija = new TiedostoLukija(kayttajaTunnus, "pelaajat");
        if (!lukija.tiedostoOlemassa()) {
            throw new Error("Pelaajan " + kayttajaTunnus + " tiedostoa ei ole olemassa");
        }
        ArrayList<String> rivit = lukija.getRivit();
        annaTiedot(rivit.get(1), rivit.get(2), rivit.get(3), rivit.get(4), rivit.get(5));
    }

    /**
     *
     * @param Kaynnissa_rahaMaara
     */
    public void setKaynnissa_rahaMaara(Long Kaynnissa_rahaMaara) {
        this.Kaynnissa_rahaMaara = Kaynnissa_rahaMaara;
    }

    /**
     *
     * @param Kaynnissa_panos
     */
    public void setKaynnissa_panos(Integer Kaynnissa_panos) {
        this.Kaynnissa_panos = Kaynnissa_panos;
    }

    /**
     *
     * @param suurinRahaMaara
     */
    public void setSuurinRahaMaara(long suurinRahaMaara) {
        this.suurinRahaMaara = suurinRahaMaara;
    }

    /**
     *
     * @param suurinVoitto
     */
    public void setSuurinVoitto(long suurinVoitto) {
        this.suurinVoitto = suurinVoitto;
    }

    /**
     *
     * @return
     */
    public String getKayttajaTunnus() {
        return kayttajaTunnus;
    }

    /**
     *
     * @return
     */
    public Long getKaynnissa_rahaMaara() {
        return Kaynnissa_rahaMaara;
    }

    /**
     *
     * @return
     */
    public Integer getKaynnissa_panos() {
        return Kaynnissa_panos;
    }

    /**
     *
     * @return
     */
    public long getSuurinRahaMaara() {
        return suurinRahaMaara;
    }

    /**
     *
     * @return
     */
    public long getSuurinVoitto() {
        return suurinVoitto;
    }

    /**
     *
     * @return
     */
    public BigInteger getAikaPelattuMins() {
        return aikaPelattuMins;
    }

    /**
     *
     */
    public void tallennaTiedot() {
        TiedostoKirjoittaja kirjoittaja = new TiedostoKirjoittaja(kayttajaTunnus, "pelaajat", false);
        ArrayList<String> rivit = new ArrayList<String>();
        rivit.add(kayttajaTunnus);
        rivit.add(Kaynnissa_rahaMaara.toString());
        rivit.add(Kaynnissa_panos.toString());
        rivit.add(suurinRahaMaara.toString());
        rivit.add(suurinVoitto.toString());
        rivit.add(aikaPelattuMins.toString());
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
     *
     * @return
     */
    public boolean isJarjestaSuurimmanVoitonMukaan() {
        return jarjestaSuurimmanVoitonMukaan;
    }

    /**
     *
     * @param jarjestaSuurimmanVoitonMukaan
     */
    public void setJarjestaSuurimmanVoitonMukaan(boolean jarjestaSuurimmanVoitonMukaan) {
        this.jarjestaSuurimmanVoitonMukaan = jarjestaSuurimmanVoitonMukaan;
    }

    @Override
    public String toString() {
        return this.getKayttajaTunnus();
    }
    
}
