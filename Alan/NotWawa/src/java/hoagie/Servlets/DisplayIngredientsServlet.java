package hoagie.Servlets;
 
import hoagie.HoagieDao;
import java.io.IOException;
import javax.ejb.EJB;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 *
 * @author Alan
 */
@WebServlet(name="DisplayIngredientsServlet", urlPatterns="/disp_ingred")
public class DisplayIngredientsServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
    // Injected DAO EJB:
    @EJB HoagieDao hoagieDao;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Display the list of hoagies:
        request.setAttribute("ingredients", hoagieDao.getAllIngredients());
        request.getRequestDispatcher("/disp_ingred.jsp").forward(request, response);
    }
 
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
   
        doGet(request, response);
    }
}