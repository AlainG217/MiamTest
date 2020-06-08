/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tapisserie;
import static java.lang.Math.floor;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Tapisserie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        Double hauteurMur;
        Double largeurMur;
        Double hauteurRouleau;
        Double largeurRouleau;
        Double nbLeRouleau = 0.0;
        Double nbRouleau = 0.0;
        
        // Demander les données
        System.out.print("Hauteur du mur: ");
        hauteurMur = clavier.nextDouble();
        System.out.print("Largeur du mur: ");
        largeurMur = clavier.nextDouble();
        System.out.print("Longueur du rouleau: ");
        hauteurRouleau = clavier.nextDouble();
        System.out.print("Largeur du rouleau: ");
        largeurRouleau = clavier.nextDouble();
        
        // Initialiser les objets
        Surface mur = new Surface(hauteurMur, largeurMur);
        Rouleau rouleau = new Rouleau(hauteurRouleau, largeurRouleau);
        
        // Calculs
        nbLeRouleau = rouleau.nbLeRouleau(hauteurMur);
        
        if (nbLeRouleau > 0) {
            nbRouleau = floor((mur.getLargeur() / rouleau.getLargeur()) / nbLeRouleau) + 1 ;
        }
        
        // Affichage
        if (nbLeRouleau < 0) {
            System.out.println("Largeur du mur invalide. Calcul impossible");
        } else {
            System.out.println("Nombre de lés par rouleau: " + nbLeRouleau);
            System.out.println("Nombres de rouleaux: " + nbRouleau);
            
        }
        
        
    }
    
    

}
