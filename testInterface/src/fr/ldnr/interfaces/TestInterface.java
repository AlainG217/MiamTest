/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.ldnr.interfaces;

import fr.ldnr.interfaces.exposed.Affichable;
import fr.ldnr.interfaces.model.Text;
import fr.ldnr.interfaces.model.Animal;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class TestInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Affichable x;
        Affichable[] animaux = new Affichable[4];
        
        animaux[0] = new Animal("Moineau", "Passereau");
        animaux[1] = new Animal("Chien", "Canidé");
        animaux[2] = new Animal("Baleine", "Cétacé");
        animaux[3] = new Text();
        
        for (int i = 0; i < animaux.length; i++)
        {
            utiliser(animaux[i]);
        }
        // Variables
    }
    public static void utiliser(Affichable a) {
        a.afficher();
        
    }
    

}
