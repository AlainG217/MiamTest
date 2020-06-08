/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coolcadremot;

/**
 *
 * @author stagjava
 */
public class CoolCadreMot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        char deb1 = '\u250c';
        char ligne = '\u2500';
        char fin1 = '\u2510';
        char vert = '\u2502';
        char deb2 = '\u2514';
        char fin2 = '\u2518';
        String cool = "Cool";
        
        
        // Variables
        int iMax = cool.length();
        
        // 1ère ligne        
        for (int  i= 0; i <= iMax +1; i++) {
            
            if (i == 0) {
                System.out.print(deb1);
            } else {
                if (i == iMax + 1) {
                    System.out.print(fin1);
                } else  {
                    System.out.print(ligne);
                }
            }
        }
        
        // 2ème ligne   
        System.out.println("");
        System.out.print(vert);
        System.out.print(cool);
        System.out.print(vert);
        
        // 3ème ligne        
        System.out.println("");
        for (int  i= 0; i <= iMax +1; i++) {
            
            if (i == 0) {
                System.out.print(deb2);
            } else {
                if (i == iMax + 1) {
                    System.out.print(fin2);
                } else  {
                    System.out.print(ligne);
                }
            }
        }
        
    }

}
