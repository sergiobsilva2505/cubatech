<%@ tag language="java" pageEncoding="UTF-8" %>

<%@attribute name="title" required="true" rtexprvalue="true" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <title>${ title }</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
</head>
    <body>
        <div class="container">
            <jsp:doBody/>
        </div>
    </body>
</html>