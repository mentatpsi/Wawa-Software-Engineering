<%-- 
    Document   : hoagie
    Created on : Nov 19, 2012, 8:12:46 PM
    Author     : Alan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="hoagieDB" class="hoagie.Hoagie" scope="page" >
  <jsp:setProperty name="bookDB" property="database" value="${bookDBAO}" />
</jsp:useBean>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
