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
    <c:forEach items="${category}" var="category">
        <c:if test="${(category.categoryId <= 3)}">
            <tr>
                <lable for="categoryId">${category.nameCategory}</lable>
                <input name="categoryId" type="checkbox" value="${category.categoryId}">
            </tr>
        </c:if>
    </c:forEach>
    <br>

    <h3>Manufacturer</h3>
    <c:forEach items="${manufacturers}" var="manufacturers">
        <tr>
            <lable for="manufacturerId">${manufacturers.nameManufacturer}</lable>
            <input name="manufacturerId" type="checkbox" value="${manufacturers.manufacturerId}">
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
    <c:forEach items="${characteristics}" var="characteristics">
        <tr>
            <lable for="mainCamera">${characteristics.mainCamera}</lable>
            <input name="mainCamera" type="checkbox" value="${characteristics.mainCamera}">
        </tr>
    </c:forEach>

    <br>
    <h4>Screen size</h4>
    <c:forEach items="${characteristics}" var="characteristics">
        <tr>
            <lable for="screenSize">${characteristics.screenSize}</lable>
            <input name="screenSize" type="checkbox" value="${characteristics.screenSize}">
        </tr>
    </c:forEach>

    <br>
    <h4>Memory</h4>
    <c:forEach items="${characteristics}" var="characteristics">
        <tr>
            <lable for="memory">${characteristics.memory}</lable>
            <input name="memory" type="checkbox" value="${characteristics.memory}">
        </tr>
    </c:forEach>

    <br>
    <h4>Color</h4>
    <c:forEach items="${characteristics}" var="characteristics">
        <tr>
            <lable for="color">${characteristics.color}</lable>
            <input name="color" type="checkbox" value="${characteristics.color}">
        </tr>
    </c:forEach>

    <br>
    <h4>Ram</h4>
    <c:forEach items="${characteristics}" var="characteristics">
        <tr>
            <lable for="ram">${characteristics.ram}</lable>
            <input name="ram" type="checkbox" value="${characteristics.ram}">
        </tr>
    </c:forEach>

    <input type="submit" value="Find">
</form>
</body>
</html>
