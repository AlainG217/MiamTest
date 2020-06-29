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
public class Support {
    // Attributes
    private String code;
    private String titre;
    private String nomRealisateur;
    private String prenomRealisateur;    
    private int anneeSortie;
    private int nbExemplaires;
    private int nbExemplairesLoues;

    public Support() {
    }

    public Support(String code, String titre, String nomRealisateur, String prenomRealisateur, int anneeSortie, int nbExemplaires) {
        this.code = code;
        this.titre = titre;
        this.nomRealisateur = nomRealisateur;
        this.prenomRealisateur = prenomRealisateur;
        this.anneeSortie = anneeSortie;
        this.nbExemplaires = nbExemplaires;
        nbExemplairesLoues = nbExemplaires;
    }

    @Override
    public String toString() {
        return "Support{" + "code=" + code + ", titre=" + titre + ", nomRealisateur=" + nomRealisateur + ", prenomRealisateur=" + prenomRealisateur + ", anneeSortie=" + anneeSortie + ", nbExemplaires=" + nbExemplaires + ", nbExemplairesLoues=" + nbExemplairesLoues + '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNomRealisateur() {
        return nomRealisateur;
    }

    public void setNomRealisateur(String nomRealisateur) {
        this.nomRealisateur = nomRealisateur;
    }

    public String getPrenomRealisateur() {
        return prenomRealisateur;
    }

    public void setPrenomRealisateur(String prenomRealisateur) {
        this.prenomRealisateur = prenomRealisateur;
    }

    public int getAnneeSortie() {
        return anneeSortie;
    }

    public void setAnneeSortie(int anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public int getNbExemplaires() {
        return nbExemplaires;
    }

    public void setNbExemplaires(int nbExemplaires) {
        this.nbExemplaires = nbExemplaires;
    }

    public int getNbExemplairesLoues() {
        return nbExemplairesLoues;
    }

    public void setNbExemplairesLoues(int nbExemplairesLoues) {
        this.nbExemplairesLoues = nbExemplairesLoues;
    }
    
}
