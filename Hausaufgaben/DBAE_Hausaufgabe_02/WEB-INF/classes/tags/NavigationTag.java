package tags;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import javax.servlet.jsp.tagext.TagSupport;

import data.Benutzer;

/** NavigationTag extends TagSupport - lässt die Navigation verschwinden, nachdem ein Nutzer eingeloggt wurde.
 * 
 * @author Clemens Bleck, Dennis Hasselbusch, Marten Kracke
 *
 */
public class NavigationTag extends TagSupport{
	//Zur Befriedigung der EclipseWarnung das erstellen einer serielVersionUID :-)
	private static final long serialVersionUID = 1L;
	/** DoStartTag() zum auslösen unseres Taglibs nach eintreten eines Ereignisses
	 * 
	 */
	public int doStartTag() 
	{
		//Grundgerüst um Daten aus unseren Anfragen zu empfangen
		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		Benutzer benutzer = null;
		//Try and Catch-Block um den Nutzer zu prüfen / abzufragen.
		try
		{
			benutzer = (Benutzer) session.getAttribute("benutzer");
			if(benutzer != null)
			{
				out.print("Hallo, " + benutzer.getVorname() + "!");
				return SKIP_BODY;
			} else
			{
				return EVAL_BODY_INCLUDE;
			}
		}
		catch(NullPointerException npe)
		{
			System.err.println("Noch kein Nutzer zu finden!");
		} catch (IOException e)
		{
			System.err.println("Writer konnte nicht gefunden werden");
			e.printStackTrace();
		}
		//Return der gängigen int Variablen (ACHTUNG: Variablen bei int doStartTag sind allgemeingültig)
		return EVAL_BODY_INCLUDE;
	}
}
