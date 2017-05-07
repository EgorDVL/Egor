<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 26.02.2017
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
Role- ${role}
<h3>Show All users</h3>
<%--<li><a href="ShowAllUsers">Show all users</a></li>--%>
<li><a href="useradmin/ShowAllUsers">Show all users</a></li>
<br>

<h3>Create users</h3>
<%--<li><a href="CreateUserPage">Create user</a></li>--%>
<li><a href="admin/CreateUserPage">Create user</a></li>
<br>
<br>

<h3>Show all groupps</h3>
<%--<li><a href="ShowAllGroups">Show all groupps</a></li>--%>
<li><a href="useradmin/ShowAllGroups">Show all groups</a></li>
<br>

<h3>Create groupDto</h3>
<%--<li><a href="CreateGroupPage">Create groupDto</a></li>--%>
<li><a href="admin/CreateGroupPage">Create group</a></li>
<br>

<h3>Login</h3>
<li><a href="login">Login</a></li>
<br>


<c:url value="j_spring_security_logout" var="logoutUrl"/>
<form action="${logoutUrl}"
      method="post">
    <input type="submit"
           value="Log out"/>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
</body>
</html>
