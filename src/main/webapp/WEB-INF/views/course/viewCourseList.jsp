
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cursos - CubaTech</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/assets/css/style.css">
</head>
<body>
    <div class="container ">
        <h4>${ subCategory.name } </h4>
        <h1>Cursos</h1>
        <a class="btn btn-primary" href="/admin/courses/new">Novo Curso</a>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Código</th>
                        <th>Visibilidade</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${ courses }" var="course">
                    <tr>
                        <td>${ course.name } </td>
                        <td>${ course.urlCode } </td>
                        <td>${ course.courseVisibility} </td>
                        <td><a class="btn btn-default" href="/admin/courses/${ categoryCode }/${ subCategory.urlCode }/${ course.urlCode }">Editar</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:forEach begin="1" end="${ totalPages }" varStatus="index">
                        <li><a href="?page=${ index.index-1 }">${ index.index }</a></li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </div>
</body>
</html>
