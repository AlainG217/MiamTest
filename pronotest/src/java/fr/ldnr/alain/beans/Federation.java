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
public class Federation implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String name;

    public Federation() {
    }

    public Federation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Federation{" + "name=" + name + '}';
    }
    
}
