<%@ page import="br.com.sbs.cubatech.category.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scriptlet - Lista CubaTech</title>
</head>
<body>
    <h1>HTML Utilizando Scriptlet</h1>
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
    <a href="index.jsp">Index</a>
</body>
</html>
