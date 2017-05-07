<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 27.02.2017
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create User</title>
    <style>
        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>
<%--<form action="CreateUser" method="post">--%>
${exception.exceptionMsg}
<form:form action="/CreateUser" method="post" modelAttribute="userDto">

    Email: <form:input path="email"/>
    <form:errors path="email" cssClass="error"/>
    <c:if test="${not empty error}">
        Error: ${error}
    </c:if>
    <br/>

    Password: <form:password path="password"/>
    <form:errors path="password" cssClass="error"/>
    <br/>

    Name: <form:input path="name"/>
    <form:errors path="name" cssClass="error"/>
    <br/>

    Surname: <form:input path="surname"/>
    <form:errors path="surname" cssClass="error"/>
    <br/>

    Group:
    <form:select path="groupId">
        <c:forEach items="${groupMap}" var="groupDto">
            <form:option value="${groupDto.key}">${groupDto.value}</form:option>
        </c:forEach>
    </form:select>
    <br/>

    <%--<lable class="control-label" for="email">Email</lable>--%>
    <%--<input placeholder="Pupkin@gmail.com" name="email" type="text">--%>
    <%--<form:errors path="email" cssClass="error"/><br>--%>

    <%--<lable class="control-label" for="password">Password</lable>--%>
    <%--<input placeholder="***********" name="password" type="password">--%>
    <%--<form:errors path="password" cssClass="error"/><br>--%>

    <%--<lable class="control-label" for="name">Name</lable>--%>
    <%--<input placeholder="Yehor" name="name" type="text">--%>
    <%--<form:errors path="name" cssClass="error"/><br>--%>


    <%--<lable class="control-label" for="surname">Surname</lable>--%>
    <%--<input placeholder="Zhyzhko" name="surname" type="text">--%>
    <%--<form:errors path="surname" cssClass="error"/><br>--%>

    <%--<select name="groupId">--%>
    <%--<c:forEach items="${groupMap}" var="groupDto">--%>
    <%--<option value="${groupDto.key}">${groupDto.value}</option>--%>
    <%--</c:forEach>--%>
    <%--</select><br>--%>

    <input name="roles" type="hidden" value="USER"><br>
    <button class="btn btn-info" type="submit">Create user</button>
</form:form>
<%--</form>--%>
</body>
</html>
