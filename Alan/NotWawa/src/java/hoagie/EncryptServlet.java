
package hoagie;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EncryptServlet")
public class EncryptServlet extends HttpServlet {

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
    protected StringBuilder encrypt(String pass){
        String password = pass;
        MessageDigest md = null;
        
        try{
            md = MessageDigest.getInstance("SHA-1");
        }catch (NoSuchAlgorithmException nsae) {
            //out.println("Cannot find digest algorithm");
        }
        
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return sb;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String password;
        String process;
        String user;
        
        
        //get user
        user = request.getParameter("user");
        //get password
        password = request.getParameter("password");
        //get method to process (check / persist to db)
        process = request.getParameter("process");
        // set default message
        request.setAttribute("Message", "Please enter a user and password" );
        
        // encrypt the password
        StringBuilder sb = encrypt(password);

        // process the request
        if (process.equals("store")){
            //check to see if user already exists
            if (hoagieDao.verifyUserExists(user)){
                request.setAttribute("Message", "Username already taken." );
                request.getRequestDispatcher("/addUser.jsp").forward(request, response);
            }
            
            //store the hashed password in the db
            Password pass;
            pass = new Password(user, sb.toString());
            hoagieDao.persistUserPass(pass);
            
            request.setAttribute("Message", "User" + user + " added Successfully!" );           
        } else if(process.equals("login")){
            //make sure user exists in db
            if (! hoagieDao.verifyUserExists(user)){
                request.setAttribute("Message", "User does NOT exist!" );
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            //verify password
            StringBuilder check;
            check = hoagieDao.getUserPass(user, sb);
            if (check.toString().equals(sb.toString())){
                request.setAttribute("Message", "User" + user + " exists!" );
            } else{
                request.setAttribute("Message", "Wrong Password!" );
            }  
        }
        
        request.getRequestDispatcher("/addUser.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
