<%-- 
    Document   : test02_EL_expressions
    Created on : 9 juin 2020, 16:07:38
    Author     : stagjava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Test EL sur beans</title>
</head>
<body>
    <p>
        <%--Initialisation d'un bean de type Personne avec une action standard, pour l'exemple : --%>
        <jsp:useBean id="monBean" class="fr.ldnr.alain.beans.Personne" />
        <%--Initialisation de sa propriété 'prénom' : --%>
        <jsp:setProperty name="monBean" property="prenom" value="Alphonse"/>
        <!--Et affichage de sa valeur : -->
        ${monBean.prenom} <br>
        <!--Cette syntaxe est également valable et plus précise -->
        ${monBean.getPrenom()} <br>
        <!--Des tests avec les beans -->
        {monBean.prenom == "Sophie"} vaut ${monBean.prenom == "Sophie"} <br>
        {empty monBean.prenom} vaut ${empty monBean.prenom} <br>
        {!empty monBean.prenom ? monBean.prenom : "Veuillez préciser un prénom"} vaut ${!empty monBean.prenom ? monBean.prenom : "Veuillez préciser un prénom"}<br>
    </p>
    <p>
        <!--La scriptlet suivante affiche "null" si la propriété "prenom" n'a pas 
        été initialisée, et provoque une erreur à la compilation si l'objet 
        "monBean" n'a pas été initialisé :-->
        Accès au prénom par scriptlet : <%= monBean.getPrenom()%><br>
        <!--©LDNR -Herbert CaffarelModule JEEPage 6sur 8L'action suivante affiche 
        "null" si la propriété "nom" n'a pas été initialisée, et provoque une 
        erreur à l'exécution si l'objet "monBean" n'a pas été initialisé :-->
        Accès au nom (non défini) par JSP : <jsp:getProperty name="monBean" property="nom" /><br>
        <!--L'expression EL suivante n'affiche rien si la propriété "age" n'a 
        pas été initialisée, et n'affiche rien si l'objet "monBean" n'a pas été initialisé :-->
        Accès à l'âge (non défini) par EL : ${monBean.age} <br>
    </p>
</body>
</html>
