/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaattiPokeri.Kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Juuso
 */
public class KorttiPanel extends JPanel {

    private String koodi;
    private int x;
    private double v = 0.05;
    private boolean aktivoitu = false;

    KorttiPanel(String koodi, int x) {
        this.koodi = koodi;
        this.setLayout(null);
        this.x = x;
        sizeMuutos();
        this.setBackground(Color.green);
        this.setOpaque(aktivoitu);
    }

    public void setTaustaKuva(String koodi) {
        this.koodi = koodi;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        File kuva = new File("assetteja\\KorttiKuvat\\" + koodi + ".png");
        BufferedImage korttikuva;
        try {
            korttikuva = ImageIO.read(kuva);
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

    public void paivitaLeveys(int x) {
        this.x = x;
        sizeMuutos();
    }
    
//    http://stackoverflow.com/questions/8284048/resizing-an-image-in-swing
    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) throws IOException {
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }

    private void sizeMuutos() {
        this.setSize(new Dimension((int) ((-6 * v * x + 1 * x)) / 5, (int) (7 * ((-6 * v * x + 1 * x))) / 25));
        repaint();
    }
    
    public void valinta() {
        aktivoitu = !aktivoitu;
        this.setOpaque(aktivoitu);
        repaint();
    } 
}
