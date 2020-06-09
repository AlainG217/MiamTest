<%-- 
    Document   : federation
    Created on : 8 juin 2020, 16:51:41
    Author     : stagjava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fédération</title>
    </head>
    <body>
        <h1>Fédération</h1>
        <p>Nom <% 
                String federation = (String) request.getAttribute("federation");
                out.println(federation);
            %>
            </p>
            
    </body>
</html>
