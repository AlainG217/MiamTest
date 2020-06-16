<%-- 
    Document   : FederationL
    Created on : 13 juin 2020, 09:49:32
    Author     : stagjava
--%>

<jsp:include page="/WEB-INF/template.jsp">
    <jsp:param name="title" value="Pronostics Football"/>
    <jsp:param name="cssFiles" value="football" />
    <jsp:param name="optMenuSelected" value="donnees" />
    <jsp:param name="optSubMenuSelected" value="Federation" />
    <jsp:param name="options" value="Fédérations|Compétitions|Saisons|Equipes|Journées" />
    <jsp:param name="liste" value="donnees/FederationListe" />
            
</jsp:include>
