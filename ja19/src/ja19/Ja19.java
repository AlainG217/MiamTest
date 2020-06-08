/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja19;
import java.util.Scanner;

/**
 * Recherche dichotomique
 * @author stagjava
 */
public class Ja19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        int min = 0;
        int max = 100;
        int alea = 0;
        int cpt = 0;
        String reponse = "";
        
        // Boucle de recherche
        while (!reponse.equals("=")) {
            alea = (min + max) / 2;
            System.out.println("Proposition: " + alea);
            // lire la réponse
            System.out.print("Réponse: ");
            reponse = clavier.nextLine();
            // Analyse réponse
            switch (reponse) {
                case "=" :
                    break;
                case "+" :
                    min = alea;
                    break;
                case "-" :
                    max = alea;
                    break;
                default :
                    System.out.println("Réponse invalide");
                    continue;
            }
            cpt++;
            // System.out.println("mini " + min + " max " + max);
        }

        // Affichage
        System.out.println("Touvé en " + cpt + " itération(s)");
        
        // fin
        System.out.println("-- That's all, folks! --");
    }

}
