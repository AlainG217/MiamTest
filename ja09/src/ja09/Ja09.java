/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja09;

import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        Double masse  = 0.0;
        Double taille  = 0.0;
        Double imc  = 0.0;

        // Saisie
        System.out.println("Saisissez la masse");
        masse = clavier.nextDouble();
        System.out.println("Saisissez la taille");
        taille = clavier.nextDouble();

        // Calcul IMC
        
        imc = masse / Math.pow(taille, 2.0);
        // Arrondi à 2 décimales
        imc = (double) Math.round(imc * 100.00) / 100.00;

        // Affichage résultats
        System.out.println("Taille  : " + taille);
        System.out.println("Masse   : " + masse);
        System.out.println("IMC     : " + imc);
                
        if (imc < 16.5) {
            System.out.println("Interprétaition: dénutrition" );        
        } else {
            if (imc <= 18.5) {
                System.out.println("Interprétaition: maigreur" );        
            } else {
                if (imc <= 25) {
                    System.out.println("Interprétaition: corpulence normale" );        
                } else {
                    if (imc <= 30) {
                        System.out.println("Interprétaition: surpoids" );        
                    } else {
                        if (imc <= 35) {
                            System.out.println("Interprétaition: obésité modérée" );        
                        } else {
                            if (imc <= 40) {
                                System.out.println("Interprétaition: obésité sévère" );        
                            } else {
                                System.out.println("Interprétaition: obésité morbide" );                                        
                            }                            
                        }                        
                    }
                }                
            }           
        }

        // Fin
        System.out.println("-- C'est fini --");
    }
    
}
