<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 10.04.2017
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
    <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"/>

    <script src="<c:url value="/js/jquery-3.2.0.js"/>"></script>
    <script src="<c:url value="/js/main.js"/>"></script>

    <title>Edit field</title>
</head>
<body>
<%@include file="/include/header.jspf" %>

<div class="name-page">Edit/Create Field</div>

<div class="create-update-field">
    <form class="form-horizontal" action="/field/update" method="post">
        <input name="id" type="hidden" value="${field.id}"/>


        <div class="control-group">
            <label class="control-label" for="label">Label *:</label>

            <div class="controls">
                <input id="label" name="label" type="text" value="${field.label}"
                       style="width: 220px;height: 30px;"><br>
            </div>
        </div>

        <div class="create-field-required">
            <div class="control-group">
                <label class="control-label" for="required">Required</label>

                <div class="controls">
                    <input id="required" name="required" type="checkbox"
                           <c:if test="${field.required.value eq true}">checked="checked"</c:if>/>
                </div>
            </div>
        </div>

        <div class="create-field-status">
            <div class="control-group">
                <label class="control-label" for="status">is Active</label>

                <div class="controls">
                    <input id="status" name="status" type="checkbox"
                           <c:if test="${field.status.value eq true}">checked="checked"</c:if>/>
                </div>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="type">Type *:</label>

            <div class="controls">
                <select id="type" name="type">
                    <c:forEach items="${typeEnum}" var="type">
                        <c:choose>
                            <c:when test="${field.type.typeName eq type}">
                                <option value="${type}" selected>${type}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${type}">${type}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="create-field-textarea">
              <textarea rows="3" name="typeValue" placeholder="Option 1 , Option 2" style="display:none"><c:forEach
                      items="${oldTypeValues}" var="oldValue"><c:out value="${oldValue.value},"/></c:forEach></textarea>
        </div>

        <br>

        <div class="create-field-submit">
            <button class="btn btn-success" type="submit"><i class="icon-folder-open"></i>Edit field</button>
            <button class="btn btn-warning" type="reset"><i class="icon-remove"></i>Cancel</button>
        </div>
    </form>
</div>
</body>
</html>