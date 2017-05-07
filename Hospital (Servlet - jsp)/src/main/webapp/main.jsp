<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 07.10.2016
  Time: 18:49
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

    <title>Main</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div id="main-body-image">
    <img src="image/hospital1.png" class="img-rounded">
</div>
</body>
</html>