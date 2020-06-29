/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.cagnottemvn;

/**
 *
 * @author stagjava
 */
public class Transaction {
    // Attributs
    String prenom;
    double montant;

    public Transaction() {
        
    }
    
    public Transaction(String s) {
        int i = s.indexOf(";");
        prenom = s.substring(0, i);
        montant = Double.parseDouble(s.substring(i+1,s.length()- 1));
    }

    public Transaction(String prenom, double montant) {
        this.prenom = prenom;
        this.montant = montant;
    }
    
    public Transaction clone() {
        Transaction p = new Transaction();
        p.setPrenom(prenom);
        p.setMontant(montant);
        return p;
    }
    
    public String prepareForSave() {
        String s = prenom + ";" + montant + "\n";
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

    @Override
    public String toString() {
        return prenom + "\t" + montant;
    }
    
}
