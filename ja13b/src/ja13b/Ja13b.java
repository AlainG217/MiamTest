/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja13b;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja13b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        // Variables
        Integer hauteur;
        Integer largeur;
        
        // Saisie
        System.out.println("Saisissez la hauteur:");
        hauteur = clavier.nextInt();
        System.out.println("Saisissez la largeur:");
        largeur = clavier.nextInt();
        
        // Affichage
        // Boucle 1 hauteur
        for(int i = 1; i <=hauteur; i++) {
            // Boucle 2 largeur
            for(int j = 1; j <=largeur; j++) {
                if (i== 1 || i == hauteur) {
                    System.out.print("*");
                } else {
                    if (j == 1 || j == largeur) {
                        System.out.print("*");                        
                    } else {
                        System.out.print(" ");
                    }                    
                }
            }
            System.out.print("\n");            
        }
        System.out.print("\n");            
       System.out.println("-- C'est fini --");
    }

}
