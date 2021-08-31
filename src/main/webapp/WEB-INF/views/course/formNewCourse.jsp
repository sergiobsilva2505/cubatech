<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <title>Novo Curso - CubaTech</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
</head>
<body>
<div class="container">
    <form action="/admin/courses" method="post" >
        <h3>Novo Curso</h3>
        <div class="form-group">
            <label for="name" >Nome</label>
            <input id="name" class="form-control" type="text" name="name"
                   placeholder="digite aqui o nome do curso" />
            <form:errors path="newCourseForm.name" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <label for="urlCode" >Código</label>
            <input id="urlCode" class="form-control" type="text" name="urlCode"
                   placeholder="por exemplo: java, python (não use letras maiúsculas, acentos ou caracteres especiais)"/>
            <form:errors path="newCourseForm.urlCode" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <label for="timeToFinishInHours">Duração</label>
            <input id="timeToFinishInHours" class="form-control" type="number" name="timeToFinishInHours" min="1" max="20"
                   placeholder="duração do curso em horas: entre 1 a 20 horas"/>
            <form:errors path="newCourseForm.timeToFinishInHours" cssClass="alert-danger"/>
        </div>
        <div class="form-group">
            <label for="courseVisibility">Visibilidade</label><br>
            <select id="courseVisibility" class="form-control" name="courseVisibility" >
                <option value="" >Selecione</option>
                <c:forEach items="${ courseVisibilityValues }" var="courseVisibility">
                    <option value="${ courseVisibility }" ${ courseVisibility.equals(course.courseVisibility)
                            ? 'selected' : '' } >${ courseVisibility.description }</option>
                </c:forEach>
            </select>
            <form:errors path="newCourseForm.courseVisibility" />
        </div>
        <div class="form-group">
            <label for="targetAudience">Público alvo</label>
            <input id="targetAudience" class="form-control" type="text" name="targetAudience"
                   placeholder="uma descrição de pra quem é o curso"/>
            <form:errors path="newCourseForm.courseVisibility" cssClass="alert-danger"/>
        </div>
        <div class="form-group">
            <label for="instructor" >Instrutor</label>
            <input id="instructor" class="form-control" type="text" name="instructor"
                   placeholder="digite aqui o nome do instrutor do curso" />
            <form:errors path="newCourseForm.instructor" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <label for="summary">Ementa</label>
            <textarea id="summary" class="form-control"  name="summary" rows="4" cols="50"
                      placeholder="uma descrição detalhada do que será abordado no curso"></textarea>
        </div>
        <div class="form-group">
            <label for="skillsDeveloped">Habilidades desenvolvidas</label>
            <textarea id="skillsDeveloped" class="form-control"  name="skillsDeveloped" rows="4" cols="50"
                      placeholder="um texto sobre quais capacidades a pessoa que faz o curso terá exercitado"></textarea>
        </div>
        <div class="form-group">
            <label for="subCategory">Subcategoria</label>
            <select id="subCategory" class="form-control" name="subCategoryId" >
                <option value="" >Selecione</option>
                <c:forEach items="${ subCategories }" var="subCategory">
                    <option value="${ subCategory.id }">${subCategory.name}</option>
                </c:forEach>
            </select>
            <form:errors path="newCourseForm.subCategoryId" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Enviar</button>
        </div>
    </form>
</div>
</body>
</html>
