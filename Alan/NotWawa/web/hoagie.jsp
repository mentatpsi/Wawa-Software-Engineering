<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,hoagie.Hoagie"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>JPA Guest Book Web Application Tutorial</title>
    </head>
 
    <body>
        <form method="POST" action="hoagie">
            Name: <input type="text" name="name" />
            <input type="submit" value="Add" />
        </form>
        <hr><ol> <%
            @SuppressWarnings("unchecked") 
            List<Hoagie> hoagies = (List<Hoagie>)request.getAttribute("hoagies");
            if (hoagies != null) {
                for (Hoagie hoagie : hoagies) { %>
                    <li> <%= hoagie %> </li> <%
                }
            } %>
        </ol><hr>
 
     
     </body>
 </html>