<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 19.10.2016
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show product</title>
</head>
<body>
<c:choose>
    <c:when test="${(category.categoryId ne 1) && (category.categoryId ne 2)}">
        <tr>
            <td>Product number - ${product.productId}</td>
            <br>
            <td>Name - ${product.name}</td>
            <br>
            <td>Price - ${product.price}</td>
            <br>
            <td>Count - ${product.count}</td>
            <br>
            <td>Description - ${description.description}</td>
            <br>
            <td>Category - ${category.nameCategory}</td>
            <br>
            <td>Sub category name - ${subcategoryAccessories.nameSubCategoryAccessory}</td>
            <br>
        </tr>
    </c:when>
    <c:otherwise>
        <tr>
            <td>Product number - ${product.productId}</td>
            <br>
            <td>Name - ${product.name}</td>
            <br>
            <td>Price - ${product.price}</td>
            <br>
            <td>Description - ${description.description}</td>
            <br>
            <td>Color - ${characteristic.color}</td>
            <br>
            <td>Memory - ${characteristic.memory}</td>
            <br>
            <td>ScreenSize - ${characteristic.screenSize}</td>
            <br>
            <td>Processor - ${characteristic.processor}</td>
            <br>
            <td>Ram - ${characteristic.ram}</td>
            <br>
            <td>FrontCamera - ${characteristic.frontCamera}</td>
            <br>
            <td>MainCamera - ${characteristic.mainCamera}</td>
            <br>
            <td>Manufacturer - ${manufacturer.nameManufacturer}</td>
            <br>
            <td>Category - ${category.nameCategory}</td>
            <br>
        </tr>
    </c:otherwise>
</c:choose>

<form action="addToBasket" method="post">
    <input type="hidden" name="productId" value="${product.productId}">
    <input type="hidden" name="nameDoing" value="add">
    <input type="submit" value="buy">
</form>

</body>
</html>
