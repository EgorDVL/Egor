<%@include file="/WEB-INF/pages/service-pages/init.jsp" %>

<portlet:actionURL name="transfer-add-cooperator" var="transferaddcooperatorURL"/>

<portlet:actionURL name="transfer-edit-cooperator" var="transfereditcooperatorURL"/>

<portlet:actionURL name="delete-cooperator" var="deletecooperatorURL"/>

<c:choose>
    <c:when test="${requestScope.departmentCooperatorsList == null ||
                requestScope.departmentCooperatorsList.size() == 0}">
        <h3>
            There are no cooperators in
            <c:out value="${requestScope.cooperatorsDepartment}"/> Department!
        </h3>
    </c:when>
    <c:otherwise>
        <h2>
            The cooperators of
            <c:out value="${requestScope.cooperatorsDepartment}"/> Department
            are next:
        </h2>
        <br>
        <table aria-readonly="true">
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Email</th>
                <th>Register Date</th>
            </tr>

            <c:forEach var="cooperator" items="${requestScope.departmentCooperatorsList}">
                <tr>
                    <td>${cooperator.name}</td>
                    <td>${cooperator.surname}</td>
                    <td>${cooperator.email}</td>
                    <td>${cooperator.registrationDate}</td>
                    <td>
                        <aui:form name="delete-cooperator" action="<%=deletecooperatorURL %>" method="post">
                            <aui:input type="hidden" name="cooperatorOperationEmail"
                                       value="${cooperator.email}"/>

                            <aui:button type="submit" value="delete"/>
                        </aui:form>
                    </td>
                    <td>
                        <aui:form name="transfer-edit-cooperator" action="<%=transfereditcooperatorURL %>"
                                  method="post">
                            <aui:input type="hidden" name="cooperatorOperationEmail"
                                       value="${cooperator.email}"/>

                            <aui:button type="submit" value="edit"/>
                        </aui:form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<h2>
    You could also
    <aui:form name="transfer-add-cooperator" action="<%=transferaddcooperatorURL %>" method="post">
        <aui:input type="hidden" name="departmentName"
                   value="${requestScope.cooperatorsDepartment}"/>

        <aui:button type="submit" value="add new cooperator"/>
    </aui:form>
</h2>

