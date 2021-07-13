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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
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
		
		session.setAttribute("produkte", produkte);
		
		Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
		
		if(benutzer == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("warenkorb.jsp").forward(request, response);
		}
		
		
	}

}
