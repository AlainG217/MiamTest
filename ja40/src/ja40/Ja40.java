/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja40;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja40 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Boolean graphique = true;
        String echelle ="01234567890123456789012345678901234567890123456789012345678901234567890123456789";
        
        // Créer la voiture
        Voiture maVoiture = new Voiture();
        maVoiture.couleur = "Rouge";
        maVoiture.marque = "Renault";
        maVoiture.modele = "Clio";
        // En action 
        if (graphique == false ) {
            maVoiture.demarrer();
            maVoiture.afficher();
            maVoiture.avancer(5, graphique);
            maVoiture.afficher();
            maVoiture.arreter();
            maVoiture.afficher();
        } else {
            System.out.println(echelle);
            maVoiture.graphique();
            maVoiture.demarrer();
            maVoiture.graphique();
            maVoiture.avancer(5, graphique);
            maVoiture.arreter();
            maVoiture.graphique();
            
        }
        System.out.println("");
        System.out.println("-- That's all, Folks --");
    }

}
