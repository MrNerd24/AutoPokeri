package automaattiPokeri.Kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ListaPanel extends JPanel {

    ArrayList<JLabel> tulokset;

    /**
     * Luo uuden listan tuloksista.
     */
    public ListaPanel() {
        asetukset();

    }

    private void asetukset() {

        this.setOpaque(true);
        this.setBackground(new Color(82, 181, 242));
        this.setBorder(null);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        tulokset = new ArrayList<JLabel>();
    }

    /**
     * Lisaa uuden labelin listaan.
     *
     * @param teksti labelin teksti.
     */
    public void lisaaLable(String teksti) {
        tulokset.add(new JLabel(teksti));
    }

    /**
     * Poistaa kaikki labelit.
     */
    public void poistakaikkiLabelit() {
        tulokset.clear();
    }

    /**
     * Paivittaa listan nakyman.
     */
    public void paivitaNakyma() {
        this.removeAll();
        for (JLabel jLabel : tulokset) {
            Font font = new Font(Font.DIALOG, Font.BOLD, 18);
            jLabel.setFont(font);
            this.add(Box.createRigidArea(new Dimension(1, 5)));
            this.add(jLabel);

        }
        System.out.println(this.getComponentCount());
    }

}
