/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.forms;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author stagjava
 */
public abstract class UtilisateurCheckForm {

    // Constantes    
    protected static final String CHAMP_EMAIL = "email";
    protected static final String CHAMP_PASS = "motdepasse";
    protected static final String CHAMP_CONF = "confirmation";
    protected static final String CHAMP_NOM = "nom";    
    protected static final int MIN_PASSWORD_LENGTH = 3;
    protected static final int MIN_NAME_LENGTH = 3; 

    // Attributs  
    protected String resultat;
    protected Map<String, String> erreurs = new HashMap<>();
    /**
     * Valide l'adresse mail saisie.
     */    
    protected void validationEmail(String email) throws Exception {
        
        if ( email != null && email.length() != 0 ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }    
    }

    /**
     * Valide les mots de passe saisis.
     */    
    protected void validationMdp(String mdp, String confirmation) 
            throws Exception {
        
        if ( mdp != null && mdp.length() != 0 && confirmation != null 
                && confirmation.length() != 0 ) {
            if ( !mdp.equals( confirmation ) ) {
                throw new Exception( 
                        "Les mots de passe entrés sont différents, "
                                + "merci de les saisir à nouveau." );
            } else if ( mdp.length() < MIN_PASSWORD_LENGTH){
                throw new Exception( 
                        "Les mots de passe doivent contenir au moins " 
                                + MIN_PASSWORD_LENGTH + "caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }        
    }

    /**
     * Valide les mots de passe saisis.
     */    
    protected void validationMdp(String mdp) 
            throws Exception {
        
        if ( mdp != null && mdp.length() != 0 ) {
            if ( mdp.length() < MIN_PASSWORD_LENGTH){
                throw new Exception( 
                        "Le mot de passe doit contenir au moins " 
                                + MIN_PASSWORD_LENGTH + "caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }        
    }
    
    /**
     * Valide le nom saisi.
     */
    protected void validationNom(String nom) throws Exception {
        
        if (nom != null && nom.length() < MIN_NAME_LENGTH) {
            throw new Exception( 
                    "Le nom d'utilisateur doit contenir au moins " 
                            + MIN_NAME_LENGTH + "caractères." );            
        }
    }

    /**
     * contenu d'un paramètre
     * @param request
     * @param champ
     * @return 
     */
    public static String getValeurChamp(HttpServletRequest request, String champ) {
        String valeur = request.getParameter(champ);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur.trim();
        }
    }
    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(Map<String, String> erreurs) {
        this.erreurs = erreurs;
    }
    
}
