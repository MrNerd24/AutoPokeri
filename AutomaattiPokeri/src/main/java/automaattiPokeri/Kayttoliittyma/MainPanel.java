/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Kayttoliittyma;

import automaattiPokeri.KayttoliittymaKuuntelijat.PaneeliSuuruusKuuntelija;
import automaattiPokeri.Interfaces.KoonMuuttaja;
import automaattiPokeri.Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
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
    private Valikko menu;

    public MainPanel() {
        super();
        muutaLayout();
        setTausta();

        LuoValikko();

    }

    private void muutaLayout() {
        this.setLayout(null);
    }

    private void LuoValikko() {

        menu = new Valikko(this);
        menu.setBounds(0, 0, menu.getPreferredSize().width, menu.getPreferredSize().height);
        this.add(menu);

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
            this.kaynnissaOlevaPeli.setBounds(0, menu.getHeight() + 1, this.x, this.y - menu.getHeight());
        }
        paintComponent(this.getGraphics());
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
                Jatka();
                break;
            case "Top lista":
                topLista();
                break;
            default:
                throw new AssertionError();
        }

        this.revalidate();
        this.repaint();

    }

    private void uusiPeli() {
        this.kaynnissaOlevaPeli = new Peli(x, y, 10);
        PaneeliSuuruusKuuntelija kuuntelija = new PaneeliSuuruusKuuntelija(kaynnissaOlevaPeli);
        this.addComponentListener(kuuntelija);
        this.kaynnissaOlevaPeli.setBounds(0, menu.getPreferredSize().height + 1, this.x, this.y - menu.getPreferredSize().height);
        this.add(kaynnissaOlevaPeli);
        kaynnissaOlevaPeli.invalidate();
    }

    private void Jatka() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void topLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void paivitaNakyma() {

    }

}
