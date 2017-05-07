<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 19.01.2017
  Time: 0:14
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
    <script type="text/javascript" src="bootstrap/js/updatehealing.validator.js"></script>

    <title>Update Healing</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>


<div id="search-patient-container" style="width: 650px;">
    <form class="form-horizontal" action="UpdateHealing" method="post" id="updateHealingValidate" id="login-form">

        <input name="healingId" type="hidden" value="${healing.healingId}">
        <input name="symptoms" type="hidden" value="${healing.symptoms}">
        <input name="dateStart" type="hidden" value="${healing.dateHealingStart}">

        <div class="control-group">
            <lable class="control-label" for="dateEnd">Date end</lable>
            <div class="controls">
                <input placeholder="25-01-2017" name="dateEnd" type="date" value="${healing.dateHealingEnd}"
                       style="height: 30px;">
            </div>
        </div>

        <input name="appointmentId" type="hidden" value="${healing.appointmentId}">
        <input name="diagnosisId" type="hidden" value="${healing.diagnosisId}">
        <input name="hospitalCardId" type="hidden" value="${healing.hospitalCardId}">

        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn btn-warning" type="submit" style="margin-left: -67px;">Update healing
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
</body>
</html>