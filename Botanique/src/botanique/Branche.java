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
public class Branche extends Organe {
    // Attributes
    ListOfOrganes  organes;

    public Branche(int masse, int taille) {
        super(masse, taille);
    }
    
    @Override
    public int getTotalMasse() {
        int total = 0;
        
        int max = (organes == null) ? 0 : organes.size()
                ; 
        
        // Masse de l'organe lui-même
        total = super.getMasse();
        
        // Masse de ces organes
        if (organes != null) {
            for ( LOOIterator iter = organes.getIterator();iter.hasNext();) {
                Organable organe = iter.next();
                if (organe != null) 
                    total += organe.getTotalMasse();
            }
        }
        return total;

    }
    
    @Override
    public int getMaxTaille() {
        int maxTaille = 0;
        int uneTaille = 0;
        int total = 0;
        int max = (organes == null) ? 0 : organes.size(); 
        boolean aUneBranche = false;
        
        
        // Taille de l'organe lui-même
        total = super.getMaxTaille();
        
        // Taille de ces organes
        // On cherche la plus longue branche
        if (organes != null) {
            for ( LOOIterator iter = organes.getIterator();iter.hasNext();) {
                Organable organe = iter.next();
                // On cherche la plus longue branche
                if (organe != null && organe.getClass().getName().equals("botanique.Branche")){
                    aUneBranche = true;
                    uneTaille = organe.getMaxTaille();
                    if (uneTaille >  maxTaille) {
                        maxTaille = uneTaille;
                        total += maxTaille;
                    }
                }
                // Si la branche a au moins une autre branche, la feuille ne compte pas
                if (organe != null && organe.getClass().getName().equals("botanique.Feuille") && aUneBranche == false) {
                    total += organe.getMaxTaille();

                }
            }
        }
        return total;
    }
    public ListOfOrganes getOrganes() {
        return organes;
    }

    @Override
    public void setOrganes(ListOfOrganes organes) {
        this.organes = organes;
    }



    
}
