<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 12.01.2017
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
    <link rel="stylesheet" text="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"/>

    <title>Healing patient info</title>
</head>
<body>
<%@include file="/include/header.jspf" %>
<%@include file="/include/main.jspf" %>

<div class="user-show-tab-header" style="margin-left: 250px; padding-top: 70px;">
    <fmt:message key="healingpatientinfo.Healinghistory"/>
</div>

<%--Error message--%>
<div id="login-error-message" style=" margin-left: 535px;margin-bottom: 10px;"><span
        class="label label-important">${errorMessage}</span>
</div>

<table class="table table-striped" id="user-show-tab-attribute" style="margin-left: 315px;">
    <thead>
    <tr>
        <th colspan="2" style="text-align: center"><fmt:message key="healingpatientinfo.Healing"/></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Hospitalcard"/></td>
        <td style="width: 50%;text-align: center">${healing.hospitalCardId}</td>
    </tr>


    <%--Update symptoms--%>
    <tr>
        <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Symptoms"/></td>
        <td style="width: 50%;text-align: center">${healing.symptoms}</td>
    </tr>
    <c:if test="${user.userRole eq 'DOCTOR'}">
        <tr>
            <td></td>
            <td style="width: 50%;text-align: center">
                <input class="btn btn-danger" type="button"
                       value="<fmt:message key="healingpatientinfo.Updatesymptoms"/>"
                       onClick='location.href="UpdateSymptoms?healingId=${healing.healingId}"'>
            </td>
        </tr>
    </c:if>


    <%--Update healing date--%>
    <tr>
        <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Datehealingstart"/></td>
        <td style="width: 50%;text-align: center">${healing.dateHealingStart}</td>
    </tr>
    <tr>
        <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Datehealingend"/></td>
        <td style="width: 50%;text-align: center">${healing.dateHealingEnd}</td>
    </tr>
    <c:if test="${user.userRole eq 'DOCTOR'}">
        <tr>
            <td></td>
            <td style="width: 50%;text-align: center">
                <input class="btn btn-danger" type="button"
                       value="<fmt:message key="healingpatientinfo.Updatehealingdateend"/>"
                       onClick='location.href="UpdateHealing?healingId=${healing.healingId}"'>
            </td>
        </tr>
    </c:if>

    <%--Diagnosis--%>
    <tr>
        <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Diagnosis"/></td>
        <td style="width: 50%;text-align: center">${diagnosis.nameDiagnos}</td>
    </tr>
    <c:if test="${user.userRole eq 'DOCTOR'}">
        <tr>
            <td></td>
            <td style="width: 50%;text-align: center">
                <input class="btn btn-danger" type="button"
                       value="<fmt:message key="healingpatientinfo.Updatediagnosis"/>"
                       onClick='location.href="UpdateDiagnosis?diagnosisId=${diagnosis.diagnosisId}"'>
            </td>
        </tr>
    </c:if>
    </tbody>


    <%--Attending doctor--%>
    <thead>
    <tr>
        <th colspan="2" style="text-align: center"><fmt:message key="healingpatientinfo.Attendingdoctor"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${doctorsList}" var="doctors">
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.NameSurname"/></td>
            <td style="width: 50%;text-align: center">${doctors.name} ${doctors.surname}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Specialty"/></td>
            <td style="width: 50%;text-align: center">${doctors.specialty}</td>
        </tr>
    </c:forEach>
    </tbody>


    <%--Appointment--%>
    <thead>
    <tr>
        <th colspan="2" style="text-align: center"><fmt:message key="healingpatientinfo.Appointment"/></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Appointmentname"/></td>
        <td style="width: 50%;text-align: center">${appointment.nameAppointment}</td>
    </tr>
    <tr>
        <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Dateappointment"/></td>
        <td style="width: 50%;text-align: center">${appointment.dateAppointment}</td>
    </tr>
    </tbody>


    <%--Operation--%>
    <c:if test="${operation != null}">
        <thead>
        <tr>
            <th colspan="2" style="text-align: center"><fmt:message key="healingpatientinfo.Operation"/></th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${user.userRole eq 'DOCTOR'}">
            <tr>
                <td style="width: 50%;text-align: center">
                    <c:if test="${user.userRole eq 'DOCTOR' and operation.operationStatus eq 'NOT_DONE'}">
                        <input class="btn btn-success" type="button"
                               value="<fmt:message key="healingpatientinfo.Executeoperation"/>"
                               onClick='location.href="ExecuteOperation?operationId=${operation.operationId}&healingId=${healing.healingId}"'>
                    </c:if>
                </td>

                </td>
                <td style="width: 50%;text-align: center">
                    <input class="btn btn-danger" type="button"
                           value="<fmt:message key="healingpatientinfo.Updateoperation"/>"
                           onClick='location.href="UpdateOperation?operationId=${operation.operationId}"'>
                </td>
            </tr>
        </c:if>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Operationname"/></td>
            <td style="width: 50%;text-align: center">${operation.nameOperation}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Dateoperation"/></td>
            <td style="width: 50%;text-align: center">${operation.dateOperation}</td>
        </tr>

        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Complexity"/></td>
            <td style="width: 50%;text-align: center">${operation.complexityEnum}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Status"/></td>
            <td style="width: 50%;text-align: center">${operation.operationStatus}</td>
        </tr>
        </tbody>
    </c:if>


    <%--Medicament--%>
    <c:if test="${medicament != null}">
        <thead>
        <tr>
            <th colspan="2" style="text-align: center"><fmt:message key="healingpatientinfo.Medicament"/></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td style="width: 50%;text-align: center">
                <c:if test="${user.userRole eq 'DOCTOR' or user.userRole eq 'NURSE'}">
                    <c:if test="${medicament.medicamentStatus eq 'NOT_DONE'}">
                        <input class="btn btn-success" type="button"
                               value="<fmt:message key="healingpatientinfo.Executemedicament"/>"
                               onClick='location.href="ExecuteMedicament?medicamentId=${medicament.medicamentId}&healingId=${healing.healingId}"'>
                    </c:if>
                </c:if>
            </td>

            <c:if test="${user.userRole eq 'DOCTOR'}">
                <td style="width: 50%;text-align: center">
                    <input class="btn btn-danger" type="button"
                           value="<fmt:message key="healingpatientinfo.Updatemedicament"/>"
                           onClick='location.href="UpdateMedicament?medicamentId=${medicament.medicamentId}"'>
                </td>
            </c:if>
        </tr>

        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Medicamentname"/></td>
            <td style="width: 50%;text-align: center">${medicament.nameMedicament}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Type"/></td>
            <td style="width: 50%;text-align: center">${medicament.medicamentEnum}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Use"/></td>
            <td style="width: 50%;text-align: center">${medicament.useMedicament}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Datemedicamentstart"/></td>
            <td style="width: 50%;text-align: center">${medicament.dateStartMedicament}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Datemedicamentend"/></td>
            <td style="width: 50%;text-align: center">${medicament.dateEndMedicament}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Medicamentstatus"/></td>
            <td style="width: 50%;text-align: center">${medicament.medicamentStatus}</td>
            </td>
        </tr>
        </tbody>
    </c:if>

    <%--Procedures--%>
    <c:if test="${procedures != null}">
        <thead>
        <tr>
            <th colspan="2" style="text-align: center"><fmt:message key="healingpatientinfo.Procedures"/></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td style="width: 50%;text-align: center">
                <c:if test="${user.userRole eq 'DOCTOR' or user.userRole eq 'NURSE'}">
                    <c:if test="${procedures.procedureStatus eq 'NOT_DONE'}">
                        <input class="btn btn-success" type="button"
                               value="<fmt:message key="healingpatientinfo.Executeprocedure"/>"
                               onClick='location.href="ExecuteProcedure?procedureId=${procedures.proceduresId}&healingId=${healing.healingId}"'>
                    </c:if>
                </c:if>
            </td>

            <c:if test="${user.userRole eq 'DOCTOR'}">
                <td style="width: 50%;text-align: center">
                    <input class="btn btn-danger" type="button"
                           value="<fmt:message key="healingpatientinfo.Updateprocedur"/>"
                           onClick='location.href="UpdateProcedures?proceduresId=${procedures.proceduresId}"'>
                </td>
            </c:if>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Proceduresname"/></td>
            <td style="width: 50%;text-align: center">${procedures.nameProcedure}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Useprocedure"/></td>
            <td style="width: 50%;text-align: center">${procedures.useProcedure}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Dateproceduresstart"/></td>
            <td style="width: 50%;text-align: center">${procedures.dateStartProcedure}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Dateproceduresend"/></td>
            <td style="width: 50%;text-align: center">${procedures.dateEndProcedure}</td>
        </tr>
        <tr>
            <td style="width: 50%;text-align: center"><fmt:message key="healingpatientinfo.Procedurestatus"/></td>
            <td style="width: 50%;text-align: center">${procedures.procedureStatus}</td>
        </tr>
        </tbody>
    </c:if>
</table>
</body>
</html>