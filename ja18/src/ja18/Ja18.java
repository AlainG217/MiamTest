/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja18;
import java.util.Scanner;

/**
 * Calculatrice
 * @author stagjava
 */
public class Ja18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        Double nombre1 = 0.0;
        Double nombre2 = 0.0;
        Double resultat = 0.0;
        String operateur = "";
        Boolean continuer = true;

        // Saisie 
        System.out.println("Nombre ");
        nombre1 = clavier.nextDouble();

        operateur = clavier.nextLine(); // why needed?
        while (continuer == true) {
            System.out.println("Opérateur ");
            operateur = clavier.nextLine();
            // Valider l'opérateur
            if (operateur.equals("+") 
                    || operateur.equals("-") 
                    || operateur.equals("*") 
                    || operateur.equals("/")) {
                continuer = false;
            } else {
                System.out.println("Opérateur invalide");
            }
        }
        continuer = true;
        while (continuer == true) {
            System.out.println("Nombre ");
            nombre2 = clavier.nextDouble();
            // Vérifier pas de division par 0
            if (operateur.equals("/") && nombre2 == 0) {                
                System.out.println("Division par 0 impossible");
            } else {
                continuer = false;                
            }
        }

        // Calcul
        switch (operateur) {
            case "+" : resultat = nombre1 + nombre2;
            break;
            case "-" : resultat = nombre1 - nombre2;
            break;
            case "*" : resultat = nombre1 * nombre2;
            break;
            case "/" : resultat = nombre1 / nombre2;
            break;
            default : 
                  System.out.println("Opérateur invalide");
        }

       // Affichage
       System.out.println("Résultat: " + resultat);
        
        // fin
        System.out.println("-- That's all, folks! --");
    }

}
