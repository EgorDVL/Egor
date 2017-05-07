<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 23.01.2017
  Time: 22:09
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

    <title>Search patients by params</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div id="search-patient-container">
    <form class="form-horizontal" action="FindPatientByParam" method="post" id="login-form">
        <div class="control-group">
            <lable class="control-label" for="surname"><fmt:message key="searchpatientbyparam.Surname"/></lable>
            <div class="controls">
                <input placeholder="surname" name="surname" type="text" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="phone"><fmt:message key="searchpatientbyparam.Phone"/></lable>
            <div class="controls">
                <input placeholder="380501234567" name="phone" type="text" style="height: 30px;" maxlength="12"
                       minlength="12">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="dateOfBirth"><fmt:message key="searchpatientbyparam.DateOfbirth"/></lable>
            <div class="controls">
                <input placeholder="20.04.1994" name="dateOfBirth" type="date" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn btn-info" type="submit" style="margin-left: -7px;"><fmt:message
                                key="searchpatientbyparam.Search"/></button>
                    </div>


                    <div id="login-error-message"><span class="label label-important"
                                                        style="margin-left: -17px;">${errorMessage}</span></div>
                    <div id="login-successful-message"><span
                            class="label label-success" style="margin-left: -17px;">${successfulMessage}</span></div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
