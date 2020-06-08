/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sport.trot.model;

import fr.sport.trot.error.TrotException;
import fr.sport.trot.web.WCourseRang;
import java.sql.Connection;

/**
 *
 * @author stagjava
 */
public class MPersonne extends MBase{
    // Attributes
    private String prenom;
    private boolean isJockey;
    private boolean isEntraineur;
    private boolean isProprietaire;
    
    public MPersonne(Connection db) throws TrotException {
        super(db, "personne");
        buildMapping();
    }
    
    public void setFlags(String type) throws TrotException {
        switch (type) {
            case "J" :
                isJockey(true);
                isEntraineur(false);
                isProprietaire(false);
                break;
            case "E" :
                isJockey(false);
                isEntraineur(true);
                isProprietaire(false);
                break;
            case "P" :
                isJockey(false);
                isEntraineur(true);
                isProprietaire(true);
                break;
            default : throw new TrotException("CCE0001");
        }
        setObjectState(1);
    }

    @Override
    public MPersonne clone() {
        try {
            MPersonne unePersonne = new MPersonne(this.getDb());
            unePersonne.id(this.id(null));
            unePersonne.name(this.name(null));
            unePersonne.prenom(this.prenom(null));
            unePersonne.isJockey(this.isJockey(null));
            unePersonne.isEntraineur(this.isEntraineur(null));
            unePersonne.isProprietaire(this.isProprietaire(null));
            return unePersonne;
        } catch (TrotException e) {
            return null;
        }
            
    }

    @Override
    public String toString() {
        return "MPersonne{" + "id=" + id + ", name=" + name + ", prenom=" + prenom + ", isJockey=" + isJockey + ", isEntraineur=" + isEntraineur + ", isProprietaire=" + isProprietaire + '}';
    }
    
    @Override
    protected void buildMapping () {
        super.buildMapping();
        mapping.put("prenom", "prenom");
        mapTypes.put("prenom", "String");
        mapping.put("isJockey", "isJockey");
        mapTypes.put("isJockey", "boolean");
        mapping.put("isEntraineur", "isEntraineur");
        mapTypes.put("isEntraineur", "boolean");
        mapping.put("isProprietaire", "isProprietaire");
        mapTypes.put("isProprietaire", "boolean");
    }

    public String prenom(String prenom) {
        if (prenom == null)
            return this.prenom;
        else {
            this.prenom = prenom;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Boolean isJockey(Boolean value) {
        if (value == null)
            return isJockey;
        else {
            this.isJockey = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Boolean isEntraineur(Boolean value) {
        if (value == null)
            return isEntraineur;
        else {
            this.isEntraineur = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Boolean isProprietaire(Boolean value) {
        if (value == null)
            return isProprietaire;
        else {
            this.isProprietaire = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

}
