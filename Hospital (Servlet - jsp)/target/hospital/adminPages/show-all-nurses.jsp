<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 11.01.2017
  Time: 21:18
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

    <title>Show all Nurses</title>
</head>
<body>

<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div class="doctors-selection-lable">
    <fmt:message key="showallnurses.ALLNURSE"/>
</div>


<div class="show-all-doctors">
    <table class="table table-striped table table-hover" id="myTable">
        <thead>
        <tr>
            <th><fmt:message key="showallnurses.Photo"/></th>
            <th><fmt:message key="showallnurses.Name"/></th>
            <th><fmt:message key="showallnurses.Surname"/></th>
            <th><fmt:message key="showallnurses.Speciality"/></th>
            <th><fmt:message key="showallnurses.Department"/></th>
            <th><fmt:message key="showallnurses.Moreinfo"/></th>
        </tr>
        </thead>

        <tbody>

        <c:forEach items="${nurseList}" var="nurses">
            <tr>
                <td>
                    <img src="${nurses.photo}" class="img-rounded" style="width: 50px; height: 50px;">
                </td>
                <td>${nurses.name}</td>
                <td>${nurses.surname}</td>
                <td>${nurses.specialty}</td>
                <td>${nurses.department}</td>
                <td>
                    <form action="ShowNurse" method="get">
                        <input type="hidden" name="nurseId" value="${nurses.nurseId}">
                        <button class="btn btn-info" type="submit"><fmt:message key="showallnurses.Moreinfo"/>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
