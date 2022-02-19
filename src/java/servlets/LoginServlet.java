
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import service.AccountService;

/**
 *
 * @author guryu
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User realuser = (User) session.getAttribute("realuser");
         String logout = request.getParameter("logout");
        
        
        if(logout !=null){   
            session.invalidate();
            request.setAttribute("message", "You have sucessfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
            
        }
        else{
             if(realuser != null)
            {   
                response.sendRedirect("home");
                 return;
                
            }
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
            
        }
        
        
                
         
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userN = request.getParameter("username");
        String passW = request.getParameter("password");
        
        User user = new User(userN, passW);
        HttpSession session = request.getSession();
        
        AccountService as = new AccountService();
        
        if(as.login(userN, passW)== null){
          request.setAttribute("message", "Error: Authentication Failed"); 
          request.setAttribute("user", user);
          getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
          return;
        }
          else{
             request.setAttribute("message", "Message: Authentication Successfull"); 
            session.setAttribute("realuser", user);
            response.sendRedirect("home");
            return;
        }
        
//        if(user.getUsername().equals("") || user.getUsername() == null || user.getPassword().equals("") || user.getPassword() == null)
//        {
//               
//         request.setAttribute("message", "Error: Please Enter Credentials."); 
//            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//       
//    }
//        else
//        {
//               
//        }

    
  
}
}
