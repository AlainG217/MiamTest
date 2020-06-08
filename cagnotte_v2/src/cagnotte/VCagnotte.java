/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cagnotte;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JFrame;


/**
 *
 * @author stagjava
 */
public class VCagnotte extends JFrame {

    public VCagnotte() throws HeadlessException {
    }

    public VCagnotte(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(100, 150);
        this.setContentPane(new Panneau());
        this.setVisible(true);
    }

    public VCagnotte(String title, GraphicsConfiguration gc) {
        super(title, gc);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(100, 150);
        this.setContentPane(new Panneau());
        this.setVisible(true);
    }
    
}
