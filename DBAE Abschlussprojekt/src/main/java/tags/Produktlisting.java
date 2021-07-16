package tags;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import data.Produkt;
import database.StatementsDB;

/** Dieses Tag gibt die Produkte auf index.jsp aus.
 *
 * @author clemensbeck
 *
 */
public class Produktlisting extends SimpleTagSupport {

	/**
	 * Die Funktion ruft StatementsDB auf und nutzt die zurückgegebenen Arrays mit
	 * Produkten, um der Reihe nach die beliebtesten Produkte, Hardware, Software
	 * und Peripherie in Bootstrap Cards auszugeben.
	 *
	 */
	public void doTag() throws JspException, IOException{
		//Grundgerüst um die Daten aus der Request zu holen
		JspWriter out = getJspContext().getOut();
		
		try {

			out.print("<h4>Beliebteste Produkte</h4>");

			Produkt[] beliebt = StatementsDB.getTopProdukte();

			out.print("<div class=\"beliebtliste\">");
			for(Produkt produkt:beliebt) {
				out.print("<a class=\"produkt card\" href=\"./Produkte?p=" + produkt.getProduktnummer() + "\">"
						+ "<img src=" + produkt.getBild() + " class=\"card-img-top\">"
						+ "<div class=\"card-body\">"
						+ "<h5 class=\"card-title\">" + produkt.getTitel() + "</h5>"
						+ "<p class=\"card-text\">" + produkt.getBeschreibung() + "</p>"
						+ "</div>"
						+ "</a>");
			}
			out.print("</div>");
		} catch(SQLException e) {
			out.print("<p>"+ e.getMessage() + "</p>");
		}


		out.print("<h4>Hardware</h4>");

		Produkt[] produkte = StatementsDB.getHardware();

		out.print("<div class=\"hardwareliste\">");
		for(Produkt produkt:produkte) {
			out.print("<a class=\"produkt card\" href=\"./Produkte?p=" + produkt.getProduktnummer() + "\">"
					+ "<div class=\"card-body\">"
					+ "<h5 class=\"card-title\">" + produkt.getTitel() + "</h5>"
					+ "<p class=\"card-text\">" + produkt.getBeschreibung() + "</p>"
					+ "</div>"
					+ "</a>");
		}
		out.print("</div>");


		out.print("<h4>Software</h4>");

		produkte = StatementsDB.getSoftware();

		out.print("<div class=\"softwareliste\">");
		for(Produkt produkt:produkte) {
			out.print("<a class=\"produkt card\" href=\"./Produkte?p=" + produkt.getProduktnummer() + "\">"
					+ "<div class=\"card-body\">"
					+ "<h5 class=\"card-title\">" + produkt.getTitel() + "</h5>"
					+ "<p class=\"card-text\">" + produkt.getBeschreibung() + "</p>"
					+ "</div>"
					+ "</a>");
		}
		out.print("</div>");


		out.print("<h4>Peripherie</h4>");

		produkte = StatementsDB.getPeripherie();

		out.print("<div class=\"peripherieliste\">");
		for(Produkt produkt:produkte) {
			out.print("<a class=\"produkt card\" href=\"./Produkte?p=" + produkt.getProduktnummer() + "\">"
					+ "<div class=\"card-body\">"
					+ "<h5 class=\"card-title\">" + produkt.getTitel() + "</h5>"
					+ "<p class=\"card-text\">" + produkt.getBeschreibung() + "</p>"
					+ "</div>"
					+ "</a>");
		}
		out.print("</div>");
	}
}
