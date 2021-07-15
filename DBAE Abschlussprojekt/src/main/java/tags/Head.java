package tags;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import data.*;
import database.*;

/** Taglibs wird benötigt um den Header (also das Menü) dem Login-Status entsprechend
 * anzupassen.
 * 
 * @author dennishasselbusch
 *
 */
public class Head extends SimpleTagSupport {

private String username;
	
//
//<div class="card produkte" style="width: 18rem;">
//<div class="card-body">
//  <h5 class="card-title">Produkte</h5>
//  <p class="card-text">Hier siehst du alle Produkte in den Datenbanken Hardware, Software, Peripherie.</p>
//  <form class="" method="POST" action=AdminServlet>
//		<input class="btn btn-primary" type="submit" value="Produkte" name="details" />
//	</form>
//</div>
//</div>

	public void doTag() throws JspException, IOException{
		//Grundgerüst um die Daten aus der Request zu holen
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		
		
		try {
			
			out.print("<h4>Beliebteste Produkte</h4>");
			
			Produkt[] beliebt = StatementsDB.getTopProdukte();
			
			out.print("<div class=\"beliebtliste\">");
			for(Produkt produkt:beliebt) {
				out.print("<a class=\"produkt card\" href=\"./Produkte?p=" + produkt.getProduktnummer() + "\">"
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
