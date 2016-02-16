<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>All</title>
    <jsp:include page="../head.jsp"/>
</head>
<body>
<table width="600px">
    Technical Test CRM
    <tr>
        <td><b>Contacts:</b></td>
    </tr>
    <c:forEach var="contact" items="${contacts}">
        <tr>
            <td><a href="/contactEdit?id=${contact.id}">${contact.firstName} ${contact.lastName}</a></td>
        </tr>
    </c:forEach>
</table>
<form:form action="contactEdit" method="get">
    <input type="submit" value="Add Contact">
</form:form>
</body>
</html>