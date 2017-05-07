<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 25.01.2017
  Time: 17:24
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
    <script type="text/javascript" src="bootstrap/js/updatesymptom.validator.js"></script>

    <title>Update symptoms</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>


<div id="search-patient-container" style="width: 650px;">
    <form class="form-horizontal" action="UpdateSymptoms" method="post" id="updateSymptomValidate" id="login-form">
        <input name="healingId" type="hidden" value="${healing.healingId}">

        <div class="control-group">
            <lable class="control-label" for="symptoms">Symptoms</lable>
            <div class="controls">
                <input placeholder="Chills" name="symptoms" type="text" value="${healing.symptoms}"
                       style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn btn-warning" type="submit" style="margin-left: -77px;">Update Symptoms
                        </button>
                    </div>


                    <div id="login-error-message"><span class="label label-important"
                                                        style="margin-left: -57px;">${errorMessage}</span></div>
                    <div id="login-successful-message"><span
                            class="label label-success" style="margin-left: -57px;">${successfulMessage}</span></div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
