/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ja47;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Ja47 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Camion camion1 = new Camion();
        camion1.setModele("T440");
        camion1.charger(300);
        camion1.charger(-50);
        camion1.afficher();
    }

}
