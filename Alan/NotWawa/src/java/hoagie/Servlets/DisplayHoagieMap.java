/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoagie.Servlets;

import hoagie.HoagieDao;
import hoagie.HoagieMap;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alan
 */
@WebServlet(name = "DisplayHoagieMap", urlPatterns = {"/DisplayHoagieMap"})
public class DisplayHoagieMap extends HttpServlet {

    // Injected DAO EJB:
    @EJB HoagieDao hoagieDao;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("here");
        
        // get all the hoagieMaps
        List<HoagieMap> hm = hoagieDao.getAllHoagieMaps();
        
        out.println(hm);
        
        for(HoagieMap h : hm){
            out.println("HoagieMap Id: " + h.getId() + 
                    "Ingredient Id: " + h.getIngredient_id() + 
                    "Hoagie Id: " + h.getHoagie_id() + 
                    "Quantity: " + h.getQuantity());
        }
        
        
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
