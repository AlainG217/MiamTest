/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Test de servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ceci est une page générée depuis une servlet</h1>");
            out.println("</body>");
            out.println("</html>");    
        }
    }
            
}
