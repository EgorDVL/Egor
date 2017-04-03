<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 17.01.2017
  Time: 23:45
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
    <script type="text/javascript" src="bootstrap/js/updateoperation.validator.js"></script>

    <title>Update operation</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>


<div id="search-patient-container" style="width: 650px;">
    <form class="form-horizontal" action="UpdateOperation" method="post" id="updateOperationValidate" id="login-form">

        <input type="hidden" name="operationId" value="${operation.operationId}">

        <div class="control-group">
            <lable class="control-label" for="name">Operation</lable>
            <div class="controls">
                <input placeholder="Delete finger" name="name" type="text" value="${operation.nameOperation}"
                       style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="date">Date</lable>
            <div class="controls">
                <input placeholder="20-01-2017" name="date" type="date" value="${operation.dateOperation}"
                       style="height: 30px;">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="complexity">Complexity</lable>
            <div class="controls">
                <select name="complexity" style="width: 206px;">
                    <c:choose>
                        <c:when test="${operation.complexityEnum eq 'EAZY'}">
                            <option value="EAZY" selected>EAZY</option>
                            <option value="NORMAL">NORMAL</option>
                            <option value="HARD">HARD</option>
                        </c:when>
                        <c:when test="${operation.complexityEnum eq 'NORMAL'}">
                            <option value="EAZY">EAZY</option>
                            <option value="NORMAL" selected>NORMAL</option>
                            <option value="HARD">HARD</option>
                        </c:when>
                        <c:when test="${operation.complexityEnum eq 'HARD'}">
                            <option value="EAZY">EAZY</option>
                            <option value="NORMAL">NORMAL</option>
                            <option value="HARD" selected>HARD</option>
                        </c:when>
                        <c:otherwise>
                            <option value="EAZY">EAZY</option>
                            <option value="NORMAL">NORMAL</option>
                            <option value="HARD">HARD</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
        </div>

        <input name="operationStatus" type="hidden" value="NOT_DONE">


        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn btn-warning" type="submit" style="margin-left: -43px;">Update
                        </button>
                    </div>


                    <div id="login-error-message"><span class="label label-important"
                                                        style="margin-left: -27px;">${errorMessage}</span></div>
                    <div id="login-successful-message"><span
                            class="label label-success" style="margin-left: -27px;">${successfulMessage}</span></div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>