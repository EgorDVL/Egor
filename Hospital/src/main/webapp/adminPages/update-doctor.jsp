<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 02.02.2017
  Time: 12:49
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
    <script type="text/javascript" src="bootstrap/js/updatedoctor.validator.js"></script>

    <title>Update doctor</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>


<div id="search-patient-container" style="width: 600px;">
    <form class="form-horizontal" action="UpdateDoctor" method="post" id="updateDoctorValidator" id="login-form">
        <input name="doctorId" type="hidden" value="${doctor.doctorId}">

        <div class="control-group">
            <lable class="control-label" for="name"><fmt:message key="updatedoctor.Name"/></lable>
            <div class="controls">
                <input placeholder="Vasua" name="name" type="text" style="height: 30px;" value="${doctor.name}">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="surname"><fmt:message key="updatedoctor.Surname"/></lable>
            <div class="controls">
                <input placeholder="Pupkin" name="surname" type="text" style="height: 30px;" value="${doctor.surname}">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="phone"><fmt:message key="updatedoctor.Phone"/></lable>
            <div class="controls">
                <input placeholder="38(050)-111-11-11" name="phone" type="text" style="height: 30px;"
                       value="${doctor.phone}" minlength="12" maxlength="12">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="specialty"><fmt:message key="updatedoctor.Specialty"/></lable>
            <div class="controls">
                <input placeholder="Therapist" name="specialty" type="text" style="height: 30px;"
                       value="${doctor.specialty}">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="experience"><fmt:message key="updatedoctor.Experience"/></lable>
            <div class="controls">
                <input placeholder="5" name="experience" type="number" style="height: 30px;"
                       value="${doctor.experience}">
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn btn-success" type="submit" style="margin-left: -50px;">
                            <fmt:message key="updatedoctor.UpdateDoctor"/>
                        </button>
                    </div>


                    <div id="login-error-message"><span class="label label-important"
                                                        style="margin-left: -45px;">${errorMessage}</span></div>
                    <div id="login-successful-message"><span
                            class="label label-success" style="margin-left: -45px;">${successfulMessage}</span></div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
