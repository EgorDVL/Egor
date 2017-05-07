<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 31.01.2017
  Time: 23:42
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

    <title>Title</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div class="add-image">
    <form method="post" action="UploadImage" enctype="multipart/form-data">
        <lable>
            <span class="label label-info" id="add-image-lable"><fmt:message key="addimage.Selectimg"/> :</span>
        </lable>
        <br>
        <input type="file" name="file" id="add-upload-select">
        <br>
        <button type="submit" class="btn btn-success" id="add-image-button"><fmt:message
                key="addimage.Uploadphoto"/></button>
    </form>
</div>
</body>
</html>
