/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Kayttoliittyma;

import automaattiPokeri.KayttoliittymaKuuntelijat.PaneeliSuuruusKuuntelija;
import automaattiPokeri.KayttoliittymaKuuntelijat.palautusKuuntelija;
import automaattiPokeri.Interfaces.KoonMuuttaja;
import automaattiPokeri.Logiikka.Logiikka;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentListener;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Juuso
 */
public class Peli extends JPanel implements KoonMuuttaja {

    private PakkaPanel pakka;
    private KasiPanel kasi;
    private Logiikka logiikka;
    private int x;
    private int y;
    private HashSet<Integer> valitut;
    private JButton pakkaNappula;
    private boolean voiAktivoida = true;
    private JLabel rahaMaara;

    public Peli(int x, int y, int rahamaara) {
        super();
        valitut = new HashSet<Integer>();
//        this.setBackground(Color.green);
        this.setOpaque(false);
        this.setLayout(null);

        logiikka = new Logiikka(1);
        logiikka.taytaKasi();
        this.y = y;
        this.x = x;
        lisaaPakka();
        lisaaKasi();
        lisaaPalautusNappula();
        lisaaRahaMaara();
        korttienUusiJako();
    }

    public void uudetKortit() {
        for (int i = 0; i < logiikka.getKadenKoodit().length; i++) {
            kasi.MuutaKortti(i, logiikka.getKadenKoodit()[i]);
        }

    }

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

    private void lisaaPakka() {
        pakka = new PakkaPanel(x, y);
        ComponentListener kokoKuuntelija = new PaneeliSuuruusKuuntelija(pakka);
        this.addComponentListener(kokoKuuntelija);
        this.add(pakka);
    }

    private void lisaaKasi() {
        kasi = new KasiPanel(x, y, this);
        this.add(kasi);
    }

    @Override
    public void muutaKokoa(int y, int x) {
        this.y = y;
        this.x = x;
        this.setPreferredSize(new Dimension(x, y));
        kasi.muutaKokoa(y, x);
        pakkaNappula.setBounds((x - 200) / 2, y - 90, 200, 50);
        rahaMaara.setBounds(x - 200, 20, 190, 50);
        this.revalidate();

    }

    private void lisaaPalautusNappula() {
        pakkaNappula = new JButton("Vaihda");
        pakkaNappula.setBounds((x - 200) / 2, y - 90, 200, 50);
        pakkaNappula.addActionListener(new palautusKuuntelija(this));
        this.add(pakkaNappula);
    }

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
        logiikka.palkitse();
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
        this.revalidate();
    }

    private void peliLoppu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
