
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Altera Categoria</title>
    <link rel="stylesheet" href="/assets/css/style.css">
</head>
<body>
<form action="/atualizaCategoria" method="post" >
    <h3>Nova Categoria:</h3>
    <br>

    <input type="hidden" name="id" value="${ category.id }">
    <div class="tableRow">
        <p >Nome:</p>
        <p><input id="name" type="text" name="name" value="${ category.name }"/></p>
    </div>
    <div class="tableRow">
        <p>UrlCode:</p>
        <p><input id="urlCode" type="text" name="urlCode" value="${ category.urlCode }" /></p>
    </div>
    <div class="tableRow">
        <p>Ordem:</p>
        <p><input id="orderInSystem" type="text" name="orderInSystem" value="${ category.orderInSystem }" /></p>
    </div>
    <div class="tableRow">
        <p>Descricao:</p>
        <p><input id="description" type="text" name="description" value="${ category.description }" /></p>
    </div>
    <div class="tableRow">
        <p>Status:</p>
        <p>
            <select id="status" name="status" >
                <option value="" >Selecione</option>
                <c:forEach items="${ statusValues }" var="status">
                    <option value="${ status }" ${ status.equals(category.status)? 'selected': '' } >${ status }</option>
                </c:forEach>

            </select>
        </p>
    </div>
    <div class="tableRow">
        <p>Icone:</p>
        <p><input id="iconPath" type="text" name="iconPath" value="${ category.iconPath }" /></p>
    </div>
    <div class="tableRow">
        <p>Cor:</p>
        <p><input id="colorCode" type="text" name="colorCode" value="${ category.colorCode }" /></p>
    </div>
    <div class="tableRow">
        <p></p>
        <input type="hidden" name="acao" value="UpdateCategory">
        <p><input type="submit" />
    </div>
</form>
</body>
</html>

