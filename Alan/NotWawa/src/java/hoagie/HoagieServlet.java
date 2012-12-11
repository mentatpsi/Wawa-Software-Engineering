package hoagie;
 
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name="HoagieServlet", urlPatterns={"/add_hoagie", "/disp_hoagie"})
public class HoagieServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
    // Injected DAO EJB:
    @EJB HoagieDao hoagieDao;
    

 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // setup stream to write to page
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String display = request.getParameter("display");
        
        // Display the list of hoagies:
        if (display != null){
            request.setAttribute("hoagies", hoagieDao.getAllHoagies());
            request.getRequestDispatcher("/select_hoagie.jsp").forward(request, response);
        }else{
            // route to add_hoagie.jsp
            request.getRequestDispatcher("/add_hoagie.jsp").forward(request, response);
        }
    }
 
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // setup stream to write to page
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Handle a new hoagie:
        String name = request.getParameter("name");
        
        //out.println(name);
        if (name != null){
            // persist hoagie
            hoagieDao.persist(new Hoagie(name));

            // we just persisted a hoagie, send it to the hoagieMapServlet
            // to add ingredients to the hoagie
            
            //get parameter
            String hName;
            hName = request.getParameter("name");
            //out.println(hName);
            
            //get the hoagie from the db
            Hoagie myHoagie = hoagieDao.getHoagieByName(hName);
            
            //grab its ID
            String hid = Integer.toString((int) myHoagie.getId());
            
            //out.println(hid);
            
            //pass the hoagie id to the map servlet (which calls addHoagieMap.jsp)
            request.getRequestDispatcher("/addHoagieMap?hId="+hid).forward(request, response);
        }
        
        // Display the list of guests:
        //doGet(request, response);
        
    }
}