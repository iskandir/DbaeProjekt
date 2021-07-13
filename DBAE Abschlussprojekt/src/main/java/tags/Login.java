package tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import data.Benutzer;

/**Wird für Anpassungen der index.jsp benötigt / verwendet
 * 
 * @author dennishasselbusch
 *
 */
public class Login extends SimpleTagSupport {

	private String username;
	
	public void doTag() throws JspException, IOException{
		//Grundgerüst um die Daten aus der Request zu holen
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		
		Benutzer benutzer = null;			

		try {
			benutzer = (Benutzer)session.getAttribute("benutzer");
			username = benutzer.getUsername();

		} catch (NullPointerException npe) {
			System.err.println("NullPointerException " + npe.toString());

		}
		
		if(username != null && benutzer != null) {
			//if user is logged in...
			
			out.print("<p> Hallo, " +  benutzer.getUsername()+ " !");
		} else {
			
			out.print("<br>\n"
					+ "        <h1>Willkommen!</h1>\n"
					+ "        \n"
					+ "        <button>CLICK ME!</button>");
		}
		
	}

	
}
