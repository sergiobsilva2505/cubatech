<%@ page import="br.com.sbs.cubatech.category.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scriptlet - Lista CubaTech</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Lista Utilizando Scriptlet</h1>
        <ul class="list-group">
            <%
                List<Category> categoryList = (List<Category>) request.getAttribute("categories");
                for (Category category : categoryList){
            %>
                    <li class="list-group-item"> <%= category %> </li>
            <%
                }
            %>
        </ul>
        <a href="index.jsp">Index</a>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">

    </script>
</body>
</html>
