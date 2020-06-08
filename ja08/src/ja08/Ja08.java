/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja08;

import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        Double note  = 0.0;

        // Saisie
        System.out.println("Saisissez la moyenne au bac");
        note = clavier.nextDouble();

        // Affichage résultats
        System.out.println("Note " + note);
        if (note < 12) {
            System.out.println("Désolé pas de mention" );        
        } else {
            if (note < 14) {
                System.out.println("Mention: assez bien" );        
            } else {
                if (note < 16) {
                    System.out.println("Mention:  bien" );        
                } else {
                    System.out.println("Mention:  très bien" ); 
                }                
            }           
        }

        // Fin
        System.out.println("-- C'est fini --");
    }
    
}
