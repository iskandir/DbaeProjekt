package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.StatementsDB;
import data.Ticket;

/**
 * 
 * @author martenkracke
 *
 */
@WebServlet("/SupportServlet")
public class SupportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public SupportServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * Die Daten zum Ticket werden aus den Parametern gelesen und verwendet, um eine Instanz von Ticket zu erstellen,
	 * welche dann in der Datenbank gespeichert wird.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String nachname = request.getParameter("nachname");
		String vorname = request.getParameter("vorname");
		String email = request.getParameter("email");
		String betreff = request.getParameter("betreff");
		String inhalt = request.getParameter("inhalt");
		
		String msg;
		try {
			StatementsDB.ticketHinzufuegen(new Ticket(vorname, nachname , betreff, email, inhalt));
			msg = "Ihr Ticket wird zeitnah von unserem Support bearbeitet.";
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "Ihre Anfrage konnte leider nicht gespeichert werden: " + e.getMessage();
		}
		
		session.setAttribute("output", msg);
		
		request.getRequestDispatcher("erfolg.jsp").forward(request, response);
	}

}
