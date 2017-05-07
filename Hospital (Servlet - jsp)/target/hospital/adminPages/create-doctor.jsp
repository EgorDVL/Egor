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
    <script type="text/javascript" src="bootstrap/js/createdoctor.validator.js"></script>

    <title>Create doctor</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>


<div id="search-patient-container" style="width: 600px;">
    <form class="form-horizontal" action="CreateDoctor" method="post" id="createDoctorValidator" id="login-form">
        <div class="control-group">
            <lable class="control-label" for="name"><fmt:message key="createdoctor.Name"/></lable>
            <div class="controls">
                <input placeholder="Vasua" name="name" type="text" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="surname"><fmt:message key="createdoctor.Surname"/></lable>
            <div class="controls">
                <input placeholder="Pupkin" name="surname" type="text" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="phone"><fmt:message key="createdoctor.Phone"/></lable>
            <div class="controls">
                <input placeholder="38(050)-111-11-11" name="phone" type="text" style="height: 30px;" minlength="12"
                       maxlength="12">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="dateOfBirth"><fmt:message key="createdoctor.Dateofbirth"/></lable>
            <div class="controls">
                <input placeholder="1993-03-23" name="dateOfBirth" type="date" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="specialty"><fmt:message key="createdoctor.Specialty"/></lable>
            <div class="controls">
                <input placeholder="Therapist" name="specialty" type="text" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="experience"><fmt:message key="createdoctor.Experience"/></lable>
            <div class="controls">
                <input placeholder="5" name="experience" type="number" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="department"><fmt:message key="createdoctor.Department"/></lable>
            <div class="controls">
                <select name="department" style="width: 206px;">
                    <option value="THERAPY"><fmt:message key="createdoctor.THERAPY"/></option>
                    <option value="SURGERY"><fmt:message key="createdoctor.SURGERY"/></option>
                    <option value="TRAUMATOLOGY"><fmt:message key="createdoctor.TRAUMATOLOGY"/></option>
                    <option value="STOMATOLOGY"><fmt:message key="createdoctor.STOMATOLOGY"/></option>
                    <option value="PEDIATRICS"><fmt:message key="createdoctor.PEDIATRICS"/></option>
                    <option value="OPHTHALMOLOGY"><fmt:message key="createdoctor.OPHTHALMOLOGY"/></option>
                    <option value="NEUROLOGY"><fmt:message key="createdoctor.NEUROLOGY"/></option>
                    <option value="CARDIOLOGY"><fmt:message key="createdoctor.CARDIOLOGY"/></option>
                    <option value="GYNECOLOGY"><fmt:message key="createdoctor.GYNECOLOGY"/></option>
                    <option value="VENEREOLOGY"><fmt:message key="createdoctor.VENEREOLOGY"/></option>
                    <option value="OBSTETRICS"><fmt:message key="createdoctor.OBSTETRICS"/></option>
                </select>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn btn-success" type="submit" style="margin-left: -50px;"><fmt:message
                                key="createdoctor.CreateDoctor"/>
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
