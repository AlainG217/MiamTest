<%-- 
    Document   : header
    Created on : 9 juin 2020, 15:18:18
    Author     : stagjava
--%>

        <div class="menu">
            <h1>Pronostics football</h1>
            <c:set var="optMenuSelected" value="${param.optMenuSelected}" 
                   scope="request"/>
            <c:choose>
                <c:when test="${optMenuSelected == 'donnees'}">
                    <c:set var="className" value="optMenuSelected" 
                           scope="request"/>
                </c:when>
                <c:otherwise>
                    <c:set var="className" value="optmenu" scope="request"/>
                </c:otherwise>
            </c:choose>
            <a class="${className}" href="./donnees">Données</a>
            <c:choose>
                <c:when test="${optMenuSelected == 'resultats'}">
                    <c:set var="className" value="optMenuSelected" 
                           scope="request"/>
                </c:when>
                <c:otherwise>
                    <c:set var="className" value="optmenu" scope="request"/>
                </c:otherwise>
            </c:choose>
            <a class="${className}" href="./resultats">Résultats</a>
            <c:choose>
                <c:when test="${optMenuSelected == 'pronostics'}">
                    <c:set var="className" value="optMenuSelected"
                           scope="request"/>
                </c:when>
                <c:otherwise>
                    <c:set var="className" value="optmenu" scope="request"/>
                </c:otherwise>
            </c:choose>
            <a class="${className}" href="./pronostics">Pronostics</a>
        </div>
