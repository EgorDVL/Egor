<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 26.02.2017
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Show all users</title>
</head>
<body>
<c:forEach items="${users}" var="user">
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
    </tr>
    <form action="/GetById" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <button class="btn btn-info" type="submit">More info</button>
    </form>
    <br>

    <form action="/GetByEmail" method="post">
        <input type="hidden" name="email" value="${user.email}">
        <button class="btn btn-info" type="submit">More info email</button>
    </form>
    <br>

    <form action="/DeleteUser" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <button class="btn btn-danger" type="submit">Delete user</button>
    </form>
</c:forEach>
</body>
</html>
