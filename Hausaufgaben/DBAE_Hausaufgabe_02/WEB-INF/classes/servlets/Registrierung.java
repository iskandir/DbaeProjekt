package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Benutzer;
import data.Passwort;
import database.StatementsDB;

/**
 * Servlet implementation class Registrierung
 */
@WebServlet("/Registrierung")
public class Registrierung extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /** Konstruktor für das RegistrierungsServlet
     * 
     */
	public Registrierung() {
        super();
    }
	/** Standardmäßige doGet Methode
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/** doPost Methode um die einzelnen benötigten Speichervariablen zu erhalten und abzuspeichern
	 *  Fehlermeldungen wie ServletException und IOException werden abgefangen
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Deklarierung der Variablen und request der Parameter
		String email = request.getParameter("email");
		int alter = Integer.parseInt(request.getParameter("alter"));
		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String rolle = request.getParameter("rolle");
		String passwort = request.getParameter("passwort");
		String passwortWdh = request.getParameter("passwortWdh");
		//Initialisierung von zwei Objekten um diese im Anschluss speichern zu können
		Benutzer benutzer = new Benutzer(email, passwort,alter,vorname,nachname,rolle);
		Passwort objPasswort = new Passwort(passwort);
		//Prüfe ob Passwörter-Spalte leer sind
		if(benutzer.getPasswort().isEmpty())
		{
			System.out.println("Pw is empty!");
		} 
		else
		/**Prüfe länge der Email >= 5 , denn alle Mails < 5 sind nicht in korrektem Format.
		 * 
		 */
		if(benutzer.getEmail().length() >= 5)
		{
			/**Prüfe ob Passwörter gleich sind
			 * 
			 */
			if(benutzer.getPasswort().equals(passwortWdh))
			{
				//Prüfe ob StatementsDB.benutzerHinzufuegen true, dann setze Attribute und gehe auf die index.jsp
				if(StatementsDB.benutzerHinzufuegen(benutzer))
				{
					HttpSession session = request.getSession();
					session.setAttribute("benutzer",  benutzer);
					session.setAttribute("passwoerter", objPasswort);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} 
				else
				{
					request.setAttribute("error", "Benutzer konnte nicht registriert werden");
					request.getRequestDispatcher("registrierung.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("error", "Passwörter nicht identisch");
				request.getRequestDispatcher("registrierung.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("error", "Email Adresse ist nicht mind. 5 Zeichen lang.");
			request.getRequestDispatcher("registrierung.jsp").forward(request, response);;
		}
	}

}
