package automaattiPokeri.Kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class listaPanel extends JPanel {

    ArrayList<JLabel> tulokset;

    public listaPanel() {
        asetukset();

    }

    private void asetukset() {

        this.setOpaque(true);
        this.setBackground(new Color(82, 181, 242));
        this.setBorder(null);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        tulokset = new ArrayList<JLabel>();
    }

    public void lisaaLable(String teksti) {
        tulokset.add(new JLabel(teksti));
    }

    public void poistakaikkiLabelit() {
        tulokset.clear();
    }

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
