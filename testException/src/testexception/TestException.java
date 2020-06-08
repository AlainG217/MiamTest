/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testexception;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author stagjava
 */
public class TestException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);

/*        
        // Variables
        FileWriter toto;
        FileReader tata;
        
        File output = new File("/home/stagjava/Documents/Cours/Java JSE/monFichier.txt");
        
        try {
            if (output.exists()) {
                 tata = new FileReader(output);
                 while (tata.ready()) {
                     char c = (char) tata.read();
                     System.out.print(c);
                 }
                tata.close();
                 
                 tata = new FileReader(output);
                 BufferedReader br = new BufferedReader(tata);
                 while (br.ready()) {
                     String s = br.readLine();
                     System.out.println(s);
                 }
                 
            }
            toto = new FileWriter(output);
            toto.write("Ceci est mon texte.\nNouvelleligne");
            toto.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
*/                
    }

}
