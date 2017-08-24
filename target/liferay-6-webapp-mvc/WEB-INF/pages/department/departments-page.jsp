<%@include file="/WEB-INF/pages/service-pages/init.jsp" %>

<portlet:actionURL name="transfer-create-department" var="transfercreatedepartmentURL"/>

<portlet:actionURL name="show-cooperators" var="showcooperatorsURL"/>

<portlet:actionURL name="transfer-edit-department" var="transfereditdepartmentURL"/>

<portlet:actionURL name="delete-department" var="deletedepartmentURL"/>

<c:choose>
    <c:when test="${requestScope.departmentsList == null ||
                requestScope.departmentsList.size() == 0}">
        <h3>
            There are no departments here!
        </h3>
    </c:when>
    <c:otherwise>
        <h2>
            The departments are next:
        </h2>
        <br>
        <table aria-readonly="true">
            <tr>
                <th>Name</th>
                <th>Operations</th>
            </tr>

            <c:forEach var="department" items="${requestScope.departmentsList}">
                <tr>
                    <td>${department.name}</td>
                    <td>
                        <aui:form name="delete-department" action="<%=deletedepartmentURL %>" method="post">
                            <aui:input type="hidden" name="departmentOperationName"
                                       value="${department.name}"/>

                            <aui:button type="submit" value="delete"/>
                        </aui:form>
                    </td>
                    <td>
                        <aui:form name="transfer-edit-department" action="<%=transfereditdepartmentURL %>"
                                  method="post">

                            <aui:input type="hidden" name="departmentOperationName"
                                       value="${department.name}"/>

                            <aui:button type="submit" value="edit"/>
                        </aui:form>
                    </td>
                    <td>
                        <aui:form name="show-cooperators" action="<%=showcooperatorsURL %>" method="post">
                            <aui:input type="hidden" name="departmentOperationName"
                                       value="${department.name}"/>

                            <aui:button type="submit" value="show cooperators"/>
                        </aui:form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<h2>
    You can
    <aui:form name="transfer-create-department" action="<%=transfercreatedepartmentURL %>" method="post">
        <aui:button type="submit" value="add new department"/>
    </aui:form>
</h2>
