package servlet;

import java.io.IOException;
import java.sql.SQLException;

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
 * @author xxxxxxxx
 *
 */
@WebServlet("/SuchenServlet")
public class SuchenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Produkt produkt;
		
		try {
			produkt = StatementsDB.getProdukt(request.getParameter("search"));
			System.out.println("Produkt: " + produkt);
		} catch(SQLException e) {
			System.out.println("Produkt not found");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
