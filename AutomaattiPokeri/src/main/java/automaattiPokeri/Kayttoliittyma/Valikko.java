/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Kayttoliittyma;

import automaattiPokeri.KayttoliittymaKuuntelijat.valikkoNappulaKuuntelija;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Juuso
 */
public class Valikko extends JPanel {

    private MainPanel panel;
    private valikkoNappulaKuuntelija kuuntelija;
    private JLabel nimikentta;

    /**
     * Luo uuden valikon
     * @param panel Main paneelin ilmentyma.
     */
    public Valikko(MainPanel panel) {
        super();
        this.setLayout(new FlowLayout());
        this.panel = panel;
        luoKuuntelija();
        createComponents();
        this.setOpaque(false);
    }

    private void createComponents() {
        lisaaUusiPeliNappula();
        lisaaLataaPeliNappula();
        lisaaTopListaNappula();
        lisaaVaihdaKayttajaNappula();
        lisaaNimiKentta();
    }

    private void lisaaUusiPeliNappula() {
        JButton nappula = new JButton("Uusi peli");
        lisaaNappula(nappula);
    }

    private void lisaaNappula(JButton nappula) {
        nappula.addActionListener(kuuntelija);
        this.add(nappula);
    }

    private void lisaaLataaPeliNappula() {
        JButton nappula = new JButton("Jatka");
        lisaaNappula(nappula);
    }

    private void lisaaTopListaNappula() {
        JButton nappula = new JButton("Top lista");
        lisaaNappula(nappula);
    }

    private void luoKuuntelija() {
        kuuntelija = new valikkoNappulaKuuntelija();
        kuuntelija.annaMainPanel(panel);
    }

    private void lisaaVaihdaKayttajaNappula() {
        JButton nappula = new JButton("Vaihda Käyttäjä");
        lisaaNappula(nappula);
    }

    /**
     * Vaihtaa kayttajan nimen valikossa
     * @param nimi Uusi nimi
     */
    public void vaihdaKayttajaNimi(String nimi) {
        nimikentta.setText(nimi);
        this.setSize(this.getPreferredSize().width, this.getPreferredSize().height);
        this.revalidate();
        nimikentta.repaint();
    }

    private void lisaaNimiKentta() {
        nimikentta = new JLabel();
        Font font = new Font(Font.DIALOG, Font.BOLD, 24);
        nimikentta.setFont(font);
        nimikentta.setForeground(Color.white);
        this.add(nimikentta);
    }

}
