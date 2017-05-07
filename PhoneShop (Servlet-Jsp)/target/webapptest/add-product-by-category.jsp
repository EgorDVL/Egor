<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 11.11.2016
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="AddNewProductByCategory" method="get">
    <lable for="category">Category</lable>
    <select name="category">
        <option value="1">Phones</option>
        <option value="2">Tablets</option>
        <option value="3">Accessories</option>
    </select>
    <br>
    <input type="submit" value="Next">
</form>
</body>
</html>
