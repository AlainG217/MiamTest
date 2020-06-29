/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.*;

/**
 *
 * @author stagjava
 */
public class TestUI extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Locale.setDefault(Locale.ITALY);
        Locale local = Locale.getDefault();

        ResourceBundle rb = ResourceBundle.getBundle("appl", local);
        System.out.println(rb.getString("titre"));
        
        new TestUI(rb.getString("titre"));

       
        // Variables
    }
    
    // Attributes
    private JButton unBtn;
    private JButton deuxBtn;
    private JButton troisBtn;
    private JTextField unTF;
    
    public TestUI (String titre) {
        super(titre);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setBackground(Color.GRAY);

        unBtn = new JButton("Un");
        unBtn.setBounds(10, 10,80, 40); 
        unBtn.setBackground(Color.green); 
        unBtn.setText("Un");
        unBtn.addActionListener(this);
        this.getContentPane().add(unBtn);
        deuxBtn = new JButton("Deux");
        deuxBtn.setBounds(110, 10,80, 40); 
        deuxBtn.setBackground(Color.red); 
        deuxBtn.addActionListener(this);
        this.getContentPane().add(deuxBtn);
        troisBtn = new JButton("Trois");
        troisBtn.setBounds(10, 110,80, 40); 
        troisBtn.setBackground(Color.yellow); 
        troisBtn.addActionListener(this);
        this.getContentPane().add(troisBtn);

        
        unTF = new JTextField(" ");
        unTF.setBounds(110, 110,50, 40); 
        this.getContentPane().add(unTF);

        this.pack();

        this.setVisible(true);
        this.setSize(200, 200);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==unBtn)
            unTF.setText(unBtn.getText());
        if (e.getSource()==deuxBtn)
            unTF.setText(deuxBtn.getText());        
        if (e.getSource()==troisBtn)
            unTF.setText(troisBtn.getText());    }

}
