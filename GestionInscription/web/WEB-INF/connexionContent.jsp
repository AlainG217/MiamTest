<%-- 
    Document   : connexionContent
    Created on : 15 juin 2020, 10:01:24
    Author     : stagjava
--%>

<form method="POST" action="connexion">
    <fieldset>
        <legend>Connexion</legend>
        <p>Vous pouvez vous connecter via ce formulaire</p>
        
        <label for="email">Courriel <span class="requis">*</span></label>
        <input type="text" id="email" name="email" 
               size="20" maxlength="60"
               value='<c:out value='${utilisateur.email}'/>'                                     
               />
        <span class="erreur">${form.erreurs.email}</span>
        <br>
        <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="motdepasse" name="motdepasse" 
               size="20" maxlength="20" 
               value='<c:out value='${utilisateur.mdp}'/>'                      
               />
        <span class="erreur">${form.erreurs.motdepasse}</span>
        <br>
        <input type="submit" value='Connexion' class="sansLabel"/>
        <p>Les champs marqués d'un <span class='requis'>*</span>
        sont obligatoires.</p>
        <p class="${ (empty erreurs) ? 'succes' : 'erreur'}">${form.resultat}</p>
        <%--Vérification de la présence d'un objet utilisateur en session --%>
        <c:if test="${!empty sessionScope.sessionUtilisateur}">
            <%--Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
            <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
        </c:if>        
            
    </fields1et>
        
</form>
