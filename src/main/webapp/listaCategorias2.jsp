
<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Lista de Categorias - Cubatech</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
  <div>
    <h2>Categorias:</h2>
    <ul>
      <c:forEach items="${ categories }" var="category">
        <li>${ category } -<br> <a href="mostraCategoria?id=${ category.id }">edita</a>
        <hr>
      </c:forEach>
    </ul>
    <br>
    <a href="index.jsp">Index</a>
  </div>
</body>
</html>
