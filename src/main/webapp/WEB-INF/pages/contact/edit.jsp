<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Contact</title>
    <jsp:include page="../head.jsp"/>
</head>
<body>
<table>
    <tr>
        <td>
            <jsp:include page="all.jsp">
                <jsp:param name="contacts" value="contacts"/>
            </jsp:include>
        </td>
        <td>
            <jsp:include page="fields.jsp">
                <jsp:param name="currentContact" value="currentContact"/>
            </jsp:include>
            <c:choose>
                <c:when test="${not empty currentContact.id}">
                <form:form action="/addActivity" method="get" modelAttribute="currentContact">
                    <form:hidden path="id"/>
                    <input type="submit" value="Add Activity">
            </form:form>
            <jsp:include page="../activity/list.jsp">
                <jsp:param name="currentActivities" value="currentActivities"/>
            </jsp:include>
        </c:when>
        </c:choose>
        </td>
        <c:choose>
            <c:when test="${not empty currentContact.id}">
                <td>
                    <form:form action="/deleteContact" method="post" modelAttribute="currentContact"
                               onSubmit="return confirm('Are you sure?')">
                        <form:hidden path="id"/>
                        <form:hidden path="version"/>
                        <input type="submit" value="Delete contact">
                    </form:form>
                </td>
            </c:when>
        </c:choose>

    </tr>
</table>
</body>
</html>

