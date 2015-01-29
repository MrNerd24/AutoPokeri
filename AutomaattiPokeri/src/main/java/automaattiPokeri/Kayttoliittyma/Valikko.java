/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Kayttoliittyma;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Juuso
 */
public class Valikko extends JPanel {

    private MainPanel panel;
    private valikkoNappulaKuuntelija kuuntelija;

    public Valikko(MainPanel panel) {
        super();
        this.setLayout(new FlowLayout());
        this.panel = panel;
        luoKuuntelija();
        createComponents();
        this.setBackground(Color.red);
    }

    private void createComponents() {
        lisaaUusiPeliNappula();
        lisaaLataaPeliNappula();
        lisaaTopListaNappula();

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
        JButton nappula = new JButton("Lataa peli");
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

}
