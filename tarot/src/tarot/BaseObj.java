/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarot;

/**
 * Object de base 
 * @author stagjava
 */
public class BaseObj {
    int etat;       // 0= en traimement, 1 = OK, <0 En erreur
/**
 * ==========================
 * METHODES
 * ==========================
 */  
/**
 * Constructeur
 * @param 
 */     
    public BaseObj () {
        etat = 0;
    }
 /**
 * Méthode clone
 * Crée et renvoit une copie de lui-même
 * @param 
 */ 
    public BaseObj clone () {
        BaseObj unObj = new BaseObj();
        unObj.etat = 0;
        return unObj;
    }
 /**
 * ==========================
 * getters
 * ==========================
 */  
    public int getEtat(){
        return this.etat;
    }
 /**
 * ==========================
 * setters
 * ==========================
 */  
    public void setEtat(int etat){
        this.etat = etat;
    }    
}
