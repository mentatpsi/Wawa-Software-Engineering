<%-- 
    Document   : addHoagie
    Created on : Nov 19, 2012, 9:24:46 PM
    Author     : Alan
--%>

<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,hoagie.Hoagie"%>

<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Add a new Hoagie</h2>
        <form action="hoagie" method="post">
            Name: <input type="text" name="name" /> <br/>
            <input type="submit" value="Add" />
        </form>
        
        
    </body>
</html>
