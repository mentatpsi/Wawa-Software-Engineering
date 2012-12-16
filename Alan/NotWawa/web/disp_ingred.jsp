<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,hoagie.HoagieIngredients"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="/includes/sessionTracker.jsp"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display all Ingredients</title>
    </head>
    <body>
        <a href="admin.jsp">Return</a><br/>

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
