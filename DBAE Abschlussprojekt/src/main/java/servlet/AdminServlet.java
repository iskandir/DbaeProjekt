package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.*;
import database.StatementsDB;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public AdminServlet() {
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String kategorie = request.getParameter("details");
		System.out.println(kategorie);
		
		HttpSession session = request.getSession();
		
		switch (kategorie) {
		case "Produkte": 
			Produkt[] hardwareListe = StatementsDB.getHardware();
			Produkt[] softwareListe = StatementsDB.getSoftware();
			Produkt[] peripherieListe = StatementsDB.getPeripherie();
			
			session.setAttribute("hardwareListe", hardwareListe);
			session.setAttribute("softwareListe", softwareListe);
			session.setAttribute("peripherieListe", peripherieListe);
			
			request.getRequestDispatcher("adminProdukte.jsp").forward((request), response);
			break;
			
		case "Bestellungen":
			Bestellung[] bestellungenListe = StatementsDB.getBestellungen();
			
			session.setAttribute("bestellungenListe", bestellungenListe);
			
			request.getRequestDispatcher("adminBestellungen.jsp").forward((request), response);
			break;
			
		case "Kunden": 
			Benutzer[] benutzerliste = StatementsDB.getBenutzer();
			
			session.setAttribute("benutzerliste", benutzerliste);
			request.getRequestDispatcher("adminBenutzer.jsp").forward((request), response);
			break;
		default:
			request.getRequestDispatcher("index.jsp");
		}
		
	}
}
