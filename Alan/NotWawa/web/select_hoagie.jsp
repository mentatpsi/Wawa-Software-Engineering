<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,hoagie.Hoagie"%>
<jsp:useBean id="fns" class="hoagie.HoagieDao" scope="page"/>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor ="black" text="white">
        <h1>Please Select Hoagie Type</h1>
        
         
        <hr><ol> <%
            @SuppressWarnings("unchecked") 
            List<Hoagie> hoagies = (List<Hoagie>)request.getAttribute("hoagies");
            if (hoagies != null) {
                //create link to nutritionLabel, and pass the hoagie id to it.
                for (Hoagie hoagie : hoagies) { %>
                    <li> <a href="DisplayHoagieServlet?hId=<%= hoagie.getId() %>"><%= hoagie.getName() %> </li> <%
                }
            } %>
        </ol><hr>
    </body>
</html>
