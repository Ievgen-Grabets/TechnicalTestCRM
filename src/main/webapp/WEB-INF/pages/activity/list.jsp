<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
    <tr>
        <td>Title</td>
        <td>Type</td>
    </tr>
    <c:forEach var="activity" items="${currentActivities}">
        <tr>
            <td><a href="/editActivity?id=${activity.id}">${activity.title}</a></td>
            <td><a href="/editActivity?id=${activity.id}">${activity.type.name}</a></td>
        </tr>
    </c:forEach>
</table>
