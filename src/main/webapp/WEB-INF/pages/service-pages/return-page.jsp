<%@include file="init.jsp" %>

<portlet:actionURL name="main-page" var="mainpageURL"/>

<br>
You could return to
<aui:form name="main-page" action="<%=mainpageURL %>" method="post">
    <aui:button type="submit" value="main page"/>
</aui:form>
