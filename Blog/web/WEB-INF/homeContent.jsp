<%-- 
    Document   : homeContent
    Created on : 9 juin 2020, 16:25:56
    Author     : stagjava
--%>

        <div id="cadre">
            <h2>Voici mes premiers articles</h2>
            <h3>${requestScope.unArticle.getTitre()}</h3>
            <p> Article créée le ${requestScope.unArticle.getDateArt()} par ${requestScope.unArticle.getAuteur()}
            </p>
            <p>${requestScope.unArticle.getContenu()} </p>
        </div>             

