
package hoagie.Servlets;

import hoagie.HoagieDao;
import hoagie.Password;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "EncryptServlet", urlPatterns={"/addUser", "/login", "/logout"})
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
        
        // debugging - write to screen
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Define vars
        String password;
        String process;
        String user;
        
        // set default response message
        request.setAttribute("Message", "Please enter a user and password" );
        
        /********************************/
        /* Get the passed-in parameters */
        /********************************/
        user = request.getParameter("user");            //get user
        password = request.getParameter("password");    //get password
        process = request.getParameter("process");      //get method to process
       
        // encrypt the password
        StringBuilder sb = encrypt(password);

        /*******************************/
        /* Handle session              */
        /*******************************/
        //get session if exists, if it doesn't exist, don't create just yet
        HttpSession session = request.getSession(false); 
        if (null == session){ // no session exists
            session = request.getSession(true);         //create session
            session.setAttribute("USER", user);         //set USER
            session.setAttribute("LOGIN", false);       //not logged in yet
        } 
        
        // get session vars
        String sId = session.getId();                  

 
        /***********************/
        /* process the request */
        /***********************/
        if (process.equals("store")){
            //check to see if user already exists
            if (hoagieDao.verifyUserExists(user)){
                request.setAttribute("message", "Username already taken." );
                request.getRequestDispatcher("/addUser.jsp").forward(request, response);
            } else{
                //store the username and hashed password in the db
                hoagieDao.persistUserPass( new Password(user, sb.toString()) );
                request.setAttribute("message", "User" + user + " added Successfully!" );
                request.getRequestDispatcher("/addUser.jsp").forward(request, response);
            }
 
            
           
            
        } else if(process.equals("login")){
            //verify user exists, else return to login
            if (! hoagieDao.verifyUserExists(user)){
                out.println("User doesn't exist!");
                request.setAttribute("message", "User does NOT exist!" );
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }else{
                //verify password, else return to login
                String check;
                check = hoagieDao.getUserPass(user);
                if (check.equals(sb.toString())){
                    // user and pass correct, redirect to admin page
                    session.setAttribute("LOGIN", true);       //set login session to true
                    session.setAttribute("USER", user);
                    request.setAttribute("message", user);
                    request.getRequestDispatcher("/admin.jsp").forward(request, response);
                    
                } else{
                        // wrong password, send back to login screen
                        request.setAttribute("message", "Wrong Password!" );
                        //out.println("Sb:" + sb.toString() + "check: " + check );
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                } 
                
            }
            
            
            
        }
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
        
        //check if user clicked "logout"
        if (request.getParameter("logout").equals("y")){
            HttpSession session = request.getSession(false); 
            
            //make sure a session exists
            if(session != null){
                session.invalidate();
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }
        processRequest(request, response);
    }


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
