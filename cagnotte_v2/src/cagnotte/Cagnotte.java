/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cagnotte;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author stagjava
 */
public class Cagnotte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        VCagnotte frame = new VCagnotte("Cagnotte");
/*        
        // Variables
        String  prenom;
        double montant;
        Transaction personne;
        Solde solde;
        Solde unSolde;
        ArrayList<Transaction> transactions = new ArrayList();
        Map<String, Solde> soldes = new TreeMap();
        double total = 0.0;
        
        // Gestion du fichier
        // option 2
        LocalDate aujh = LocalDate.now();
        String s = "p" + aujh.toString() + ".txt";
        File fp = new File(s);
        
        // Récupérer le contenu du fichier
        if (fp.exists()) {
            transactions = lireFichier(fp);                                
        }
               
        // Demander les infos
        System.out.println("Prénom: ");
        prenom = clavier.nextLine();
        System.out.println("Montant;");
        montant = clavier.nextDouble();
        
        // Sauvegarder les infos
        personne = new Transaction(prenom, montant);
        transactions.add(personne.clone());                
        
        ecrireFichier(fp, transactions);
        
        // Afficher la recap
            for (Transaction p:transactions) {
                System.out.println(p.toString());
                
                // Pour option 1
                solde = new Solde(p.getPrenom(), p.getMontant());
                if (soldes.containsKey(p.getPrenom())) {
                    unSolde = soldes.get(p.getPrenom());
                    solde.setMontant(p.getMontant() + unSolde.getMontant());
                    soldes.replace(p.getPrenom(), solde);
                                        
                } else {
                    soldes.put(p.getPrenom(), solde);
                }
                
                total += p.getMontant();
                
            }
            
        // Option 1 
        afficherBilan(total, soldes);
    */    
        
    }
    
    public static void afficherBilan(Double total, Map<String, Solde> soldes) {

        int nbPersonnes = soldes.size();
        
            final double moyenne = total / nbPersonnes;
        
        // Calcul
        soldes.forEach(
                (k,v) -> v.calculSolde(moyenne));

        // Affichage
        System.out.println("");
        System.out.println("---- Bilan -----");
        soldes.forEach(
                (k,v) -> System.out.println(v.toString()));
    }
    
    
    public static void ecrireFichier(File file, ArrayList<Transaction> personnes) {
        FileWriter fw;
        String s = "", ps;
        
        try {
            fw = new FileWriter(file);
            
            for (Transaction p:personnes) {
                ps = p.prepareForSave();
                s = s + ps;
            }
            
                fw.write(s);
                fw.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        
    }
    public static ArrayList<Transaction> lireFichier(File file) {

        FileReader fr;
        BufferedReader br;
        String s;
        Transaction unePersonne;
        ArrayList<Transaction> personnes = new ArrayList();

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            while (br.ready()) {
                s = br.readLine();
                unePersonne = new Transaction(s);
                personnes.add(unePersonne.clone());                
            }
            
            fr.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        return personnes;
    }

}
