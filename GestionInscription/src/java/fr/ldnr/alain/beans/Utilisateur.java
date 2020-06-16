/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.beans;

import fr.ldnr.alain.dao.UtilisateurDAO;

/**
 *
 * @author stagjava
 */
public class Utilisateur {
    
    private int id;
    private String email;
    private String mdp;
    private String nom;

    public Utilisateur() {
    }

    public Utilisateur(int id, String email, String mdp, String nom) {
        this.id = id;
        this.email = email;
        this.mdp = mdp;
        this.nom = nom;
    }

    public void add() {
        UtilisateurDAO udao = new UtilisateurDAO();
        
        udao.create(this);
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
