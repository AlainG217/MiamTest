/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarot.model;

import tarot.BaseObj;

/**
 *
 * @author stagjava
 */
public class CarteJouee extends BaseObj {
    //Attributs
    Carte carte;
    Joueur joueur;

    public CarteJouee(Carte carte, Joueur joueur) {
        setCarte(carte);
        setJoueur(joueur);
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        if (carte != null)
            this.carte = carte;
        else
            setEtat(-1);
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        if (joueur != null)
            this.joueur = joueur;
        else
            setEtat(-1);
    }
    
    
    
}
