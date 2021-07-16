package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Produkt;
import database.StatementsDB;

/**
 * 
 * @author clemensbeck
 *
 */
@WebServlet("/SuchenServlet")
public class SuchenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/** Ruft die Suchfunktion in StatementsDB auf und leitet zu suchergebnisse.jsp weiter
	 * @author clemensbeck
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Produkt[] produkte;
		
		produkte = StatementsDB.sucheProdukte(request.getParameter("suche"));
		
		session.setAttribute("suchergebnisse", produkte);
		
		request.getRequestDispatcher("suchergebnisse.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
