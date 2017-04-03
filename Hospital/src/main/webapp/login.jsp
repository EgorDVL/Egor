<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 07.10.2016
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--session="false"--%>

<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
    <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"/>

    <title>Login page</title>
</head>
<body>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>

<div id="header">
    <ul class="nav nav-pills">
        <li>
            <form class="form-inline">
                <select name="language">
                    <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message
                            key="login.language.eng"/></option>
                    <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message
                            key="login.language.ru"/></option>
                </select>
                <button type="submit" class="btn"><fmt:message
                        key="login.language.change"/></button>
            </form>
        </li>
    </ul>
</div>

<div id="container" style="margin-top: 18%">
    <form class="form-horizontal" action="Login" method="post" id="login-form">
        <div class="control-group">
            <lable class="control-label" for="email">Email</lable>
            <div class="controls">
                <input placeholder="e-mail" name="email" type="text">
            </div>
        </div>

        <div class="control-group">
            <lable class="control-label" for="password"><fmt:message
                    key="login.password"/></lable>
            <div class="controls">
                <input placeholder="password" name="password" type="password">
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <div id="signup-button">
                    <div>
                        <button class="btn" type="submit"><fmt:message
                                key="login.sigin"/></button>
                    </div>
                    <div id="login-error-message"><span class="label label-important">${errorMessage}</span></div>
                    <div id="login-successful-message"><span
                            class="label label-success">${successfulMessage}</span></div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>