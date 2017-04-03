<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 27.02.2017
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<form action="/UpdateUser" method="post">
    <input name="id" type="hidden" value="${user.id}"/>

    <lable class="control-label" for="email">Email</lable>
    <input name="email" type="text" value="${user.email}"/><br>

    <lable class="control-label" for="password">Password</lable>
    <input name="password" type="password" value="${user.password}"/><br>

    <lable class="control-label" for="name">Name</lable>
    <input name="name" type="text" value="${user.name}"/><br>

    <lable class="control-label" for="surname">Surname</lable>
    <input name="surname" type="text" value="${user.surname}"/><br>

    <input name="groupId" type="hidden" value="${user.groupId}"/>
    <input name="roles" type="hidden"
           value="<c:forEach items="${user.roles}" var="role">${role}</c:forEach>"/>

    <button class="btn btn-info" type="submit">Update user</button>
</form>
</body>
</html>
