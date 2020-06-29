<%-- 
    Document   : TestLimitations
    Created on : 11 juin 2020, 10:23:18
    Author     : stagjava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test des limitations des JSP en EL</title>
    </head>
    <body>
        <p>
            <%
                List<Integer> liste = (List<Integer>) request.getAttribute("liste");
                for ( Integer i : liste) {
                    out.println( i + " ; ");
                }
            %>
        </p>
        <P>
            <%
                Integer jourDuMois = (Integer) request.getAttribute("jour");
                if (0 == jourDuMois % 2) {
                    out.println("Jour pair : " + jourDuMois );
                } else {
                    out.println("Jour impair : " + jourDuMois );                    
                }
            %>
        </P>
    </body>
</html>
