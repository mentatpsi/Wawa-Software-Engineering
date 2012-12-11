/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoagie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author g0D
 */
@WebServlet(name = "AddHoagieMapServlet", urlPatterns = {"/addHoagieMap"})
public class AddHoagieMapServlet extends HttpServlet {

    @EJB HoagieDao hoagieDao;
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        // Handle a new hoagie:
        

        
        /*if (id > 0){
            HoagieIngredients h;
            h = new HoagieIngredients(name, calories, fatCal, totFat,
                    satFat, polyFat, transFat, cholesterol, sodium,
                    potassium, carbs, fiber, sugars, protein);
            hoagieDao.persistIngredients(h);
            message = "Successfully wrote " + name + " to the database!";
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);    
        
        // pass the page the ingredients
        request.setAttribute("ingredients", hoagieDao.getAllIngredients());  
        
        // route the request to the mapping page
        request.getRequestDispatcher("/addHoagieMap.jsp").forward(request, response);
    
    }
    
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        // setup stream to write to page
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();        
        
        // get the parameter
        String param = request.getParameter("parameter");
        
        // if no parameter, just dump into a GET
        // for instance, when /add_hoagie links to this servlet
        // it's via POST, passing the hoagie id (hId)        
        if (request.getParameter("hoagie_id") != null){

            //we are storing the maps

            //get the hoagie_id
            int hid = Integer.parseInt(request.getParameter("hoagie_id"));
            //out.println(id);

            // get all parameter names
            Enumeration paramNames = request.getParameterNames();

            // begin response to screen
            out.println("Hoagie added!<br/>");
            out.println("Hoagie_id = " + hid +"<br/>");

            //loop through parameters
            while(paramNames.hasMoreElements()){
                //get next element in the enumeration
                String currentParamName = (String) paramNames.nextElement();

                //hack to skip first parameter name (string), the rest are ints
                if (! "hoagie_id".equalsIgnoreCase(currentParamName)){
                    // get values
                    int ingredientId = Integer.parseInt(currentParamName);
                    int quantity = Integer.parseInt(request.getParameter(currentParamName));

                    // create the object
                    HoagieMap hoagieMap = new HoagieMap(hid, ingredientId, quantity);

                    //Only persist if the quantity > 0
                    if (quantity > 0){
                        hoagieDao.persistHoagieMap(hoagieMap);
                        out.println("ingredientID = " + currentParamName + ", quantity = " + request.getParameter(currentParamName) +"<br/>");
                    } 
                } 
            }
            // route the request to the hoagie display page
            request.getRequestDispatcher("/DisplayHoagieServlet?hId=" + request.getParameter("hoagie_id")).forward(request, response);
            
        }else{
            // just pass through if we aren't storing the map objects
            doGet(request, response);
            
        }

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
