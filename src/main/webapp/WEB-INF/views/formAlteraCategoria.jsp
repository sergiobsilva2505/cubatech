<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <title>Altera Categoria</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
</head>
<body>
<h3>Edita Categoria:</h3>
<br>
<form action="/admin/categories{categoryCode}" method="post" >



    <label for="name">Nome</label>
    <input id="name" type="text" name="name" />
    </div>
    <div>
    <label for="urlCode">Código</label>
    <input id="urlCode" type="text" name="urlCode" />
    </div>
    <div>
    <input type="checkbox" id="cActive" name="vehicle1" value="Bike">
    <label for="cActive">Categoria ativa?</label><br>
    </div>
    <div>
    <label for="orderInSystem">Ordem da categoria</label>
    <input id="orderInSystem" type="text" name="orderInSystem" />
    </div>
    <div>
    <label for="studyGuide">Guia de estudo</label>
    <textarea id="studyGuide" name="studyGuide" rows="4" cols="50">
    </textarea>
    </div>
    <div>
    <label for="iconPath">Caminho do ícone</label>
    <input id="iconPath" type="text" name="iconPath" />
    </div>
    <div>
    <label for="colorCode">Cor</label>
    <input id="colorCode" type="text" name="colorCode" />
    </div>
    <div>
    <label for="description">Descrição</label>
    <input id="description" type="text" name="description" />
    </div>
    <div>
    <button type="submit">Enviar</button>
    </div>
</form>
</body>
</html>

