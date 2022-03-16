<%--
  Created by IntelliJ IDEA.
  User: Fred
  Date: 13/03/2022
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<html>
<head>
    <title>Modele</title>
</head>
<body>
    <h1>Modele de code Jsp</h1>
<%--    Insertion de code Java--%>
    <% int nombre = 27; %>
        <c:if test="${nombre == 27}">
            Ce texte est affiché si ma nombre vaut <%=nombre%>.
        </c:if>

    <%--work est passé via :
    request.setAttribute("work", work);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/work-details.jsp");
    requestDispatcher.forward(request, response);--%>

    Titre : ${work.title}<br/>
    Année de parution : ${work.release}<br/>
    Genre : ${work.genre}<br/>
    Artiste principal : ${work.mainArtist.name}<br/><a/>
    Résumé : ${work.summary}<br/>

    <form action=addToCart method="post">
        <input type=hidden name=identifiant value = "${work.id}"/><br/><br/>
        <input type=submit value=Ajouter au caddie>
    </form>

</body>
</html>
