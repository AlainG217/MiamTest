/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stagjava
 */
public final class MySQLConnexion {

    /*** URL de connection*/
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "blog";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
    
    /*** Nom du user*/
    private static final String USER = "ldnrjava";
    /*** Mot de passe du user*/
    private static final String PASSWORD = "ldnrjava";    
    
    // Objet connexion
    private static Connection connexion = null;

    public MySQLConnexion() {
    }
    
    public static Connection getInstance () {
        
        if (connexion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connexion = DriverManager.getConnection(URL, USER, PASSWORD);
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MySQLConnexion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex2) {
                Logger.getLogger(MySQLConnexion.class.getName()).log(Level.SEVERE, null, ex2);
            }
        }
        return connexion;
    }
    
    
}
