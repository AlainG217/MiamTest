/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testjar;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author stagjava
 */
public class TestJar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        
        // Variables
        try {
            // Indiquer le oilote à utiliser
            Class.forName("org.sqlite.JDBC");
            
            // Connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:sqlite:base1.db");
            
            
            // Création table animal
            String sqlStat = "CREATE TABLE IF NOT EXISTS " +
                    "animal(nom TEXTE, espece TEXT)";
            Statement st1 = conn.createStatement();
            st1.executeUpdate(sqlStat);

            // Ecriture  table animal
/*            sqlStat = "INSERT INTO animal(nom , espece) VALUES('Tigre', 'Félin')";
            st1 = conn.createStatement();
            st1.executeUpdate(sqlStat);

            String nom = "Vache";
            String espece = "Bovidé";
            sqlStat = "INSERT INTO animal(nom , espece) VALUES('" + 
                    nom + "', '" + espece + "')";
            st1 = conn.createStatement();
            st1.executeUpdate(sqlStat);
*/

            String nom = "Vache";
            String espece = "Bovidé";
            sqlStat = "INSERT INTO animal(nom , espece) VALUES(? , ?)";
            PreparedStatement ps1 = conn.prepareStatement(sqlStat);
            ps1.setString(1, nom);
            ps1.setString(2, espece);
            ps1.executeUpdate(sqlStat);
            
            // Requete
            sqlStat = "SELECT * FROM animal";
            ps1 = conn.prepareStatement(sqlStat);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                System.out.println("-- " + rs.getString("nom") + " :" + rs.getString("espece"));
            }
            rs.close();
            

            // Fermer la connexion
            conn.close();
            
        } catch (Exception ex) {
            System.out.println("Erreur " + ex);
        }
    }

}
