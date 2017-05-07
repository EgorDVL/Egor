<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 10.01.2017
  Time: 17:59
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

    <title>Show Patient</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div id="show-doctor-main-body">
    <div class="user-info">
        <div class="user-show-left">
            <div class="user-image">
                <img src="${patient.photo}" class="img-rounded" style="width: 400px; height: 400px;">
            </div>
        </div>

        <div class="user-show-right">
            <div class="user-description">
                <span><fmt:message key="showpatient.Name"/> : </span>
                <b>${patient.name}</b>
                <br>
                <span><fmt:message key="showpatient.Surname"/> : </span>
                <b>${patient.surname}</b>
                <br>
                <span><fmt:message key="showpatient.Dateofbirth"/> : </span>
                <b>${patient.dateOfBirth}</b>
                <br>
                <span><fmt:message key="showpatient.Phone"/> : </span>
                <b>${patient.phone}</b>
            </div>

            <div class="user-show-patients">
                <form action="MedicalHistoryPatient" method="get">
                    <input type="hidden" name="hospitalCardId" value="${hospitalCard.hospitalCardId}">
                    <button class="btn btn-info" type="submit"><fmt:message key="showpatient.Medicalhistory"/></button>
                </form>
            </div>
            <br>

            <div class="user-show-patients">
                <c:if test="${sessionScope.user.userRole eq 'ADMIN'}">
                    <input class="btn btn-warning" style="width: 121px;" type="button"
                           value="<fmt:message key="showpatient.Updatepatient"/>"
                           onClick='location.href="UpdatePatient?patientId=${patient.patientId}"'>
                </c:if>
            </div>
            <br>

            <div class="user-show-patients">
                <c:if test="${sessionScope.user.userRole eq 'ADMIN'}">
                    <input class="btn btn-danger" style="width: 121px;" type="button"
                           value="<fmt:message key="showpatient.Deletepatient"/>"
                           onClick='location.href="DeletePatient?patientId=${patient.patientId}"'>
                </c:if>
            </div>
            <br>

            <div class="user-show-patients">
                <c:if test="${sessionScope.user.userRole eq 'DOCTOR' or 'NURSE'}">
                    <input class="btn btn-primary" type="button"
                           value="<fmt:message key="showpatient.Showjournalactivity"/>"
                           onClick='location.href="ShowJournalPatient?patientId=${patient.patientId}"'>
                </c:if>
            </div>
            <br>

            <div class="user-show-patients">
                <c:if test="${sessionScope.user.userRole eq 'DOCTOR' and patient.patientStatus ne 'DISCHARGE'}">
                    <input class="btn btn-success" style="width: 155px;" type="button"
                           value="<fmt:message key="showpatient.Releasepatient"/>"
                           onClick='location.href="ReleasePatient?patientId=${patient.patientId}"'>
                </c:if>
            </div>
        </div>
    </div>

    <div class="user-show-tab-header">
        <fmt:message key="showdoctor.allinfo"/>
    </div>

    <table class="table table-striped" id="user-show-tab-attribute">
        <thead>
        <tr>
            <th colspan="2" style="text-align: center"><fmt:message key="showpatient.Aboutpatient"/></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="showpatient.Name"/></td>
            <td style="width: 50%;text-align: center">${patient.name}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="showpatient.Surname"/></td>
            <td style="width: 50%;text-align: center">${patient.surname}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="showpatient.Dateofbirth"/></td>
            <td style="width: 50%;text-align: center">${patient.dateOfBirth}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="showpatient.Phone"/></td>
            <td style="width: 50%;text-align: center">${patient.phone}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="showpatient.Address"/></td>
            <td style="width: 50%;text-align: center">${patient.address}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center">E-mail</td>
            <td style="width: 50%;text-align: center">${user.email}</td>
        </tr>
        </tbody>

        <thead>
        <tr>
            <th colspan="2" style="text-align: center"><fmt:message key="showpatient.Healing"/></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="showpatient.Status"/></td>
            <td style="width: 50%;text-align: center">${patient.patientStatus}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="showpatient.HospitalCard"/></td>
            <td style="width: 50%;text-align: center">${hospitalCard.hospitalCardId}</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>