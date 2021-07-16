package servlet;

import java.io.IOException;  
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

/**Das Servlet schlieﬂt die Session und loggt den Benutzer aus.
 * 
 * @author dennishasselbusch
 *
 */
@WebServlet("/AbmeldenServlet")
public class AbmeldenServlet extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
            HttpSession session = request.getSession();  
            session.invalidate();  
            response.sendRedirect("index.jsp");
    }  


}
