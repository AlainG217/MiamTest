/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja03;

import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Double t1       = 0.0;
        Double t2       = 0.0;
        Double t3       = 0.0;
        Double somme    = 0.0;
        Double moyenne  = 0.0;
        Scanner clavier = new Scanner(System.in);
     
        // Saisie des températures
        System.out.println("Saisissez la température 1");            
        t1 = clavier.nextDouble();
        System.out.println("Saisissez la température 2");            
        t2 = clavier.nextDouble();
        System.out.println("Saisissez la température 3");            
        t3 = clavier.nextDouble();
        
        // Calcul
        somme = t1 + t2 + t3;
        moyenne = somme / 3.00;
        // Arrondi à 2 décimales
        moyenne = (double) Math.round(moyenne * 100.00) / 100.00;
        
        // Afficher le résultat
        System.out.println("t1 : " + t1);
        System.out.println("t2 : " + t2);
        System.out.println("t3 : " + t3);
        System.out.println("somme : " + somme);
        System.out.println("moyenne : " + moyenne);
         }
    
}
