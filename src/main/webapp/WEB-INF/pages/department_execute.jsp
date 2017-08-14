<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.07.17
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/css/main.css"/>

    <title>Department Execute</title>
    <script src="<c:url value="/js/lib/jquery-3.2.0.js"/>"></script>
</head>
<body>
<%@include file="/include/main.jsp" %>
<div id="app">
</div>

<div id="container">
    <input name="departmentId" type="hidden" id="departmentId"
           value="<c:out value="${param.departmentId == null ? department.id : param.departmentId}"/>"/>
    <div>
        <label class="label-create-department" for="name">Name</label>
        <div>
            <input id="name" placeholder="Management"
                   name="name" type="text"
                   value="<c:out value="${param.name == null ? department.name : param.name}"/>"/>
        </div>
    </div>

    <button class="button-create-department" onclick="departmentExecute()">Execute</button>
</div>
</body>
</html>
