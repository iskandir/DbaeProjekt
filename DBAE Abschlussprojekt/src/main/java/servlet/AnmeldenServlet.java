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

/**AnmeldenServlet welches gebraucht wird um das Login der Nutzer abzuarbeiten
 * 
 * @author dennishasselbusch
 *
 */
@WebServlet("/AnmeldenServlet")
public class AnmeldenServlet extends HttpServlet {
	Benutzer tempBenutzer = null;
	private static final long serialVersionUID = 1L;
       
	/**Methode mit der man alle Attribute des Benutzers auslesen kann
	 * @author dennishasselbusch
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		session.setAttribute("Username", tempBenutzer.getUsername());
		session.setAttribute("Adresse", tempBenutzer.getStreet() 
				+ tempBenutzer.getHousenmb() 
				+ tempBenutzer.getPostalcode() 
				+ tempBenutzer.getCity());
		
		
		
	}
	/** Wird benötigt um den
	 * Benutzer einzuloggen, dass Passwort zu hashen und mit der Datenbank
	 * abzugleichen. 
	 * @author dennishasselbusch
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String benutzername = request.getParameter("benutzername");
		String passwort = request.getParameter("passwort");

		System.out.println("DOPOST: \n benutzername " + benutzername + "\n password "
				+ passwort);
		tempBenutzer = new Benutzer(benutzername,passwort);
		System.out.println();
		String encrypt = tempBenutzer.encryptPassword(passwort);
		tempBenutzer.setPassword(encrypt);
				
		Benutzer sqlBenutzer = StatementsDB.benutzerLogin(tempBenutzer);
		
		//case 1 - Logge Nutzer ein, erstelle eine Session und gehe zurück zur Startseite
		//case 2 - gib Fehlermeldung aus und bleibe bei Login
		
		if(sqlBenutzer != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("benutzer", sqlBenutzer);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "Benutzername oder Passwort falsch!");
			
			request.getRequestDispatcher("anmelden.jsp").forward(request, response);
		}
		
	}

}
