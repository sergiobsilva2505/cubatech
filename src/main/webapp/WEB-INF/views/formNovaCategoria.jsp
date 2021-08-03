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
            <div class="input-group">
                <label for="name">Nome</label>
                <input id="name" class="form-control" placeholder="nome aqui" type="text" name="name" />
            </div>
            <div class="input-group">
                <label for="urlCode">Código</label>
                <input id="urlCode" class="form-control" type="text" name="urlCode" />
            </div>
            <div class="input-group">
            <input type="checkbox"  id="cActive" name="vehicle1" value="Bike">
            <label for="cActive">Categoria ativa?</label><br>
            </div>
            <div class="input-group">
                <label for="orderInSystem">Ordem da categoria</label>
                <input id="orderInSystem" class="form-control" type="text" name="orderInSystem" />
            </div>
            <div class="input-group">
            <label for="studyGuide">Guia de estudo</label>
            <textarea id="studyGuide" class="form-control" name="studyGuide" rows="4" cols="50">

            </textarea>
            </div>
            <div class="input-group">
            <label for="iconPath">Caminho do ícone</label>
            <input id="iconPath" class="form-control" type="text" name="iconPath" />
            </div>
            <div class="input-group">
            <label for="colorCode">Cor</label>
            <input id="colorCode" class="form-control" type="text" name="colorCode" />
            </div>
            <div class="input-group">
            <label for="description">Descrição</label>
            <input id="description" class="form-control" type="text" name="description" />
            </div>
            <div class="input-group">
            <button type="submit">Enviar</button>
            </div>
        </form>
</div>
</body>
</html>
