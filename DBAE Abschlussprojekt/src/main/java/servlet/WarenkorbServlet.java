package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.*;
import database.StatementsDB;

/**
 * Servlet implementation class WarenkorbServlet
 */
@WebServlet("/WarenkorbServlet")
public class WarenkorbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/** Wird aufgerufen beim Hinzufügen zu Warenkorb
	 * @author clemensbeck
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
		
		if(benutzer == null) {
			
			//Leitet Benutzer zu anmelden.jsp um, falls nicht angemeldet
			request.setAttribute("error", "Bitte melde dich erst an.");
			request.getRequestDispatcher("anmelden.jsp").forward(request, response);
			
		} else {
			
			String produktnummer = request.getParameter("produktnummer");			
			List<Produkt> produkte = (List<Produkt>) session.getAttribute("produkte");
			
			if(produkte == null) {
				produkte = new ArrayList<Produkt>();
			}
			
			//Füge zu Produktnummer gehörendes Produkt zur Liste hinzu
			if(produktnummer != null) {
				try {
					Produkt produkt = StatementsDB.getProdukt(produktnummer);
					produkte.add(produkt);
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}
			
			//Berechne Gesamtbetrag
			Double gesamtbetrag = 0.0;
			for(int i=0; i<produkte.size(); i++) {
				gesamtbetrag = gesamtbetrag + produkte.get(i).getPreis();
			}
			
			//Speichere Liste mit Produkten und Gesamtbetrag (ohne MWST) in Session
			session.setAttribute("produkte", produkte);
			session.setAttribute("gesamtbetrag", gesamtbetrag);
			
			request.getRequestDispatcher("warenkorb.jsp").forward(request, response);
		}
		
		
	}

}
