<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,hoagie.Password"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">



<!-- The following XHTML snippet builds a basic nutrition label when accompanied by the
		nutrition.css stylesheet. The code is free, and you may use it as you wish. Crediting the author
		is always appreciated.
		Jonathon Eric Cihlar, January 2007
	-->
<html>      
    <link rel="stylesheet" type="text/css" href="nutrition.css" />
    <table class="nutrition" summary="This table summarizes nutritional information">
            <caption>Nutritional information</caption>
            <tr>
                    <th colspan="2">Nutrition Facts</th>
            </tr>
            <tr id="servings">
                    <td colspan="2">Serving Size 1 cupcake (67g)<br />Servings Per Batch 12</td>
            </tr>
            <tr>
                    <td colspan="2">Amount Per Serving</td>
            </tr>
            <tr id="calories">
                    <td><strong>Calories</strong> 194</td>
                    <td>Calories from Fat 81 (42%)</td>
            </tr>
            <tr>
                    <td></td>
                    <td class="dv">% Daily Value *</td>
            </tr>
            <tr>
                    <td><strong>Total Fat</strong> 9g</td>
                    <td class="dv">14%</td>
            </tr>
            <tr>
                    <td class="sub">Saturated Fat 2g</td>
                    <td class="dv">10%</td>
            </tr>
            <tr>
                    <td class="sub">Monounsaturated Fat 2g</td>
                    <td class="dv"></td>
            </tr>
            <tr>
                    <td class="sub">Polyunsaturated Fat 2g</td>
                    <td class="dv"></td>
            </tr>

            <tr>
                    <td class="sub">Trans Fat 0g</td>
                    <td></td>
            </tr>
            <tr>
                    <td><strong>Cholesterol</strong> 0g</td>
                    <td class="dv">0%</td>
            </tr>
            <tr>
                    <td><strong>Sodium</strong> 160mg</td>
                    <td class="dv">7%</td>
            </tr>
            <tr>
                    <td><strong>Potassium</strong> 80mg</td>
                    <td class="dv">2%</td>
            </tr>
            <tr>
                    <td><strong>Total Carbohydrate</strong> 29g</td>
                    <td class="dv">10%</td>
            </tr>
            <tr>
                    <td class="sub">Dietary Fiber 2g</td>
                    <td class="dv">8%</td>
            </tr>
            <tr>
                    <td class="sub">Sugars 18g</td>
                    <td></td>
            </tr>
            <tr>
                    <td><strong>Protein</strong> 2g</td>
                    <td class="dv">4%</td>
            </tr>
            <tr id="minerals">
                    <td>Vitamin A</td>
                    <td class="dv">1%</td>
            </tr>
            <tr>
                    <td>Vitamin C</td>
                    <td class="dv">0%</td>
            </tr>
            <tr>
                    <td>Calcium</td>
                    <td class="dv">4%</td>
            </tr>
            <tr>
                    <td>Iron</td>
                    <td class="dv">7%</td>
            </tr>
            <tr>
                    <td id="disclaimer" colspan="2">
                            * The Percent Daily Values are based on a 2,000 calorie diet, so your values may change depending on your calorie needs.
                            The values here may not be 100% accurate because the recipes have not been professionally evaluated nor have they been evaluated by the U.S. FDA.	
                    </td>
            </tr>
    </table>
</html>