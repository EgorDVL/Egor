<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 16.01.2017
  Time: 18:11
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
    <script type="text/javascript" src="bootstrap/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/createappointmment.validator.js"></script>

    <title>Create Appointment</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>


<div id="search-patient-container" style="width: 650px;">
    <form class="form-horizontal" action="CreateAppointment" method="get" id="createAppointmentValidator"
          id="login-form" style="margin-top: -60px;">
        <div class="control-group">
            <lable class="control-label" for="name">Appointment name</lable>
            <div class="controls">
                <input placeholder="Appointment name" name="name" type="text" style="height: 30px;">
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn btn-success" type="submit" style="margin-left: -78px;">Create Appointment
                        </button>
                    </div>


                    <div id="login-error-message"><span class="label label-important"
                                                        style="margin-left: -47px;">${errorMessage}</span></div>
                    <div id="login-successful-message"><span
                            class="label label-success" style="margin-left: -47px;">${successfulMessage}</span></div>
                </div>
            </div>
        </div>
    </form>
</div>
<br>

<div class="user-show-tab-header" style="margin-left: 391px; padding-top: 20px;">
    ADD APPOINTMENT
</div>


<table class="table table-striped" id="user-show-tab-attribute" style="margin-left: 458px;">
    <thead>
    <tr>
        <th colspan="2" style="text-align: center">Operation</th>
    </tr>
    </thead>
    <tbody>
    <%--Create operation--%>
    <tr>
        <td></td>
        <td style="width: 50%;text-align: center">
            <input class="btn btn-success" type="button"
                   value="Add operation" style="width: 133px;"
                   onClick='location.href="CreateOperation"'>
        </td>
    </tr>
    <c:if test="${operation != null}">
        <tr>
            <td style="width: 50%;text-align: center">Operation name</td>
            <td style="width: 50%;text-align: center">${operation.nameOperation}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center">Date operation</td>
            <td style="width: 50%;text-align: center">${operation.dateOperation}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center">Complexity</td>
            <td style="width: 50%;text-align: center">${operation.complexityEnum}</td>
        </tr>
    </c:if>
    </tbody>

    <thead>
    <tr>
        <th colspan="2" style="text-align: center">Medicament</th>
    </tr>
    </thead>
    <tbody>
    <%--Create medicament--%>
    <tr>
        <td></td>
        <td style="width: 50%;text-align: center">
            <input class="btn btn-success" type="button"
                   value="Add medicament"
                   onClick='location.href="CreateMedicament"'>
        </td>
    </tr>

    <c:if test="${medicament != null}">
        <tr>
            <td style="width: 50%;text-align: center">Medicament name</td>
            <td style="width: 50%;text-align: center">${medicament.nameMedicament}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center">Type</td>
            <td style="width: 50%;text-align: center">${medicament.medicamentEnum}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center">Use</td>
            <td style="width: 50%;text-align: center">${medicament.useMedicament}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center">Date medicament start</td>
            <td style="width: 50%;text-align: center">${medicament.dateStartMedicament}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center">Date medicament end</td>
            <td style="width: 50%;text-align: center">${medicament.dateEndMedicament}</td>
        </tr>
    </c:if>
    </tbody>

    <thead>
    <tr>
        <th colspan="2" style="text-align: center">Procedure</th>
    </tr>
    </thead>
    <tbody>
    <%--Create procedures--%>
    <tr>
        <td></td>
        <td style="width: 50%;text-align: center">
            <input class="btn btn-success" type="button"
                   value="Add procedures" style="width: 133px;"
                   onClick='location.href="CreateProcedures"'>
        </td>
    </tr>
    <c:if test="${procedures != null}">
        <tr>
            <td style="width: 50%;text-align: center">Procedures name</td>
            <td style="width: 50%;text-align: center">${procedures.nameProcedure}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center">Use</td>
            <td style="width: 50%;text-align: center">${procedures.useProcedure}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center">Date procedures start</td>
            <td style="width: 50%;text-align: center">${procedures.dateStartProcedure}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center">Date procedures end</td>
            <td style="width: 50%;text-align: center">${procedures.dateEndProcedure}</td>
        </tr>
    </c:if>
    </tbody>
</table>
</body>
</html>
