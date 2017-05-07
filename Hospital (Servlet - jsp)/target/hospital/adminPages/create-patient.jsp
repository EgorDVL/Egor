<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 11.01.2017
  Time: 0:44
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
    <script type="text/javascript" src="bootstrap/js/createpatient.validator.js"></script>

    <title>Create Patient</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div id="search-patient-container" style="width: 600px;">
    <form class="form-horizontal" action="CreatePatient" method="post" id="createPatientValidator" id="login-form">
        <div class="control-group">
            <lable class="control-label" for="name"><fmt:message key="createpatient.Name"/></lable>
            <div class="controls">
                <input placeholder="Vasua" name="name" type="text" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="surname"><fmt:message key="createpatient.Surname"/></lable>
            <div class="controls">
                <input placeholder="Pupkin" name="surname" type="text" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="phone"><fmt:message key="createpatient.Phone"/></lable>
            <div class="controls">
                <input placeholder="38(050)-111-11-11" name="phone" type="text" style="height: 30px;" minlength="12"
                       maxlength="12">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="dateOfBirth"><fmt:message key="createpatient.Dateofbirth"/></lable>
            <div class="controls">
                <input placeholder="1993-03-23" name="dateOfBirth" type="date" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="address"><fmt:message key="createpatient.Address"/></lable>
            <div class="controls">
                <input placeholder="Naukova st. h.12, f.102" name="address" type="text" style="height: 30px;">
            </div>
        </div>

        <input type="hidden" name="patientStatus" value="NOT_TREATED">

        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn btn-success" type="submit" style="margin-left: -54px;">
                            <fmt:message key="createpatient.CreatePatient"/>
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
