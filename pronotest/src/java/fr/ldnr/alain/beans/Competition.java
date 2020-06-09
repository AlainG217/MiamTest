/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.beans;

/**
 *
 * @author stagjava
 */
public class Competition {
    
    private static final long serialVersionUID = 1L;
    private String name;
    private Federation federation;

    public Competition() {
    }

    public Competition(String name, Federation federation) {
        this.name = name;
        this.federation = federation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Federation getFederation() {
        return federation;
    }

    public void setFederation(Federation federation) {
        this.federation = federation;
    }

    @Override
    public String toString() {
        return "Competition{" + "name=" + name + ", federation=" + federation + '}';
    }
    
    
}
