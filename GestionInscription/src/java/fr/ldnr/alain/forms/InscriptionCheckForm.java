/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.forms;

import fr.ldnr.alain.beans.Utilisateur;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author stagjava
 */
public class InscriptionCheckForm {

    // Constantes    
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "motdepasse";
    private static final String CHAMP_CONF = "confirmation";
    private static final String CHAMP_NOM = "nom";    
    private static final int MIN_PASSWORD_LENGTH = 3;
    private static final int MIN_NAME_LENGTH = 3; 

    // Attributs  
    private String resultat;
    private Map<String, String> erreurs = new HashMap<>();

    public Utilisateur checkForm( HttpServletRequest request) {
        Utilisateur unUtilisateur = new Utilisateur();
        
        // Recup des données reçues
        String email            = getValeurChamp(request, CHAMP_EMAIL);
        String mdp              = getValeurChamp(request, CHAMP_PASS);
        String nom              = getValeurChamp(request, CHAMP_NOM);
        String confirmation     = getValeurChamp(request, CHAMP_CONF);

        // Validation des données reçues
        try {
            validationEmail(email);
        } catch (Exception e) {
            /* Gérer les erreurs */
            erreurs.put( CHAMP_EMAIL, e.getMessage());
        }
        
        try {
            validationMdp(mdp, confirmation);
        } catch (Exception e) {
            /* Gérer les erreurs */
            erreurs.put( CHAMP_PASS, e.getMessage());
        }
        
        try {
            validationNom(nom);
        } catch (Exception e) {
            /* Gérer les erreurs */
            erreurs.put( CHAMP_NOM, e.getMessage());
        }

        // Résultat 
        unUtilisateur.setEmail(email);
        unUtilisateur.setMdp(mdp);
        unUtilisateur.setNom(nom);
        
        if (erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription";
        } else {
            resultat = "Echec de l'inscription";            
        }
        
        return unUtilisateur;
    }
    
    /**
     * Valide l'adresse mail saisie.
     */    
    private void validationEmail(String email) throws Exception {
        
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
    private void validationMdp(String mdp, String confirmation) 
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
     * Valide le nom saisi.
     */
    private void validationNom(String nom) throws Exception {
        
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
