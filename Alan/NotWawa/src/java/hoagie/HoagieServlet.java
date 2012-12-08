package hoagie;
 
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
@WebServlet(name="HoagieServlet", urlPatterns={"/add_hoagie", "/disp_hoagie"})
public class HoagieServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
    // Injected DAO EJB:
    @EJB HoagieDao hoagieDao;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Display the list of hoagies:
        if (request.getParameter("display").equalsIgnoreCase("y")){
            request.setAttribute("hoagies", hoagieDao.getAllHoagies());
            request.getRequestDispatcher("/select_hoagie.jsp").forward(request, response);
        }else{
            request.setAttribute("hoagies", hoagieDao.getAllHoagies());
            request.getRequestDispatcher("/addHoagieMap.jsp").forward(request, response);
        }
    }
 
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 

        // Handle a new hoagie:
        String name = request.getParameter("name");
        if (name != null){
            hoagieDao.persist(new Hoagie(name));
        }
        // Display the list of guests:
        doGet(request, response);
        
    }
}