<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 18.01.2017
  Time: 1:26
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
    <script type="text/javascript" src="bootstrap/js/updatemedicament.validator.js"></script>

    <title>Update medicament</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>


<div id="search-patient-container" style="width: 650px;">
    <form class="form-horizontal" action="UpdateMedicament" method="post" id="updateMedicamentValidate" id="login-form">
        <input type="hidden" name="medicamentId" value="${medicament.medicamentId}">

        <div class="control-group">
            <lable class="control-label" for="name">Medicament</lable>
            <div class="controls">
                <input placeholder="Aspirin" name="name" type="text" value="${medicament.nameMedicament}"
                       style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="type">Type</lable>
            <div class="controls">
                <select name="type" style="width: 206px;">
                    <c:choose>
                        <c:when test="${medicament.medicamentEnum eq 'PILLS'}">
                            <option value="PILLS" selected>PILLS</option>
                            <option value="INJECTION">INJECTION</option>
                            <option value="POWDER">POWDER</option>
                        </c:when>
                        <c:when test="${medicament.medicamentEnum eq 'INJECTION'}">
                            <option value="PILLS">PILLS</option>
                            <option value="INJECTION" selected>INJECTION</option>
                            <option value="POWDER">POWDER</option>
                        </c:when>
                        <c:when test="${medicament.medicamentEnum eq 'POWDER'}">
                            <option value="PILLS">PILLS</option>
                            <option value="INJECTION">INJECTION</option>
                            <option value="POWDER" selected>POWDER</option>
                        </c:when>
                        <c:otherwise>
                            <option value="PILLS">PILLS</option>
                            <option value="INJECTION">INJECTION</option>
                            <option value="POWDER">POWDER</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="use">Use</lable>
            <div class="controls">
                <input placeholder="2 times a day" name="use" type="text" value="${medicament.useMedicament}"
                       style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="dateStart">Date start</lable>
            <div class="controls">
                <input placeholder="15-02-2017" name="dateStart" type="date" value="${medicament.dateStartMedicament}"
                       style="height: 30px;">
            </div>
        </div>
        <div class="control-group">
            <lable class="control-label" for="dateEnd">Date end</lable>
            <div class="controls">
                <input placeholder="23-02-2017" name="dateEnd" type="date" value="${medicament.dateEndMedicament}"
                       style="height: 30px;">
            </div>
        </div>

        <input name="medicamentStatus" type="hidden" value="NOT_DONE">

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
