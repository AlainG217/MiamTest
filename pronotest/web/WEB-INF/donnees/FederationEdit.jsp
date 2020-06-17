<%-- 
    Document   : FederationFull
    Created on : 17 juin 2020, 09:00:41
    Author     : stagjava
--%>

<jsp:include page="/WEB-INF/template.jsp">
    <jsp:param name="title" value="Pronostics Football"/>
    <jsp:param name="cssFiles" value="football" />
    <jsp:param name="optSubMenuSelected" value="Fédérations"/>
    <jsp:param name="optMenuSelected" value="donnees" />
    <jsp:param name="options" value="Fédérations|Compétitions|Saisons|Equipes|Journées" />
    <jsp:param name="liste" value="donnees/FederationListe" />
    <jsp:param name="content" value="donnees/FederationContent" />
            
</jsp:include>
