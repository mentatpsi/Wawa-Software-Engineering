<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,hoagie.Password"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Not Wawa Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="EncryptServlet">
            <table border="0">
                <colgroup>
                    <col span="1" style=" width: 150px;">
                    <col span="1" style=" width: 150px;">
                </colgroup>
                <tr><td>UserName</td> <td><input type="text" name="user"></td></tr>
                <tr><td>Password</td> <td><input type="password" name="password"></td></tr>
                <tr colspan ="2"><td><input type="hidden" name="process" value="login" /></td></tr>
                <tr colspan ="2"><td><input type="submit"  value="Add" /></td></tr>
            </table>
        </form>
        
        <hr><%
            @SuppressWarnings("unchecked") 
            String message = (String)request.getAttribute("message");
            if (message != null) { %>
                     <%= message %>  <%
                }
             %>
        <hr>
    </body>
</html>
