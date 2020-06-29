/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.dao;

import fr.ldnr.alain.connexion.MySQLConnexion;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author stagjava
 */
public abstract class DAO<T> {
    
    protected Connection connexion = MySQLConnexion.getInstance();
    
    /**
     * Récupère un objet via son id
     * @param id
     * @return 
     */
    public abstract T find(Integer id);

    /**
     * Insère l'objet dans la base
     * @param obj
     * @return 
     */
    public abstract T create(T obj);

    /**
     * Supprime l'objet dans la base
     * @param obj
     * @return 
     */
    public abstract T delete(T obj);
    
    /**
     * Met à jour l'objet dans la base
     * @param obj
     * @return 
     */
    public abstract T update(T obj);
    
    /**
     * Retourne une  liste des objets dans la base
     * @param obj
     * @return 
     */
    public abstract List<T> list();
    
}
