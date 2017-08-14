<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04.07.17
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/css/main.css"/>

    <title>Show all departments</title>
    <script src="<c:url value="/js/lib/jquery-3.2.0.js"/>"></script>

</head>
<body>

<%@include file="/include/main.jsp" %>


<%--<div id="show-all-departments">--%>
<%--<table class="table table-hover">--%>
<%--<thead>--%>
<%--<tr>--%>
<%--<th>ID</th>--%>
<%--<th>Name</th>--%>
<%--<th>Employees</th>--%>
<%--<th>Update</th>--%>
<%--<th>Delete</th>--%>
<%--</tr>--%>
<%--</thead>--%>

<%--<tbody>--%>

<%--<c:forEach items="${departmentList}" var="departments">--%>
<%--<tr>--%>
<%--<td>${departments.id}</td>--%>
<%--<td>${departments.name}</td>--%>
<%--<td>--%>
<%--<a href="/employee/allDepartmentEmployees?departmentId=${departments.id}">--%>
<%--<input type="button" value="Employees"/>--%>
<%--</a>--%>
<%--</td>--%>
<%--<td>--%>
<%--<a href="/department/departmentExecutePage?departmentId=${departments.id}">--%>
<%--<input type="button" value="Update"/>--%>
<%--</a>--%>
<%--</td>--%>
<%--<td>--%>
<%--<form action="/department/delete" method="post">--%>
<%--<input type="hidden" name="departmentId" value="${departments.id}">--%>
<%--<button type="submit">Delete</button>--%>
<%--</form>--%>
<%--</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</tbody>--%>
<%--</table>--%>
<%--</div>--%>

</body>
</html>
