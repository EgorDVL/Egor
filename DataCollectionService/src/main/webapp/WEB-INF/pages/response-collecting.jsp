<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 12.04.2017
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
    <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"/>

    <title>Response collecting</title>
</head>
<body>
<%@include file="/include/header.jspf" %>

<div class="response-collection-main">
    <form:form method="post" action="/response/create" modelAttribute="createForm">

        <c:forEach items="${createForm.showForms}" var="form" varStatus="status">
            <input type="hidden" name="showForms[${status.index}].required" value="${form.required}">
            <input type="hidden" name="showForms[${status.index}].status" value="${form.status}">

            <c:choose>
                <c:when test="${form.status eq true}">
                    <input type="hidden" name="showForms[${status.index}].fieldId" value="${form.fieldId}">


                    <div class="response-collection-name">
                        <c:choose>
                            <c:when test="${form.required eq true}">
                                <label style="font-size: 18px;">${form.fieldLabel} * :</label>
                                <input type="hidden" name="showForms[${status.index}].fieldLabel"
                                       value="${form.fieldLabel}">
                            </c:when>
                            <c:when test="${form.required eq false}">
                                <label style="font-size: 18px;">${form.fieldLabel} :</label>
                                <input type="hidden" name="showForms[${status.index}].fieldLabel"
                                       value="${form.fieldLabel}">
                            </c:when>
                        </c:choose>
                    </div>


                    <c:choose>
                        <c:when test="${form.typeName eq 'Simple line'}">
                            <input name="showForms[${status.index}].typeName" type="hidden"
                                   value="${form.typeName}">

                            <div class="response-simple-line">
                                <input name="showForms[${status.index}].typeValues" type="text"
                                       <c:if test="${form.required eq true}">required</c:if>
                                       style=" width: 300px; height: 30px;"><br>
                            </div>
                        </c:when>


                        <c:when test="${form.typeName eq 'Multi line'}">
                            <input name="showForms[${status.index}].typeName" type="hidden"
                                   value="${form.typeName}">

                            <div class="response-multi-line">
                            <textarea rows="3" name="showForms[${status.index}].typeValues"
                                      style="width: 300px;"
                                      <c:if test="${form.required eq true}">required</c:if>
                            ></textarea>
                            </div>
                        </c:when>

                        <c:when test="${form.typeName eq 'Date'}">
                            <input name="showForms[${status.index}].typeName" type="hidden"
                                   value="${form.typeName}">

                            <div class="response-date">
                                <input name="showForms[${status.index}].typeValues" type="date"
                                       <c:if test="${form.required eq true}">required</c:if>
                                       style=" width: 300px; height: 30px;"><br>
                            </div>
                        </c:when>

                        <c:when test="${form.typeName eq 'Radio'}">
                            <input name="showForms[${status.index}].typeName" type="hidden"
                                   value="${form.typeName}">

                            <c:forEach items="${form.typeValues}" var="value">
                                <div class="radio">
                                    <label><input name="showForms[${status.index}].typeValues" type="radio"
                                                  <c:if test="${form.required eq true}">required</c:if>
                                                  value="${value}"/>${value}
                                    </label>
                                </div>
                            </c:forEach>
                        </c:when>

                        <c:when test="${form.typeName eq 'Check box'}">
                            <input name="showForms[${status.index}].typeName" type="hidden"
                                   value="${form.typeName}">

                            <c:forEach items="${form.typeValues}" var="value">
                                <div class="checkbox">
                                    <label><input name="showForms[${status.index}].typeValues" type="checkbox"
                                                  value="${value}"/>${value}
                                    </label>
                                </div>
                            </c:forEach>
                        </c:when>

                        <c:when test="${form.typeName eq 'Combo box'}">
                            <input name="showForms[${status.index}].typeName" type="hidden"
                                   value="${form.typeName}">

                            <select name="showForms[${status.index}].typeValues"
                                    <c:if test="${form.required eq true}">required</c:if> style="width: 300px;">
                                <option value="" selected> - select option -</option>
                                <c:forEach items="${form.typeValues}" var="value">
                                    <option value="${value}">${value}</option>
                                </c:forEach>
                            </select>
                        </c:when>
                    </c:choose>
                    <br>
                </c:when>

                <c:when test="${form.status eq false}">
                    <input type="hidden" name="showForms[${status.index}].fieldId" value="${form.fieldId}">
                    <input type="hidden" name="showForms[${status.index}].fieldLabel" value="${form.fieldLabel}">
                    <input type="hidden" name="showForms[${status.index}].typeName" value="${form.typeName}">
                    <input type="hidden" name="showForms[${status.index}].typeValues" value=""/>
                </c:when>
            </c:choose>

        </c:forEach>
        <br>

        <div class="response-submit">
            <button class="btn btn-success" type="submit"><i class="icon-folder-open"></i>Submit</button>
            <button class="btn btn-warning" type="reset"><i class="icon-remove"></i>Cancel</button>
        </div>
    </form:form>
</div>
</body>
</html>
