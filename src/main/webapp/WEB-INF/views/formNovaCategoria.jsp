<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <title>Nova Categoria</title>
        <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
    </head>
<body>
        <div class="container">
            <form action="/admin/categories" method="post" >
            <h3>Nova Categoria:</h3>
            <br>
            <div class="mb-3">
                <label for="name" >Nome</label>
                <input id="name" class="form-control" type="text" name="name"
                       placeholder="Digite aqui o nome da categoria"/>
                <form:errors path="categoryForm.name" cssStyle="color: red" />
            </div>
                <br>
            <div class="mb-3">
                <label for="urlCode" >Código</label>
                <input id="urlCode" class="form-control" type="number" name="urlCode"
                       placeholder="por exemplo: desenvolvimento, mobile (não use letras maiúsculas, acentos ou caracteres especiais)"/>
                <form:errors path="categoryForm.urlCode" cssStyle="color: red" />
            </div>
                <br>
            <div class="mb-3">
                <label for="status">Categoria ativa?</label><br>
                <select id="status" class="form-control" name="status" >
                    <option value="" >Selecione</option>
                    <c:forEach items="${ statusValues }" var="status">
                        <option value="${ status }" ${ status.equals(category.status)? 'selected': '' } >${ status }</option>
                    </c:forEach>
                </select>
                <form:errors path="categoryForm.status" />

            </div>
                <br>
            <div class="mb-3">
                <label for="orderInSystem">Ordem da categoria</label>
                <input id="orderInSystem" class="form-control" type="text" name="orderInSystem"
                       placeholder="por exemplo: categoria de ordem 1 aparece antes de ordem 2"/>
                <form:errors path="categoryForm.orderInSystem" cssStyle="color: red" />
            </div>
                <br>
            <div class="mb-3">
                <label for="studyGuide">Guia de estudo</label>
                <textarea id="studyGuide" class="form-control" name="studyGuide" rows="4" cols="50"
                          placeholder="Um texto apontando para formações para ajudar pessoas perdidas">
                </textarea>
            </div>
                <br>
            <div class="mb-3">
                <label for="iconPath">Caminho do ícone</label>
                <input id="iconPath" class="form-control" type="text" name="iconPath"
                       placeholder="por exmplo: /images/categorias/programação.svg"/>
            </div>
                <br>
            <div class="mb-3">
                <label for="colorCode">Cor</label>
                <input id="colorCode" class="form-control" type="text" name="colorCode"
                       placeholder="por exemplo: #fcc14a"/>
            </div>
                <br>
            <div class="mb-3">
                <label for="description">Descrição</label>
                <input id="description" class="form-control" type="text" name="description"
                       placeholder="por exemplo: iOS, Android, PhoneGap e mais."/>
            </div>
                <br>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
            </form>
            <br><br>
        </div>
    </body>
</html>
