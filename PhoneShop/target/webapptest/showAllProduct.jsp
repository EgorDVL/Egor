<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 19.10.2016
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show all product</title>
</head>
<body>
<c:forEach items="${allProductList}" var="allProductList">
    <tr>
        <td>Product number - ${allProductList.productId}</td>
        <br>
        <td>Name - ${allProductList.name}</td>
        <br>
        <td>Price - ${allProductList.price}</td>
        <br>
        <td>Count - ${allProductList.count}</td>
        <br>
        <td>Description id - ${allProductList.descriptionId}</td>
        <br>
        <td>Characteristic id - ${allProductList.characteristicId}</td>
        <br>
        <td>Manufacturer Id - ${allProductList.manufacturerId}</td>
        <br>
        <td>Category Id - ${allProductList.categoryId}</td>
    </tr>
    <form action="ShowAllProduct" method="post">
        <input type="hidden" name="productId" value="${allProductList.productId}">
        <input type="hidden" name="descriptionId" value="${allProductList.descriptionId}">
        <input type="hidden" name="characteristicId" value="${allProductList.characteristicId}">
        <input type="hidden" name="manufacturerId" value="${allProductList.manufacturerId}">
        <input type="hidden" name="categoryId" value="${allProductList.categoryId}">
        <input id="submit-btn" type="submit" value="More info">
    </form>
    <form action="addToBasket" method="post">
        <input type="hidden" name="productId" value="${allProductList.productId}">
        <input type="hidden" name="nameDoing" value="add">
        <input type="submit" value="Buy">
    </form>
    <br>
    <br>
</c:forEach>
</body>
</html>
