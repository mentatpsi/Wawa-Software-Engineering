package hoagie;
 
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/hoagie")
public class HoagieServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
    // Injected DAO EJB:
    @EJB HoagieDao hoagieDao;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Display the list of guests:
        //request.setAttribute("hoagies", hoagieDao.getAllHoagies());
        request.getRequestDispatcher("/hoagie.jsp").forward(request, response);
    }
 
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Handle a new guest:
        String name = request.getParameter("name");
        if (name != null)
            hoagieDao.persist(new Hoagie(name));
 
        // Display the list of guests:
        doGet(request, response);
    }
}