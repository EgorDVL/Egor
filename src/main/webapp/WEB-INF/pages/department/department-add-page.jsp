<%@include file="/WEB-INF/pages/service-pages/init.jsp" %>

<portlet:actionURL name="create-department" var="createdepartmentURL"/>

<hr>
<p>You can add new Department:</p>
<br>
<aui:form name="addDetails" action="<%=createdepartmentURL %>" method="post">
    <aui:input label="Department Name:" type="text" name="name"
               placeholder="Enter from 5 to 29 symbols"
               value='${requestScope.name}'/>

    <label class="error-message">
        <c:out value='${requestScope.errorName}'/>
    </label>

    <aui:button type="submit" value="add new department"/>
</aui:form>
