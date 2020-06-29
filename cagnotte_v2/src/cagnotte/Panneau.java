/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cagnotte;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author stagjava
 */
public class Panneau extends JPanel {
    public void paintComponent(Graphics g) {
        System.out.println("Je suis exécutée");
        g.fillOval(20, 20, 75, 75);
        
    }
}
