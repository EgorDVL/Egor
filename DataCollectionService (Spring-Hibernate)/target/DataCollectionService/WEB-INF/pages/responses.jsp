<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 11.04.2017
  Time: 22:44
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


    <title>Responses</title>
</head>
<body>
<%@include file="/include/header.jspf" %>

<div class="add-response">
    <input id="addField" class="btn btn-success" type="button"
           value="+ Add response"
           onClick='location.href="/response/createPage"'>
</div>
<div class="response">
    <table class="table table-striped table-bordered" style="width: 800px;">
        <thead>
        <tr>
            <c:forEach items="${responses}" var="res">
                <th>${res.key.label}</th>
            </c:forEach>
        </tr>
        </thead>

        <tbody>
        <tr>
            <c:forEach items="${responses}" var="res">
                <td>
                    <c:forEach items="${res.value}" var="val">
                        <c:choose>
                            <c:when test="${val ne ''}">
                                ${val}
                            </c:when>
                            <c:when test="${val eq ''}">
                                N/A
                            </c:when>
                        </c:choose>
                        <br>

                        <div class="response-line"></div>
                    </c:forEach>
                </td>
            </c:forEach>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>