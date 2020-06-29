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
            <jsp:param name="optSubMenuSelected" value="${param.optSubMenuSelected}" />            
        </jsp:include>
            <c:set var="liste" value="${param.liste}"/>    
        <c:if test="${!empty liste}">
            <jsp:include page="/WEB-INF/${param.liste}.jsp" >
                <jsp:param name="selection" value="${param.selection}" />                            
            </jsp:include>
        </c:if>
            <c:set var="content" value="${param.content}"/>    
            <c:if test="${!empty content}">
            <jsp:include page="/WEB-INF/${param.content}.jsp" />
        </c:if>
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>
