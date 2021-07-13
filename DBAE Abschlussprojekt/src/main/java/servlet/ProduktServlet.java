package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.util.List;
import java.util.ArrayList;

import data.*;
import database.StatementsDB;



@WebServlet("/Produkte")
public class ProduktServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProduktServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Produkt produkt;
		try {
			produkt = StatementsDB.getProdukt(request.getParameter("p"));
			if (produkt == null) {
				session.removeAttribute("produkt");
				session.setAttribute("msg", "Das Produkt konnte leider nicht gefunden werden.");
			} else {
				session.removeAttribute("msg");
				session.setAttribute("produkt", produkt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			session.removeAttribute("produkt");
			session.setAttribute("msg", "Es gab ein Problem beim Laden des Produktes: " + e.getMessage());
		}
		request.getRequestDispatcher("/productDetail.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
