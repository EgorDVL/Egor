<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 28.10.2016
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
</head>
<body>
<c:if test="${ basket.contains ne null}">
    <form action="Checkout" method="post">
        <lable for="email">E-mail</lable>
        <input placeholder="Looo@gmail.com" name="email" type="text">
        <br>
        <lable for="name">Name</lable>
        <input placeholder="Petr" name="name" type="text">
        <br>
        <lable for="surname">Surname</lable>
        <input placeholder="Petrovich" name="surname" type="text">
        <br>
        <lable for="phone">Phone</lable>
        <input placeholder="+38(011)-111-11-11" name="phone" type="text">
        <br>
        <lable for="city">City</lable>
        <input placeholder="Kharkiv" name="city" type="text">
        <br>
        <lable for="address">Address</lable>
        <input placeholder="Svobody" name="address" type="text">
        <br>
        <lable for="house">House</lable>
        <input placeholder="34" name="house" type="text">
        <br>
        <lable for="delivery">Delivery Method</lable>
        <select name="delivery">
            <option value="PICKUP">Pickup</option>
            <option value="NOVA_POSHTA">Nova poshta</option>
        </select>
        <br>
        <lable for="payment">Payment Method</lable>
        <select name="payment">
            <option value="CASH_PAYMENT">Cash payment</option>
            <option value="TRANSFER_TO_ACCOUNT">Transfer to account</option>
        </select>
        <br>
        <input type="submit" value="Checkout">
    </form>
    <a href="Main">Main page</a>
    <br>
    <br>

    <div>${errorMessage}</div>
    <br>
    <td>Total price = ${basket.totalPrice}</td>
    <br>
    <br>
    <br>
    <c:forEach items="${basket.contains}" var="product">
        <td>Count products - ${product.value}</td>
        <br>
        <br>
        <tr>
            <td>Product number - ${product.key.productId}</td>
            <br>
            <td>Name - ${product.key.name}</td>
            <br>
            <td>Price - ${product.key.price}</td>
            <br>
            <td>Count - ${product.key.count}</td>
            <br>
            <td>Description id - ${product.key.descriptionId}</td>
            <br>
            <td>Characteristic id - ${product.key.characteristicId}</td>
            <br>
            <td>Manufacturer Id - ${product.key.manufacturerId}</td>
            <br>
            <td>Category Id - ${product.key.categoryId}</td>
        </tr>
        <br>
        <br>
    </c:forEach>
</c:if>
</body>
</html>
