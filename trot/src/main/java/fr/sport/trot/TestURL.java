/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.sport.trot;
import fr.sport.trot.control.CTrotDriver;
import java.util.Scanner;

/**
 *
 * @author stagjava
 */
public class TestURL {

    /**
     * @param args the command line arguments
     */ 
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
/*        
        // Variables
        String urlName = "https://www.zone-turf.fr/rapports/r1-c1-prix-de-pavilly-488534.html";
//        WebPage coursePage = new WebPage(urlName);
        WebPage coursePage = new WebPage();
        coursePage.analyzePage();
*/
        CTrotDriver leDriver = new CTrotDriver("HST");
        leDriver.setHistoryStDate("01/01/2018");
        leDriver.drive();
        
    }

}
