/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.agy.football.beans.donnees;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author stagjava
 */
public class FederationB {
    
    private String name;
    
    /**
     * Constructors
     */

    public FederationB() {
    }

    public FederationB(String name) {
        this.name = name;
    }
    
    public ArrayList<FederationB> getAll() {
        // Impl temporaire
        ArrayList<FederationB> federations = new ArrayList<>();
        
        federations.add(new FederationB("Allemagne"));
        federations.add(new FederationB("Angleterre"));
        federations.add(new FederationB("Espagne"));
        federations.add(new FederationB("Italie"));
            
        return federations;
    }

    /**
     * Getters and setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FederationB other = (FederationB) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FederationB{" + "name=" + name + '}';
    }
    
    
    
}
