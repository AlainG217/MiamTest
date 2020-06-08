/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja15;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        String phrase;
        String inverse = "";
        Integer longueur = 0;
        Integer i = 0;

        // Saisie
       System.out.println("Phrase ? ");
        phrase = clavier.nextLine();
        
        // Inverser la phrase
        longueur = phrase.length();
        for (i = longueur - 1; i >=0; i--) {
           inverse = inverse + phrase.charAt(i);
        }
        
       // Affichage
       System.out.println("Phrase   : " + phrase);
       System.out.println("Inverse  : " + inverse);
        
       System.out.println("-- C'est fini --");
        
    }

}
