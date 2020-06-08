/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja10;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        Double a = 0.0;
        Double b = 0.0;
        Double c = 0.0;
        Double x1 = 0.0;
        Double x2 = 0.0;
        Double delta = 0.0;

        // Saisie
        System.out.println("Saisissez a");
        a = clavier.nextDouble();
        System.out.println("Saisissez b");
        b = clavier.nextDouble();
        System.out.println("Saisissez c");
        c = clavier.nextDouble();
        
        // Calculer le discriminant
        delta = Math.pow(b, 2) - (4 * a * c);
        
        // Résolution équation
        
        if (delta == 0.0 ) {
            if (a == 0.0 && b == 0) {
                x1 = c;
            } else {
                x1 = - (b / (2 * a));                
            }
            x2 = x1;
            
        } else {
            if (delta > 0) {
                if (a == 0) {
                    x1 = - (c / b);
                    x2 = x1;
                } else {
                    x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    x2 = (-b - Math.sqrt(delta)) / (2 * a);
                }
            }
        }
       // Affichage résultats
        System.out.println("a  : " + a);
        System.out.println("b  : " + b);
        System.out.println("c  : " + c);

        if (delta < 0.0) {
            System.out.println("Pas de solutions");
        } else {
            if (delta > 0.0) {
                System.out.println("Deux solutions");
                
            } else {
                System.out.println("Une solution");
            }
                
            System.out.println("x1  : " + x1);
            System.out.println("x2  : " + x2);            
        }
        System.out.println("delta  : " + delta);
    }
 
}
