/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.forms;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import fr.ldnr.alain.beans.ArticleB;
import fr.ldnr.alain.beans.Utilisateur;

/**
 *
 * @author stagjava
 */
public class ArticleCheckForm {

    protected static final String CHAMP_TITRE = "titre";
    protected static final String CHAMP_CONT = "contenu";

    // Attributs  
    protected String resultat;
    protected Map<String, String> erreurs = new HashMap<>();

    public ArticleB checkForm( HttpServletRequest request) {
        ArticleB unArticle = new ArticleB();
        
        // Recup des données reçues
        String titre            = getValeurChamp(request, CHAMP_TITRE);
        String contenu          = getValeurChamp(request, CHAMP_CONT);
        Utilisateur auteur  = (Utilisateur)request.getSession().
                                        getAttribute("sessionUtilisateur");
        int idUtilisateur = auteur.getId();


        // Validation des données reçues
        try {
            notEmpty(titre);
        } catch (Exception e) {
            /* Gérer les erreurs */
            erreurs.put( CHAMP_TITRE, e.getMessage());
        }
        
        try {
            notEmpty(contenu);
        } catch (Exception e) {
            /* Gérer les erreurs */
            erreurs.put( CHAMP_CONT, e.getMessage());
        }
        

        // Résultat 
        unArticle.setTitre(titre);
        unArticle.setContenu(contenu);
        unArticle.setIdAuteur(idUtilisateur);
        
        if (erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription";
        } else {
            resultat = "Echec de l'inscription";            
        }
        
        return unArticle;
    }
    /**
     * Valide le nom saisi.
     */
    protected void notEmpty(String nom) throws Exception {
        
        if (nom == null || nom.length() == 0) {
            throw new Exception( 
                    "Obligatoire" );            
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
