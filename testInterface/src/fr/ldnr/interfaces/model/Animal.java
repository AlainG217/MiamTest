/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.interfaces.model;

import fr.ldnr.interfaces.exposed.Affichable;

/**
 *
 * @author Godefroy Alain
 */
public class Animal implements Affichable{
    // Attributs
    String nom;
    String espece;
    
    public void afficher () {
        System.out.println(nom + "\t" + espece);
    }
    public Animal(String nom, String espece) {
        this.nom = nom;
        this.espece = espece;
    }
    
    
    
}
