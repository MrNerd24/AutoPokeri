/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automaattiPokeri.Kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Juuso
 */
public class Kayttoliittyma implements Runnable {
    
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Automaattipokeri");
        
        frame.setPreferredSize(new Dimension(1000, 800));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        
        frame.pack();
        
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    private void createComponents(Container contentPane) {
        MainPanel peli = new MainPanel();
        contentPane.addComponentListener(new PaneeliSuuruusKuuntelija(peli));
        contentPane.add(peli);
    }
    
}
