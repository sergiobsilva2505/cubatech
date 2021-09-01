<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:admin-templates title="Categorias" >
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
</templates:admin-templates>

