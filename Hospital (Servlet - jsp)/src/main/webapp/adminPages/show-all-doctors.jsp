<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 09.01.2017
  Time: 18:45
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

    <title>Show all doctors</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div class="doctors-selection-lable">
    <fmt:message key="showalldoctors.ALLDOCTORS"/>
</div>

<div class="show-all-doctors">
    <table class="table table-striped table-hover" id="myTable">
        <thead>
        <tr>
            <th><fmt:message key="showalldoctors.Photo"/></th>
            <th><fmt:message key="showalldoctors.Name"/></th>
            <th><fmt:message key="showalldoctors.Surname"/></th>
            <th><fmt:message key="showalldoctors.Speciality"/></th>
            <th><fmt:message key="showalldoctors.Department"/></th>
            <%--<th><fmt:message key="showalldoctors.Amountpatients"/></th>--%>
            <th><fmt:message key="showalldoctors.Moreinfo"/></th>
            <th><fmt:message key="showalldoctors.Assignpatient"/></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${doctorList}" var="doctor">
            <tr>
                <td>
                    <img src="${doctor.key.photo}" class="img-rounded" style="width: 50px; height: 50px;">
                </td>
                <td>${doctor.key.name}</td>
                <td>${doctor.key.surname}</td>
                <td>${doctor.key.specialty}</td>
                <td>${doctor.key.department}</td>
                    <%--<c:if test="${doctor.value <= 1}">--%>
                    <%--<td>${doctor.value} - person</td>--%>
                    <%--</c:if>--%>
                    <%--<c:if test="${doctor.value > 1}">--%>
                    <%--<td>${doctor.value} - people</td>--%>
                    <%--</c:if>--%>
                <td>
                    <form action="ShowDoctor" method="get">
                        <input type="hidden" name="doctorId" value="${doctor.key.doctorId}">
                        <button class="btn btn-info" type="submit"><fmt:message key="showalldoctors.Moreinfo"/></button>
                    </form>
                </td>
                <td>
                    <form action="AddDoctorAndPatient" method="post">
                        <input type="hidden" name="doctorId" value="${doctor.key.doctorId}">
                        <button class="btn btn-success" type="submit"><fmt:message
                                key="showalldoctors.Choosepatient"/></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
