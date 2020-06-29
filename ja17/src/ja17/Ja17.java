/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja17;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        
        // Variables
        int mn = 0;
        int heure = 0;
        int reste = 0;
        String libelle;

        // Saisie du numéro de jour
        System.out.println("Minutes ");
        mn = clavier.nextInt();

        // Calcul
        heure = (int) Math.floor(mn / 60);
        reste = (int) (mn - (heure * 60));

       // Affichage
       System.out.println(mn + "minute(s) correspondent à " + (int) heure + "H" + reste);
        
        // fin
        System.out.println("-- That's all, folks! --");
    }

}
