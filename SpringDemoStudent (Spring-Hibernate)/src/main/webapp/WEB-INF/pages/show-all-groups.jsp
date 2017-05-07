<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 27.02.2017
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Show all groups</title>
</head>
<body>
<c:forEach items="${groupps}" var="groupp">
    <tr>
        <td>Id - ${groupp.id}</td>
        <br>
        <td>Name- ${groupp.name}</td>
        <br>
        <td>Count students - ${groupp.countStudents}</td>
        <br>
    </tr>
    </form>
    <form action="/GetGroup" method="get">
        <input type="hidden" name="id" value="${groupp.id}">
        <button class="btn btn-info" type="submit">More info</button>
    </form>
    <form action="/DeleteGroup" method="post">
        <input type="hidden" name="id" value="${groupp.id}">
        <button class="btn btn-info" type="submit">Delete group</button>
    </form>
    <form action="/ShowAllUsersInGroup" method="get">
        <input type="hidden" name="groupId" value="${groupp.id}">
        <button class="btn btn-info" type="submit">Show all users in group</button>
    </form>
</c:forEach>
</body>
</html>
