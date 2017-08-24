<%@include file="service-pages/init.jsp" %>

<portlet:actionURL name="show-departments" var="showdepartmentsURL"/>

<h2>This is first page</h2>
<p>
    If you wanna
    <aui:form name="show-departments" action="<%=showdepartmentsURL %>" method="post">
        <aui:button type="submit" value="open departments page"/>
    </aui:form>
</p>

