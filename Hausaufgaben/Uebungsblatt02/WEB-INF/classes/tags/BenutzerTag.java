package tags;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import data.Benutzer;

/** BenutzerTag extends SimpleTagSupport um unseren Nutzer nach der Registration zu begrüßen 
 * 
 * @author Clemens Bleck, Dennis Hasselbusch, Marten Kracke
 *
 */
public class BenutzerTag extends SimpleTagSupport{
	private String email;
	/** doTag Methode um unser BenutzerTag anzeigen zu können
	 * 
	 */
	public void doTag() throws JspException, IOException
	{
		//Grundgerüst um Daten aus unseren Anfragen zu empfangen
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		Benutzer benutzer = null;
		/** Try and catch-block zum abgreifen der geforderten Attribute(objekt benutzer)
		 * 
		 */
		try
		{
			benutzer = (Benutzer) session.getAttribute("benutzer");
			email = benutzer.getEmail();
			if(email != null)
			{
				out.print("<p> Hi " + benutzer.getEmail() + ", " + benutzer.getVorname() + benutzer.getNachname() + ""
						+ ". Dein Alter ist " + benutzer.getAlter() + " und du bist " + benutzer.getRolle());
			}
			
		}
		catch(NullPointerException npe)
		{
			System.err.println("BenutzerTag NullPointerException");
		}
		
	}
}
