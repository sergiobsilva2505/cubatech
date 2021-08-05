
<%@ page import="br.com.sbs.cubatech.category.Category" %>
<%@ page import="java.util.List" %>
<!DOCTYPE>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Scriptlet - Lista CubaTech</title>
    <link rel="stylesheet" href="/assets/css/style.css">
</head>
<body>
    <div>
        <h1>Lista Utilizando Scriptlet</h1>
        <ul>
            <%
                List<Category> categoryList = (List<Category>) request.getAttribute("categories");
                for (Category category : categoryList){
            %>
                    <li> <%= category %> </li>
            <%
                }
            %>
        </ul>
        <br>
        <a href="../index.jsp">Index</a>
    </div>

    </script>
</body>
</html>
