/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author stagjava
 */
public class Utils {
    
    public static int alea (int debut, int fin) {
        int alea = debut + (int) ( Math.random() * (fin -1));
        return alea;
    }
}
