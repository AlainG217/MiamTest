/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stagjava
 */
@WebServlet(name = "Inscription", urlPatterns = {"/inscription"})
public class Inscription extends HttpServlet {
    
    // Constantes
    public static final String VUE = "/WEB-INF/inscription.jsp";
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "motdepasse";
    private static final String CHAMP_CONF = "confirmation";
    private static final String CHAMP_NOM = "nom";
    private static final int MIN_PASSWORD_LENGTH = 3;
    private static final int MIN_NAME_LENGTH = 3; 
    private static final String ATT_ERREURS = "erreurs";
    private static final String ATT_RESULTAT = "resultat";    

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Affichagz de la page d'inscription
        this.getServletContext().getRequestDispatcher(VUE).
                forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Initialisation
        String resultat;
        Map<String , String> erreurs = new HashMap<>();
        
        // Recup champs formulaires
        String email = request.getParameter(CHAMP_EMAIL);
        String mdp = request.getParameter(CHAMP_PASS);
        String confirmation = request.getParameter(CHAMP_CONF);
        String nom = request.getParameter(CHAMP_NOM);
        
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
        
        // Résultat global
        if (erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription";
        } else {
            resultat = "Echec de l'inscription";            
        }
        
        request.setAttribute(ATT_ERREURS, erreurs);
        request.setAttribute(ATT_RESULTAT, resultat);

        this.getServletContext().getRequestDispatcher(VUE).
                forward(request, response);
            
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
