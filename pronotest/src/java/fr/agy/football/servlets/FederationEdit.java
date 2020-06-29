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
import javax.servlet.http.HttpSession;

/**
 *
 * @author stagjava
 */
@WebServlet(name = "FederationEdit", urlPatterns = {"/FederationEdit"})
public class FederationEdit extends HttpServlet {


    // Constantes
    public static final String VUE = "/WEB-INF/donnees/FederationEdit.jsp";
    public static final String ATT_FORM = "form";
    public static final String ATT_FEDE = "federation";

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
        HttpSession session = request.getSession();
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
        
        // Gérer le mode
        String opt = request.getParameter("opt");
        
        if (opt.equals("A")) {
            session.setAttribute("mode", "add");
        } else {
            
            // Trouver la fede à éditer
            // Recup paramètre, if any
            String ind = request.getParameter("index");
            if (!ind.equals(null)){
                int index = Integer.parseInt(ind);

                federations = (ArrayList<FederationB>) session.getAttribute("federations");
                FederationB[] fedeArr = new FederationB[federations.size()];
                federations.toArray(fedeArr);
                uneFede = fedeArr[index];
                request.setAttribute(ATT_FEDE, uneFede);
                switch (opt) {
                    case "V":
                        session.setAttribute("mode", "view");
                        break;
                    case "E":
                        session.setAttribute("mode", "upd");
                        break;
                    case "S":
                        session.setAttribute("mode", "del");
                        break;
                    default:
                        session.setAttribute("mode", "view");                        
                }
            }
        }
        
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
        return "Federation Edit";
    }// </editor-fold>

}
