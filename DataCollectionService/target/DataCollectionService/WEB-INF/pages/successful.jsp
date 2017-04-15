<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 14.04.2017
  Time: 15:37
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

    <title>Successful page</title>
</head>
<body>
<%@include file="/include/header.jspf" %>

<div class="successful">
    <h3>Thank you for submitting your data!</h3>
</div>
</body>
</html>
