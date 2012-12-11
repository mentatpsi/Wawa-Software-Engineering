<%@page import="hoagie.HoagieIngredients"%>
<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Hoagie</title>
    </head>
    <body>
        <h1><c:out value= "${param.hoagieName}" /></h1>
                      <hr><ol> <%
            @SuppressWarnings("unchecked") 
            List<HoagieIngredients> ingredients;
            ingredients = (List<HoagieIngredients>)request.getAttribute("ingredients");
            if (ingredients != null) {
                for (HoagieIngredients ingredient : ingredients) { %>
                    <%=ingredient%>
                    <% }
            } %>
            
        
    </body>
</html>
