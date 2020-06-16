/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.dao;

import fr.ldnr.alain.beans.Utilisateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stagjava
 */
public class UtilisateurDAO extends DAO<Utilisateur> {
    
    private final String TABLE = "utilisateur";
    
    @Override
    public Utilisateur find(Integer id) {
        // Initialisation
        Utilisateur utilisateur = null;
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE id = ?";
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.first()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(id);
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setMdp(rs.getString("motdepasse"));
                utilisateur.setNom(rs.getString("nom"));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(
                    UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return utilisateur;
    }
    
    public Utilisateur findByEmail(String email) {
        // Initialisation
        Utilisateur utilisateur = null;
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE email = ?";
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.first()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setMdp(rs.getString("motdepasse"));
                utilisateur.setNom(rs.getString("nom"));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(
                    UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return utilisateur;
    }
    
    @Override
    public Utilisateur create(Utilisateur obj) {
        
        // Accès à la base
        try {
            String req = "INSERT INTO " + TABLE + 
                    " (email, motdepasse, nom) VALUES(?, ?, ?)";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getEmail());
            pstmt.setString(2, obj.getMdp());
            pstmt.setString(3, obj.getNom());

            pstmt.executeUpdate();
            
            // Récupérer l'ID
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if (rs.first()) {
                obj.setId(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(
                    UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public Utilisateur update(Utilisateur obj) {
        
        // Accès à la base
        try {
            String req = "UPDATE " + TABLE + 
                    " SET email = ?, motdepasse = ? , nom = ?) WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setString(1, obj.getEmail());
            pstmt.setString(2, obj.getMdp());
            pstmt.setString(3, obj.getNom());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(
                    UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public Utilisateur delete(Utilisateur obj) {
        
        // Accès à la base
        try {
            String req = "DELETE FROM " + TABLE + "  WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setInt(1, obj.getId());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(
                    UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public List<Utilisateur> list() {
        // Initialisation
        List<Utilisateur> utilisateurs = new ArrayList<>();
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE;
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                utilisateurs.add( new Utilisateur(
                        rs.getInt("id"), 
                        rs.getString("email"), 
                        rs.getString("motdepasse"), 
                        rs.getString("nom")));
          }
            
        } catch (SQLException e) {
            Logger.getLogger(
                    UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return utilisateurs;
    }
    
}
