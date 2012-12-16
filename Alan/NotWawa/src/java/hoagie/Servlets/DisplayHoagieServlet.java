/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoagie.Servlets;

import hoagie.Hoagie;
import hoagie.HoagieDao;
import hoagie.HoagieIngredients;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "DisplayHoagieServlet", urlPatterns = {"/DisplayHoagieServlet"})
public class DisplayHoagieServlet extends HttpServlet {

    // Injected DAO EJB:
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayHoagieServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayHoagieServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        //get the hoagie_id that was selected (cast as int)
        int hID = Integer.parseInt(request.getParameter("hId"));
        
        // get hoagie by ID
        Hoagie hoagie = hoagieDao.getHoagiebyId(hID);
        
        // get the Hoagie name
        String name = hoagie.getName();
        
        
        // get all map objects that have the same hoagie id
        List<HoagieIngredients> hIngrs = hoagieDao.getIngrsForHoagie(hID);
        
        //get totals for hoagie
        HoagieIngredients hTotal= hoagieDao.getTotal(hID);
        
        //get all declared fields of hTotal
        Map<String, Integer> field;
        field = hTotal.getFields();
            
        
        
        // pass items to the page
        request.setAttribute("fields", field); // list of fields
        request.setAttribute("ingredients", hIngrs);  //list of ingredients
        request.setAttribute("hTotal", hTotal); // totals
        
        // redirect to the page
        request.getRequestDispatcher("/dispHoagie.jsp?hoagieName=" + name).forward(request, response);

        
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
