<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 25.01.2017
  Time: 18:04
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

    <title>Journal patient</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div class="doctors-selection-lable">
    JOURNAL
</div>

<div class="show-all-doctors">
    <table class="table table-striped table table-hover"  id="myTable" style="margin-left: 45px;">
        <thead>
        <tr>
            <th>Date</th>
            <th>Message</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${journalList}" var="journal">
            <tr>
                <td>${journal.date}</td>
                <td>${journal.message}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
