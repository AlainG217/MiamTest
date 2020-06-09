<%-- 
    Document   : homeContent
    Created on : 9 juin 2020, 16:25:56
    Author     : stagjava
--%>

        <div id="cadre">
            <h2>Voici mes premiers articles</h2>
            <h3>${unArticle.getTitre()}</h3>
            <p> Article créée le ${unArticle.getDateArt()} par ${unArticle.getAuteur()}
            </p>
            <p>${unArticle.getContenu()} </p>
        </div>             

