<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
 <form action="/j_spring_security_check" method="POST" >
 <h1>Enter your credentials</h1>

 <table>
     <tr>
         <td>Username:</td>
         <td><input type="text" name="j_username"/></td>
     </tr>
     <tr>
         <td>Password</td>
         <td><input type="password" name="j_password"/></td>
     </tr>
     <tr>
         <td colspan="2" align="left"><input type="submit" value="Login"/> </td>
         <a href="/register.html" onclick="location.href='register.html'">Registration</a>
     </tr>
 </table>
</form>
 <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
     <font color="red">
         <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
         Try again or register <br/><br/>
     </font>
 </c:if>

</body>
</html>
