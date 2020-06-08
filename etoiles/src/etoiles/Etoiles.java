/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etoiles;
import java.util.Scanner;
//SQL
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author stagjava
 */
public class Etoiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        Scanner clavier = new Scanner(System.in);
        Connection conn = null;

        // Acquérir la taille

        System.out.println("Taille du motif");
        int taille = clavier.nextInt();
        
        if (taille < 5 || taille > 15) {
            System.out.println("Taille invalide");  
            System.exit(0);
        }
        
        // Connexion à la base de donnée
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(
                    "jdbc:sqlite:base1.db");
            
            
            // Création table animal
            String sqlStat = "CREATE TABLE IF NOT EXISTS " +
                    "etoiles(absisse INTEGER, ordonnee INTEGER)";
            Statement st1 = conn.createStatement();
            st1.executeUpdate(sqlStat);
            
        } catch (Exception ex) {
            System.out.println("Erreur " + ex);
            System.exit(0);
        }
        
        if (doitRemplir(conn, taille)) {
            // Remplir la table
            viderTable(conn);

            // Remplir la table
            remplirTable(conn, taille);
        }
        
        // Afficher la table
        afficherTable(conn);

        // Afficher le motif
        afficherMotif(conn, taille);
        
        
        // Cloture
        try {
            conn.close();
        } catch (Exception ex) {
            System.out.println("Erreur " + ex);
            System.exit(0);
        }
        
    }

    public static void afficherMotif (Connection conn, int taille) {
        
        String[][] motif = new String[taille][taille];
        // Initialiser avec des blancs
        for (int i = 0; i < motif.length; i++) {
            for (int j = 0; j < motif[i].length; j++) {
                motif[i][j] = " ";
            }            
        }

        // Lire la table et positionner les *
        try {
            String sqlStat = "SELECT * FROM etoiles ORDER BY absisse, ordonnee";
            PreparedStatement ps1 = conn.prepareStatement(sqlStat);
            ps1 = conn.prepareStatement(sqlStat);

            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                motif[rs.getInt("absisse")][rs.getInt("ordonnee")] = "*";
            }
            rs.close();
        } catch (Exception ex) {
            System.out.println("Erreur " + ex);
            System.exit(0);
        }

        // Afficher le motif
        for (int i = 0; i < motif.length; i++) {
            for (int j = 0; j < motif[i].length; j++) {
                System.out.print(motif[i][j]);
            }
            System.out.println("");
        }
    }
    public static void afficherTable (Connection conn) {
        
        try {
            String sqlStat = "SELECT * FROM etoiles  ORDER BY absisse, ordonnee";
            PreparedStatement ps1 = conn.prepareStatement(sqlStat);
            ps1 = conn.prepareStatement(sqlStat);

            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                System.out.print("(" + rs.getInt("absisse") + "," + rs.getInt("ordonnee") + "), ");
            }
            System.out.println("");
            rs.close();
        } catch (Exception ex) {
            System.out.println("Erreur " + ex);
            System.exit(0);
        }
    }
    
    public static boolean doitRemplir (Connection conn, int taille) {
         int maxA = 0;
        int maxO = 0;
        String sqlStat = "";
        
        try {
            sqlStat = "SELECT max(absisse), max(ordonnee)  FROM etoiles";
            PreparedStatement ps1 = conn.prepareStatement(sqlStat);
            ps1 = conn.prepareStatement(sqlStat);
            ResultSet rs = ps1.executeQuery();
            rs.next();
            maxA = rs.getInt("max(absisse)");
            maxO = rs.getInt("max(ordonnee)");
            rs.close();
        } catch (Exception ex) {
            System.out.println("Erreur " + ex);
            System.exit(0);
        }

        if (taille < maxA || taille < maxO)
            return true;
        else 
            return false;
    }
    public static void remplirTable (Connection conn, int taille) {
        int abs = 0;
        int ord = 0;
        String sqlStat = "";

        for (int i = 1; i <= 20; i++) {
        
            abs = (int)(Math.random()* (taille)); 
            ord = (int)(Math.random()* (taille));
            sqlStat = "INSERT INTO etoiles VALUES(? , ?)";
        try {
            PreparedStatement ps1 = conn.prepareStatement(sqlStat);
                ps1.setInt(1, abs);
                ps1.setInt(2, ord);
                ps1.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Erreur " + ex);
            System.exit(0);
        }

    }
    
    }
    
    public static void viderTable (Connection conn) {
        
        try {
            String sqlStat = "DELETE FROM etoiles";
            PreparedStatement ps1 = conn.prepareStatement(sqlStat);
            ps1.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Erreur " + ex);
            System.exit(0);
        }
    }
}
