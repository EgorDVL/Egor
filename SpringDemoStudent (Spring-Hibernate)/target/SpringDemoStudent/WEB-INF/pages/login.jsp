<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 27.03.2017
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="<c:url value='j_spring_security_check'/>" method="POST">
    <c:if test="${param.error != null}">
        <p>
            Invalid username and password.
        </p>
    </c:if>
    <c:if test="${param.logout != null}">
        <p>
            You have been logged out.
        </p>
    </c:if>
    <label for="email">Email</label>
    <input id="email" name="email">
    <br>
    <label for="password">Password</label>
    <input id="password" type="password" name="password">
    <br>
    <label for="remember">Remember me</label>
    <input id="remember" type="checkbox" name="remember-me" value="true">
    <br>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <input type="submit">
</form>
</body>
</html>
