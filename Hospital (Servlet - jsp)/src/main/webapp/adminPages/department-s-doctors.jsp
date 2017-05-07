<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 23.01.2017
  Time: 19:44
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

    <title>Show all doctors and nurse from department</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div class="doctors-selection-lable">
    <fmt:message key="departmentsdoctor.DOCTORS"/>
</div>

<div class="show-all-doctors">
    <table class="table table-striped table table-hover" id="myTable">
        <thead>
        <tr>
            <th><fmt:message key="departmentsdoctor.Photo"/></th>
            <th><fmt:message key="departmentsdoctor.Name"/></th>
            <th><fmt:message key="departmentsdoctor.Surname"/></th>
            <th><fmt:message key="departmentsdoctor.Speciality"/></th>
            <th><fmt:message key="departmentsdoctor.Department"/></th>
            <th><fmt:message key="departmentsdoctor.Moreinfo"/></th>
            <th><fmt:message key="departmentsdoctor.Assignpatient"/></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${doctorList}" var="doctor">
            <tr>
                <td>
                    <img src="${doctor.photo}" class="img-rounded" style="width: 50px; height: 50px;">
                </td>
                <td>${doctor.name}</td>
                <td>${doctor.surname}</td>
                <td>${doctor.specialty}</td>
                <td>${doctor.department}</td>
                <td>
                    <form action="ShowDoctor" method="get">
                        <input type="hidden" name="doctorId" value="${doctor.doctorId}">
                        <button class="btn btn-info" type="submit"><fmt:message
                                key="departmentsdoctor.Moreinfo"/></button>
                    </form>
                </td>
                <td>
                    <form action="AddDoctorAndPatient" method="post">
                        <input type="hidden" name="doctorId" value="${doctor.doctorId}">
                        <button class="btn btn-success" type="submit"><fmt:message
                                key="departmentsdoctor.Choosepatient"/></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br>

<div class="doctors-selection-lable" style="padding-top: 25px;">
    <fmt:message key="departmentsdoctor.NURSES"/>
</div>
<div class="show-all-doctors">
    <table class="table table-striped table table-hover">
        <thead>
        <tr>
            <th><fmt:message key="departmentsdoctor.Photo"/></th>
            <th><fmt:message key="departmentsdoctor.Name"/></th>
            <th><fmt:message key="departmentsdoctor.Surname"/></th>
            <th><fmt:message key="departmentsdoctor.Speciality"/></th>
            <th><fmt:message key="departmentsdoctor.Department"/></th>
            <th><fmt:message key="departmentsdoctor.Moreinfo"/></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${nurseList}" var="nurse">
            <tr>
                <td>
                    <img src="${nurse.photo}" class="img-rounded" style="width: 50px; height: 50px;">
                </td>
                <td>${nurse.name}</td>
                <td>${nurse.surname}</td>
                <td>${nurse.specialty}</td>
                <td>${nurse.department}</td>
                <td>
                    <form action="ShowNurse" method="get">
                        <input type="hidden" name="nurseId" value="${nurse.nurseId}">
                        <button class="btn btn-info" type="submit"><fmt:message
                                key="departmentsdoctor.Moreinfo"/></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>