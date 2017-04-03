<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 27.02.2017
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Update group</title>
</head>
<body>
<form action="/UpdateGroup" method="post">
    <input name="Id" type="hidden" value="${group.id}"><br>

    <lable class="control-label" for="name">Name</lable>
    <input placeholder="Inf-12-1" name="name" type="text" value="${group.name}"><br>

    <lable class="control-label" for="countStudents">Count students</lable>
    <input placeholder="12" name="countStudents" type="number" value="${group.countStudents}"><br>

    <button class="btn btn-info" type="submit">Update group</button>
</form>
</body>
</html>
