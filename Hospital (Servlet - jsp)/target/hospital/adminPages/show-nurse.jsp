<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 11.01.2017
  Time: 21:20
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

    <title>Show Nurse</title>
</head>
<body>

<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div id="show-doctor-main-body">
    <div class="user-info">
        <div class="user-show-left">
            <div class="user-image">
                <img src="${nurse.photo}" class="img-rounded" style="width: 400px; height: 400px;">
            </div>
        </div>

        <div class="user-show-right">
            <div class="user-description">
                <span><fmt:message key="shownurse.Name"/> : </span>
                <b>${nurse.name}</b>
                <br>
                <span><fmt:message key="shownurse.Surname"/> : </span>
                <b>${nurse.surname}</b>
                <br>
                <span><fmt:message key="shownurse.Dateofbirth"/> : </span>
                <b>${nurse.dateOfBirth}</b>
                <br>
                <span><fmt:message key="shownurse.Phone"/> : </span>
                <b>${nurse.phone}</b>
            </div>

            <div class="user-show-patients">
                <c:if test="${sessionScope.user.userRole eq 'ADMIN'}">
                    <input class="btn btn-warning" type="button"
                           value="<fmt:message key="shownurse.Updatenurse"/>" style="width: 107px;"
                           onClick='location.href="UpdateNurse?nurseId=${nurse.nurseId}"'>
                </c:if>
            </div>
            <br>

            <div class="user-show-patients">
                <c:if test="${sessionScope.user.userRole eq 'ADMIN'}">
                    <input class="btn btn-danger" type="button"
                           value="<fmt:message key="shownurse.Deletenurse"/>"
                           onClick='location.href="DeleteNurse?nurseId=${nurse.nurseId}"'>
                </c:if>
            </div>
            <br>

            <div class="user-show-patients">
                <form action="TransferNurseDepartment" method="get">
                    <input type="hidden" name="nurseId" value="${nurse.nurseId}">

                    <button class="btn btn-warning" type="submit">
                        <fmt:message key="shownurse.Transfertoanotherdepartment"/></button>
                    <br>
                    <select name="department" class="form-control" style="width: 226px;">

                        <c:forEach items="${departments}" var="dep">
                            <c:choose>
                                <c:when test="${dep.departmentEnum eq nurse.department}">
                                    <option value="${dep.departmentEnum}" selected>${dep.departmentEnum}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${dep.departmentEnum}">${dep.departmentEnum}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </form>
            </div>
        </div>
    </div>

    <div class="user-show-tab-header">
        <fmt:message key="showdoctor.allinfo"/>
    </div>

    <table class="table table-striped" id="user-show-tab-attribute">
        <thead>
        <tr>
            <th colspan="2" style="text-align: center"><fmt:message key="shownurse.Aboutnurse"/></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="shownurse.Name"/></td>
            <td style="width: 50%;text-align: center">${nurse.name}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="shownurse.Surname"/></td>
            <td style="width: 50%;text-align: center">${nurse.surname}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="shownurse.Dateofbirth"/></td>
            <td style="width: 50%;text-align: center">${nurse.dateOfBirth}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="shownurse.Phone"/></td>
            <td style="width: 50%;text-align: center">${nurse.phone}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center">E-mail</td>
            <td style="width: 50%;text-align: center">${user.email}</td>
        </tr>
        </tbody>

        <thead>
        <tr>
            <th colspan="2" style="text-align: center"><fmt:message key="shownurse.Speciality"/></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="shownurse.Speciality"/></td>
            <td style="width: 50%;text-align: center">${nurse.specialty}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="shownurse.Department"/></td>
            <td style="width: 50%;text-align: center">${nurse.department}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="shownurse.Experience"/></td>
            <td style="width: 50%;text-align: center">${nurse.experience} - year</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>