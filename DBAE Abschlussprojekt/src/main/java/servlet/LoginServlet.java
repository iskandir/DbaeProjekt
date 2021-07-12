package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Benutzer;
import database.StatementsDB;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	Benutzer benutzer = null;
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		session.setAttribute("Username", benutzer.getUsername());
		session.setAttribute("Adresse", benutzer.getStreet() 
				+ benutzer.getHousenmb() 
				+ benutzer.getPostalcode() 
				+ benutzer.getCity());
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("DOPOST: \n username " + username + "\n password "
				+ password);
		benutzer = new Benutzer(username,password);
		System.out.println();
		String encrypt = benutzer.encryptPassword(password);
		benutzer.setPassword(encrypt);
				
		Benutzer sqlBenutzer = StatementsDB.benutzerLogin(benutzer);
		
		//case 1 - Logge Nutzer ein, erstelle eine Session und gehe zurück zur Startseite
		//case 2 - gib Fehlermeldung aus und bleibe bei Login
		
		if(sqlBenutzer != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username", benutzer);
			session.setAttribute("Adresse", benutzer.getStreet() 
				+ benutzer.getHousenmb() 
				+ benutzer.getPostalcode() 
				+ benutzer.getCity());
			//session.setAttribute("Warenkorb", getWarenkorb);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "Kombination aus Email "
					+ "und pw stimmen nicht überein!!");
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
