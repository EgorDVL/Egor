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

    <title>Create Nurse</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>


<div id="search-patient-container" style="width: 600px;">
    <form class="form-horizontal" action="CreateNurse" method="post" id="createDoctorValidator" id="login-form">

        <div class="control-group">
            <lable class="control-label" for="name"><fmt:message key="createnurse.Name"/></lable>
            <div class="controls">
                <input placeholder="Vasua" name="name" type="text" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="surname"><fmt:message key="createnurse.Surname"/></lable>
            <div class="controls">
                <input placeholder="Pupkin" name="surname" type="text" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="phone"><fmt:message key="createnurse.Phone"/></lable>
            <div class="controls">
                <input placeholder="38(050)-111-11-11" name="phone" type="text" style="height: 30px;" minlength="12"
                       maxlength="12">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="dateOfBirth"><fmt:message key="createnurse.Dateofbirth"/></lable>
            <div class="controls">
                <input placeholder="1993-03-23" name="dateOfBirth" type="date" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="specialty"><fmt:message key="createnurse.Specialty"/></lable>
            <div class="controls">
                <input placeholder="Therapist" name="specialty" type="text" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="experience"><fmt:message key="createnurse.Experience"/></lable>
            <div class="controls">
                <input placeholder="5" name="experience" type="number" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="department"><fmt:message key="createnurse.Department"/></lable>
            <div class="controls">
                <select name="department" style="width: 206px;">
                    <option value="THERAPY"><fmt:message key="createnurse.THERAPY"/></option>
                    <option value="SURGERY"><fmt:message key="createnurse.SURGERY"/></option>
                    <option value="TRAUMATOLOGY"><fmt:message key="createnurse.TRAUMATOLOGY"/></option>
                    <option value="STOMATOLOGY"><fmt:message key="createnurse.STOMATOLOGY"/></option>
                    <option value="PEDIATRICS"><fmt:message key="createnurse.PEDIATRICS"/></option>
                    <option value="OPHTHALMOLOGY"><fmt:message key="createnurse.OPHTHALMOLOGY"/></option>
                    <option value="NEUROLOGY"><fmt:message key="createnurse.NEUROLOGY"/></option>
                    <option value="CARDIOLOGY"><fmt:message key="createnurse.CARDIOLOGY"/></option>
                    <option value="GYNECOLOGY"><fmt:message key="createnurse.GYNECOLOGY"/></option>
                    <option value="VENEREOLOGY"><fmt:message key="createnurse.VENEREOLOGY"/></option>
                    <option value="OBSTETRICS"><fmt:message key="createnurse.OBSTETRICS"/></option>
                </select>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn btn-success" type="submit" style="margin-left: -46px;">
                            <fmt:message key="createnurse.CreateNurse"/>
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
