/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarot.view;

import java.util.Scanner;
import tarot.BaseObj;

/**
 * tarot view
 * @author stagjava
 */
public class TarotV extends BaseObj {
    Scanner clavier;
    
    public TarotV () {
        super();
        // Initialiser le clavier
        clavier = new Scanner(System.in);
    }
    
    public void afficherAccueil() {

        System.out.println("Bienvenue dans notre application de tarot");        
    }
    
        public String demanderCarteAuCHien() {
        String rep;
        
        System.out.print("Voulez-vous mettre la prochaine carte au chien: ");
        return rep = clavier.nextLine();
    }

    public int nombreDeJoueurs() {
        int nb = 0;
        boolean continuer = true;
        String rep = "O";
        
        // Mode de jeu (3, 4 , ou 5)
        while (continuer == true) {
            System.out.print("Saisissez le nombre de joueurs: ");
            nb = clavier.nextInt();
            // le nombre de joueurs doit être entre 3 et 5
            if (nb < 3 || nb > 5) {
                System.out.println("Le nombre de joueurs est 3, 4 ou 5 ");
                
                // Demander si continuer
                System.out.println("Voulez-vous continuer (O/n)?");                
                clavier.nextLine();
                rep = clavier.nextLine();
                if (rep.equals("n")) {
                    continuer = false;
                    nb = -1;
                }
            } else {
                
                clavier.nextLine();
                continuer = false;
            }  
        }

        return nb;
    }

    public int nombreDeParties() {
        int nbParties;
        
        System.out.print("Saisissez le nombre de parties: ");
        nbParties = clavier.nextInt();
        
        return nbParties;
    }
    
    public String nomJoueur (int numero) {
        // Définition variables
        String nom;
        
        System.out.println("Saisissez le nom du joueur " + numero);
        nom = clavier.nextLine();
        return nom;
    }
}
