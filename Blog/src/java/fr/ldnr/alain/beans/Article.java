/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.beans;

import java.io.Serializable;

/**
 *
 * @author stagjava
 */
public class Article implements Serializable {
    
    private String titre;
    private String contenu;
    private String dateArt;
    private String auteur;

    public Article() {
    }

    public Article(String titre, String contenu, String dateArt, String auteur) {
        this.titre = titre;
        this.contenu = contenu;
        this.dateArt = dateArt;
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getDateArt() {
        return dateArt;
    }

    public void setDateArt(String dateArt) {
        this.dateArt = dateArt;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    
    
}
