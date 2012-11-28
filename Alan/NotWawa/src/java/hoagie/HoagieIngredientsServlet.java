/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoagie;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alan
 */
@WebServlet(name="HoagieIngredientsServlet", urlPatterns="/add_ingred")
public class HoagieIngredientsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String message = "default";
    // Injected DAO EJB:
    @EJB HoagieDao hoagieDao;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 
        
        request.setAttribute("message", message);
        request.getRequestDispatcher("/add_ingred.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle a new hoagie:
        String name = request.getParameter("name");
        //convert the rest to ints
        int calories = Integer.parseInt(request.getParameter("calories"));
        int fatCal = Integer.parseInt(request.getParameter("fatCal"));
        int totFat = Integer.parseInt(request.getParameter("totFat"));
        int satFat = Integer.parseInt(request.getParameter("satFat"));
        int polyFat = Integer.parseInt(request.getParameter("polyFat"));
        int transFat = Integer.parseInt(request.getParameter("transFat"));
        int cholesterol = Integer.parseInt(request.getParameter("cholesterol"));
        int sodium = Integer.parseInt(request.getParameter("sodium"));
        int potassium = Integer.parseInt(request.getParameter("potassium"));
        int carbs = Integer.parseInt(request.getParameter("carbs"));
        int fiber = Integer.parseInt(request.getParameter("fiber"));
        int sugars = Integer.parseInt(request.getParameter("sugars"));
        int protein = Integer.parseInt(request.getParameter("protein"));
        
        if (name != null){
            HoagieIngredients h;
            h = new HoagieIngredients(name, calories, fatCal, totFat,
                    satFat, polyFat, transFat, cholesterol, sodium,
                    potassium, carbs, fiber, sugars, protein);
            hoagieDao.persistIngredients(h);
            message = "Successfully wrote " + name + " to the database!";
        }
        // Display the list of guests:
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
