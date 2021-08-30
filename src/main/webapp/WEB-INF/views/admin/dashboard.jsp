
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Dashboard - Admin</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/assets/css/style.css">
</head>
<body>
<div class="container ">
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
</div>
</body>
</html>
