/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.interfaces.model;

import fr.ldnr.interfaces.exposed.Affichable;

/**
 *
 * @author stagjava
 */
public class Text implements Affichable {
    public void afficher () {
        System.out.println("OK!");
    }
}
