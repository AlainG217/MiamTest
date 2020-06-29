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
public class InscriptionCheckForm  extends UtilisateurCheckForm {


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
    
    

}
