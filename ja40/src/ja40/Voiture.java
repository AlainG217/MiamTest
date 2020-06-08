/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja40;

/**
 * Classe Voiture
 * @author stagjava
 */
public class Voiture {
    String couleur;
    String marque;
    String modele;
    int compteur = 0;
    Boolean estDemarree = false;
    // Graphique
    String route = "v";
    
    public void demarrer() {
        estDemarree = true;
        // Graphique
        route = "V";
    } 

    public void avancer(int km, Boolean graphique) {
        int debut = compteur;
        compteur = compteur + km;
        // Graphique
        if (graphique) {
            for (int i = debut; i < compteur; i++) {
                route = " " + route;
                graphique();
            }
        }
        
    }
    
    public void arreter() {
        estDemarree = false;
        int lg = route.length();
        // Graphique
        route = route.substring(0, lg-1) + "v";
    } 
    public void afficher() {
        System.out.println("Couleur: "  + couleur);
        System.out.println("marque: "  + marque);
        System.out.println("modele: "  + modele);
        System.out.println("compteur: "  + compteur);
        System.out.println("Est démarrée: "  + estDemarree);
    }
        public void graphique() {
        System.out.println(route);
    }
}
