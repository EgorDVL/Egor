<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 07.10.2016
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>Login page</title>
</head>
<body>
<form action="Login" method="post">
    <lable for="email">E-mail</lable>
    <input placeholder="e-mail" name="email" type="text">

    <lable for="password">Password</lable>
    <input placeholder="password" name="password" type="password">
    <br>
    <input id="submit-btn" type="submit" value="submit">

    <input class="btn" type="button" value="Registration" onClick='location.href="Registration"'>

    <div>${errorMessage}</div>
</form>
</body>
</html>
