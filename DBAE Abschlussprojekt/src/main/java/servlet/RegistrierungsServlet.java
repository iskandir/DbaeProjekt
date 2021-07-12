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
 * Servlet implementation class RegistrierungsServlet
 */
@WebServlet("/RegistrierungsServlet")
public class RegistrierungsServlet extends HttpServlet {
	Benutzer benutzer = null;
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordWdh = request.getParameter("psw-repeat");
		String street = request.getParameter("street");
		String housenmb = request.getParameter("housenmb");
		String postalcode = request.getParameter("postalcode");
		String city = request.getParameter("city");

		benutzer = new Benutzer(username, password, street, housenmb, postalcode,
				city, firstname, lastname, email);
		
		String encrypt = benutzer.encryptPassword(password);
		benutzer.setPassword(encrypt);
		System.out.println("Loginname:" + username + 
				" Password:" + benutzer.getPassword());
		
		

		System.out.println("Username: " + benutzer.getUsername() 
				+" \nFirstname: " + benutzer.getFirstName() 
				+ "\nLastname:" + benutzer.getLastName() 
				+ "\nEmail:" + benutzer.getEmail() 
				+ "\nPw:" + benutzer.getPassword()
				+ "\nPwwdh:" + passwordWdh 
				+ "\nStreet:" + benutzer.getStreet() 
				+ "\nHousenmb:" + benutzer.getHousenmb() 
				+ "\nPostalcode:" + benutzer.getPostalcode() 
				+ "\nCity:" + benutzer.getCity());
		
		
		//Prüfe ob Passwörter-Spalte leer sind
		if(benutzer.getPassword().isEmpty())
		{
			System.out.println("Pw is empty!");			
		} 
		else
		/** Prüfe länge der Email >= 8 , denn alle Mails < 5 sind nicht in korrektem Format.
		 * 
		 */
			if(benutzer.getEmail().length() >= 8)
			{
				System.out.println("Email ist lang genug !");
				/** Prüfe ob Passwörter gleich sind
				 * 
				 */
				if(password.equals(passwordWdh))
				{
					System.out.println("PW wdhl gleich pwdw.");
					//Prüfe ob StatementsDB.benutzerHinzufuegen true, dann setze Attribute und gehe auf die index.jsp
					if(StatementsDB.benutzerHinzufuegen(benutzer))
					{
						System.out.println("starte");
						HttpSession session = request.getSession();
						session.setAttribute("benutzer",  benutzer);
						request.getRequestDispatcher("index.jsp").forward(request, response);
					} 
					else
					{
						request.setAttribute("error", "Benutzer konnte nicht registriert werden!");
						request.getRequestDispatcher("registrierung.jsp").forward(request, response);
					}
				}
				else
				{
					request.setAttribute("error", "Passwörter nicht identisch!");
					request.getRequestDispatcher("registrierung.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("error", "Email Adresse ist nicht mind. 8 Zeichen lang!");
				request.getRequestDispatcher("registrierung.jsp").forward(request, response);
			}
		
		
	}


}


