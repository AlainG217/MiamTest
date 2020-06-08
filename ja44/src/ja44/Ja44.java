/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja44;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja44 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Voiture voiture1 = new Voiture("Renault","Megane","blanc");
         voiture1.demarrer();
         voiture1.avancer(50);
         voiture1.avancer(-40);
         voiture1.setCouleur("rose");
         voiture1.setMarque("Honda");
         voiture1.afficher();
    }

}
