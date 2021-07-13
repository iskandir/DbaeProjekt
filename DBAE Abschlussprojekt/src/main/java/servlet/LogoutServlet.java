package servlet;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

/**Das Servlet schließt die Session und loggt den Benutzer aus.
 * 
 * @author dennishasselbusch
 *
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
			
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
              
            request.getRequestDispatcher("index.jsp").include(request, response);  
            HttpSession session = request.getSession();  
            session.invalidate();  
            System.out.println("User wurde ausgeloggt!");
            out.close();  
    }  


}
