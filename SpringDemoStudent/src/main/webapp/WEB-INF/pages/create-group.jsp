<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 27.02.2017
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Create group</title>
</head>
<body>
<form action="/CreateGroup" method="post">

    <lable class="control-label" for="name">Name</lable>
    <input placeholder="Inf-12-1" name="name" type="text"><br>

    <input name="countStudents" type="hidden" value="0"><br>

    <button class="btn btn-info" type="submit">Create group</button>
</form>
</body>
</html>
