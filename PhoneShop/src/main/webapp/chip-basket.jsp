<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 26.10.2016
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chip basket</title>
</head>
<body>
<td>Total price = ${basket.totalPrice}</td>
<br>
<c:forEach items="${basket.contains}" var="product">
    <td>Count products - ${product.value}</td>
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

    <form action="AddToBasket" method="post">
        <input type="hidden" name="productId" value="${product.key.productId}">
        <input type="hidden" name="nameDoing" value="delete">
        <input type="submit" value="delete">
    </form>
</c:forEach>
<a href="checkout.jsp">Checkout</a>
<a href="Main">Main page</a>
</form>
</body>
</html>
