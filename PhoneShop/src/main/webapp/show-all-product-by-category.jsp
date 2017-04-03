<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 01.11.2016
  Time: 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show all product by category</title>
</head>
<body>
<form action="Sort" method="get">
    <lable for="sort">Sort</lable>
    <select name="sort">
        <option value="name">Name [A-Z]</option>
        <option value="name Desc">Name [Z-A]</option>
        <option value="price">Price [min -> max]</option>
        <option value="price Desc">Price [max -> min]</option>
    </select>
    <br>
    <input type="submit" value="Sort">
</form>
<a href="Main">Main page</a>
<br>
<br>
<c:forEach items="${allProductListCategory}" var="ProductByCategory">
    <c:if test="${ProductByCategory.count ne 0}">
        <tr>
            <td>Product number - ${ProductByCategory.productId}</td>
            <br>
            <td>Name - ${ProductByCategory.name}</td>
            <br>
            <td>Price - ${ProductByCategory.price}</td>
            <br>
            <td>Count - ${ProductByCategory.count}</td>
            <br>
            <td>Description id - ${ProductByCategory.descriptionId}</td>
            <br>
            <td>Characteristic id - ${ProductByCategory.characteristicId}</td>
            <br>
            <td>Manufacturer Id - ${ProductByCategory.manufacturerId}</td>
            <br>
            <td>Category Id - ${ProductByCategory.categoryId}</td>
        </tr>
        <form action="ShowProductSelection" method="post">
            <input type="hidden" name="productId" value="${ProductByCategory.productId}">
            <input type="hidden" name="descriptionId" value="${ProductByCategory.descriptionId}">
            <input type="hidden" name="characteristicId" value="${ProductByCategory.characteristicId}">
            <input type="hidden" name="manufacturerId" value="${ProductByCategory.manufacturerId}">
            <input type="hidden" name="categoryId" value="${ProductByCategory.categoryId}">
            <input id="submit-btn" type="submit" value="More info">
        </form>
        <form action="AddToBasket" method="post">
            <input type="hidden" name="productId" value="${ProductByCategory.productId}">
            <input type="hidden" name="nameDoing" value="add">
            <input type="submit" value="Buy">
        </form>
        <br>
        <br>
    </c:if>
</c:forEach>
</body>
</html>
