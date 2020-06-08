/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja07;

import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        Double temp  = 0.0;
        String etat  = "";

        // Saisie
        System.out.println("Saisissez la température");
        temp = clavier.nextDouble();

        // Déteminer l'état
        if (temp < 0) {
            etat = "solide";
        } else {
            if (temp >= 100) {
                etat = "gazeux";
            } else {
                etat = "liquide";
            }
        }
        // Affichage résultats
        System.out.println("Température " + temp);
        System.out.println("l'état est " + etat);

        // Fin
        System.out.println("-- C'est fini --");
    }
}
