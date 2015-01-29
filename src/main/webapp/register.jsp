<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration</title>
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
</head>
<body>
<form:form commandName="user" method="POST" action="/register.html" >
    <h1>Enter your credentials</h1>
    <a href="/login.html" onclick="location.href='login.html'">Authorization</a>
    <table>
        <tr>
            <td><form:label path="username">Username</form:label></td>
            <td><form:input path="username" /></td>
            <td><form:errors path="username" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input path="password" /></td>
            <td><form:errors path="password" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
