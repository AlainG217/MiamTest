/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author stagjava
 */
public class TestServlet extends HttpServlet {
    
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        String attributMsg = "Transmission attribut OK";
        request.setAttribute("cle", attributMsg);
        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/test.jsp")
                .forward(request, response);
    }
            
}
