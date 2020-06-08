/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tapisserie;

/**
 *
 * @author stagjava
 */
public class Rouleau {
    // Attributs
    final private Double hauteur;
    final private Double largeur;
    
    public Rouleau (Double hauteur, Double largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public Double nbLeRouleau(Double hauteur) {
        Double nb;
        
        if (hauteur == 0) {
            return -1.0;
        }
        
        return Math.floor(this.hauteur / hauteur);  
    }


    public Double getHauteur() {
        return hauteur;
    }

    public Double getLargeur() {
        return largeur;
    }
        
        
}
