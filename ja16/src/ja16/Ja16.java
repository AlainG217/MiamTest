/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja16;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja16 {

    /**
     * Déterminer le libellé du jour à partir de son numéro dans l'année (2015)s
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        Integer jour;
        Integer w1 = 0;
        int ent = 0;
        String libelle = "Inconnu ???";
        
        // Saisie du numéro de jour
       System.out.println("Jour ");
        jour = clavier.nextInt();
        
        // Calcul du numéro dans la semaine
        ent = (int) Math.floor(jour/7);
        w1 = jour - (7 * ent ) -1;
        
        switch (w1) {
            case 0 : libelle = "jeudi";
            break;
            case 1 : libelle = "vendredi";
            break;
            case 2 : libelle = "samedi";
            break;
            case 3 : libelle = "dimanche";
            break;
            case 4 : libelle = "lundi";
            break;
            case 5 : libelle = "mardi";
            break;
            case 6 : libelle = "mercredi";
            break;
        }
        
       // Affichage
       System.out.println("Le " + jour + " est un " + libelle);
        
    }

}
