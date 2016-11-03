<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 03.11.2016
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search list products</title>
</head>
<body>
<form action="SortForSearch" method="get">
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
<c:forEach items="${searchListProducts}" var="products">
    <c:if test="${products.count ne 0}">
        <tr>
            <td>Product number - ${products.productId}</td>
            <br>
            <td>Name - ${products.name}</td>
            <br>
            <td>Price - ${products.price}</td>
            <br>
            <td>Count - ${products.count}</td>
            <br>
            <td>Description id - ${products.descriptionId}</td>
            <br>
            <td>Characteristic id - ${products.characteristicId}</td>
            <br>
            <td>Manufacturer Id - ${products.manufacturerId}</td>
            <br>
            <td>Category Id - ${products.categoryId}</td>
        </tr>
        <form action="ShowAllProduct" method="post">
            <input type="hidden" name="productId" value="${products.productId}">
            <input type="hidden" name="descriptionId" value="${products.descriptionId}">
            <input type="hidden" name="characteristicId" value="${products.characteristicId}">
            <input type="hidden" name="manufacturerId" value="${products.manufacturerId}">
            <input type="hidden" name="categoryId" value="${products.categoryId}">
            <input id="submit-btn" type="submit" value="More info">
        </form>
        <form action="AddToBasket" method="post">
            <input type="hidden" name="productId" value="${products.productId}">
            <input type="hidden" name="nameDoing" value="add">
            <input type="submit" value="Buy">
        </form>
        <br>
        <br>
    </c:if>
</c:forEach>
</body>
</html>
