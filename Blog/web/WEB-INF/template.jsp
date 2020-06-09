<%-- 
    Document   : newjsp
    Created on : 9 juin 2020, 14:51:31
    Author     : stagjava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${param.title}</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <jsp:include page="/WEB-INF/${param.content}.jsp" />
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>
