<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,hoagie.Password"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="/includes/sessionTracker.jsp"%> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <title>Not Wawa Login</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form method="POST" action="login">
            <table border="0">
                <colgroup>
                    <col span="1" style=" width: 150px;">
                    <col span="1" style=" width: 150px;">
                </colgroup>
                <tr><td>UserName</td> <td><input type="text" name="user"></td></tr>
                <tr><td>Password</td> <td><input type="password" name="password"></td></tr>
                <tr colspan ="2"><td><input type="hidden" name="process" value="login" /></td></tr>
                <tr colspan ="2"><td><input type="submit"  value="Login" <c:if test='${isLoggedIn}'> disabled </c:if> /></td></tr>
            </table>
        </form>
        
        <%-- Print message if user already logged in--%>    
        <c:set var="hasMessage" value="${not empty requestScope.message}"/>
        <c:if test='${isLoggedIn}'>
            <hr>
            <c:out value="User already logged in!" />
            <hr>
        </c:if>

        <%-- Print passed-in message from servlet --%>
        <c:if test="${hasMessage}">
            <hr>
            <c:out value="${requestScope.message}" />
            <hr>
        </c:if>
            
            
    
        
    </body>
</html>
