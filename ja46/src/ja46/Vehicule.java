/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja46;

/**
 * Classe Voiture
 * @author stagjava
 */
public class Vehicule {
    private String couleur;
    private String marque;
    private String modele;
    private int compteur = 0;
    private Boolean estDemarree = false;
    
    public Vehicule () {
        setMarque("Renault");
        setCouleur("blanc");
        setModele("Megane");
    }
    public Vehicule (String marque, String modele, String couleur) {
        setMarque(marque);
        setCouleur(couleur);
        this.modele = modele;
    }
    
    public void demarrer() {
        estDemarree = true;
    } 

    public void avancer(int km) {
        setCompteur(km);
        
    }
    
    public void arreter() {
        estDemarree = false;
    } 
    public void afficher() {
        System.out.println("Couleur: "  + couleur);
        System.out.println("marque: "  + marque);
        System.out.println("modele: "  + modele);
        System.out.println("compteur: "  + compteur);
        System.out.println("Est démarrée: "  + estDemarree);
    }
    
    public void setMarque(String marque) {
        if (marque.equals("Renault") || marque.equals("Dacia"))  {
            this.marque = marque;
        } else {
            System.out.println("Marque invalide");
        }
    }
    
    public void setCouleur(String couleur) {
        if (couleur.equals("bleu") || couleur.equals("blanc")  || couleur.equals("rouge"))  {
            this.couleur = couleur;
        } else {
            System.out.println("couleur invalide");
        }
    }
    
    public void setModele(String modele) {
            this.modele = modele;
    }
    
    public void setCompteur(int km) {
        if (km > 0) {
            this.compteur += km;
        } else {
            System.out.println("Kilométrage doit être positif");
        }
    }
    
    public void setEstDemarree(Boolean demarre) {
            this.estDemarree = demarre;
    }
    
    public String getMarque( ) {
            return marque;
    }

    public String getCouleur( ) {
            return couleur;
    }

    public String getModele( ) {
            return modele;
    }
    
    public int getCompteur() {
        return compteur;
    }

    public Boolean getEstDemarree() {
        return estDemarree;
    }
    

}
