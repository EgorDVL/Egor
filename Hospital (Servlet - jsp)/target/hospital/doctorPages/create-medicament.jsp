<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 16.01.2017
  Time: 18:17
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
    <script type="text/javascript" src="bootstrap/js/createmedicament.validator.js"></script>

    <title>Create medicament</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>


<div id="search-patient-container" style="width: 650px;">
    <form class="form-horizontal" action="CreateMedicament" method="post" id="createMedicamentValidator"
          id="login-form">
        <div class="control-group">
            <lable class="control-label" for="name">Medicament</lable>
            <div class="controls">
                <input placeholder="Aspirin" name="name" type="text" style="height: 30px;">
            </div>
        </div>
        <div class="control-group">
            <lable class="control-label" for="type">Type</lable>
            <div class="controls">
                <select name="type" style="width: 206px;">
                    <option value="PILLS">PILLS</option>
                    <option value="INJECTION">INJECTION</option>
                    <option value="POWDER">POWDER</option>
                </select>
            </div>
        </div>
        <div class="control-group">
            <lable class="control-label" for="use">Use</lable>
            <div class="controls">
                <input placeholder="2 times a day" name="use" type="text" style="height: 30px;">
            </div>
        </div>
        <div class="control-group">
            <lable class="control-label" for="dateStart">Date start</lable>
            <div class="controls">
                <input placeholder="15-02-2017" name="dateStart" type="date" style="height: 30px;">
            </div>
        </div>
        <div class="control-group">
            <lable class="control-label" for="dateEnd">Date end</lable>
            <div class="controls">
                <input placeholder="23-02-2017" name="dateEnd" type="date" style="height: 30px;">
            </div>
        </div>

        <input name="medicamentStatus" type="hidden" value="NOT_DONE">

        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn btn-success" type="submit" style="margin-left: -80px;">Create Medicament
                        </button>
                    </div>


                    <div id="login-error-message"><span class="label label-important"
                                                        style="margin-left: -72px;">${errorMessage}</span></div>
                    <div id="login-successful-message"><span
                            class="label label-success" style="margin-left: -72px;">${successfulMessage}</span></div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
