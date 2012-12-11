<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,hoagie.HoagieIngredients"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Ingredients</title>
    </head>
    <body>
        <a href="admin.jsp">Return</a><br/>
        <h2>Add Ingredients</h2>
 
        <form method="POST" action="addHoagieMap">
            <table border="0">
                <colgroup>
                    <col span="1" style=" width: 150px;">
                    <col span="1" style=" width: 150px;">
                </colgroup>
         
                <!-- (1)The hoagie ID is passed into this page (by AddHoagieMapServlet)
                     (2)The list of ingredients needs to be pulled from the db and dynamically displayed here
                        like the input box below named "1"
                     (3)Once submitted, the servlet only grabs those fields with entries, and persists them.
                        See the servlet AddHoagieMapServlet.java for details.
                -->
                
                <tr><td></td> <td><input type="hidden" name="hoagie_id" value ="<%=request.getParameter("hId") %>"></td></tr>
            <%= request.getParameter("hId") %>
                <%
            @SuppressWarnings("unchecked") 
            List<HoagieIngredients> ingredients;
            ingredients = (List<HoagieIngredients>)request.getAttribute("ingredients");
            if (ingredients != null) {
                for (HoagieIngredients ingredient : ingredients) { %>
                <tr><td><%=ingredient.getName()%></td><td><input type="text" name="<%=ingredient.getId()%>" size="4" value="0"> </td></tr>
                    <% }
            } %>

             
                
               
                <tr colspan ="2"><td><input type="submit" value="Add" /></td></tr> 
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

