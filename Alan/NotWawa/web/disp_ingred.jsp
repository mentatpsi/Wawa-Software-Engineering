<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,hoagie.HoagieIngredients"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="admin.jsp">Return</a><br/>
        <form method="POST" action="disp_ingred">
            <input type="submit" value="Display Ingredients" />
        </form>
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
