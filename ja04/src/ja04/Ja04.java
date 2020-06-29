/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja04;

import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Double rayon    = 0.0;
        Double surface  = 0.0;
        Double circonf  = 0.0;
        Scanner clavier = new Scanner(System.in);
        // Saisie du montant à convertir
        System.out.println("Saisissez le rayon du cercle");             
        rayon = clavier.nextDouble();

        // Calcul surface
        surface = Math.pow(rayon, 2.0) * Math.PI;
        // Calcul circonférence
        circonf = rayon * 2.0 * Math.PI;
        // Arrondi à 2 décimales
        surface = (double) Math.round(surface * 100.00) / 100.00;
        circonf = (double) Math.round(circonf * 100.00) / 100.00;
        
        // Afficher le résultat
        System.out.println("Rayon:          " + rayon);
        System.out.println("Surface:        " + surface);
        System.out.println("Circonférence:  " + circonf);

        // Fin
        System.out.println("-- C'est fini --");
    }
    
}
