<%-- 
    Document   : addHoagie
    Created on : Nov 19, 2012, 9:24:46 PM
    Author     : Alan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Add a new Hoagie</h2>
        <form method="POST" action="hoagie">
            Name: <input type="text" name="name" /> <br/>
            Calories: <input type="text" name="cal" /> <br/>
            Fat Calories: <input type="text" name="fatCal" /> <br/>
            Total Fat: <input type="text" name="totFat" /> <br/>
            Sat Fat: <input type="text" name="satFat" /> <br/>
            Trans Fat: <input type="text" name="transFat" /> <br/>
            Cholesterol: <input type="text" name="chol" /> <br/>
            Sodium: <input type="text" name="sodium" /> <br/>
            Carbs: <input type="text" name="carb" /> <br/>
            Fiber: <input type="text" name="fiber" /> <br/>
            Sugars: <input type="text" name="sugars" /> <br/>
            Protein: <input type="text" name="protein" /> <br/>
            VitA: <input type="text" name="vitA" /> <br/>
            VitC: <input type="text" name="vitC" /> <br/>
            Calcium: <input type="text" name="calcium" /> <br/>
            Iron: <input type="text" name="iron" /> <br/>
            <input type="submit" value="Add" />
        </form>
    </body>
</html>
