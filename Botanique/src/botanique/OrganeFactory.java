/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botanique;

/**
 *
 * @author stagjava
 */
public class OrganeFactory {
    
    public Organable getOrgane (String type, int masse, int taille) {
        if (type.equals("Branche")) {
            return new Branche(masse, taille);
        } else {
            if (type.equals("Feuille")) {
                return new Feuille(masse, taille);
            } else {
                return null;
            }           
        }
    }
    
}
