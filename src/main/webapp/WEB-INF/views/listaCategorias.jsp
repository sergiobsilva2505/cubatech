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
        <button type="button" class="btn btn-primary" >Nova Categoria</button>
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
                        <td><a href="/admin/subcategories/${ category.urlCode }">Subcategorias</a></td>
                        <td>
                            <form class="" action="/admin/categories/${ category.urlCode }" method="">
                                <input type="hidden" name="id" value="${ category.id }">
                                <button type="submit" class="btn" >Editar</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>

