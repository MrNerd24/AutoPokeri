/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Kayttoliittyma;

import automaattiPokeri.Interfaces.KoonMuuttaja;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
        luoKuuntelijat();

        LuoValikko();

    }

    private void muutaLayout() {
        this.setLayout(new GridBagLayout());
    }

    private void LuoValikko() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
//        constraints.gridwidth = 1;
//        constraints.gridheight = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.weighty = 1;
        constraints.weightx = 1;
        menu = new Valikko(this);
        this.add(menu, constraints);

    }

    private void setTausta() {
        try {
            File kuva = new File("assetteja\\kuvia\\Background.jpg");
            tausta = ImageIO.read(kuva);
            paintComponent(this.getGraphics());
        } catch (Exception e) {
            this.setBackground(new Color(38, 117, 173));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
        int koordiX = ((this.x) / 2) - 960;
        int koordiY = ((this.y) / 2) - 600;
        g.drawImage(tausta, koordiX, koordiY, null);           
    }

    private void luoKuuntelijat() {
        PaneeliSuuruusKuuntelija ikkunanSuuruusKuuntelija = new PaneeliSuuruusKuuntelija(this);
        this.addComponentListener(ikkunanSuuruusKuuntelija);
    }

    @Override
    public void muutaKokoa(int y, int x) {
        this.y = y;
        this.x = x;
        paintComponent(this.getGraphics());
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
            case "Lataa peli":
                lataaPeli();
                break;
            case "Top lista":
                topLista();
                break;
            default:
                throw new AssertionError();
        }

        this.revalidate();

    }

    private void uusiPeli() {
        this.kaynnissaOlevaPeli = new Peli();
        GridBagConstraints constraints = paaConstraints();
        this.add(kaynnissaOlevaPeli, constraints);
    }

    private GridBagConstraints paaConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 1;
        constraints.gridx = 0;
//        constraints.gridwidth = 1;
//        constraints.gridheight = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weighty = 1;
        constraints.weightx = 1;
        return constraints;
    }

    private void lataaPeli() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void topLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void paivitaNakyma() {
        
    }

}
