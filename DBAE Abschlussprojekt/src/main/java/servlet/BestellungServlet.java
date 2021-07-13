package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.time.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.*;
import database.StatementsDB;

/**
 * Servlet implementation class BestellungServlet
 */
@WebServlet("/BestellungServlet")
public class BestellungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BestellungServlet() {
        super();
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
		
		HttpSession session = request.getSession();
		
		String strasse = request.getParameter("strasse");
		String hausnummer = request.getParameter("hausnummer");
		String postleitzahl = request.getParameter("postleitzahl");
		String stadt = request.getParameter("stadt");
		
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer"); 
		List<Produkt> produkte = (List<Produkt>) session.getAttribute("produkte");
		
		Double gesamtbetrag = 0.0;
		Instant instant = Instant.now();
		
		String[] produktnummern = new String[produkte.size()];
		for(int i=0; i<produktnummern.length; i++) {
			Produkt tempProdukt = produkte.get(i);
			produktnummern[i] = tempProdukt.getProduktnummer();

			gesamtbetrag = gesamtbetrag + tempProdukt.getPreis();
		}
		
		StatementsDB.bestellungHinzufuegen(new Bestellung(instant, gesamtbetrag, produktnummern, benutzer.getUsername(), benutzer.getLastName(), strasse, hausnummer, postleitzahl, stadt));
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
