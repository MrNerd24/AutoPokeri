/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automaattiPokeri.Kayttoliittyma;

import java.awt.Graphics;
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
    
    KorttiPanel(String koodi, int x) {
        this.koodi = koodi;
        this.x = x;
    }
    
    public void setTaustaKuva(String koodi) {
        this.koodi = koodi;
        paintComponent(this.getGraphics());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
        File kuva = new File("assetteja\\KorttiKuvat\\" + koodi + ".png");
        BufferedImage korttikuva;
        try {
            korttikuva = ImageIO.read(kuva);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new Error();
        }
        Image scaalattuKuva = korttikuva.getScaledInstance((int) ((6*v-1)*x)/5, (int) (7*((6*v-1)*x))/25, Image.SCALE_DEFAULT);
        g.drawImage(scaalattuKuva, 0, 0, null);
    }
    
    public void paivitaLeveys(int x) {
        this.x = x;
    }
}
