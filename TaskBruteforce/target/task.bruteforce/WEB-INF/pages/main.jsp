<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 22.05.2017
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Write password</title>
</head>
<body>
<form action="/password" method="post">

    <lable class="control-label" for="password">Enter password (Not more than 7 numbers):</lable>
    <input name="password" type="number"><br>

    <button class="btn btn-info" type="submit">Find</button>
</form>
</body>
</html>
