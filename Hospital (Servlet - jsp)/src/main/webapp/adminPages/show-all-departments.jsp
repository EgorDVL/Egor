<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 12.01.2017
  Time: 23:22
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

    <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="bootstrap/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/jquery.tablesorter.js"></script>
    <script type="text/javascript" src="bootstrap/js/sort-runner.js"></script>

    <title>Show all departments</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div class="doctors-selection-lable">
    <fmt:message key="showalldepartments.ALLDEPARTMENTS"/>
</div>

<div class="show-all-doctors" style="padding-left: 45px;">
    <table class="table table-striped table table-hover" id="myTable">
        <thead>
        <tr>
            <th><fmt:message key="showalldepartments.Department"/></th>
            <th><fmt:message key="showalldepartments.Name"/></th>
            <th><fmt:message key="showalldepartments.Showallworkers"/></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${departmentList}" var="departments">
            <tr>
                <td>${departments.departmentId}</td>
                <td>${departments.departmentEnum}</td>
                <td>
                    <form action="ShowAllDepartments" method="post">
                        <input type="hidden" name="departmentId" value="${departments.departmentId}">
                        <button class="btn btn-info" type="submit">
                            <fmt:message key="showalldepartments.Showalldoctorsandnurses"/></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
