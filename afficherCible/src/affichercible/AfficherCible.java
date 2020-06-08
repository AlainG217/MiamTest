/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package affichercible;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class AfficherCible {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        Cible uneCible = new Cible("", 0);
        boolean continuer = true;
        
        // Demander les paramètres de la forme
        while (continuer) {
            System.out.print("Type de cible: ");
            uneCible.setType(clavier.nextLine());
            System.out.print("Taille de la cible: ");
            uneCible.setTaille(clavier.nextInt());
            
            if (uneCible.estValide()) {
                continuer = false;
            }                    
        }

        // Affichage
        System.out.println(uneCible.getForme());
        
    }

}
