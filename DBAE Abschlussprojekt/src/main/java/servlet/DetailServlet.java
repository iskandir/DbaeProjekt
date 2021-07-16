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
 * @author martenkracke
 *
 */
@WebServlet("/Produkte")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailServlet() {
        super();
    }

    
	/**
	 * Die Produktnummer entspricht dem Wert des Parameters 'p'. Wenn das Produkt nicht gefunden werden konnte,
	 * gibt die StatementsDB.getProdukt() null zurück. Dies wird hier abgefangen und dem Benutzer wird dargestellt,
	 * dass das Produkt nicht gefunden werden konnte. SQL-Fehler werden ebenfalls abgefangen und ausgegeben. Das
	 * Attribut "produkt" wird mit der Instanz des Produktes belegt. Wird kein Produkt gefunden, so wird das Attribut
	 * "produkt" aus der Session entfernt, damit parallel zur Fehlermeldung nicht das alte Produkt noch angezeigt wird.
	 */
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
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
