<%-- 
    Document   : FederationContent
    Created on : 17 juin 2020, 09:04:34
    Author     : stagjava
--%>


<form method="POST" action="Federation">
    <fieldset>
        <legend>Fédération</legend>
        <c:out value="${sessionScope.mode}"/>
        <label for="name">Nom <span class="requis">*</span></label>
        <input type="text" id="name" name="name" 
               size="60" maxlength="60"
               value='<c:out value='${federation.name}'/>' 
               <c:choose>
                   <c:when test="${sessionScope.mode == 'upd'}">
                       readonly="false"
                   </c:when>
                   <c:otherwise>
                       readonly="true"                       
                   </c:otherwise>
               </c:choose>
               />
        <span class="erreur">${form.erreurs.name}</span>
        <br>
        <c:if  test="${sessionScope.mode ne 'view'}">
            <input type="submit" value='Sauvegarder' class="sansLabel"/>            
            <p>Les champs marqués d'un <span class='requis'>*</span>
            sont obligatoires.</p>
        </c:if>
        <p class="${ (empty erreurs) ? 'succes' : 'erreur'}">${form.resultat}</p>
            
    </fields1et>
        
</form>

