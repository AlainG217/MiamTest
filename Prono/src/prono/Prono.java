/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prono;

import prono.control.CPronoDriver;

/**
 *
 * @author alain
 */
public class Prono {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Let's go
        CPronoDriver driver = new CPronoDriver();
        driver.drive();
    }
    
}
