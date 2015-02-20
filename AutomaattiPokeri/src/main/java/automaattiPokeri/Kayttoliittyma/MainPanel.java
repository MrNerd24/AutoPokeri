/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Kayttoliittyma;

import automaattiPokeri.KayttoliittymaKuuntelijat.PaneeliSuuruusKuuntelija;
import automaattiPokeri.Interfaces.KoonMuuttaja;
import automaattiPokeri.Main;
import automaattiPokeri.TiedostoKasittelijat.TiedostoKirjoittaja;
import automaattiPokeri.TiedostoKasittelijat.TiedostoLukija;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Juuso
 */
public class MainPanel extends JPanel implements KoonMuuttaja {

    BufferedImage tausta;
    private int y = 0;
    private int x = 0;

    private Peli kaynnissaOlevaPeli;
    private Valikko valikko;
    private PelaajanNimiKysyja kysyja;
    private String pelaajaNimi;

    public MainPanel() {
        super();
        muutaLayout();
        setTausta();

        LuoValikko();
        haeNimi();
    }

    private void muutaLayout() {
        this.setLayout(null);
    }

    private void LuoValikko() {

        valikko = new Valikko(this);
        valikko.setBounds(0, 0, valikko.getPreferredSize().width, valikko.getPreferredSize().height);
        this.add(valikko);

    }

    private void setTausta() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            tausta = ImageIO.read(classLoader.getResourceAsStream("Kuvia/Background.jpg"));
            paintComponent(this.getGraphics());
        } catch (Exception e) {
            this.setBackground(new Color(38, 117, 173));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int koordiX = ((this.x) / 2) - 960;
        int koordiY = ((this.y) / 2) - 600;
        g.drawImage(tausta, koordiX, koordiY, null);
    }

    @Override
    public void muutaKokoa(int y, int x) {
        this.y = y;
        this.x = x;
        this.setPreferredSize(new Dimension(x, y));
        if (kaynnissaOlevaPeli != null) {
            this.kaynnissaOlevaPeli.setBounds(0, valikko.getHeight() + 1, this.x, this.y - valikko.getHeight());
        }
        
        this.repaint();

    }

    public void muutaPanel(String nimi) {
        System.out.println(this.getComponentCount());
        if (this.getComponentCount() == 2) {
            this.remove(1);
        }
        switch (nimi) {
            case "Uusi peli":
                uusiPeli();
                break;
            case "Jatka":
                jatka();
                break;
            case "Top lista":
                topLista();
                break;
            case "Vaihda Käyttäjä":
                vaihda();
                break;
            default:
                throw new AssertionError();
        }

        this.revalidate();
        this.repaint();

    }

    private void uusiPeli(boolean uusi, String pelaaja) {
        this.kaynnissaOlevaPeli = new Peli(x, y, uusi, pelaaja);
        PaneeliSuuruusKuuntelija kuuntelija = new PaneeliSuuruusKuuntelija(kaynnissaOlevaPeli);
        this.addComponentListener(kuuntelija);
        this.kaynnissaOlevaPeli.setBounds(0, valikko.getPreferredSize().height + 1, this.x, this.y - valikko.getPreferredSize().height);
        this.add(kaynnissaOlevaPeli);
        kaynnissaOlevaPeli.invalidate();
    }

    private void jatka() {
        if (pelaajaNimi != null) {
            uusiPeli(false, pelaajaNimi);
        } else {
            vaihda();
        }
        
    }

    private void topLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void uusiPeli() {
        if (pelaajaNimi != null) {
            uusiPeli(true, pelaajaNimi);
        } else {
            vaihda();
        }

    }

    private void vaihda() {
        kysyja = new PelaajanNimiKysyja(x, y, this);
        PaneeliSuuruusKuuntelija kuuntelija = new PaneeliSuuruusKuuntelija(kysyja);
        this.addComponentListener(kuuntelija);
        this.add(kysyja);
        this.revalidate();
        
    }
    
    public void setNimi(String nimi) {
        pelaajaNimi = nimi;
        if (this.getComponentCount() > 1) {
            this.remove(1);
        }
        valikko.vaihdaKayttajaNimi(nimi);
        this.revalidate();
        muutaKokoa(y,x);
        asetaViimeisin();
    }

    private void haeNimi() {
        TiedostoLukija lukija = new TiedostoLukija("viimeisinKayttaja", "asetukset");
        if (!lukija.tiedostoOlemassa()) {
            return;
        }
        setNimi(lukija.getRivit().get(0));
    }

    private void asetaViimeisin() {
        TiedostoKirjoittaja kirjoittaja = new TiedostoKirjoittaja("viimeisinKayttaja", "asetukset", false);
        ArrayList<String> nimi = new ArrayList<String>();
        nimi.add(pelaajaNimi);
        kirjoittaja.Kirjoita(nimi);
    }




}
