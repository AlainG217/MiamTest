/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.servlets;

import fr.ldnr.alain.beans.Utilisateur;
import fr.ldnr.alain.forms.ConnexionCheckForm;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author stagjava
 */
@WebServlet(name = "Connexion", urlPatterns = {"/connexion"})
public class Connexion extends HttpServlet {
    
    // Constantes
    public static final String VUE = "/WEB-INF/connexion.jsp";
    public static final String SUCCESS = "/home";
    public static final String ATT_FORM = "form";
    public static final String ATT_USER = "utilisateur";

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        ConnexionCheckForm form = new ConnexionCheckForm();
        
        // Validation et traitement du formulaire
        Utilisateur utilisateur = form.checkForm(request);
        
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_USER, utilisateur);
        
        // Recup session
        HttpSession session = request.getSession();

        // Ajout du bean Utilisateur à la session
        if (form.getErreurs().isEmpty()) {
            session.setAttribute("sessionUtilisateur", utilisateur);
/*            this.getServletContext().getRequestDispatcher(SUCCESS).
                forward(request, response);
*/
            response.sendRedirect(request.getContextPath() + SUCCESS);
        } else {
            session.setAttribute("sessionUtilisateur", null);            
            this.getServletContext().getRequestDispatcher(VUE).
                forward(request, response);
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
    }// </editor-fold>

}
