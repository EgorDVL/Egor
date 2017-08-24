<%@include file="/WEB-INF/pages/service-pages/init.jsp" %>

<portlet:actionURL name="edit-cooperator" var="editcooperatorURL"/>

<aui:form name="addDetails" action="<%=editcooperatorURL %>" method="post">
    <aui:input type="hidden" name="oldCooperatorEmail"
               value="${requestScope.oldCooperatorEmail}"/>

    <aui:input label="Name:" type="text" placeholder="Enter from 5 to 19 Symbols"
               name="name"
               value='${requestScope.name}'/>
    <label class="error-message">
        <c:out value='${requestScope.errorName}'/>
    </label>
    <br>

    <aui:input label="Surname:" type="text" placeholder="Enter from 5 to 19 Symbols"
               name="surname"
               value='${requestScope.surname}'/>
    <label class="error-message">
        <c:out value='${requestScope.errorSurname}'/>
    </label>
    <br>

    <aui:input label="Email:" type="text" placeholder="Enter Email like example@m.com"
               name="email"
               value='${requestScope.email}'/>
    <label class="error-message">
        <c:out value='${requestScope.errorEmail}'/>
    </label>
    <br>

    <aui:input label="Registration Date:" type="text"
               placeholder="Enter Date in YYYY-MM-DD Format"
               name="cooperatorRegDate"
               value='${requestScope.cooperatorRegDate}'/>
    <label class="error-message">
        <c:out value='${requestScope.errorRegDate}'/>
    </label>

    <aui:button type="submit" value="edit"/>
</aui:form>

