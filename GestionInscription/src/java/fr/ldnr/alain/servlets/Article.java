/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.servlets;

import fr.ldnr.alain.beans.ArticleB;
import fr.ldnr.alain.forms.ArticleCheckForm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "Article", urlPatterns = {"/Article"})
public class Article extends HttpServlet {

    // Constantes
    public static final String VUE = "/WEB-INF/article.jsp";
    public static final String ATT_FORM = "form";
    public static final String ATT_POST = "article";

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
        // Init
        HttpSession session = request.getSession();
        List<ArticleB> articles = new ArrayList<>();
        ArticleB monArticle = new ArticleB();

        // Trouver l'article à éditer
        // Recup paramètre, if any
        String ind = request.getParameter("id");
        if (!ind.equals(null)){
            int index = Integer.parseInt(ind);

            articles = (List<ArticleB>) session.getAttribute("articles");
            ArticleB[] artArr = new ArticleB[articles.size()];
            articles.toArray(artArr);
            monArticle = artArr[index];
            request.setAttribute(ATT_POST, monArticle);
            session.setAttribute("mode", "upd");
        } else {
            session.setAttribute("mode", "add");
            
        }
        
        
        
        
        // Affichagz de la page de maintenance article
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
        ArticleCheckForm form = new ArticleCheckForm();
        HttpSession session = request.getSession();
        
        // Validation et traitement du formulaire
        ArticleB article = form.checkForm(request);
        
        // Temporaire status sert à dire si creation ou MAJ
        if (session.getAttribute("mode").equals("upd")){
            article.setStatus(10);
        } else {
            article.setStatus(1);
        }

        if (form.getErreurs().isEmpty() ) {
            article.save();
        }
        
        
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_POST, article);

        this.getServletContext().getRequestDispatcher(VUE).
                forward(request, response);
            
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
