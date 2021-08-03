<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <title>Lista de Categorias - Cubatech</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
</head>
<body>
    <div class="container">
        <h2>Categorias:</h2>
        <form action="/admin/categories/new" method="get" >
            <button type="submit"  class="btn btn-primary" >Nova Categoria</button>
        </form>

        <br><br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Código</th>
                    <th>Status</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ categories }" var="category">
                    <tr>
                        <td>${ category.name } </td>
                        <td>${ category.urlCode } </td>
                        <td>${ category.status } </td>
                        <td><a href="/admin/subcategories">Subcategorias</a></td>
                        <td>
                            <a class="btn btn-default" href="/admin/categories/${ category.urlCode }">Editar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>

