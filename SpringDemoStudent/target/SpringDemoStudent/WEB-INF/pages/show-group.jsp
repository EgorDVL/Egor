<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 27.02.2017
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Show group</title>
</head>
<body>
<tr>
    <td>Id - ${group.id}</td>
    <br>
    <td>Name- ${group.name}</td>
    <br>
    <td>Count students - ${group.countStudents}</td>
    <br>
</tr>
<br>
<li><a href="/UpdateGroupPage?groupId=${group.id}">Update groupDto page</a></li>
</body>
</html>
