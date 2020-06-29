/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja14;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        Double note = 0.0;
        Double mini = 20.0;
        Double maxi = 0.0;
        Double somme = 0.0;
        Double compt = 0.0;
        Double moyenne = 0.0;

        // Boucle de saisie
        while (note >= 0) {
            System.out.println("Note:");
            note = clavier.nextDouble();
            
            if (note > 20) {
                System.out.println("Note doit être comprise entre 0 et 20");                
            } else {
                if (note >= 0) {
                    // Traitement principal
                    if (note < mini) {
                        mini = note;
                    }
                    if (note > maxi) {
                        maxi = note;
                    }
                    compt++;
                    somme += note;                    
                }
            }          
        }

        // Affichage
        if (compt == 0) {
            System.out.println("Aucune note saisie:");
        } else {
            moyenne = (double) somme / compt;
            moyenne = (double) (Math.round(moyenne * 100.00) / 100.00);

            System.out.println("Nombre de notes:    " + compt);
            System.out.println("Note mini:          " + mini);
            System.out.println("Note maxi:          " + maxi);
            System.out.println("Somme des notes:    " + somme);
            System.out.println("Moyenne des notes:  " + moyenne);
                        
        }
       System.out.println("-- C'est fini --");
    }

}
