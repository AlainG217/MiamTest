<%-- 
    Document   : test
    Created on : 8 juin 2020, 16:29:59
    Author     : stagjava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p> Ceci est une page générée depuis une servlet</p>
        <p>Hello World!</p>
        <p>
            <%
                String monAttr = (String) request.getAttribute("cle");
                out.println(monAttr);
            %>
        </p>
        
    </body>
</html>
