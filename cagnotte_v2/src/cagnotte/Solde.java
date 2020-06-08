/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cagnotte;

/**
 *
 * @author stagjava
 */
public class Solde {
    // Attributs
    String prenom;
    double montant;
    double solde;

    public Solde() {
    }

    public Solde(String prenom, double montant) {
        this.prenom = prenom;
        this.montant = montant;
    }
    
    public void calculSolde(double moyenne) {
        solde = montant - moyenne;
    }
    public Solde clone() {
        Solde s = new Solde();
        s.setPrenom(prenom);
        s.setMontant(montant);
        s.setSolde(solde);
        return s;
    }
 
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return prenom + "\t" + montant+ "\t" + solde;
    }
    
}
