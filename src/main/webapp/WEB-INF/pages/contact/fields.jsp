<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form method="post" action="/contactSaveOrUpdate" modelAttribute="currentContact">
    <form:hidden path="id"/>
    <form:hidden path="version"/>
    <table>
        <tr>
            <td>
                <table>
                    <tr>
                        <td>Fist Name *</td>
                        <td><form:input path="firstName"/></td>
                        <td><form:errors path="firstName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Email *</td>
                        <td><form:input path="email"/></td>
                        <td><form:errors path="email" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Address1</td>
                        <td><form:input path="address1"/></td>
                    </tr>
                    <tr>
                        <td>Address2</td>
                        <td><form:input path="address2"/></td>
                    </tr>
                    <tr>
                        <td>City:</td>
                        <td><form:input path="city"/></td>
                    </tr>
                    <tr>
                        <td>Post Code</td>
                        <td><form:input path="postCode"/></td>
                    </tr>
                </table>
            </td>
            <td>
                <table>
                    <tr>
                        <td>last Name *</td>
                        <td><form:input path="lastName"/></td>
                        <td><form:errors path="lastName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Telephone</td>
                        <td><form:input path="telephoneNumber"/></td>
                    </tr>
                </table>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save">
            </td>
        </tr>
    </table>
</form:form>