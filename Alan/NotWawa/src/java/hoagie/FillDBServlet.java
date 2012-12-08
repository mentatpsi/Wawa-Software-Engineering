/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoagie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Scandellous
 */

 
@WebServlet(name="FillDBServlet", urlPatterns="/filldb")
public class FillDBServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private boolean filled = false;
 
    String message = "default";
    // Injected DAO EJB:
    @EJB HoagieDao hoagieDao;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("message", message);
        request.getRequestDispatcher("/filldb.jsp").forward(request, response);
    }
 
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String fileName = "/WEB-INF/ingredients.csv";// Ingredients file
        ServletContext context = getServletContext();
        InputStream streamIngredients = context.getResourceAsStream(fileName);
        if (false == filled) 
        {
            InputStreamReader isrIngredients = new InputStreamReader(streamIngredients);
            BufferedReader readerIngredients = new BufferedReader(isrIngredients);
            String text = "";
            
            //fills the Database with Ingredients
            while ((text = readerIngredients.readLine()) != null) 
            {
                String[] strings = text.split(",");
                HoagieIngredients ingredient= new HoagieIngredients(strings[0],
                        Integer.parseInt(strings[1]), 
                        Integer.parseInt(strings[2]), 
                        Integer.parseInt(strings[3]),
                        Integer.parseInt(strings[4]),
                        Integer.parseInt(strings[5]), 
                        Integer.parseInt(strings[6]), 
                        Integer.parseInt(strings[7]),
                        Integer.parseInt(strings[8]));
                hoagieDao.persistIngredients(ingredient);

            }
            streamIngredients.close();
            //fills the Database with hoagies by reading Hoagie.csv file
            fileName = "/WEB-INF/Hoagie.csv";
            text = "";
            InputStream streamHoagie = context.getResourceAsStream(fileName);
            InputStreamReader isrHoagie = new InputStreamReader(streamHoagie);
            BufferedReader readerHoagie = new BufferedReader(isrHoagie);
            while ((text = readerHoagie.readLine()) != null) 
            {
                String[] strings = text.split(",");
                Hoagie hoagie= new Hoagie(strings[0]);
                hoagieDao.persist(hoagie);

            }
            filled = true;
            streamHoagie.close();
        }
        message = "!!!The database has been populated!!!";
        doGet(request, response);
    }
}

