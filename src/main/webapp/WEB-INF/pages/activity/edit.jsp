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
            <jsp:include page="../contact/all.jsp">
                <jsp:param name="contacts" value="contacts"/>
            </jsp:include>
        </td>
        <td>
            <jsp:include page="fields.jsp">
                <jsp:param name="currentActivity" value="currentActivity"/>
            </jsp:include>
        </td>
        <c:choose>
            <c:when test="${not empty currentActivity.id}">
                <td>
                    <form:form action="/deleteActivity" method="post" modelAttribute="currentActivity"
                               onSubmit="return confirm('Are you sure?')">
                        <form:hidden path="id"/>
                        <form:hidden path="version"/>
                        <input type="submit" value="Delete activity">
                    </form:form>
                </td>
            </c:when>
        </c:choose>
    </tr>
</table>
</body>
</html>

