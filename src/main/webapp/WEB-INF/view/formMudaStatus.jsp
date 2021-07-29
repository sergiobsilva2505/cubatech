
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:url value="/entrada" var="linkEntradaServlet"/>
<!DOCTYPE>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Confirma mudança de status - Cubatech</title>
    <link rel="stylesheet" href="../../style.css">
</head>
<body>
    <br>
    <br>
    <br>
    <p>Deseja realmente mudar o status</p>
    <br>
    <form action="${ linkEntradaServlet }" method="post" >
        <div class="tableRow">
            <p></p>
            <input type="hidden" name="acao" value="UpdateCategory">
            <p><input type="submit" />
        </div>
    </form>

</body>
</html>
