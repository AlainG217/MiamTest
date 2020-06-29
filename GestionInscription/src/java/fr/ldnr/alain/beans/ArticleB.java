/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.beans;

import fr.ldnr.alain.dao.PostDAO;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author stagjava
 */
public class ArticleB implements Serializable {
    
    private int id;
    private String titre;
    private String contenu;
    private Date dateArt;
    private int idAuteur;
    private int status;
    
    private Utilisateur auteur;

    public ArticleB() {
        auteur = null;
        status = 0;
    }

    public ArticleB(String titre, String contenu,  int idAuteur) {
        this.titre = titre;
        this.contenu = contenu;
        this.auteur = auteur;
        this.idAuteur = idAuteur;
        auteur = null;
        status = 0;
    }

    public ArticleB(int id, String titre, String contenu, Date dateArt, 
            int idAuteur) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.dateArt = dateArt;
        this.idAuteur = idAuteur;
        auteur = null;
        status = 0;
    }

    public void save() {
        PostDAO dao = new PostDAO();
    
        switch (status) {
            case 1: 
                dao.create(this);
                break;
            case 10: 
                dao.update(this);
                break;
            
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDateArt() {
        return dateArt;
    }

    public void setDateArt(Date dateArt) {
        this.dateArt = dateArt;
    }

    public int getIdAuteur() {
        return idAuteur;
    }

    public void setIdAuteur(int idAuteur) {
        this.idAuteur = idAuteur;
    }

    public Utilisateur getAuteur() {
        
        if (auteur == null) {
        }
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
