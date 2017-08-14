<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="main-body-menu">
    <ul class="nav">
        <li class="nav-header">Departments</li>
        <li>
            <button class="li-color" onclick="showDepartmentCreateOrUpdateForm(event)" type="submit">Create</button>
        </li>
        <li>
            <button class="li-color" onclick="showAllDepartments()">Show departments</button>
        </li>
        
    </ul>
    <br>
    <ul class="nav">
        <li class="nav-header">Employees</li>
        <li>
            <button class="li-color" onclick="showEmployeeCreateOrUpdateForm(event)" type="submit">Create</button>
        </li>
        <li>
            <button class="li-color" onclick="showAllEmployees()">Show employees</button>
        </li>
    </ul>
</div>
