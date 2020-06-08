/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package encadreur;

import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class Encadreur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        String texte;
        // Variables
        String strEncadre;
        
        // lire le texte
        Scanner clavier = new Scanner(System.in);
        System.out.print("Entrer le texte: ");
        texte = clavier.nextLine();
        
        strEncadre = encadre(texte);
        
        System.out.println(strEncadre);
    }

    public static String encadre(String unTexte) {
        String unString = "";
        int iMax = unTexte.length();
        
        // Vérifier la longueur du texte
        if ( iMax > 80) {
            unTexte = unTexte.substring(0, 80);
            iMax = 80;
        }
        // Encadrer le texte
        
        // 1ère ligne        
        for (int  i= 0; i <= iMax +1; i++) {
            
            if (i == 0) {
                unString = unString + "\u250c";
            } else {
                if (i == iMax + 1) {
                    unString = unString + "\u2510";
                } else  {
                    unString = unString + "\u2500";
                }
            }
        }
        
        // 2ème ligne   
        unString = unString + "\n";
        unString = unString + "\u2502";
        unString = unString + unTexte;
        unString = unString + "\u2502";
        
        // 3ème ligne        
        unString = unString + "\n";
        for (int  i= 0; i <= iMax +1; i++) {
            
            if (i == 0) {
                unString = unString + "\u2514";
            } else {
                if (i == iMax + 1) {
                    unString = unString + "\u2518";
                } else  {
                    unString = unString + "\u2500";
                }
            }
        }
        
        return unString;
    }
}
