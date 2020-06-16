<%-- 
    Document   : FederationListe
    Created on : 13 juin 2020, 10:07:43
    Author     : stagjava
--%>
<form method="POST" action="selectionFederation">
    <fieldset>
        <legend>Sélection</legend>
        
        <c:if test="${param.selection}">
            <label for="selection">${param.selection} <span class="requis">*</span></label>
            <input type="text" id="email" name="email" 
               size="20" maxlength="60"
               value=''                                     
               />
        </c:if>
        
        <table class="liste">
            <colgroup span="1"></colgroup>
            <tr>
                <th class="entTabNom">Nom</th>
                <th class="entTabOpt">Vue</th>
                <th class="entTabOpt">Edit</th>
                <th class="entTabOpt">Suppr</th>
            </tr>
            <c:forEach items="${requestScope.federations}" var="fede">
                <tr>
                    <td>${fede.name}</td>
                    <td><input type="button" class="btnListe" value="V"/></td>
                    <td><input type="button" class="btnListe" value="E"/></td>
                    <td><input type="button" class="btnListe" value="D"/></td>
                </tr>
            </c:forEach>
            
        </table>
            
    </fields1et>
</form>
        

