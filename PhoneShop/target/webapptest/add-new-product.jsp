<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 10.11.2016
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new product</title>
</head>
<body>
<form action="AddNewProduct" method="post">

    <lable for="manufacturer">Manufacturer</lable>
    <select name="manufacturer">
        <option value="1">Apple</option>
        <option value="2">Samsung</option>
        <option value="3">LG</option>
        <option value="4">Nokia</option>
        <option value="5">Lenovo</option>
    </select>
    <br>

    <lable for="name">Product name</lable>
    <input placeholder="iphone 7" name="name" type="text">
    <br>

    <lable for="price">Price</lable>
    <input placeholder="700" name="price" type="number">
    <br>

    <lable for="count">Count</lable>
    <input placeholder="20" name="count" type="number">
    <br>

    <lable for="description">Description</lable>
    <input placeholder="iphone 7 good phone..." name="description" type="text">
    <br>

    <h3>Characteristic</h3>
    <br>
    <lable for="color">Color</lable>
    <select name="color">
        <option value="black">black</option>
        <option value="silver">silver</option>
        <option value="white">white</option>
        <option value="onix">onix</option>
        <option value="space-grey">space-grey</option>
    </select>

    <br>
    <lable for="memory">Memory</lable>
    <input placeholder="16" name="memory" type="number">

    <br>
    <lable for="screenSize">Screen size</lable>
    <select name="screenSize">
        <option value="4.0">4.0</option>
        <option value="4.5">4.5</option>
        <option value="4.75">4.75</option>
        <option value="5.0">5.0</option>
        <option value="5.5">5.5</option>
        <option value="5.75">5.75</option>
        <option value="6">6</option>
    </select>

    <br>
    <lable for="processor">Processor</lable>
    <select name="processor">
        <option value="apple A6">apple A6</option>
        <option value="apple A7">apple A7</option>
        <option value="apple A8">apple A8</option>
        <option value="apple A9">apple A9</option>
        <option value="apple A10">apple A10</option>
        <option value="ARM">ARM</option>
        <option value="Intel">Intel</option>
        <option value="Mediatec">Mediatec</option>
        <option value="Cortex">Cortex</option>
        <option value="Qualcomm">Qualcomm</option>
        <option value="Meizu">Meizu</option>
        <option value="Hiomi">Hiomi</option>
    </select>

    <br>
    <lable for="ram">Ram</lable>
    <input placeholder="2" name="ram" type="number">

    <br>
    <lable for="frontCamera">Front camera</lable>
    <select name="frontCamera">
        <option value="2.5">2.5</option>
        <option value="3.0">3.0</option>
        <option value="3.5">3.5</option>
        <option value="4.0">4.0</option>
        <option value="4.5">4.5</option>
        <option value="5.0">5.0</option>
        <option value="6.0">6.5</option>
        <option value="6.5">6.5</option>
        <option value="7.0">7.0</option>
        <option value="7.5">7.5</option>
        <option value="8.0">8.0</option>
    </select>

    <br>
    <lable for="mainCamera">Main camera</lable>
    <select name="mainCamera">
        <option value="8.0">8.0</option>
        <option value="8.5">8.5</option>
        <option value="9.0">9.0</option>
        <option value="9.5">9.5</option>
        <option value="10.0">10.0</option>
        <option value="11.0">11.0</option>
        <option value="12.0">12.0</option>
        <option value="12.5">12.5</option>
        <option value="13.0">13.0</option>
        <option value="13.5">13.5</option>
        <option value="14.0">14.0</option>
    </select>
    <br>
    <input type="submit" value="Add product">

    <div>${errorMessage}</div>
</form>
</body>
</html>
