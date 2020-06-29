/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarot.control;

// Utilities
import java.util.ArrayList;
import java.util.Enumeration;
import tarot.view.ScoreV;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import tarot.BaseObj;
import tarot.model.Carte;
import tarot.model.Joueur;
import tarot.view.TarotV;
import utils.Utils;

/**
 *
 * @author stagjava
 */
public class TarotC extends BaseObj {
    // Attributs
    private int nbJoueurs = 0;
    private Hashtable joueurs = new Hashtable();
    private HashSet<Carte> jeuInitial = new HashSet<>();
    private ArrayList<Carte> jeu = new ArrayList<>();
    private ArrayList<Carte> chien = new ArrayList<>();
    private ArrayList<Carte> tour = new ArrayList<>();
    private int quiDistribue;
    private int nbParties;
    private int partieEnCours;
    private int nbCartesChien;
    private int nbCartes1Tour;
    
    private TarotV view;
    
    public  TarotC () { 
        super();
        view = new TarotV();
    }
    
    public int drive () {
        boolean isOK = true;
        ScoreV tableauScore = new ScoreV();

        if (initialiserPartie() == false)
            setEtat(-1);
        
        if (drivePartie() == false)
            setEtat(-1);
        
        isOK = tableauScore.afficherResume(joueurs);
                
        
        return getEtat();
        
    }
    public boolean couper() {
        boolean isOK = true;
        HashSet<Carte> moitie1 = new HashSet<>();
        HashSet<Carte> moitie2 = new HashSet<>();
        
        // Vérifier que je jeu intial n'est pas vide
        if (jeuInitial.isEmpty()) {
            setEtat(-1);
            return false;
        }
        
        
        // Dans un premier temps on coupe au milieu
        int j = 0; 
        // Pour couper, la première fois, on met les cartes de jeuInitial dans jeu
        // Comme jeuInitial est un hashtable, l'ordre est aléatoire et les
        // cartes sont ainsi automatiquement mélangées
        
        if (partieEnCours == 0) {
            
            // On fait les 2 moitiés
            Iterator it = jeuInitial.iterator();
            while (it.hasNext()) {
                j++;
                if (j <= 38) {
                    moitie1.add((Carte) it.next());
                } else {
                    moitie2.add((Carte) it.next());                    
                }
            }
            // On commence par la 2nde moitié
            it = moitie2.iterator();
            while (it.hasNext()){
                jeu.add((Carte) it.next());
            }
            
            // Puis la 1ère moitié
            it = moitie2.iterator();
            while (it.hasNext()){
                jeu.add((Carte) it.next());
            }
            partieEnCours++;
        }

        // Test
        /*
        for (int i = 0; i < jeu.size(); i++) {
            System.out.println(i + "\t" + jeu.get(i).getAbbr());
        }
*/
        return isOK;
    }
    public boolean distribuer() {
        boolean isOK = true;
        int i = 0;
        boolean first = true;
        int prochainJoueur = quiDistribue;
        String carteAuChien = "n";
        System.out.println(jeu.size());
        
        while (i < 78) {
            
            System.out.println(i);
            prochainJoueur++;
            if (prochainJoueur > nbJoueurs)
                prochainJoueur = 1;
            
            // Au 1er tour pas de cartes au chien
            
            if (i > nbCartes1Tour && chien.size() < nbCartesChien) {
                // demander si on met une carte au chien
                carteAuChien = view.demanderCarteAuCHien();
                
                if (carteAuChien.equals("o") || carteAuChien.equals("O")) {
                    mettreCarteAuChien(i);
                    i++;
                }
                
            }
            isOK = donnerCartesProchainJoueur(i, prochainJoueur);
            i += 3;

            
        }

            // Test
        for (int z = 1; z <= nbJoueurs;z++) {
            System.out.println("Joueur " + z);
            Joueur ceJoueur = (Joueur) joueurs.get(z);
            TreeMap<Integer, Carte>  cartes = ceJoueur.getCartes();
            System.out.println(cartes.size());
            cartes.forEach(
                (k,v) -> System.out.print(v.getAbbr() + " "));
            System.out.println("");
        }    
        
        // Effacer le jeu puisqu'il a été distribué
        jeu.clear();
        
        // Test quick check
        System.out.println("------");
        Enumeration e = joueurs.elements();
        while (e.hasMoreElements()) {
            Joueur unJoueur = (Joueur) e.nextElement();
            System.out.println(unJoueur.getCartes().size());
        }
        return isOK;
    }
    
    public boolean donnerCartesProchainJoueur(int pos,int prochainJoueur) {
        boolean isOK = true;
        Joueur ceJoueur = (Joueur) joueurs.get(prochainJoueur);
        if (ceJoueur == null)
            return false;
        
        for (int i = pos; i < pos +3; i++) {
            ceJoueur.getCartes().put(jeu.get(i).getRang(),jeu.get(i));
        }
        return isOK;
    }
    
    public boolean drivePartie() {
        boolean isOK = true;
        int noPartie = 0;
        
        for (int i = 1; i <= nbParties; i++) {
            // Couper le jeu
            isOK = couper();

            // Distribuer les cartes
            isOK = distribuer();
            break;

            // Tour d'annonce

            // Jeu 

            // Compter les points
            
            // Ramasser les cartes
            
        }

        return isOK;
    }
    
    public boolean initialiserPartie() {
        boolean isOK = true;
        String nomJoueur;
        
        Joueur joueur = new Joueur();

        // Afficher l'accueil
        view.afficherAccueil();
        
        // Demander le nombre de parties
        nbParties = view.nombreDeParties();

        // Demander le nombre de joueurs
      nbJoueurs = view.nombreDeJoueurs();
      switch (nbJoueurs) {
          case 3 : nbCartesChien = 6;
                    nbCartes1Tour =9;
                    break;
          case 4 : nbCartesChien = 6;
                    nbCartes1Tour =12;
                    break;
          case 5 : nbCartesChien = 3;
                    nbCartes1Tour =15;
                    break;
      }
        
        if (nbJoueurs == -1) {
            // Fin
            return false;
        } 
        
        // Demander le nom des joueurs

        for (int i=1;i <= nbJoueurs;i++) {
            nomJoueur = view.nomJoueur(i);
            joueur.Joueur(i, nomJoueur);
            joueurs.put(i, joueur.clone());
        }
        
        // Charger les cartes
        isOK = chargerCartes();
        
        // Déterminer le joueur qui commence (au début aléatoire)
        quiDistribue = Utils.alea(0, nbJoueurs -1);
        
     
        return isOK;
    }
    
        
    public void mettreCarteAuChien(int pos) {
            chien.add(jeu.get(pos));
    }

    public boolean chargerCartes() {
        boolean isOK = true;
        Integer i;
        String str;
        Carte carte = new Carte();
        Carte uneCarte = new Carte();

        // Créer les atouts
        for (i=21; i >=0; i--) {
            if (i == 0) {
                carte.init("Excuse", "Atout");                
            } else {
                str = i.toString();
                carte.init(str, "Atout");
                jeuInitial.add(carte.clone());
            }            
        }
        // Créer les coeurs
        for (i= 1; i <= 10; i++) {
            str = i.toString();
            carte.init(str, "Coeur");
            jeuInitial.add(carte.clone());
        }
        carte.init("Valet", "Coeur");
        jeuInitial.add(carte.clone());
        carte.init("Cavalier", "Coeur");
        jeuInitial.add(carte.clone());
        carte.init("Dame", "Coeur");
        jeuInitial.add(carte.clone());
        carte.init("Roi", "Coeur");
        jeuInitial.add(carte.clone());

        // Créer les carreaux
        for (i= 1; i <= 10; i++) {
            str = i.toString();
            carte.init(str, "Carreau");
            jeuInitial.add(carte.clone());
        }
        carte.init("Valet", "Carreau");
        jeuInitial.add(carte.clone());
        carte.init("Cavalier", "Carreau");
        jeuInitial.add(carte.clone());
        carte.init("Dame", "Carreau");
        jeuInitial.add(carte.clone());
        carte.init("Roi", "Carreau");
        jeuInitial.add(carte.clone());
        
        // Créer les piques
        for (i= 1; i <= 10; i++) {
            str = i.toString();
            carte.init(str, "Pique");
            jeuInitial.add(carte.clone());
        }
        carte.init("Valet", "Pique");
        jeuInitial.add(carte.clone());
        carte.init("Cavalier", "Pique");
        jeuInitial.add(carte.clone());
        carte.init("Dame", "Pique");
        jeuInitial.add(carte.clone());
        carte.init("Roi", "Pique");
        jeuInitial.add(carte.clone());
        
        // Créer les trèfles
        for (i= 1; i <= 10; i++) {
            str = i.toString();
            carte.init(str, "Trèfle");
            jeuInitial.add(carte.clone());
        }
        carte.init("Valet", "Trèfle");
        jeuInitial.add(carte.clone());
        carte.init("Cavalier", "Trèfle");
        jeuInitial.add(carte.clone());
        carte.init("Dame", "Trèfle");
        jeuInitial.add(carte.clone());
        carte.init("Roi", "Trèfle");
        jeuInitial.add(carte.clone());
        
/*        Iterator it = jeuInitial.iterator();
        while (it.hasNext()) {
            uneCarte = (Carte) it.next();
            System.out.println(uneCarte.getAbbr() + "\t" +uneCarte.getLibelle() + "\t" + uneCarte.getCouleur() + "\t" 
                    + uneCarte.getRang() + "\t" + uneCarte.getRangCouleur() + "\t" + uneCarte.getValeur() + 
                    "\t" + uneCarte.getEstBout() + "\t" + uneCarte.getEstFigure());
        }
*/        
        return isOK;
    }
}
