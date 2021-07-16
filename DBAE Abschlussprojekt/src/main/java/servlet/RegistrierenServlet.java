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
 * Servlet wird genutzt um dem Nutzer die M�glichkeit zu geben sich zu
 * registrieren
 * 
 * @author dennishasselbusch
 *
 */
@WebServlet("/RegistrierenServlet")
public class RegistrierenServlet extends HttpServlet {
	Benutzer benutzer = null;
	private static final long serialVersionUID = 1L;

	/**
	 * Fragt die ben�tigten Parameter aus dem registrierung.jsp ab und speichert
	 * diese in der Datenbank Besonderheit: Das Passwort wird gehasht gespeichert
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("benutzername");
		String firstname = request.getParameter("vorname");
		String lastname = request.getParameter("nachname");
		String email = request.getParameter("email");
		String password = request.getParameter("passwort");
		String passwordWdh = request.getParameter("passwort-repeat");
		String street = request.getParameter("strasse");
		String housenmb = request.getParameter("hausnummer");
		String postalcode = request.getParameter("postleitzahl");
		String city = request.getParameter("stadt");

		benutzer = new Benutzer(username, password, street, housenmb, postalcode, city, firstname, lastname, email);

		String encrypt = benutzer.encryptPassword(password);
		benutzer.setPassword(encrypt);

		// Pr�fe ob Passw�rter-Spalte leer sind
		if (!(benutzer.getPassword().isEmpty()))
			/**
			 * Pr�fe ob Passw�rter gleich sind
			 * 
			 */
			if (password.equals(passwordWdh)) {
				// Pr�fe ob StatementsDB.benutzerHinzufuegen true, dann setze Attribute und gehe
				// auf die index.jsp
				if (StatementsDB.benutzerHinzufuegen(benutzer)) {
					HttpSession session = request.getSession();
					session.setAttribute("benutzer", benutzer);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					request.setAttribute("error", "Benutzer konnte nicht registriert werden!");
					request.getRequestDispatcher("registrieren.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("error", "Passwoerter nicht identisch!");
				request.getRequestDispatcher("registrieren.jsp").forward(request, response);
			}

	}

}
