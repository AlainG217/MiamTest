/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.dao;

import fr.ldnr.alain.connexion.MySQLConnexion;
import java.sql.Connection;

/**
 *
 * @author stagjava
 */
public class TestDB {

    public static void main(String[] args) {
        
        Connection conn = MySQLConnexion.getInstance();

        if (conn != null) {
            System.out.println("Connecté");
        
    }
    
    
}
    
    
    
}
