/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affichercible;

import static java.lang.Float.max;
import static java.lang.Math.abs;

/**
 *
 * @author stagjava
 */
public class Cible {
    // Attributs
    private String type;
    private int taille;
    private String forme;
    private int etat;

    public Cible(String type, int taille) {
        this.type = type;
        this.taille = taille;
        etat = 0;
    }
    
    public boolean estValide () {
        if (etat == -1)
            return false;
        else
            return true;
    }
    
    public void dessinerForme() {
        switch (type) {
            case "croix" : dessinerCroix();
            break;
            case "étoile" : dessinerEtoile();
            break;
            case "zone" : dessinerZone();
            break;
        }
    }

    public void dessinerCroix() {
        StringBuilder uneForme = new StringBuilder("");
        int posForme = (taille / 2) + 1; 
        
        for (int i = 1; i <= taille; i++) {
            
            for (int j = 1; j <= taille; j++) {
                
                if (i == posForme  || j == posForme) {
                    uneForme.append("X");
                } else {
                    uneForme.append(".");                    
                }                
            }
            uneForme.append("\n");                    
            
        }
        
        forme = uneForme.toString();
    }
    public void dessinerEtoile() {
        StringBuilder uneForme = new StringBuilder("");
        int posForme = (taille / 2) + 1;
        int posDeb = 1;
        int posFin = taille;

        
        for (int i = 1; i <= taille; i++) {
            
            for (int j = 1; j <= taille; j++) {
                
                if (i == posForme || j == posForme) {
                    uneForme.append('X');                    
                } else {
                    if ( j == posDeb || j == posFin) {
                        uneForme.append('X');
                    } else {
                        uneForme.append('.');                    
                    }
                }
            }
            uneForme.append("\n");
            if (i < posForme) {
                posDeb++;
                posFin--;
            } else {
                posDeb--;
                posFin++;
                
            }
        }

            forme = uneForme.toString();
    }

    public void dessinerZone() {
        StringBuilder uneForme = new StringBuilder("");
//        uneForme.append((char)(uneForme.codePointAt(uneForme.length() -1) + 1));
        int distance;
        char codeCaractere;

        int posForme = (taille / 2) + 1;
        int posDeb = 1;
        int posFin = taille;
        int curUCode = 97;
        int nextUCode;
        int incr = 1;

        
        for (int i = 1; i <= taille; i++) {
            
            for (int j = 1; j <= taille; j++) {
                distance = (int) max(abs(i-(taille+1)/2),abs(j  -(taille+1)/2));
                codeCaractere = (char) ('a' + (taille+1)/2 -1 - distance);

            }
            uneForme.append("\n");
            if (i < posForme) {
                posDeb++;
                posFin--;
            } else {
                posDeb--;
                posFin++;
                incr = -1;
            }
        }
        forme = uneForme.toString();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equals("croix") || type.equals("étoile") || type.equals("zone")) {
            this.type = type;
        } else {
            System.out.println("Type doit être croix, étoile");
            this.etat = -1;          
        }
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        if (taille % 2 == 0 || taille < 1 || taille > 9) {
            System.out.println("Taille doit être entre 1 et 9 et impaire");
            this.etat = -1;
        } else {
            this.taille = taille;            
        }
    }

    public String getForme() {
        if (forme == null) {
            dessinerForme();
        }
        return forme;
    }

    public void setForme(String forme) {
        this.forme = forme;
    }
    
    
}
