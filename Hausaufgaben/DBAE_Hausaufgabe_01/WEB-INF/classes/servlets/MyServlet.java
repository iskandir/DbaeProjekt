package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.Fehlermanager;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("Hello get!");
		String mail = request.getParameter("email");
		String pw = request.getParameter("password");
		String type = request.getParameter("type");
		
		out.println(mail + " is my mail adress");
		out.println(pw + " is my password");
		out.println(type + " is my type" );
		out.println("Servlet closed!");
		
		myData(mail, pw, type);
		Fehlermanager fehlermanager = new Fehlermanager(mail, pw, type);
		
		if (fehlermanager.weiterleitung == true)
		{
			String message = String.format("Erfolgreich eingeloggt! Willkommen,  %s", mail);
			request.setAttribute("message", message);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} else {
			
			String message = "Email oder Passwort falsch, bitte erneut versuchen!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void myData(String mail, String pw, String type) {
		String userMail = mail;
		String userPassword = pw;
		String userType = type;
		
		System.out.println("Userdata are: " + userMail + " " + userPassword +" "+ userType);
	}
}
