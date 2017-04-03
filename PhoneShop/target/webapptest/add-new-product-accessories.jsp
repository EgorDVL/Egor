<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 11.11.2016
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="AddNewProductAccessories" method="post">
    <lable for="subcategory">Manufacturer</lable>
    <select name="subcategory">
        <option value="1">covers</option>
        <option value="2">PROTECTIVE_SCREEN</option>
        <option value="3">PROTECTIVE_GLASSES</option>
        <option value="4">HEADSET</option>
        <option value="5">CHARGING_DEVICE</option>
        <option value="6">MONOPODS_FOR_SELFIE</option>
        <option value="7">BATTARIES</option>
    </select>
    <br>
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
    <input placeholder="iphone 7 score" name="name" type="text">
    <br>

    <lable for="price">Price</lable>
    <input placeholder="20" name="price" type="number">
    <br>

    <lable for="count">Count</lable>
    <input placeholder="200" name="count" type="number">
    <br>

    <lable for="description">Description</lable>
    <input placeholder="The best score..." name="description" type="text">
    <br>

    <input type="submit" value="Add product">
    <div>${errorMessage}</div>

</form>
</body>
</html>
