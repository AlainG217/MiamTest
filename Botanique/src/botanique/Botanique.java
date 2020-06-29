/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package botanique;

import java.util.ArrayList;

/**
 *
 * @author stagjava
 */
public class Botanique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation factory
        OrganeFactory maFactory = new OrganeFactory();

        // Initialisation iterateur
        ListOfOrganes organes = new ListOfOrganes();

        // Initialisation interface
        Organable b1 = maFactory.getOrgane("Branche", 40,12);
        Organable b2 = maFactory.getOrgane("Branche", 25,8);
        Organable f1 = maFactory.getOrgane("Feuille",4,7);

        organes.add(f1);
        organes.add(b2);
        b1.setOrganes(organes);
        
        
        
        System.out.println(b1.getTotalMasse());
        System.out.println(b1.getMaxTaille());   


       
            
    }

}
