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
        <form method="POST" action="hoagie">
            Name: <input type="text" name="name" />
            Calories: <input type="text" name="cal" />
            Fat Calories <input type="text" name="fatCal" />
            
            <input type="submit" value="Add" />
        </form>
    </body>
</html>
