<%@page import="hoagie.HoagieIngredients"%>
<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>
<%@include file="/includes/sessionTracker.jsp"%> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Hoagie</title>
    </head>
    <body bgcolor="black" text="white">
        <html>      
    <link rel="stylesheet" type="text/css" href="nutrition.css" />
    <a href="index.jsp">Return to Main</a><br/>
    <h1><c:out value= "${param.hoagieName}" /></h1>

        <%-- check that the passed-in vals exist --%>
        <c:set var="hasTotals" value="${not empty requestScope.hTotal}"/>
        <c:set var="hasFields" value="${not empty requestScope.fields}"/>
        <c:set var="hasIngredients" value="${not empty requestScope.ingredients}"/>
        
        
        
        <%-- print out the ingredients & totals --%>
        <c:if test="${hasTotals && hasFields && hasIngredients}" >
            <%-- set the variables passed to the page--%>
            <c:set var="total" scope="page" value="${requestScope.hTotal}" />
            <c:set var="ingred" scope="page" value="${requestScope.ingredients}" />
            
            
            <%-- print out all the included ingredients --%>
            <h3>Hoagie Ingredients: </h3>
            <c:forEach var="key" items="${ingred}">
                <c:out value="${key.getName()}"/> <br/>             
            </c:forEach> 
      
            <%-- get the 'total' object's fields, values, and keys--%>
            <h3>Nutritional Totals:</h3>
            <c:set var="fields" scope="page" value="${total.getFields()}" />
            <c:set var="values" scope="page" value="${fields.values()}" />
            <c:set var="keys" scope="page" value="${fields.keySet()}"/>
           
            <%-- loop over the key map and print out totals --%>
       <%-- used for testing, simply prints everything out
            <c:forEach var="key" items="${keys}">
                <c:out value="${key}"/> <c:out value="${fields.get(key)}"/> <br/>             
            </c:forEach> 
       --%>
        </c:if>
      <table class="nutrition" summary="This table summarizes nutritional information" bgcolor="white" text="black">
            <caption>Nutritional information</caption>
            <tr>
                    <th colspan="2">Nutrition Facts</th>
            </tr>
            <tr id="servings">
                    <td colspan="2">Serving Size 1 Hoagie</td>
            </tr>
            <tr>
                    <td colspan="2">Amount Per Serving</td>
            </tr>
           <tr id="calories">
               <td><strong>Calories</strong> <c:out value="${fields.get('Calories')}"/> </td>
                    <td>Calories from Fat -- </td>
            </tr>
            <tr>
                    <td></td>
                    <td class="dv">% Daily Value *</td>
            </tr>
            <tr>
                    <td><strong>Total Fat</strong> <c:out value="${fields.get('Total Fat')}"/></td>
                    <td class="dv">--</td>
            </tr>
            <tr>
                    <td class="sub">Saturated Fat <c:out value="${fields.get('Saturated Fat')}"/></td>
                    <td class="dv">--</td>
            </tr>
            <tr>
                    <td class="sub">Monounsaturated Fat <c:out value="${fields.get('Monounsaturated Fat')}"/>g</td>
                    <td class="dv"></td>
            </tr>
            <tr>
                    <td class="sub">Polyunsaturated Fat <c:out value="${fields.get('Polyunsaturated Fat')}"/>g</td>
                    <td class="dv"></td>
            </tr>

            <tr>
                    <td class="sub">Trans Fat <c:out value="${fields.get('Trans Fat')}"/>g</td>
                    <td></td>
            </tr>
            <tr>
                    <td><strong>Cholesterol</strong> <c:out value="${fields.get('Cholesterol')}"/>g</td>
                    <td class="dv">--</td>
            </tr>
            <tr>
                    <td><strong>Sodium</strong> <c:out value="${fields.get('Sodium')}"/>mg</td>
                    <td class="dv">--</td>
            </tr>
            <tr>
                    <td><strong>Potassium</strong> <c:out value="${fields.get('Potassium')}"/>mg</td>
                    <td class="dv">--</td>
            </tr>
            <tr>
                    <td><strong>Total Carbohydrate</strong> <c:out value="${fields.get('Carbohydrates')}"/>g</td>
                    <td class="dv">--</td>
            </tr>
            <tr>
                    <td class="sub">Dietary Fiber <c:out value="${fields.get('Fiber')}"/>g</td>
                    <td class="dv">--<td>
            </tr>
            <tr>
                    <td class="sub">Sugars <c:out value="${fields.get('Sugars')}"/>g</td>
                    <td></td>
            </tr>
            <tr>
                    <td><strong>Protein</strong> <c:out value="${fields.get('Protein')}"/>g</td>
                    <td class="dv">--</td>
            </tr>
            <tr id="minerals">
                    <td>Vitamin A</td>
                    <td class="dv">--</td>
            </tr>
            <tr>
                    <td>Vitamin C</td>
                    <td class="dv">--</td>
            </tr>
            <tr>
                    <td>Calcium</td>
                    <td class="dv">--</td>
            </tr>
            <tr>
                    <td>Iron</td>
                    <td class="dv">--</td>
            </tr>
            <tr>
                    <td id="disclaimer" colspan="2">
                            * The Percent Daily Values are based on a 2,000 calorie diet, so your values may change depending on your calorie needs.
                            The values here may not be 100% accurate because the recipes have not been professionally evaluated nor have they been evaluated by the U.S. FDA.	
                    </td>
            </tr>
       </table>      

    </body>
</html>
