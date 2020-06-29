/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tapisserie;

/**
 * Définit un mur
 * @author stagjava
 */
public class Surface {
    // Attributs
    final private Double hauteur;
    final private Double largeur;
    
    public Surface (Double hauteur, Double largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public Double getHauteur() {
        return hauteur;
    }

    public Double getLargeur() {
        return largeur;
    }
    
}
