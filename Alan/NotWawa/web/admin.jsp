<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,hoagie.HoagieIngredients"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">



<html style=" padding:0; margin:auto; height:100%; min-height:100%; width: 95%;">
    <head>
        <title>JPA Guest Book Web Application Tutorial</title>
    </head>
 
    <body bgcolor="white"  style="padding:0; margin:auto; height:100%; min-height:100%; width: 95%;">
        <%
            @SuppressWarnings("unchecked") 
            String message = (String)request.getAttribute("message");
            if (message != null) { %>
                <h2>Welcome, <%= message %>, to the Admin Page! </h2>  <%
                }
        %>
            
        <a href="add_ingred">Add New Ingredient</a><br/>
        <a href="disp_ingred">Display All Ingredients</a><br/>
        <a href="add_hoagie">Add New Hoagie</a><br/>
        <a href="login.jsp">Login</a> (remove from here)<br/> 
        <a href="addUser.jsp">Add User</a><br/>
        <a href="filldb.jsp">Populate the database</a><br/>
        <a href="select_hoagie.jsp">Select a hoagie</a><br/>
    </body>
</html>