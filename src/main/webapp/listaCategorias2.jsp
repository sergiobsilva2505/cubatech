
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Categorias - Cubatech</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
  <div>
    <h2>Categorias:</h2>
    <ul>
      <c:forEach items="${ categories }" var="category">
        <li>${ category } -<br> <a href="">edita</a> - <a href="">ativa/desativa</a></li>
        <hr>
      </c:forEach>
    </ul>
    <br>
    <a href="index.jsp">Index</a>
  </div>
</body>
</html>
