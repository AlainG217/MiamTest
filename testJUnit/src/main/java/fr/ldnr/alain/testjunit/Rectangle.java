/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.testjunit;

/**
 *
 * @author stagjava
 */
public class Rectangle {
    // Attributs
    private int longueur;
    private int largeur;

    public Rectangle() {
        this(0,0);
    }

    public Rectangle(int longueur, int largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public int getPerimetre() {
        return (2*longueur) + (2*largeur);
    }

    public int getSurface() {
        return longueur * largeur;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "longueur=" + longueur + ", largeur=" + largeur + '}';
    }
    
    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
    
    
}
