<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <title>Categorias - CubaTech</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/assets/css/style.css">
</head>
<body>
    <div class="container ">
        <h1>Categorias</h1>
        <a class="btn btn-primary" href="/admin/categories/new">Nova Categoria</a>
        <div class="table-responsive">
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
                            <td>${ category.status.description} </td>
                            <td><a href="/admin/subcategories/${ category.urlCode }">Subcategorias</a></td>
                            <td>
                                <a class="btn btn-default" href="/admin/categories/${ category.urlCode }">Editar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>

