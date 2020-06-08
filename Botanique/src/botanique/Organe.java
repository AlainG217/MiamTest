/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botanique;

import java.util.ArrayList;

/**
 * J'ai créé cette méthode bien qu'elle n'était pas nécessaire dans le cadre
 * de l'exercice, mais parce que les 2 classes avaient des attributs communs,
 * Et aussi, histoire de mêler héritage et interfaces.
 * @author Godefroy
 */
abstract public class Organe implements Organable {
    // Attributs
    final private int masse;
    final private int taille;

    public Organe(int masse, int taille) {
        this.masse = masse;
        this.taille = taille;
    }
    public int getTotalMasse() {
        return masse;
    }

    public int getMaxTaille() {
        return taille;
    }
    // Masse de cet organe
    public int getMasse() {
        return masse;
    }

    public int getTaille() {
        return taille;
    }

    @Override
    abstract public void setOrganes(ListOfOrganes organes);    

    @Override
    abstract public ListOfOrganes getOrganes();    
}
