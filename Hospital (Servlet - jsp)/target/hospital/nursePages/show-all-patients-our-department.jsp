<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 20.01.2017
  Time: 15:34
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

    <title>Show all patients oyr department</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div class="doctors-selection-lable">
    ALL PATIENTS OUR DEPARTMENT
</div>

<div id="login-error-message" style=" margin-left: 720px;"><span class="label label-important">${errorMessage}</span>
</div>


<div class="show-all-doctors">
    <table class="table table-striped table table-hover" id="myTable">
        <thead>
        <tr>
            <th>Photo</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Status</th>
            <th>More info</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${patientList}" var="patients">
            <tr>
                <td>
                    <img src="${patients.photo}" class="img-rounded" style="width: 50px; height: 50px;">
                </td>
                <td>${patients.name}</td>
                <td>${patients.surname}</td>
                <td>${patients.patientStatus}</td>
                <td>
                    <form action="ShowPatient" method="post">
                        <input type="hidden" name="patientId" value="${patients.patientId}">
                        <button class="btn btn-info" type="submit">More info</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
