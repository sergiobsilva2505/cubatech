
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<!DOCTYPE>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Nova Categoria</title>
    <link rel="stylesheet" href="/assets/css/style.css">
</head>
<body>
        <form action="/adicionaCategoria" method="post" >
            <h3>Nova Categoria:</h3>
            <br>
            <div class="tableRow">
                <p >Nome:</p>
                <p><input id="name" type="text" name="name" /></p>
            </div>
            <div class="tableRow">
                <p>UrlCode:</p>
                <p><input id="urlCode" type="text" name="urlCode" /></p>
            </div>
            <div class="tableRow">
                <p>Ordem:</p>
                <p><input id="orderInSystem" type="text" name="orderInSystem" /></p>
            </div>
            <div class="tableRow">
                <p>Descrição:</p>
                <p><input id="description" type="text" name="description" /></p>
            </div>
            <div class="tableRow">
                <p>Status:</p>
                <p>
                    <select id="status" name="status" >
                        <option value="Selecione" selected>Selecione</option>
                        <option value="ACTIVE">ACTIVE</option>
                        <option value="INACTIVE">INACTIVE</option>
                    </select>
                </p>
            </div>
            <div class="tableRow">
                <p>Icone:</p>
                <p><input id="iconPath" type="text" name="iconPath" /></p>
            </div>
            <div class="tableRow">
                <p>Cor:</p>
                <p><input id="colorCode" type="text" name="colorCode" /></p>
            </div>
            <div class="tableRow">
                <p></p>
                <input type="hidden" name="acao" value="AddCategory">
                <p><input type="submit" />
            </div>
        </form>
</body>
</html>
