<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 07.10.2016
  Time: 18:49
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
${user.name} : ${role}
<br>
<a href="ReqDispatcherToShowProduct">Show Category</a>
<br>
<a href="ShowAllProduct">Show all products</a>
<br>
<a href="chip-basket.jsp">Chip-basket</a>
<br>
<a href="Logout">Exit</a>

</body>
</html>