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
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
		
		if(benutzer == null) {
			
			request.setAttribute("error", "Bitte melde dich erst an.");
			
			request.getRequestDispatcher("anmelden.jsp").forward(request, response);
		} else {
			
			
			String produktnummer = request.getParameter("produktnummer");
			System.out.println("Produkt in Warenkorb:" + produktnummer);
			
			List<Produkt> produkte = (List<Produkt>) session.getAttribute("produkte");
			
			if(produkte == null) {
				produkte = new ArrayList<Produkt>();
			}
			
			
			if(produktnummer != null) {
				try {
					Produkt produkt = StatementsDB.getProdukt(produktnummer);
					produkte.add(produkt);
				} catch (SQLException e) {
					
				}
			}
			
			Double gesamtbetrag = 0.0;
			
			for(int i=0; i<produkte.size(); i++) {
				gesamtbetrag = gesamtbetrag + produkte.get(i).getPreis();
			}
			
			session.setAttribute("produkte", produkte);
			session.setAttribute("gesamtbetrag", gesamtbetrag);
			
			request.getRequestDispatcher("warenkorb.jsp").forward(request, response);
		}
		
		
	}

}
