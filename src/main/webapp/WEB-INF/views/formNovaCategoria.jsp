<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

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
                <input id="name" class="form-control" placeholder="nome aqui" type="text" name="name" />
            </div>
                <br>
            <div class="mb-3">
                <label for="urlCode" >Código</label>
                <input id="urlCode" class="form-control" type="text" name="urlCode" />
            </div>
                <br>
            <div class="mb-3">
                <label for="status">Categoria ativa?</label><br>
                <select id="status" class="form-control" name="status" >
                    <option value="Selecione" selected>Selecione</option>
                    <c:forEach items="${ statusValues }" var="status">
                        <option value="${ status }" ${ status.equals(category.status)? 'selected': '' } >${ status }</option>
                    </c:forEach>
                </select>

            </div>
                <br>
            <div class="mb-3">
                <label for="orderInSystem">Ordem da categoria</label>
                <input id="orderInSystem" class="form-control" type="text" name="orderInSystem" />
            </div>
                <br>
            <div class="mb-3">
                <label for="studyGuide">Guia de estudo</label>
                <textarea id="studyGuide" class="form-control" name="studyGuide" rows="4" cols="50">
<%--                    Texto aqui--%>
                </textarea>
            </div>
                <br>
            <div class="mb-3">
                <label for="iconPath">Caminho do ícone</label>
                <input id="iconPath" class="form-control" type="text" name="iconPath" />
            </div>
                <br>
            <div class="mb-3">
                <label for="colorCode">Cor</label>
                <input id="colorCode" class="form-control" type="text" name="colorCode" />
            </div>
                <br>
            <div class="mb-3">
                <label for="description">Descrição</label>
                <input id="description" class="form-control" type="text" name="description" />
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
