<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 02.11.2016
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<form action="Search" method="post">
    <h3>Category</h3>
    <c:forEach items="${category}" var="categoryVar">
        <c:if test="${(categoryVar.categoryId <= 3)}">
            <tr>
                <lable for="categoryId">${categoryVar.nameCategory}</lable>
                <input name="categoryId" type="checkbox" value="${categoryVar.categoryId}">
            </tr>
        </c:if>
    </c:forEach>
    <br>

    <h3>Manufacturer</h3>
    <c:forEach items="${manufacturers}" var="manufacturerVar">
        <tr>
            <lable for="manufacturerId">${manufacturerVar.nameManufacturer}</lable>
            <input name="manufacturerId" type="checkbox" value="${manufacturerVar.manufacturerId}">
        </tr>
    </c:forEach>
    <br>
    <h4>Price</h4>
    <tr>
        <lable for="priceFrom">From</lable>
        <input name="priceFrom" type="number">

        <lable for="priceTo">To</lable>
        <input name="priceTo" type="number">
    </tr>

    <h3>Characteristic :</h3>
    <h4>Main camera</h4>
    <c:forEach items="${mainCameraSet}" var="mainCamera">
        <c:if test="${mainCamera ne 0.0}">
            <lable for="mainCamera">${mainCamera}</lable>
            <input name="mainCamera" type="checkbox" value="${mainCamera}">
        </c:if>
    </c:forEach>

    <br>
    <h4>Screen size</h4>
    <c:forEach items="${screenSizeSet}" var="screenSize">
        <tr>
            <c:if test="${screenSize ne 0.0}">
                <lable for="screenSize">${screenSize}</lable>
                <input name="screenSize" type="checkbox" value="${screenSize}">
            </c:if>
        </tr>
    </c:forEach>

    <br>
    <h4>Memory</h4>
    <c:forEach items="${memorySet}" var="memory">
        <tr>
            <c:if test="${memory ne 0}">
                <lable for="memory">${memory}</lable>
                <input name="memory" type="checkbox" value="${memory}">
            </c:if>
        </tr>
    </c:forEach>

    <br>
    <h4>Color</h4>
    <c:forEach items="${colorSet}" var="color">
        <tr>
            <lable for="color">${color}</lable>
            <input name="color" type="checkbox" value="${color}">
        </tr>
    </c:forEach>

    <br>
    <h4>Ram</h4>
    <c:forEach items="${ramSet}" var="ram">
        <tr>
            <c:if test="${ram ne 0}">
                <lable for="ram">${ram}</lable>
                <input name="ram" type="checkbox" value="${ram}">
            </c:if>
        </tr>
    </c:forEach>

    <input type="submit" value="Find">
</form>
</body>
</html>
