<%-- 
    Document   : header
    Created on : 9 juin 2020, 15:18:18
    Author     : stagjava
--%>

            <h1>Votre blog</h1>
            <div class=""menu">
                <c:if test="${empty sessionScope.sessionUtilisateur}">
                    <a class="optmenu" href="./inscription">Inscription</a>
                </c:if>        
                <c:if test="${empty sessionScope.sessionUtilisateur}">
                    <a class="optmenu" href="./connexion">Connexion</a>
                </c:if>        
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <a class="optmenu" href="./Article">Nouvel article</a>
                </c:if>        
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <a class="optmenu" href="./deconnexion">Deconnexion</a>
                </c:if>        
            </div>

