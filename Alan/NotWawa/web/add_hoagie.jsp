<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,hoagie.Hoagie"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>Add a Hoagie</title>
    </head>
 
    <body>
        <a href="admin.jsp">Return</a><br/>
        <form method="POST" action="add_hoagie">
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