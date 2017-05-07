<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 03.02.2017
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
    <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"/>
    <title>Title</title>
</head>
<body>

<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div class="doctors-selection-lable">
    <fmt:message key="showalldoctors.ALLDOCTORS"/>
</div>

<div class="show-all-doctors">
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th>Name Surname</th>
            <th>Count patient</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${doctorMap}" var="doctor">
            <tr>
                <td>${doctor.key.name} - ${doctor.key.surname}</td>
                <c:if test="${doctor.value <= 1}">
                    <td>${doctor.value} - person</td>
                </c:if>
                <c:if test="${doctor.value > 1}">
                    <td>${doctor.value} - people</td>
                </c:if>
                <td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
