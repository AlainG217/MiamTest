/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja41;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja41 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation

        
        // Créer la voiture
        Voiture voiture1 = new Voiture();
        voiture1.couleur = "Rouge";
        voiture1.marque = "Renault";
        voiture1.modele = "Mégane";

        Voiture voiture2 = new Voiture();
        voiture2.couleur = "Rouge";
        voiture2.marque = "Peugeot";
        voiture2.modele = "208";

        Voiture voiture3 = new Voiture();
        voiture3.couleur = "Rouge";
        voiture3.marque = "Citroen";
        voiture3.modele = "C3";

    // En action 
        voiture1.demarrer();
        voiture2.demarrer();
        voiture3.demarrer();
        voiture1.avancer(50);
        voiture2.avancer(20);
        voiture1.avancer(20);
        voiture1.afficher();
        voiture2.afficher();
        voiture3.afficher();
        
    }

}
