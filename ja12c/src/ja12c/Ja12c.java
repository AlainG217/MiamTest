/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja12c;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja12c {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        Integer nombre;
        Integer i = 1;
        
        // Saisie
        System.out.println("Saisissez le nombre:");
        nombre = clavier.nextInt();
        
        // Affichage
        do  {
            System.out.println(nombre + " x " + i + " = " + (nombre * i));            
            i++;
        } while (i <= 10);
        System.out.println("-- C'est fini --");
     }

}
