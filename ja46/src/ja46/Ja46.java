/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja46;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja46 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Voiture voiture1 = new Voiture();
        voiture1.afficher();
        Voiture voiture2 = new Voiture("Rebault","Clio","Rouge");
        voiture1.afficher();

    }

}
