<%-- 
    Document   : submenu
    Created on : 12 juin 2020, 16:19:05
    Author     : stagjava
--%>

    <div class="menu">
        <c:forTokens items="${param.options}" delims="|" var="option" varStatus="status">
            <c:set var="key" value="${option}" scope="request"/>
            <c:set var="url" value="${urls[i]}" scope="request"/>
            <c:set var="optSubMenuSelected" value="${param.optSubMenuSelected}" 
                   scope="request"/>
            <c:choose>
                <c:when test="${optMenuSelected == option}">
                    <c:set var="className" value="optMenuSelected" 
                           scope="request"/>
                </c:when>
                <c:otherwise>
                    <c:set var="className" value="optmenu" scope="request"/>
                </c:otherwise>
            </c:choose>
            <a class="optmenu" href="<c:url value='${urls[key]}' />"><c:out value="${option}"/></a>
        </c:forTokens>
    </div>

