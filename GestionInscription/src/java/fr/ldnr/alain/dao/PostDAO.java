/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.dao;

import fr.ldnr.alain.beans.ArticleB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stagjava
 */
public class PostDAO extends DAO<ArticleB>{
    
    private final String TABLE = "post";
    
    @Override
    public ArticleB find(Integer id) {
        // Initialisation
        ArticleB article = null;
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE id = ?";
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.first()) {
                article = new ArticleB();
                article.setId(id);
                article.setTitre(rs.getString("titre"));
                article.setContenu(rs.getString("contenu"));
                Date uneDate = rs.getDate("dateCreation");
                article.setDateArt(rs.getDate("dateCreation") );
                article.setIdAuteur(rs.getInt("idUtilisateur"));
                
            }
            
        } catch (SQLException e) {
            Logger.getLogger(
                    UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return article;
    }
    
    @Override
    public ArticleB create(ArticleB obj) {
        
        // Accès à la base
        try {
            String req = "INSERT INTO " + TABLE + 
                    " (titre, contenu,  idUtilisateur) VALUES(?,  ?, ?)";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getTitre());
            pstmt.setString(2, obj.getContenu());
            pstmt.setInt(3, obj.getIdAuteur());

            pstmt.executeUpdate();

            // Récupérer l'ID
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if (rs.first()) {
                obj.setId(rs.getInt(1));
            }
            
            // Date de création
            obj.setDateArt(Date.valueOf(LocalDate.now()));
            
        } catch (SQLException e) {
            Logger.getLogger(
                    UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public ArticleB update(ArticleB obj) {
        
        // Accès à la base
        try {
            String req = "UPDATE " + TABLE + 
                    " SET titre = ?, contenu = ? , idUtilisateur = ? WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setString(1, obj.getTitre());
            pstmt.setString(2, obj.getContenu());
            pstmt.setInt(3, obj.getIdAuteur());
            pstmt.setInt(4, obj.getId());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(
                    UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public ArticleB delete(ArticleB obj) {
        
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
    public List<ArticleB> list() {
        // Initialisation
        List<ArticleB> articles = new ArrayList<>();
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE;
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Date uneDate = rs.getDate("dateCreation");
                articles.add(new ArticleB(
                        rs.getInt("id"), 
                        rs.getString("titre"), 
                        rs.getString("contenu"), 
                        rs.getDate("dateCreation"),
                        rs.getInt("idUtilisateur"))
                );
          }
            
        } catch (SQLException e) {
            Logger.getLogger(
                    UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return articles;
    }
    
}
