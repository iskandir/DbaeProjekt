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
 * Servlet implementation class support
 */
@WebServlet("/SupportServlet")
public class SupportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public SupportServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("Nachname");
		String vorname = request.getParameter("Name");
		
		
		String msg;
		try {
			StatementsDB.ticketHinzufuegen(new Ticket(vorname, name , request.getParameter("Betreff"), request.getParameter("Email"), request.getParameter("Inhalt")));
			msg = "Ihr Ticket wird zeitnah von unserem Support mit hoher Priorität bearbeitet!!!:)";
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "Ihre Anfrage konnte leider nicht gespeichert werden: ";
		}
		
		session.setAttribute("output", msg);
		
		
		request.getRequestDispatcher("Erfolg.html").forward(request, response);
	}

}
