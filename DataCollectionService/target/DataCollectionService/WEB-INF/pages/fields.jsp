<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 10.04.2017
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
    <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"/>

    <title>Fields</title>
</head>
<body>
<%@include file="/include/header.jspf" %>

<div class="add-field">
    <input id="addField" class="btn btn-success" type="button"
           value="+ Add field"
           onClick='location.href="/field/createPage"'>
</div>

<div class="field">
    <table class="table table-striped table-hover table-bordered">
        <thead>
        <tr>
            <th>Label</th>
            <th>Type</th>
            <th>Required</th>
            <th>is Active</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${fields}" var="field">
            <tr>
                <td>${field.label}</td>
                <td>${field.type.typeName}</td>
                <td>
                    <div class="checkbox">
                        <input type="checkbox" disabled
                               <c:if test="${field.required.value eq true}">checked="checked"</c:if>/>
                    </div>
                </td>

                <td>
                    <div class="checkbox">

                        <input type="checkbox" disabled
                               <c:if test="${field.status.value == true}">checked="checked"</c:if>/>
                    </div>
                </td>

                <td>
                    <input class="btn btn-primary" type="button"
                           value="Edit"
                           onClick='location.href="/field/updatePage?fieldId=${field.id}"'>
                </td>
                <td>
                    <form action="/field/delete" method="post">
                        <input type="hidden" name="fieldId" value="${field.id}">
                        <button class="btn btn-danger" type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
