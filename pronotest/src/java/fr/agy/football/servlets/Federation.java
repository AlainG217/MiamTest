/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.agy.football.servlets;

import fr.agy.football.beans.donnees.FederationB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stagjava
 */
@WebServlet(name = "Federation", urlPatterns = {"/Federation"})
public class Federation extends HttpServlet {

    // Constantes
    public static final String VUE = "/WEB-INF/donnees/Federation.jsp";

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
        
        // Initiallisation
        ArrayList<FederationB> federations = new ArrayList<>();
        FederationB uneFede = new FederationB();
        
        // URLs
        HashMap<String, String> urls = new HashMap<>();
        urls.put("Fédérations", "./Federation");
        urls.put("Compétitions", "./Competition");
        urls.put("Saisons", "./Saison");
        urls.put("Equipes", "./Equipe");
        urls.put("Journées", "./Journee");
        request.setAttribute("urls", urls);
        
        // Liste des fédés
        federations = uneFede.getAll();
        request.setAttribute("federations", federations);
        
        // Affichage liste
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
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Serlet Federation";
    }


}
