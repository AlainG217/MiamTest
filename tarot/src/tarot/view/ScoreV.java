/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarot.view;

import java.util.Enumeration;
import java.util.Hashtable;
import tarot.model.Joueur;

/**
 *
 * @author stagjava
 */
public class ScoreV extends TarotV {
    
    public ScoreV () {
        super();
    }
    
    public boolean afficherResume (Hashtable joueurs) {
        boolean isOK = true;
        String ligneNoms = "";
        String ligneTraits = "";
        String lignePts = "";
        String trait = "---------- ";
        Joueur joueur = new Joueur();
        
           Object obj; 
        Enumeration e = joueurs.elements();
        while (e.hasMoreElements()) {
            obj = e.nextElement();
            joueur = (Joueur) obj;
            ligneNoms = ligneNoms + joueur.getNom() + "\t\t";
            ligneTraits = ligneTraits + trait + "\t";
            lignePts = lignePts + joueur.getptsTotal() + "\t\t";
        }
    
        System.out.println(ligneNoms);
        System.out.println(ligneTraits);
        System.out.println(lignePts);
        return isOK;
    }
    
}
