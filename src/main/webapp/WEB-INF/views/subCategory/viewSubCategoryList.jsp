<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:admin-templates title="Subcategorias">

    <h4>${ category.name } </h4>
    <h1>Subcategorias</h1>
    <a class="btn btn-primary" href="/admin/subcategories/new">Nova Subcategoria</a>
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
                <c:forEach items="${ subCategories }" var="subCategory">
                    <tr>
                        <td>${ subCategory.name } </td>
                        <td>${ subCategory.urlCode } </td>
                        <td>${ subCategory.status.description} </td>
                        <td><a href="/admin/courses/${ categoryCode }/${ subCategory.urlCode }">Cursos</a></td>
                        <td>
                            <a class="btn btn-default" href="/admin/subcategories/${ categoryCode }/${ subCategory.urlCode }">Editar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</templates:admin-templates>

