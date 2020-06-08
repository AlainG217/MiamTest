/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package voyage;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author stagjava
 */
public class Voyage {
        static HashMap villes = new HashMap();
        static HashMap nuits = new HashMap();
        static HashMap souvenirs = new HashMap();
        static TreeMap sorted = new TreeMap();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        boolean continuer = true;
        
        // Variables
        
        String ville;
        int nuit;
        int souvenir;
        int i = 0;
        
        while (continuer) {
            System.out.print("Ville: ");
            ville = clavier.nextLine();
            
            if (ville.equals("stop")) {
                continuer = false;
                break;
            }
                        
            // Vérifier si destination existe déjà
            int keyValue = villeExiste(ville);
            if (keyValue == 0) {
                i++;
                villes.put(i, ville);
            }
            
            System.out.print("Nombre de nuits: ");
            nuit = clavier.nextInt();
            if (keyValue == 0)
                nuits.put(i, nuit);
            else 
                nuits.replace(keyValue, (int) nuits.get(keyValue) + nuit);
            

            System.out.print("Nombre de souvenirs: ");
            souvenir = clavier.nextInt();
            if (keyValue == 0)
                souvenirs.put(i, souvenir);
            else 
                souvenirs.replace(keyValue, (int) souvenirs.get(keyValue) + souvenir);
            
            clavier.nextLine();
        }
        afficher();
        
        
        
    }

    public static void afficher(){
        
        int max = villes.size();
        String cadrage;
        int nbBlancs;
        int totSouvenir = 0;
        int maxNuit = 0;
        int maxKey = 0;
        
        System.out.println("\tDestination\tNuits\tSouvenirs");
        
        for (int i=1;i <= max; i++) {
            System.out.print(i + "\t");
            cadrage = (String) villes.get(i);
            nbBlancs = 10 - cadrage.length();
            cadrage = cadrage + " ".repeat(nbBlancs);
            System.out.print(cadrage + "\t");
            System.out.print(nuits.get(i) + "\t");
            System.out.println(souvenirs.get(i) + "\t");
            
            // Calculs option 2
            totSouvenir += (int) souvenirs.get(i);
            if ((int) nuits.get(i) > maxNuit) {
                maxNuit = (int) nuits.get(i);
                maxKey = i;
            }
            
            // Gestion option 3 affichage par nb de souvenirs décroissant
            sorted.put(souvenirs.get(i), villes.get(i));
        }
        
        // Aficher recap (option 2)
        System.out.println("Total de souvenirs: " + totSouvenir);
        System.out.println("Destination avec le plus de nuits: " + (String) villes.get(maxKey));
        
        // Affichage par nb de souvenirs décroissant
        System.out.println("");
        System.out.println("Par nombre de souvenirs décroissant");
        NavigableMap<Integer, String>  desc = sorted.descendingMap();
        int j = 0;
        desc.forEach(
                (k,v) -> System.out.println("\t" + v + "\t" + k ));
 
    }
    
    public static int villeExiste (String ville) {
        int max = villes.size();
        String uneVille;
        
        if (villes.containsValue(ville)) {
            for (int i=1;i <= max; i++) {
                uneVille = (String) villes.get(i);
                if (uneVille.equals(ville))
                    return i;
            }
            
        } else
            return 0;
        
        return 0;
    }
}
