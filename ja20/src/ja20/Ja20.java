/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja20;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        int i;
        int alea1;
        int alea2;
        int correct;
        int reponse;
        int points = 0;
        
        // Boucle de traitement
        for (i=1; i <= 10; i++) {
            // Tirer 2 nombres aléatoires
            alea1 = 2 + (int) ( Math.random() * 9);
            alea2 = 2 + (int) ( Math.random() * 14);
            
            // Calculer le résultat correct
            correct = alea1 * alea2;
            
            // Poser la question et lire la réponse
            System.out.println("Combien font " + alea1 + " X " + alea2 + " ?");
            reponse = clavier.nextInt();
            
            if (reponse == correct) {
                System.out.println("Bonne réponse!");
                points++;
                System.out.println(points + "/" + i);
            } else {
                System.out.println("Mauvaise réponse! C'était " + correct);
                System.out.println(points + "/" + i);
            }
        }
            

        // Affichage
        System.out.println("Vous avez " + points + " point(s) sur 10");
        
        // fin
        System.out.println("-- That's all, folks! --");

    }

}
