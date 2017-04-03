<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 12.01.2017
  Time: 16:32
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
    <script type="text/javascript" src="bootstrap/js/jquery.tablesorter.js"></script>
    <script type="text/javascript" src="bootstrap/js/sort-runner.js"></script>

    <title>Show Healing Patient</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div class="doctors-selection-lable">
    <fmt:message key="medicalhistory.HEALINGHISTORY"/>
</div>

<div id="create-new-healing">
    <c:if test="${user.userRole eq 'DOCTOR'}">
        <input class="btn btn-danger" type="button"
               value="<fmt:message key="medicalhistory.Addnewhealing"/>"
               onClick='location.href="CreateDiagnosis"'>
    </c:if>
</div>

<div class="show-all-doctors" style="margin-left: 290px;">
    <table class="table table-striped table table-hover" id="myTable">
        <thead>
        <tr>
            <th><fmt:message key="medicalhistory.Datestart"/></th>
            <th><fmt:message key="medicalhistory.Dateend"/></th>
            <th><fmt:message key="medicalhistory.Symptoms"/></th>
            <th><fmt:message key="medicalhistory.Moreinfo"/></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${healingList}" var="healing">
            <tr>
                <td>${healing.dateHealingStart}</td>
                <td>${healing.dateHealingEnd}</td>
                <td>${healing.symptoms}</td>
                <td>
                    <form action="PatientHealing" method="get">
                        <input type="hidden" name="healingId" value="${healing.healingId}">
                        <button class="btn btn-info" type="submit"><fmt:message key="medicalhistory.Moreinfo"/></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
