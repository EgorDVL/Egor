<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 18.01.2017
  Time: 1:38
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
    <script type="text/javascript" src="bootstrap/js/updateprocedures.validator.js"></script>

    <title>Update procedures</title>
</head>
<body>

<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>


<div id="search-patient-container" style="width: 650px;">
    <form class="form-horizontal" action="UpdateProcedures" method="post" id="updateProcedureValidate" id="login-form">

        <input type="hidden" name="proceduresId" value="${procedures.proceduresId}">

        <div class="control-group">
            <lable class="control-label" for="name">Procedures</lable>
            <div class="controls">
                <input placeholder="Massage" name="name" type="text" value="${procedures.nameProcedure}"
                       style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="use">Use</lable>
            <div class="controls">
                <input placeholder="1 times a day" name="use" type="text" value="${procedures.useProcedure}"
                       style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="dateStart">Date start</lable>
            <div class="controls">
                <input placeholder="20-01-2017" name="dateStart" type="date" value="${procedures.dateStartProcedure}"
                       style="height: 30px;">
            </div>
        </div>
        <div class="control-group">
            <lable class="control-label" for="dateEnd">Date end</lable>
            <div class="controls">
                <input placeholder="25-01-2017" name="dateEnd" type="date" value="${procedures.dateEndProcedure}"
                       style="height: 30px;">
            </div>
        </div>

        <input name="procedureStatus" type="hidden" value="NOT_DONE">

        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn btn-warning" type="submit" style="margin-left: -45px;">Update
                        </button>
                    </div>


                    <div id="login-error-message"><span class="label label-important"
                                                        style="margin-left: -37px;">${errorMessage}</span></div>
                    <div id="login-successful-message"><span
                            class="label label-success" style="margin-left: -37px;">${successfulMessage}</span></div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
