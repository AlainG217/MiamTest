<%-- 
    Document   : submenu
    Created on : 12 juin 2020, 16:19:05
    Author     : stagjava
--%>

    <div class="menu">
        <c:forTokens items="${param.options}" delims="|" var="option">
            <a class="optmenu" href="/${option}">${option}</a>
        </c:forTokens>
    </div>

