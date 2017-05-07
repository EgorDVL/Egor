<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 10.01.2017
  Time: 18:40
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

    <title>Create user</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div id="search-patient-container">
    <form class="form-horizontal" action="CreateUser" method="post" id="login-form">
        <div class="control-group">
            <lable class="control-label" for="email">Email</lable>
            <div class="controls">
                <input placeholder="Lolo@gmail.com" name="email" type="text" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="password"><fmt:message key="createuser.Password"/></lable>
            <div class="controls">
                <input placeholder="*****" name="password" type="password" style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="userRole"><fmt:message key="createuser.UserRole"/></lable>
            <div class="controls">
                <select name="userRole" style="width: 206px;">
                    <option value="DOCTOR"><fmt:message key="createuser.Doctor"/></option>
                    <option value="NURSE"><fmt:message key="createuser.Nurse"/></option>
                    <option value="PATIENT"><fmt:message key="createuser.Patient"/></option>
                </select>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn btn-success" type="submit" style="margin-left: -19px;">
                            <fmt:message key="createuser.Registration"/></button>
                    </div>


                    <div id="login-error-message"><span class="label label-important"
                                                        style="margin-left: -14px;">${errorMessage}</span></div>
                    <div id="login-successful-message"><span
                            class="label label-success" style="margin-left: -14px;">${successfulMessage}</span></div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
