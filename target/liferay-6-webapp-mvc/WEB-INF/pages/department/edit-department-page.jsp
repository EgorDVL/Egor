<%@include file="/WEB-INF/pages/service-pages/init.jsp" %>

<portlet:actionURL name="edit-department" var="editdepartmentURL"/>

<h2>Edit The Department:</h2>
<p>

    <aui:form name="edit-department" action="<%=editdepartmentURL %>" method="post">

        <aui:input label="Enter new Department Name:"
                   type="text" placeholder="Enter from 5 to 29 symbols"
                   name="name"
                   value='${requestScope.name}'/>
        <label class="error-message">
            <c:out value='${requestScope.errorName}'/>
        </label>
        <aui:input type="hidden" name="oldDepartmentName"
                   value="${requestScope.oldDepartmentName}"/>

        <aui:button type="submit" value="edit"/>
    </aui:form>
</p>

