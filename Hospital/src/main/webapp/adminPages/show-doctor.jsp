<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 09.01.2017
  Time: 19:32
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

    <title>Show doctor</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div id="show-doctor-main-body">
    <div class="user-info">
        <div class="user-show-left">
            <div class="user-image">
                <img src="${doctor.photo}" class="img-rounded" style="width: 400px; height: 400px;">
            </div>
        </div>

        <div class="user-show-right">
            <div class="user-description">
                <span><fmt:message key="showdoctor.Name"/> : </span>
                <b>${doctor.name}</b>
                <br>
                <span><fmt:message key="showdoctor.Surname"/> : </span>
                <b>${doctor.surname}</b>
                <br>
                <span><fmt:message key="showdoctor.Dateofbirth"/> : </span>
                <b>${doctor.dateOfBirth}</b>
                <br>
                <span><fmt:message key="showdoctor.Phone"/> : </span>
                <b>${doctor.phone}</b>
            </div>

            <div class="user-show-patients">
                <form action="DoctorsPatients" method="get">
                    <input type="hidden" name="doctorId" value="${doctor.doctorId}">
                    <button class="btn btn-info" type="submit"><fmt:message
                            key="showdoctor.ShowDoctorpatients"/></button>
                </form>
            </div>
            <br>

            <div class="user-show-patients">
                <c:if test="${sessionScope.user.userRole eq 'ADMIN'}">
                    <input class="btn btn-warning" type="button"
                           value="<fmt:message key="showdoctor.Updatedoctor"/>" style="width:111px;"
                           onClick='location.href="UpdateDoctor?doctorId=${doctor.doctorId}"'>
                </c:if>
            </div>
            <br>

            <div class="user-show-patients">
                <c:if test="${sessionScope.user.userRole eq 'ADMIN'}">
                    <input class="btn btn-danger" type="button"
                           value="<fmt:message key="showdoctor.Deletedoctor"/>"
                           onClick='location.href="DeleteDoctor?doctorId=${doctor.doctorId}"'>
                </c:if>
            </div>
            <br>
            <br>

            <div class="user-show-patients">
                <form action="TransferDoctorDepartment" method="get">
                    <input type="hidden" name="doctorId" value="${doctor.doctorId}">

                    <button class="btn btn-warning" type="submit"><fmt:message
                            key="showdoctor.Transfertoanotherdepartment"/></button>
                    <br>
                    <select name="department" class="form-control" style="width: 226px;">
                        <c:forEach items="${departments}" var="dep">
                            <c:choose>
                                <c:when test="${dep.departmentEnum eq doctor.department}">
                                    <option value="${dep.departmentEnum}" selected>${dep.departmentEnum}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${dep.departmentEnum}">${dep.departmentEnum}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </form>
            </div>
        </div>
    </div>

    <div class="user-show-tab-header">
        <fmt:message key="showdoctor.allinfo"/>
    </div>

    <table class="table table-striped" id="user-show-tab-attribute">
        <thead>
        <tr>
            <th colspan="2" style="text-align: center"><fmt:message key="showdoctor.Aboutdoctor"/></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="showdoctor.Name"/></td>
            <td style="width: 50%;text-align: center">${doctor.name}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="showdoctor.Surname"/></td>
            <td style="width: 50%;text-align: center">${doctor.surname}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="showdoctor.Dateofbirth"/></td>
            <td style="width: 50%;text-align: center">${doctor.dateOfBirth}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="showdoctor.Phone"/></td>
            <td style="width: 50%;text-align: center">${doctor.phone}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center">E-mail</td>
            <td style="width: 50%;text-align: center">${user.email}</td>
        </tr>
        </tbody>

        <thead>
        <tr>
            <th colspan="2" style="text-align: center"><fmt:message key="showdoctor.Speciality"/></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="showdoctor.Speciality"/></td>
            <td style="width: 50%;text-align: center">${doctor.specialty}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="showdoctor.Department"/></td>
            <td style="width: 50%;text-align: center">${doctor.department}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="showdoctor.Experience"/></td>
            <td style="width: 50%;text-align: center">${doctor.experience} - year</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
