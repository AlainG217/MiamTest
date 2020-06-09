<%-- 
    Document   : home.jsp
    Created on : 8 juin 2020, 16:44:38
    Author     : stagjava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style.css">
        <title>JSP Home Page</title>
    </head>
    <body>
        <div id="cadre">
            <h1>Bienvenue sur mon blog</h1>
            <h2>Voici mes premiers articles</h2>
            <h3>
                <%
                    fr.ldnr.alain.beans.Article unArticle = 
                            (fr.ldnr.alain.beans.Article) request.getAttribute("unArticle");
                    out.println(unArticle.getTitre());
                %>
            </h3>
            <p>
                <%
                    out.println(" Article créée le " + 
                            unArticle.getDateArt() + " par " + unArticle.getAuteur());
                %>
            </p>
            <p>
                <%= unArticle.getContenu()%>
            </p>
        </div>             
    </body>
</html>
