<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 31.10.2016
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show all sales</title>
</head>
<body>
<a href="Main">Main page</a>
<br>
<br>
<c:forEach items="${salesList}" var="sales">
    <tr>
        <td>Sales number - ${sales.salesId}</td>
        <br>
        <td>E-mail - ${sales.email}</td>
        <br>
        <td>User name - ${sales.userName}</td>
        <br>
        <td>User surname - ${sales.userSurname}</td>
        <br>
        <td>User phone - ${sales.userPhone}</td>
        <br>
        <td>User city - ${sales.userCity}</td>
        <br>
        <td>User address - ${sales.userAddress}</td>
        <br>
        <td>User house - ${sales.userHouse}</td>
        <br>
        <td>Delivery method - ${sales.deliveryMethod}</td>
        <br>
        <td>Payment method - ${sales.paymentMethod}</td>
        <br>
        <td>Product number - ${sales.productId}</td>
        <br>
        <td>Price - ${sales.price}</td>
        <br>
        <td>Product count - ${sales.productCount}</td>
        <br>
        <td>All price - ${sales.allPrice}</td>
        <br>
        <td>Day buy - ${sales.dateBuy}</td>
        <br>
    </tr>
    <br>
    <br>
</c:forEach>
</body>
</html>
