/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarot;

import tarot.control.TarotC;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 * @author stagjava
 */
public class Tarot {
    
    // Attributs

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Définition variables

        TarotC driver = new TarotC();
        int isOK  =  driver.drive();
    }
    
}


