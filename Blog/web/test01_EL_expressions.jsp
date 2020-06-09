<%-- 
    Document   : test01_EL_expressions
    Created on : 9 juin 2020, 15:43:26
    Author     : stagjava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Test EL sur expressions</title>
</head>
<body>
    <p>
        <!--Logiques sur des booléens -->
        { true && true } vaut ${ true && true } <br>
        { true && false} vaut ${ true && false } <br>
        { !true || false } vaut ${ !true || false } <br>
        <!--Calculs arithmétiques -->
        { 14 / 4 } vaut ${ 14 / 4 } <br>
        { 14 div 4 } vaut ${ 14 div 4 } <br>
        { 14 mod 4 } vaut ${ 14 mod 4 } <br>
        { 14 % 4 } vaut ${ 14 % 4 } <br>
        { 6 * 7 } vaut ${ 6 * 7 } <br>
        { 63 -8 } vaut ${ 63 -8 } <br>
        { 12 / -8 } vaut ${ 12 / -8 } <br>
        { 7 / 0 } vaut ${ 7 / 0 } <br>
        <!--Compare les caractères 'a' et 'b'.Le caractère 'a' étant bien situé 
        avant le caractère 'b' dans l'alphabet ASCII, cette EL affiche true.
        Remarquez au passage l'utilisation des simples quotes ' possible à la 
        place des double quote " du java-->
        { 'a' < 'b' } vaut ${ 'a' < 'b' } <br>
        <!--Compare les chaînes 'hip' et 'hit'.Puisque 'p' < 't', cette EL affiche false.-->
        { 'hip' > 'hit' } vaut ${ 'hip' > 'hit' } <br>
        <!--Compare les caractères 'a' et 'b', puis les chaînes 'hip' et 'hit'.
        Puisque le premier test renvoie true et le second false, le résultat est false.-->
        { 'a' lt 'b' && 'hip' gt 'hit' } vaut ${ 'a' lt 'b' && 'hip' gt 'hit' } <br>
        <!--Compare le résultat d'un calcul à une valeur fixe.Ici, 6 x 7 vaut 42 
        et non pas 48, le résultat est false.-->
        { 6 * 7 == 48 } vaut ${ 6 * 7 == 48 } <br>
        <!--Vérifications si vide ou null -->
        <!--La chaîne testée n'est pas vide, 
                                             le résultat est false -->
        { empty 'test' } vaut ${ empty 'test' } <br>
        <!--La chaîne testée est vide, le résultat est true -->
        { empty '' } vaut ${ empty '' } <br>
        <!--La chaîne testée est vide, le résultat est false -->
        { !empty '' } vaut ${ !empty '' } <br>
        <!--Conditions ternaires -->
        { true ? 'vrai' : 'faux' } vaut ${ true ? 'vrai' : 'faux' } <br>
        { 'a' > 'b' ? 'oui'  : 'non' } vaut ${ 'a' > 'b' ? 'oui'  : 'non' } <br>
        { empty 'test' ? 'vide' : 'non  vide'  } vaut ${ empty 'test' ? 'vide' : 'non  vide'  } 
        <br>
    </p>
</body>
</html>
