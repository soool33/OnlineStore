<%@ page import="com.mycompany.onlinestore.backend.entity.Catalogue" %>
<%@ page import="com.mycompany.onlinestore.backend.entity.Work" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalogue</title>
</head>
<body>
<h1>Catalogue des oeuvres</h1>
<%
    for (Work work : Catalogue.listOfWorks) {%>
        <%=work.getTitle()%>(<%=work.getRelease()%>)<br/>
    <%}
    %>

</body>
</html>
