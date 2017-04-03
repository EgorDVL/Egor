<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 10.10.2016
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="Main">Main page</a>
<br>

<h3 id="phones-header">Phones</h3>

<div id="phones">
    <ul>
        <li>
            <a href="ShowProductSelection?type=Phones&manufacturer=APPLE">Apple</a>
        </li>
        <li>
            <a href="ShowProductSelection?type=Phones&manufacturer=SAMSUNG">SAMSUNG</a>
        </li>
        <li>
            <a href="ShowProductSelection?type=Phones&manufacturer=LG">LG</a>
        </li>
        <li>
            <a href="ShowProductSelection?type=Phones&manufacturer=NOKIA">NOKIA</a>
        </li>
        <li>
            <a href="ShowProductSelection?type=Phones&manufacturer=LENOVO">LENOVO</a>
        </li>
    </ul>
</div>

<h3 id="tablets-header">Tablets</h3>

<div id="tablets">
    <ul>
        <li>
            <a href="ShowProductSelection?type=Tablets&manufacturer=APPLE">Apple</a>
        </li>
        <li>
            <a href="ShowProductSelection?type=Tablets&manufacturer=SAMSUNG">SAMSUNG</a>
        </li>
        <li>
            <a href="ShowProductSelection?type=Tablets&manufacturer=LG">LG</a>
        </li>
        <li>
            <a href="ShowProductSelection?type=Tablets&manufacturer=NOKIA">NOKIA</a>
        </li>
        <li>
            <a href="ShowProductSelection?type=Tablets&manufacturer=LENOVO">LENOVO</a>
        </li>
    </ul>
</div>

<h3 id="accessories-header">Accessories</h3>

<div id="accessories">
    <ul>
        <li>
            <a href="ShowProductSelection?type=Accessories&subcategory=COVERS">COVERS</a>
        </li>
        <li>
            <a href="ShowProductSelection?type=Accessories&subcategory=PROTECTIVE_SCREEN">PROTECTIVE_SCREEN</a>
        </li>
        <li>
            <a href="ShowProductSelection?type=Accessories&subcategory=PROTECTIVE_GLASSES">PROTECTIVE_GLASSES</a>
        </li>
        <li>
            <a href="ShowProductSelection?type=Accessories&subcategory=HEADSET">HEADSET</a>
        </li>
        <li>
            <a href="ShowProductSelection?type=Accessories&subcategory=CHARGING_DEVICE">CHARGING_DEVICE</a>
        </li>
        <li>
            <a href="ShowProductSelection?type=Accessories&subcategory=MONOPODS_FOR_SELFIE">MONOPODS_FOR_SELFIE</a>
        </li>
    </ul>
</div>
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
