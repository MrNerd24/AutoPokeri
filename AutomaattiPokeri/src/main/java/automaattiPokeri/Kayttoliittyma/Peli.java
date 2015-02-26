/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Kayttoliittyma;

import automaattiPokeri.KayttoliittymaKuuntelijat.palautusKuuntelija;
import automaattiPokeri.Interfaces.KoonMuuttaja;
import automaattiPokeri.Logiikka.Logiikka;
import automaattiPokeri.Objektit.Pelaaja;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Juuso
 */
public class Peli extends JPanel implements KoonMuuttaja {

    private KasiPanel kasi;
    private Logiikka logiikka;
    private int x;
    private int y;
    private HashSet<Integer> valitut;
    private JButton pakkaNappula;
    private boolean voiAktivoida = true;
    private JLabel rahaMaara;
    private Pelaaja pelaaja;

    /**
     * Kertoo onko peli loppunut.
     */
    public boolean peliloppu = false;

    /**
     * Luo uuden pelin
     * @param x vanhemman leveys
     * @param y vanhemman korkeus
     * @param uusi onko peli uusi vai jatketaanko vanhaa
     * @param pelaaja pelaajan nimi.
     */
    public Peli(int x, int y, boolean uusi, String pelaaja) {
        super();
        valitut = new HashSet<Integer>();
        this.setOpaque(false);
        this.setLayout(null);
        this.pelaaja = new Pelaaja(pelaaja);
        logiikkaSetup(uusi);
        logiikka.taytaKasi();
        this.y = y;
        this.x = x;
        lisaaKasi();
        lisaaPalautusNappula();
        lisaaRahaMaara();
        korttienUusiJako();
    }

    private void logiikkaSetup(boolean uusi) {
        if (uusi) {
            logiikka = new Logiikka(5);
            logiikka.setPanos(1);
        } else {
            logiikka = new Logiikka(this.pelaaja.getKaynnissa_rahaMaara());
            logiikka.setPanos(this.pelaaja.getKaynnissa_panos());
        }
    }

    /**
     * Vaihtaa kaikki kortit uusiin.
     */
    public void uudetKortit() {
        for (int i = 0; i < logiikka.getKadenKoodit().length; i++) {
            kasi.MuutaKortti(i, logiikka.getKadenKoodit()[i]);
        }
        kasi.paivitaNakyma();

    }

    /**
     * Aktivoi kortin jota on painettu. kuuntelija kayttama
     * @param index painetun kortin index
     */
    public void korttiPainettu(int index) {
        if (voiAktivoida) {
            kasi.aktivoiKortti(index);
            if (valitut.contains(index)) {
                valitut.remove(index);
            } else {
                valitut.add(index);
            }

        }

    }


    private void lisaaKasi() {
        kasi = new KasiPanel(x, y, this);
        this.add(kasi);
    }

    /**
     * Muuttaa kokoaan vanhemman mukaan
     * @param y vanhemman korkeus
     * @param x vanhemman leveys
     */
    @Override
    public void muutaKokoa(int y, int x) {
        this.y = y;
        this.x = x;
        this.setPreferredSize(new Dimension(x, y));
        kasi.muutaKokoa(y, x);
        pakkaNappula.setBounds((x - 200) / 2, y - 95, 200, 50);
        rahaMaara.setBounds(x - 200, 20, 190, 50);
        this.revalidate();

    }

    private void lisaaPalautusNappula() {
        pakkaNappula = new JButton("Vaihda");
        pakkaNappula.setBounds((x - 200) / 2, y - 95, 200, 50);
        pakkaNappula.addActionListener(new palautusKuuntelija(this));
        this.add(pakkaNappula);
    }

    /**
     * Ala nappulan painallus. kuuntelijan kayttama
     * @param uusiJako jaetaanko uusi jako, vai vaihdetaanko muut kuin valitut kortit.
     */
    public void alaNappulaPainallus(boolean uusiJako) {
        if (uusiJako) {
            korttienUusiJako();
        } else {
            valittujenKorttienPalautus();
        }

        this.revalidate();

    }

    private void valittujenKorttienPalautus() {
        for (int i = 0; i < 5; i++) {
            if (!valitut.contains(i)) {
                logiikka.palautaPakkaan(i);
            } else {
                kasi.aktivoiKortti(i);
            }
        }
        logiikka.taytaKasi();
        uudetKortit();
        Double voitto = logiikka.palkitse();
        pelaaja.setSuurinVoitto(Math.max(pelaaja.getSuurinVoitto(), voitto));
        this.paivitaRahaMaara();
        valitut.clear();
        pakkaNappula.setText("Uusi jako");
        voiAktivoida = false;
        if (logiikka.getRahaaKaytossa() <= 0) {
            peliLoppu();
        }
    }

    private void korttienUusiJako() {
        if (logiikka.poistaPanos()) {
            
            logiikka.tyhjennaKasi();
            logiikka.taytaKasi();
            uudetKortit();
            pakkaNappula.setText("Vaihda");
            voiAktivoida = true;
            paivitaRahaMaara();
        } else {
            pelaaja.tallennaTiedot();
            peliLoppu();
        }

    }

    private void lisaaRahaMaara() {
        this.rahaMaara = new JLabel("RahaMäärä: " + logiikka.getRahaaKaytossa());
        Font font = new Font("Rahaa", Font.PLAIN, 20);
        this.rahaMaara.setFont(font);
        rahaMaara.setForeground(Color.WHITE);
        rahaMaara.setBounds(x - 200, 20, 190, 50);
        this.add(rahaMaara);
    }

    private void paivitaRahaMaara() {
        rahaMaara.setText("Rahamäärä: " + logiikka.getRahaaKaytossa());
        pelaaja.setSuurinRahaMaara(Math.max(pelaaja.getSuurinRahaMaara(), logiikka.getRahaaKaytossa()));
        pelaaja.setKaynnissa_rahaMaara(logiikka.getRahaaKaytossa());
        pelaaja.setKaynnissa_panos(logiikka.getPanos());
        pelaaja.tallennaTiedot();
        this.revalidate();
    }

    private void peliLoppu() {
        peliloppu = true;
        JLabel banneri = new JLabel("Peli loppui! ;(");
        banneri.setBounds((x-220)/2, (y-50)/3, 220, 50);
        Font font = new Font(Font.DIALOG, Font.BOLD, 32);
        banneri.setFont(font);
        banneri.setForeground(Color.white);
        this.add(banneri);
        this.revalidate();
        this.repaint();
    }

}
