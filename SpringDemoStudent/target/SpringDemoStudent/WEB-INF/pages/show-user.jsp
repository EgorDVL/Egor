<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 26.02.2017
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Show user</title>
</head>
<body>
<tr>
    <td>Id - ${user.id}</td>
    <br>
    <td>Email- ${user.email}</td>
    <br>
    <td>Password - ${user.password}</td>
    <br>
    <td>Name - ${user.name}</td>
    <br>
    <td>Surname - ${user.surname}</td>
    <br>
    <td>Role - ${user.roles}</td>
    <br>
    <td>Group id - ${user.groupId}</td>
    <br>
    <br>
    <li><a href="/UpdateUserPage?userId=${user.id}">Update user page</a></li>
</tr>
</body>
</html>
