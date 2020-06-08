/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja11;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        Integer nbCotes;
        String nom;
        
        // Saisie
        System.out.println("Saisissez le nombre de côtés");
        nbCotes = clavier.nextInt();
        
        // Détermination
        switch (nbCotes) {
            case 3 : nom = "triangle";
                break;
            case 4 : nom = "quadrilatère";
                break;
            case 5 : nom = "pentagone";
                break;
            case 6 : nom = "hexagone";
                break;
            case 8 : nom = "octogone";
                break;
            case 12 : nom = "docécagone";
                break;
            default: nom = "???";
        }
        // Affichage
        System.out.println("Un polygone à " + nbCotes + " est un " + nom);
    }
    
}
