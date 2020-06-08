/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja02;

import java.util.Scanner;

/**
 * Conversion Euros / dollars
 * @author stagjava
 */
public class Ja02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Définition variables
        Double mtEuro   = 0.0;
        Double taux     = 0.88351;
        Double mtDollar = 0.0;
        Scanner clavier = new Scanner(System.in);
        
        // Saisie du montant à convertir
        System.out.println("Saisissez le montant en euros");             
        mtEuro = clavier.nextDouble();
        
        
        // Calcul
        mtDollar = mtEuro / taux;
        // Arrondi à 2 décimales
        mtDollar = (double) Math.round(mtDollar * 100.00) / 100.00;
        
        // Afficher le résultat
        System.out.println("Montant en euros");
        System.out.println(mtEuro);
        System.out.println("Montant en dollars");
        System.out.println(mtDollar);

        // Fin
        System.out.println("-- C'est fini --s");
        
        return;
        
    }
    
}
