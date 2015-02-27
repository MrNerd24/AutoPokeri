/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Juuso
 */
public class KorttiPanel extends JPanel {

    private String koodi;
    private int x;
    private boolean aktivoitu = false;

    /**
     * Luo uuden kortti paneelin.
     *
     * @param koodi kortin koodi.
     * @param x vanhemman leveys.
     */
    public KorttiPanel(String koodi, int x) {
        this.koodi = koodi;
        this.setLayout(null);
        this.x = x;
        this.setBackground(Color.green);
        this.setOpaque(aktivoitu);
    }

    /**
     * Asettaa kortin taustan koodin mukaan.
     *
     * @param koodi kortin koodi.
     */
    public void setTaustaKuva(String koodi) {
        this.koodi = koodi;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (koodi == null) {
            return;
        }
        ClassLoader classLoader = getClass().getClassLoader();
        String polku = "Kuvia/KorttiKuvat/" + koodi + ".png";
        BufferedImage korttikuva;
        try {
            korttikuva = ImageIO.read(classLoader.getResourceAsStream(polku));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new Error();
        }
        BufferedImage scaalattuKuva;
        try {
            scaalattuKuva = resizeImage(korttikuva, this.getWidth(), this.getHeight(), korttikuva.getType());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new Error();
        }
        g.drawImage(scaalattuKuva, 0, 0, null);
    }

//    http://stackoverflow.com/questions/8284048/resizing-an-image-in-swing
    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) throws IOException {
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }

    /**
     * Asettaa kortin valituksi ja maalaa sen uudestaan.
     */
    public void valinta() {
        aktivoitu = !aktivoitu;
        this.setOpaque(aktivoitu);
        repaint();
    }
}
