<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <title>Altera Subcategoria</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
</head>
<body>
<div class="container">
    <h3>Edita Subcategoria</h3>
<form action="/admin/subcategories/${ categoryCode }/${ subCategoryCode }" method="post" >
    <input type="hidden" name="id" value="${ subCategory.id }">
    <div class="form-group">
        <label for="name">Nome</label>
        <input id="name" class="form-control" type="text" name="name" value="${ subCategory.name }"
               placeholder="Digite aqui o nome da subcategoria"/>
        <form:errors path="subCategoryForm.name" cssClass="alert-danger" />
    </div>
    <div class="form-group">
        <label for="urlCode" >Código</label>
        <input id="urlCode" class="form-control" type="text" name="urlCode" value="${ subCategory.urlCode }"
               placeholder="por exemplo: java, python (não use letras maiúsculas, acentos ou caracteres especiais)"/>
        <form:errors path="subCategoryForm.urlCode" cssClass="alert-danger" />
    </div>
    <div class="form-group">
        <label for="status">Subcategoria ativa?</label><br>
        <select id="status" class="form-control" name="status" >
            <option value="${ category.status }" >Selecione</option>
            <c:forEach items="${ statusValues }" var="status">
                <option value="${ status }" ${ status.equals(category.status) ? 'selected' : '' } >${ status.description }</option>
            </c:forEach>
        </select>
        <form:errors path="subCategoryForm.status" />
    </div>
    <div class="form-group">
        <label for="orderInSystem">Ordem da subcategoria</label>
        <input id="orderInSystem" class="form-control" type="number" name="orderInSystem" value="${ subCategory.orderInSystem }"
               placeholder="por exemplo: subcategoria de ordem 1 aparece antes da subcategoria de ordem 2"/>
        <form:errors path="subCategoryForm.orderInSystem" cssClass="alert-danger"/>
    </div>
    <div class="form-group">
        <label for="studyGuide">Guias de estudo</label>
        <textarea id="studyGuide" class="form-control"  name="studyGuide" rows="4" cols="50"
                  placeholder="Um texto apontando para formações para ajudar pessoas perdidas">${ subCategory.studyGuide }</textarea>
    </div>
    <div class="form-group">
        <label for="description">Descrição</label>
        <input id="description" class="form-control" type="text" name="description" value="${ subCategory.description }"
               placeholder="por exemplo: Laravel, Cake PHP e CodeIgniter são frameworks que vocẽ vai treinar bastante aqui."/>
    </div>
    <div class="form-group">
        <label for="category">Categoria</label>
        <select id="category" class="form-control" name="categoryId" >
            <option value="" >Selecione</option>
            <c:forEach items="${ categories }" var="category">
                <option value="${ category.id }" ${ category.id==subCategory.categoryId ?" selected='selected'": "" }  >${ category.name }</option>
            </c:forEach>
        </select>
        <form:errors path="subCategoryForm.categoryId" />
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary" >Enviar</button>
    </div>
</form>
</div>
</body>
</html>

