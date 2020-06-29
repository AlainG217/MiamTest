/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja05;

import java.util.Scanner;

/**
 *
 * @author Alain Godefroy
 */
public class Ja05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        Integer nombre  = 0;
        Boolean estPair  = false;

        // Saisie
        System.out.println("Saisissez un nombre");
        nombre = clavier.nextInt();
           
        // Un nombre est pair si divisible par 2 
        
        if ( nombre % 2 == 0) {
            estPair = true;
        }
                    
        
        // Affichage résultats
        System.out.println("Nombre " + nombre);
        if (estPair == true) {
            System.out.println("Ce nombre est pair." );
            
        } else {
            System.out.println("Ce nombre est impair." );
            
        }
        
        // Fin
        System.out.println("-- C'est fini --");
        
    }
    
}
