<%-- 
    Document   : articleContent
    Created on : 16 juin 2020, 13:28:33
    Author     : stagjava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form method="POST" action="Article">
    <fieldset>
        <legend>Article</legend>
        <p>Vous pouvez vous créer un article via ce formulaire</p>
        
        <label for="titre">Titre <span class="requis">*</span></label>
        <input type="text" id="titre" name="titre" 
               size="50" maxlength="60"
               value='<c:out value='${article.titre}'/>'                                     
               />
        <span class="erreur">${form.erreurs.article}</span>
        <br>
        <label for="contenu">Contenu <span class="requis">*</span></label>
        <textarea id="contenu" name="contenu" rows="5" cols=""100"
                  value='<c:out value='${article.contenu}'/>'/>
        </textarea>                    
        <span class="erreur">${form.erreurs.contenu}</span>
       <br>
        <input type="submit" value='Sauvegarder' class="sansLabel"/>
        <p>Les champs marqués d'un <span class='requis'>*</span>
        sont obligatoires.</p>
        <p class="${ (empty erreurs) ? 'succes' : 'erreur'}">${form.resultat}</p>
            
    </fields1et>
        
</form>

