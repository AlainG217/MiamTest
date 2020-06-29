/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja06;

import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        Integer nb1  = 0;
        Integer nb2  = 0;
        Integer nb3  = 0;
        Integer max  = 0;

        // Saisie
        System.out.println("Saisissez le nombre 1");
        nb1 = clavier.nextInt();
        System.out.println("Saisissez le nombre 2");
        nb2 = clavier.nextInt();
        System.out.println("Saisissez le nombre 3");
        nb3 = clavier.nextInt();

        // Trouver le maxi
        if (nb1 >= nb2 && nb1 >= nb3) {
            max = nb1;
        } else {
            if (nb2 >= nb1 && nb2 >= nb3) {
                max = nb2;
            } else {
                max = nb3;
            }
        }
        // Affichage résultats
        System.out.println("Nombre 1 " + nb1);
        System.out.println("Nombre 2 " + nb2);
        System.out.println("Nombre 3 " + nb3);
        System.out.println("Le maxi est  " + max);

        // Fin
        System.out.println("-- C'est fini --");
   }
    
}
