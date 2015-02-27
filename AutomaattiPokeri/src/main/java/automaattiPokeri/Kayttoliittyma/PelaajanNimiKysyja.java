package automaattiPokeri.Kayttoliittyma;

import automaattiPokeri.Interfaces.KoonMuuttaja;
import automaattiPokeri.KayttoliittymaKuuntelijat.NimiKenttaKuuntelija;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Juuso
 */
public class PelaajanNimiKysyja extends JPanel implements KoonMuuttaja {

    private int x;
    private int y;
    private MainPanel main;

    /**
     * Luo uuden pelaajan nimea kysyvan paneelin.
     *
     * @param x vanhemman leveys
     * @param y vanhemman korkeus
     * @param main main paneelin ilmentymä.
     */
    public PelaajanNimiKysyja(int x, int y, MainPanel main) {
        this.x = x;
        this.y = y;
        this.main = main;
        this.setOpaque(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        lisaaTeksti();
        lisaaTektikentta();
        muutaKokoa(y, x);
    }

    /**
     * Muuttaa kokoaan vanhemman mukaan
     *
     * @param y vanhemman korkeus
     * @param x vanhemman leveys
     */
    @Override
    public void muutaKokoa(int y, int x) {
        this.x = x;
        this.y = y;
        setBounds((this.x - this.getPreferredSize().width) / 2, (this.y - this.getPreferredSize().height) / 2, this.getPreferredSize().width, this.getPreferredSize().height);
        this.revalidate();
        this.repaint();
    }

    private void lisaaTeksti() {
        JLabel teksti = new JLabel("Anna nimesi: ");
        Font font = new Font(Font.DIALOG, Font.BOLD, 24);
        teksti.setFont(font);
        teksti.setForeground(Color.white);
        teksti.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(teksti);
    }

    private void lisaaTektikentta() {
        JTextField kentta = new JTextField();
        kentta.setPreferredSize(new Dimension(this.getPreferredSize().width + 20, this.getPreferredSize().height));
        Font font = new Font(Font.DIALOG, Font.PLAIN, 24);
        kentta.setFont(font);
        kentta.setAlignmentX(Component.CENTER_ALIGNMENT);
        kentta.addActionListener(new NimiKenttaKuuntelija(this));
        this.add(kentta);
    }

    /**
     * Asettaa pelaajan nimen
     *
     * @param nimi pelaajan nimi.
     */
    public void setNimi(String nimi) {
        main.setNimi(nimi);
    }

}
