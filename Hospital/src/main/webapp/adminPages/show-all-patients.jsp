<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 10.01.2017
  Time: 17:49
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

    <title>Show all patients</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div class="doctors-selection-lable">
    <fmt:message key="showallpatients.ALLPATIENTS"/>
</div>
<div id="login-error-message" style=" margin-left: 727px;"><span class="label label-important">${errorMessage}</span>
</div>

<form class="form-horizontal" action="GroupPatientByStatus" method="get">
    <div class="control-group">
        <div class="controls">
            <div class="sort-value">
                <select name="status" style="margin-left: 20px; width: 150px;">
                    <c:choose>
                        <c:when test="${status eq 'ALL'}">
                            <option value="ALL" selected><fmt:message key="showallpatients.ALL"/></option>
                            <option value="NOT_TREATED"><fmt:message key="showallpatients.NOTTREATED"/></option>
                            <option value="TREATED"><fmt:message key="showallpatients.TREATED"/></option>
                            <option value="DISCHARGE"><fmt:message key="showallpatients.DISCHARGE"/></option>
                        </c:when>
                        <c:when test="${status eq 'NOT_TREATED'}">
                            <option value="NOT_TREATED" selected><fmt:message
                                    key="showallpatients.NOTTREATED"/></option>
                            <option value="TREATED"><fmt:message key="showallpatients.TREATED"/></option>
                            <option value="DISCHARGE"><fmt:message key="showallpatients.DISCHARGE"/></option>
                            <option value="ALL"><fmt:message key="showallpatients.ALL"/></option>
                        </c:when>
                        <c:when test="${status eq 'TREATED'}">
                            <option value="TREATED" selected><fmt:message key="showallpatients.TREATED"/></option>
                            <option value="DISCHARGE"><fmt:message key="showallpatients.DISCHARGE"/></option>
                            <option value="ALL"><fmt:message key="showallpatients.ALL"/></option>
                            <option value="NOT_TREATED"><fmt:message key="showallpatients.NOTTREATED"/></option>
                        </c:when>
                        <c:when test="${status eq 'DISCHARGE'}">
                            <option value="DISCHARGE" selected><fmt:message key="showallpatients.DISCHARGE"/></option>
                            <option value="ALL"><fmt:message key="showallpatients.ALL"/></option>
                            <option value="NOT_TREATED"><fmt:message key="showallpatients.NOTTREATED"/></option>
                            <option value="TREATED"><fmt:message key="showallpatients.TREATED"/></option>
                        </c:when>
                        <c:otherwise>
                            <option value="ALL"><fmt:message key="showallpatients.ALL"/></option>
                            <option value="NOT_TREATED"><fmt:message key="showallpatients.NOTTREATED"/></option>
                            <option value="TREATED"><fmt:message key="showallpatients.TREATED"/></option>
                            <option value="DISCHARGE"><fmt:message key="showallpatients.DISCHARGE"/></option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="sort-button" style="margin-left: 110px;">
                    <button type="submit" class="btn btn-primary"><fmt:message
                            key="showallpatients.FindPatients"/></button>
                </div>
            </div>
        </div>
    </div>
</form>


<form class="form-horizontal" action="SortPatient" method="get">
    <div class="control-group">
        <div class="controls">

            <div class="sort-value">
                <select name="sort" style="width: 150px; margin-left: 21px;">
                    <c:choose>
                        <c:when test="${sortParam eq 'name'}">
                            <option value="name" selected><fmt:message key="showallpatients.Name[A-Z]"/></option>
                            <option value="name Desc"><fmt:message key="showallpatients.Name[Z-A]"/></option>
                            <option value="surname"><fmt:message key="showallpatients.Surname[A-Z]"/></option>
                            <option value="surname Desc"><fmt:message key="showallpatients.Surname[Z-A]"/></option>
                            <option value="dateOfBirth"><fmt:message
                                    key="showallpatients.DateOfBirth[min->max]"/></option>
                            <option value="dateOfBirth Desc"><fmt:message
                                    key="showallpatients.DateOfBirth[max->min]"/></option>
                        </c:when>
                        <c:when test="${sortParam eq 'name Desc'}">
                            <option value="name Desc" selected><fmt:message key="showallpatients.Name[Z-A]"/></option>
                            <option value="surname"><fmt:message key="showallpatients.Surname[A-Z]"/></option>
                            <option value="surname Desc"><fmt:message key="showallpatients.Surname[Z-A]"/></option>
                            <option value="dateOfBirth"><fmt:message
                                    key="showallpatients.DateOfBirth[min->max]"/></option>
                            <option value="dateOfBirth Desc"><fmt:message
                                    key="showallpatients.DateOfBirth[max->min]"/></option>
                            <option value="name"><fmt:message key="showallpatients.Name[A-Z]"/></option>
                        </c:when>
                        <c:when test="${sortParam eq 'surname'}">
                            <option value="surname" selected><fmt:message key="showallpatients.Surname[A-Z]"/></option>
                            <option value="surname Desc"><fmt:message key="showallpatients.Surname[Z-A]"/></option>
                            <option value="dateOfBirth"><fmt:message
                                    key="showallpatients.DateOfBirth[min->max]"/></option>
                            <option value="dateOfBirth Desc"><fmt:message
                                    key="showallpatients.DateOfBirth[max->min]"/></option>
                            <option value="name"><fmt:message key="showallpatients.Name[A-Z]"/></option>
                            <option value="name Desc"><fmt:message key="showallpatients.Name[Z-A]"/></option>
                        </c:when>
                        <c:when test="${sortParam eq 'surname Desc'}">
                            <option value="surname Desc" selected><fmt:message
                                    key="showallpatients.Surname[Z-A]"/></option>
                            <option value="dateOfBirth"><fmt:message
                                    key="showallpatients.DateOfBirth[min->max]"/></option>
                            <option value="dateOfBirth Desc"><fmt:message
                                    key="showallpatients.DateOfBirth[max->min]"/></option>
                            <option value="name"><fmt:message key="showallpatients.Name[A-Z]"/></option>
                            <option value="name Desc"><fmt:message key="showallpatients.Name[Z-A]"/></option>
                            <option value="surname"><fmt:message key="showallpatients.Surname[A-Z]"/></option>
                        </c:when>
                        <c:when test="${sortParam eq 'dateOfBirth'}">
                            <option value="dateOfBirth" selected><fmt:message
                                    key="showallpatients.DateOfBirth[min->max]"/></option>
                            <option value="dateOfBirth Desc"><fmt:message
                                    key="showallpatients.DateOfBirth[max->min]"/></option>
                            <option value="name"><fmt:message key="showallpatients.Name[A-Z]"/></option>
                            <option value="name Desc"><fmt:message key="showallpatients.Name[Z-A]"/></option>
                            <option value="surname"><fmt:message key="showallpatients.Surname[A-Z]"/></option>
                            <option value="surname Desc"><fmt:message key="showallpatients.Surname[Z-A]"/></option>
                        </c:when>
                        <c:when test="${sortParam eq 'dateOfBirth Desc'}">
                            <option value="dateOfBirth Desc" selected><fmt:message
                                    key="showallpatients.DateOfBirth[min->max]"/></option>
                            <option value="name"><fmt:message key="showallpatients.Name[A-Z]"/></option>
                            <option value="name Desc"><fmt:message key="showallpatients.Name[Z-A]"/></option>
                            <option value="surname"><fmt:message key="showallpatients.Surname[A-Z]"/></option>
                            <option value="surname Desc"><fmt:message key="showallpatients.Surname[Z-A]"/></option>
                            <option value="dateOfBirth"><fmt:message
                                    key="showallpatients.DateOfBirth[max->min]"/></option>
                        </c:when>
                        <c:otherwise>
                            <option value="name"><fmt:message key="showallpatients.Name[A-Z]"/></option>
                            <option value="name Desc"><fmt:message key="showallpatients.Name[Z-A]"/></option>
                            <option value="surname"><fmt:message key="showallpatients.Surname[A-Z]"/></option>
                            <option value="surname Desc"><fmt:message key="showallpatients.Surname[Z-A]"/></option>
                            <option value="dateOfBirth"><fmt:message
                                    key="showallpatients.DateOfBirth[min->max]"/></option>
                            <option value="dateOfBirth Desc"><fmt:message
                                    key="showallpatients.DateOfBirth[max->min]"/></option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="sort-button" style=" margin-left: 110px;">
                    <button type="submit" class="btn btn-primary" style="width: 110px;"><fmt:message
                            key="showallpatients.Sort"/>
                    </button>
                </div>
            </div>
        </div>
    </div>
</form>

<div class="show-all-doctors">
    <table class="table table-striped table table-hover" id="myTable">
        <thead>
        <tr>
            <th><fmt:message key="showallpatients.Photo"/></th>
            <th><fmt:message key="showallpatients.Name"/></th>
            <th><fmt:message key="showallpatients.Surname"/></th>
            <th><fmt:message key="showallpatients.Phone"/></th>
            <th><fmt:message key="showallpatients.Dateofbirth"/></th>
            <th><fmt:message key="showallpatients.Status"/></th>
            <th><fmt:message key="showallpatients.Moreinfo"/></th>
            <th><fmt:message key="showallpatients.Assigndoctor"/></th>
            <th><fmt:message key="showallpatients.Renewpatient"/></th>
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
                <td>${patients.phone}</td>
                <td>${patients.dateOfBirth}</td>
                <td>${patients.patientStatus}</td>
                <td>
                    <form action="ShowPatient" method="post">
                        <input type="hidden" name="patientId" value="${patients.patientId}">
                        <button class="btn btn-info" type="submit"><fmt:message
                                key="showallpatients.Moreinfo"/></button>
                    </form>
                </td>
                <td><c:if test="${patients.patientStatus == 'NOT_TREATED'}">
                    <form action="AddDoctorAndPatient" method="get">
                        <input type="hidden" name="patientId" value="${patients.patientId}">
                        <button class="btn btn-success" type="submit"><fmt:message
                                key="showallpatients.Choosethedoctor"/></button>
                    </form>
                </c:if>
                </td>
                <td><c:if test="${patients.patientStatus == 'DISCHARGE'}">
                    <form action="PatientReturn" method="post">
                        <input type="hidden" name="patientId" value="${patients.patientId}">
                        <button class="btn btn-inverse" type="submit"><fmt:message
                                key="showallpatients.Renewpatient"/></button>
                    </form>
                </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
