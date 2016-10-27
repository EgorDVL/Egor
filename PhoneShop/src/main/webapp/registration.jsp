<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 09.10.2016
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="Registration" method="post">
    <lable for="email">E-mail</lable>
    <input placeholder="e-mail" name="email" type="text">

    <lable for="password">Password</lable>
    <input placeholder="password" name="password" type="password">

    <lable for="name">Name</lable>
    <input placeholder="name" name="name" type="text">

    <lable for="surname">Surname</lable>
    <input placeholder="surname" name="surname" type="text">

    <lable for="phone">Phone</lable>
    <input placeholder="+38(011)-111-11-11" name="phone" type="text">

    <input type="hidden" id="role" name="roleId" value="2">
    <br>
    <input id="submit-btn" type="submit" value="submit">
    <a href="Login">Back</a>

    <div>${errorMessage}</div>
</form>
</body>
</html>