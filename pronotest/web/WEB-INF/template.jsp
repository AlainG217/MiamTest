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
        <c:forTokens items="${param.cssFiles}" delims="|" var="cssFile">
            <link rel="stylesheet" href="./inc/${cssFile}.css">             
        </c:forTokens>
        <title>${param.title}</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" >
            <jsp:param name="optMenuSelected" value="${param.optMenuSelected}" />            
        </jsp:include>
        <jsp:include page="/WEB-INF/submenu.jsp" >
            <jsp:param name="options" value="${param.options}" />            
        </jsp:include>
        <c:if test="${param.liste}">
            <jsp:include page="/WEB-INF/${param.liste}.jsp" />
        </c:if>
        <c:if test="${param.content}">
            <jsp:include page="/WEB-INF/${param.content}.jsp" />
        </c:if>
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>
