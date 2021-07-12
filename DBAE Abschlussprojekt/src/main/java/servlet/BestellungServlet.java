package servlet;

import java.io.IOException;
import java.sql.SQLException;

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

		//TO DO 
		//Double wird nicht richtig in DB eingetragen....? 
		//wo bekomme ich die Daten her? Produktdaten -> Session? Userdaten???(Dennis)
		
		HttpSession session = request.getSession();
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
		
		
		
		
		try {
			String[] produktnummern = {"1", "2"}; 
			//StatementsDB.bestellungHinzufuegen(new Bestellung(0, 1.5, produktnummern, benutzer.getFirstName(), benutzer.getLastName(), benutzer.getStreet(), benutzer.getHousenmb(), benutzer.getPostalcode(), benutzer.getCity()));
			StatementsDB.bestellungHinzufuegen(new Bestellung(0, 1.5, produktnummern, benutzer.getFirstName(), benutzer.getLastName(), "", "", "", ""));
		} catch (SQLException e) {
			
		}
	}
}
