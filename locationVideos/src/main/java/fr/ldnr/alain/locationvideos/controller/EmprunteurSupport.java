/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.locationvideos.controller;

import java.util.ArrayList;

/**
 *
 * @author stagjava
 */
public class EmprunteurSupport {
    // Attributes
    Emprunteur emprunteur;
    ArrayList<Support> supportsLoues;

    public Emprunteur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
    }

    public ArrayList<Support> getSupportsLoues() {
        return supportsLoues;
    }

    public void setSupportsLoues(ArrayList<Support> supportsLoues) {
        this.supportsLoues = supportsLoues;
    }
    
}
