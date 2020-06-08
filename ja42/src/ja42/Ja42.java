/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja42;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja42 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Créer la voiture
        Voiture voiture1 = new Voiture("Renault","Mégane","Rouge");
        Voiture voiture2 = new Voiture("Peugeot","208","Blanc");
        Voiture voiture3 = new Voiture("Citroen","C3","Bleu");
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
