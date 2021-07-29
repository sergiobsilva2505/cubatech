
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Lista de Categorias - Cubatech</title>
    <link rel="stylesheet" href="/assets/css/style.css">
</head>
<body>
<div>
    <h2>Categorias:</h2>
    <ul>
        <c:forEach items="${ categories }" var="category">
            <li>${ category } -<br>
                <a href="/editaCategoria?id=${ category.id }">edita</a> -
                <form class="changeStatus" action="/alteraStatusCategoria" method="post">
                    <input type="hidden" name="id" value="${ category.id }">
                    <button type="submit">Muda Status</button>
                </form>
            </li>
            <hr>
        </c:forEach>
    </ul>
    <br>
    <a href="/">Index</a>
</div>
</body>
</html>

