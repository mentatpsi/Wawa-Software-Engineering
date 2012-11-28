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
        <h2>Add Ingredients</h2>
        <form method="POST" action="add_ingredients">
            <table border="0">
                <colgroup>
                    <col span="1" style=" width: 150px;">
                    <col span="1" style=" width: 150px;">
                </colgroup>
                <tr><td>Name</td> <td><input type="text" name="name"></td></tr>
                <tr><td>Calories</td> <td><input type="text" name="calories"></td></tr>
                <tr><td>Calories from Fat</td><td><input type="text" name="fatCal"></td></tr>
                <tr><td>Total Fat(g) </td> <td><input type="text" name="totFat"></td></tr>
                <tr><td>Saturated Fat(g) </td> <td><input type="text" name="satFat"></td></tr>
                <tr><td>Polyunsaturated Fat(g) </td> <td><input type="text" name="polyFat"></td></tr>
                <tr><td>Trans Fat(g) </td> <td><input type="text" name="transFat"></td></tr>
                <tr><td>Cholesterol(g) </td> <td><input type="text" name="cholesterol"></td></tr>
                <tr><td>Sodium(mg) </td> <td><input type="text" name="sodium"></td></tr>
                <tr><td>Potassium(mg) </td> <td><input type="text" name="potassium"></td></tr>
                <tr><td>Total Carbs(g) </td> <td><input type="text" name="carbs"></td></tr>
                <tr><td>Fiber(g) </td> <td><input type="text" name="fiber"></td></tr>
                <tr><td>Sugars(g) </td> <td><input type="text" name="sugars"></td></tr>
                <tr><td>Protein(g)</td> <td> <input type="text" name="protein" ></td></tr>
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
