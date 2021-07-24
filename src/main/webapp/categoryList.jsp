
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Lista de Categorias - Cubatech</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
  <div class="container-fluid">
    <h2>Categorias:</h2>
      <table class="table table-sm table-bordered ">
        <thead class="table-light">
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Nome</th>
            <th scope="col">UrlCode</th>
            <th scope="col">Descrição</th>
            <th scope="col">Guia de Estudo</th>
            <th scope="col">Status</th>
            <th scope="col">Ordem</th>
            <th scope="col">Ícone</th>
            <th scope="col">Cor</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${ categories }" var="category">
            <tr>
              <td>${ category.id }</td>
              <td>${ category.name }</td>
              <td>${ category.urlCode }</td>
              <td>${ category.description }</td>
              <td>${ category.studyGuide }</td>
              <td>${ category.status }</td>
              <td>${ category.orderInSystem }</td>
              <td>${ category.iconPath }</td>
              <td>${ category.colorCode }</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
  </script>
</body>
</html>
