/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plusmoins;

import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.Color;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author stagjava
 */
public class PlusMoins extends JFrame implements ActionListener, DocumentListener {
    // Attributes
    private JButton unBtn;
    private JButton rejouerBtn;
    private JTextField unTF;
    private JTextField unAutreTF;
    private JLabel unLabel;
    private static ResourceBundle rb;
    private int nbMystère;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Locale local = Locale.getDefault();

        rb = ResourceBundle.getBundle("libelles", local);
        
        // Créer et lancer la frame
        new PlusMoins();

    }
    
    public PlusMoins () {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setBackground(Color.GRAY);
        this.setTitle(rb.getString("titre"));
        
        unLabel = new JLabel(rb.getString("saisie"));
        unLabel.setBounds(10, 10,200, 40); 
        this.getContentPane().add(unLabel);

        unTF = new JTextField();
        unTF.setBounds(210, 10,50, 40); 
        unTF.getDocument().addDocumentListener(this);
        this.getContentPane().add(unTF);

        unBtn = new JButton("Jouer");
        unBtn.setBounds(260, 10,80, 40); 
        unBtn.addActionListener(this);
        this.getContentPane().add(unBtn);

        unAutreTF = new JTextField();
        unAutreTF.setBounds(350, 10,50, 40);
        unAutreTF.setEditable(false);
        this.getContentPane().add(unAutreTF);

        rejouerBtn = new JButton("Rejouer");
        rejouerBtn.setBounds(260, 110,80, 40); 
        rejouerBtn.setVisible(false);
        rejouerBtn.addActionListener(this);
        this.getContentPane().add(rejouerBtn);
        
        nbMystère = (int)(Math.random()*100);
        System.out.println(nbMystère);
        
        this.setVisible(true);
        this.setSize(800, 200);
        
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
            int nbSaisi = Integer.parseInt(unTF.getText());

            /* Sans option 
            if (nbSaisi > nbMystère)
                unBtn.setText("-");
            else {
                if (nbSaisi < nbMystère)
                    unBtn.setText("+");
                else
                    unBtn.setText("Gagné");
                    
            }
*/
        if (e.getSource()==unBtn) {
            if (nbSaisi > nbMystère)
                unAutreTF.setText("-");
            else {
                if (nbSaisi < nbMystère)
                    unAutreTF.setText("+");
                else {
                    unAutreTF.setText("Gagné");
                    rejouerBtn.setVisible(true);
                    
                }
            }
        }
        if (e.getSource()==rejouerBtn) {
            nbMystère = (int)(Math.random()*100);
            System.out.println(nbMystère);
            rejouerBtn.setVisible(false);
            
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
           int nbSaisi = Integer.parseInt(unTF.getText());
           if (nbSaisi > nbMystère)
                unAutreTF.setText("-");
            else {
                if (nbSaisi < nbMystère)
                    unAutreTF.setText("+");
                else {
                    unAutreTF.setText("Gagné");
                    rejouerBtn.setVisible(true);
                    
                }
            }

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
           int nbSaisi = Integer.parseInt(unTF.getText());
           if (nbSaisi > nbMystère)
                unAutreTF.setText("-");
            else {
                if (nbSaisi < nbMystère)
                    unAutreTF.setText("+");
                else {
                    unAutreTF.setText("Gagné");
                    rejouerBtn.setVisible(true);
                    
                }
            }

    }


}
