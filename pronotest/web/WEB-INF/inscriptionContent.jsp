<%-- 
    Document   : inscriptionContent
    Created on : 12 juin 2020, 10:05:26
    Author     : stagjava
--%>

<form method="POST" action="inscription">
    <fieldset>
        <legend>Inscription</legend>
        <p>Vous pouvez vous inscrire via ce formulaire</p>
        
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
        <label for="confirmation">Confirmation <span class="requis">*</span></label>
        <input type="password" id="confirmation" name="confirmation" 
               size="20" maxlength="20" 
               value='<c:out value='${param.confirmation}'/>'                      
               />
        <br>
        <label for="nom">Nom d'utilisateur <span class="requis">*</span></label>
        <input type="text" id="nom" name="nom" 
               size="20" maxlength="60" 
               value='<c:out value='${utilisateur.nom}'/>'                      
               />
        <span class="erreur">${form.erreurs.nom}</span>
        <br>
        <input type="submit" value='Inscription' class="sansLabel"/>
        <p>Les champs marqués d'un <span class='requis'>*</span>
        sont obligatoires.</p>
        <p class="${ (empty erreurs) ? 'succes' : 'erreur'}">${form.resultat}</p>
            
    </fields1et>
        
</form>
