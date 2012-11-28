<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,hoagie.HoagieIngredients"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html style=" padding:0; margin:auto; height:100%; min-height:100%; width: 95%;">
    <head>
        <title>JPA Guest Book Web Application Tutorial</title>
    </head>
 
    <body bgcolor="white"  style="padding:0; margin:auto; height:100%; min-height:100%; width: 95%;">
        
        <div type="items"style="background-color:tan; width:33%; height:75%; float:left">
            <select style= "min-width:100px;width:60% " name="FOODS" size="12">
                <option disabled>Cheeses</option>
            </select>
        </div>
        
        <div style="background-color:lightblue; width:67%; height:100%; float:right">               
            <!--NUTRITION INFORMATION-->
            <br>
            <div style="height:25%; min-width:280px; width:60%; background-color:#F0F0F0  ; padding: 4px; border : solid 4px #E0E0E0 ;  margin:auto;  ">
                Ingredient Name<br/>
                ID #<br/>
                Status: "Enable/Disabled"
            </div>

            <!--Input Boxes-->
            <div style="border : solid 4px #E0E0E0 ; background : #F0F0F0 ; padding : 4px; bottom:-33px;  min-width:280px; width:60%; height : 25%; overflow : auto; margin:auto">
                <table border="1" style="min-width: 100%">
                    
                    <colgroup>
                        <col span="1" style=" width: 50%;">
                        <col span="1" style=" width: 50%;">
                    </colgroup>
                    <tr><td>Calories</td> <td><input type="text" value="Cal_Val" name="lastname" style="width: 100%; height: 90%; float:right"></td></tr>
                    <tr><td>Calories from Fat</td><td><input type="text" value="FatCal_Val"name="lastname"style="width: 100%; height: 90%;float:right"></td></tr>
                    <tr><td> Total Fat </td> <td><input type="text"value="TotFat_Val" name="lastname"style="width: 100%;height: 90%; float:right"></td></tr>
                    <tr><td>Sodium </td> <td><input type="text"value="Na_Val" name="lastname"style="width: 100%; height: 90%;float:right"></td></tr>
                    <tr><td>Total Carbs </td> <td><input type="text" value="TotCarb_Val"name="lastname"style="width: 100%; height: 90%;float:right"></td></tr>
                    <tr><td>Protein</td> <td> <input type="text" value="Protein_Val"name="lastname"style="width: 100%;height: 90%; float:right"></td></tr>
                </table>   
            </div>

            <!--BUTTONS-->
            <div style="height:20%;  min-width:280px; width:60%; background-color:#F0F0F0 ; margin:auto ; padding : 4px;border : solid 4px #E0E0E0 ; margin-left:auto;margin-right:auto">
                <br/>
                
                <button type="button" onclick="alert('enable')"> ENABLE</button>
                <button type="button" onclick="alert('saved')">Apply</button>
                <button type="button" onclick="alert('disabled')">DISABLE</button>          
                <button type="button" onclick="alert('reload table')">reload</button>  
            </div>   
        </div>
            
        <div style="background-color:gray; width:33%; height:25%; float:left">
            <form method="POST" action="guest">
            Name: <input type="text" name="name" /><br>
            Subject: <input type="text" name="name" />
            <input type="submit" value="Add" />
            </form>
        </div>
    </body>
</html>