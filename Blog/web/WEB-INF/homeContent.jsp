<%-- 
    Document   : homeContent
    Created on : 9 juin 2020, 16:25:56
    Author     : stagjava
--%>

        <div id="cadre">
            <h2>Voici mes premiers articles</h2>
            <c:forEach items="${requestScope.articles}" var="unArticle"
                       varStatus="status"> 
                <c:set var="titre" value="${unArticle.getTitre()}" />
                <c:set var="date" value="${unArticle.getDateArt()}" />
                <c:set var="auteur" value="${unArticle.getAuteur()}" />
                <c:set var="contenu" value="${unArticle.getContenu()}" />
                <h3><c:out value="${titre}"/></h3>
                <p><c:out value="Article cr��e le ${date} par ${auteur}"/> 
                </p>
                <p><c:out value="${contenu}" /> </p>
                <c:if test="${status.last}">
                    <p><c:out value="C'est le dernier"/></p>
                </c:if>
            </c:forEach>
            </div>             

