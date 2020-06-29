/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.locationvideos.controller;

/**
 *
 * @author stagjava
 */
public class Emprunteur {
    // Attributes
    private String code;
    private String nom;
    private String prenom;
    private String adresse;

    public Emprunteur(String code, String nom, String prenom, String adresse) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public Emprunteur() {
    }

    @Override
    public String toString() {
        return "Emprunteur{" + "code=" + code + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    
}
