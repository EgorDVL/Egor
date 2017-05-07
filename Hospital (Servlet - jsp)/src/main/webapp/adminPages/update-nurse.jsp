<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 02.02.2017
  Time: 13:10
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

    <title>Update nurse</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>


<div id="search-patient-container" style="width: 600px;">
    <form class="form-horizontal" action="UpdateNurse" method="post" id="updateDoctorValidator" id="login-form">

        <input name="nurseId" type="hidden" value="${nurse.nurseId}">

        <div class="control-group">
            <lable class="control-label" for="name"><fmt:message key="updatenurse.Name"/></lable>
            <div class="controls">
                <input placeholder="Vasua" name="name" type="text" style="height: 30px;" value="${nurse.name}">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="surname"><fmt:message key="updatenurse.Surname"/></lable>
            <div class="controls">
                <input placeholder="Pupkin" name="surname" type="text" style="height: 30px;" value="${nurse.surname}">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="phone"><fmt:message key="updatenurse.Phone"/></lable>
            <div class="controls">
                <input placeholder="38(050)-111-11-11" name="phone" type="text" style="height: 30px;"
                       value="${nurse.phone}" minlength="12" maxlength="12">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="specialty"><fmt:message key="updatenurse.Specialty"/></lable>
            <div class="controls">
                <input placeholder="Therapist" name="specialty" type="text" style="height: 30px;"
                       value="${nurse.specialty}">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="experience"><fmt:message key="updatenurse.Experience"/></lable>
            <div class="controls">
                <input placeholder="5" name="experience" type="number" style="height: 30px;"
                       value="${nurse.experience}">
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn btn-success" type="submit" style="margin-left: -46px;">
                            <fmt:message key="updatenurse.UpdateNur"/>
                        </button>
                    </div>


                    <div id="login-error-message"><span class="label label-important"
                                                        style="margin-left: -42px;">${errorMessage}</span></div>
                    <div id="login-successful-message"><span
                            class="label label-success" style="margin-left: -42px;">${successfulMessage}</span></div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
