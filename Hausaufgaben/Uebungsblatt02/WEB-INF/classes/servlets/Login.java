package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Benutzer;
import database.StatementsDB;

/**Servlet implementation class Login
 * 
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	Benutzer benutzer = null;
	private static final long serialVersionUID = 1L;
	
	/** Konstruktor Login
	 * 
	 */
    public Login() {
        super();
    }
    /**Standardmäßig implementierte doGet Methode eines Servlets
     * 
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}
	/** doPost Methode um über Servlets die Abfragen zu den Logindaten vorzunehmen. Anschließend Weiterleitung zu entsprechender .jsp
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Deklarierung der Parameter und abgreifen der Variablen
		String email = request.getParameter("email");
		String passwort = request.getParameter("passwort");
		benutzer = new Benutzer(email, passwort);
		
		Benutzer sqlBenutzer = StatementsDB.benutzerLogin(benutzer);
		/*PRÜFE OB LOGINDATEN KORREKT!*/
		//case1 - Ja, korrekt -> Logge Nutzer ein und Gehe zurück zur Startseite
		//case2 - nein -> gib Fehlermeldung aus und gehe zurück zu login
		if(sqlBenutzer != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("benutzer", benutzer);
			request.getRequestDispatcher("index.jsp").forward(request,  response);
		} 
		else 
		{
			request.setAttribute("error", "Kombination aus Email und pw stimmen nicht überein!");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		
		
	}

}
