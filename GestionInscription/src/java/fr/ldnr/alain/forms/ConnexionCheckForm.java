/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.forms;

import fr.ldnr.alain.beans.Utilisateur;
import fr.ldnr.alain.dao.UtilisateurDAO;
import static fr.ldnr.alain.forms.UtilisateurCheckForm.CHAMP_EMAIL;
import static fr.ldnr.alain.forms.UtilisateurCheckForm.getValeurChamp;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author stagjava
 */
public class ConnexionCheckForm extends UtilisateurCheckForm {
    
    public Utilisateur checkForm( HttpServletRequest request) {
        Utilisateur unUtilisateur = null;
        UtilisateurDAO udao = new UtilisateurDAO();
        
        // Recup des données reçues
        String email            = getValeurChamp(request, CHAMP_EMAIL);
        String mdp              = getValeurChamp(request, CHAMP_PASS);

        // Validation des données reçues
        try {
            validationEmail(email);
        } catch (Exception e) {
            /* Gérer les erreurs */
            erreurs.put( CHAMP_EMAIL, e.getMessage());
        }
        
        try {
            validationMdp(mdp);
        } catch (Exception e) {
            /* Gérer les erreurs */
            erreurs.put( CHAMP_PASS, e.getMessage());
        }
        
        // Vérifier existence et validité mot de passe
        unUtilisateur = udao.findByEmail(email);
        
        if (unUtilisateur == null) {
            erreurs.put( CHAMP_EMAIL, "Utilisateur n'existe pas");            
        } else {
            // Verif mot de passe
            if (!mdp.equals(unUtilisateur.getMdp())) {
                erreurs.put( CHAMP_PASS, "Mot de passe invalide");                
            }
        }
        
        if (erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription";
        } else {
            resultat = "Echec de l'inscription";            
        }
        
        return unUtilisateur;
    }
    
}
