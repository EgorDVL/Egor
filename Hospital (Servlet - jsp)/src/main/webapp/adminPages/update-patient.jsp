<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 02.02.2017
  Time: 11:55
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
    <script type="text/javascript" src="bootstrap/js/updatepatient.validator.js"></script>

    <title>Update patient</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div id="search-patient-container" style="width: 600px;">
    <form class="form-horizontal" action="UpdatePatient" method="post" id="updatePatientValidator" id="login-form">
        <input name="patientId" type="hidden" value="${patient.patientId}">

        <div class="control-group">
            <lable class="control-label" for="name"><fmt:message key="updatepatient.Name"/></lable>
            <div class="controls">
                <input placeholder="Vasua" name="name" type="text" style="height: 30px;" value="${patient.name}">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="surname"><fmt:message key="updatepatient.Surname"/></lable>
            <div class="controls">
                <input placeholder="Pupkin" name="surname" type="text" style="height: 30px;" value="${patient.surname}">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="phone"><fmt:message key="updatepatient.Phone"/></lable>
            <div class="controls">
                <input placeholder="38(050)-111-11-11" name="phone" type="text" style="height: 30px;"
                       value="${patient.phone}" minlength="12" maxlength="12">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="address"><fmt:message key="updatepatient.Address"/></lable>
            <div class="controls">
                <input placeholder="Naukova st. h.12, f.102" name="address" type="text" style="height: 30px;"
                       value="${patient.address}">
            </div>
        </div>

        <input type="hidden" name="patientStatus" value="NOT_TREATED">

        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn btn-success" type="submit" style="margin-left: -54px;"><fmt:message
                                key="updatepatient.UpdatePatient"/>
                        </button>
                    </div>


                    <div id="login-error-message"><span class="label label-important"
                                                        style="margin-left: -48px;">${errorMessage}</span></div>
                    <div id="login-successful-message"><span
                            class="label label-success" style="margin-left: -48px;">${successfulMessage}</span></div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>