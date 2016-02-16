<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form method="post" action="/activitySaveOrUpdate" modelAttribute="currentActivity">
    <form:hidden path="id"/>
    <form:hidden path="contact.id"/>
    <form:hidden path="version"/>
    <table>
        <tr>
            <td>
                <table>
                    <tr>
                        <td>Contact</td>
                        <td>${currentActivity.contact.firstName} ${currentActivity.contact.lastName}</td>
                    </tr>
                    <tr>
                        <td>Subject *</td>
                        <td><form:input path="title"/></td>
                        <td><form:errors path="title" cssClass="error"/></td>
                    </tr>
                    <tr>
                    <%--    <td>DueDate</td>
                        <td><form:input path="dueDate" id="dueDate"/></td>--%>
                    </tr>
                    <tr>
                        <td>Type</td>
                        <td>
                        <select name="typeId" id="typeId">
                            <c:forEach items="${types}" var="type">
                                <option value="${type.id}" ${type.id ==  currentActivity.type.id? 'selected' : ''}>${type.name}</option>
                            </c:forEach>
                        </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Notes</td>
                        <td><form:textarea path="notes"/></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save">
            </td>
        </tr>
    </table>
</form:form>
<script>
    $(document).ready(function () {
        $(function () {
            $("#dueDate ").datepicker({
                dateFormat: 'dd/mm/yy'
            });
        });
    });
</script>