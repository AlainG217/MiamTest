/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja19test;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja19test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        int i; 
        int min = 0;
        int max = 100;
        int alea = 0;
        int cpt = 0;
        Boolean trouve = false;
        
        for (i = 1; i <= 100; i++) {
 
            // Boucle de recherche
            cpt = 0;
            min = 0;
            max = 100;
            trouve = false;
            while (trouve == false) {
                alea = (min + max) / 2;
                cpt++;

                if (alea == i) {
                    trouve = true;
                    System.out.println("Nombre " + i  + " Itérations " + cpt);
                } else {
                    if (alea < i) {
                        min = alea;
                    } else {
                        max = alea;
                    }
                }
                if (cpt > 7) {
                    trouve = true;
                }
           }
        }
    }

}
