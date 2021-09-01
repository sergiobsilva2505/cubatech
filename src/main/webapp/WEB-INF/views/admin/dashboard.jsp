
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:admin-templates title="Dashboard">

    <h1>Categorias</h1>
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Nome</th>
                <th>Qtd de cursos</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ categories }" var="category">
                <tr>
                    <td>${ category.name } </td>
                    <td>${ category.quantityOfCourses }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <h1>Instrutor com mais cursos</h1>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Nome</th>
                <th>Qtd de cursos</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ course }" var="course">
                <tr>
                    <td>${ course.instructor } </td>
                    <td>${ course.quantityOfCourses }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</templates:admin-templates>
