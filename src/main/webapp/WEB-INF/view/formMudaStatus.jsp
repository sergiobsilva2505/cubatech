
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Confirma mudança de status - Cubatech</title>
    <link rel="stylesheet" href="/assets/css/style.css">
</head>
<body>
    <br>
    <br>
    <br>
    <p>Deseja realmente mudar o status</p>
    <br>
    <form action="/alteraStatusCategoria" method="post" >
        <div class="tableRow">
            <p></p>
            <input type="hidden" name="acao" value="UpdateCategory">
            <p><input type="submit" />
        </div>
    </form>

</body>
</html>
