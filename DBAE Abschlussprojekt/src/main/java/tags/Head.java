package tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import data.Benutzer;

public class Head extends SimpleTagSupport {

private String username;
	
	public void doTag() throws JspException, IOException{
		//Grundgerüst um die Daten aus der Request zu holen
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		
		Benutzer benutzer = null;			
		try {
			benutzer = (Benutzer)session.getAttribute("username");
			username = benutzer.getUsername();
		} catch (NullPointerException npe) {
			System.err.println("NullPointerException " + npe.toString());
		}
		
		if(username != null) {
			//if user is logged in...
			out.print("<div class=\"btn-group\" role=\"group\">"
					+ "<div class=\"navbar-nav ml-auto\">"
					+ "<div class=\"dropdown\">"
					+ "<button class=\"dropbtn\"><img src=\"pictures/buyerIcon.png\" alt=\"Käufer\" width=\"20\" height=\"20\"><span class=\"float-right\">" + username + "</span>\n"
					+ "<i class=\"fa fa-caret-down\"></i>"
					+ "</button>\n"
					+ "<div class=\"dropdown-content\">\n"
					+ "<a href=\"#\">Mein Konto</a>\n"
					+ "<a href=\"#\">Persönliche Daten</a>\n"
					+ "<a href=\"supportForm.jsp\">Support</a>"
					+ "<a href=\"logoutForm.jsp\">Logout</a>"
					+ "</div>\n"
					+ "</div> \n"
					+ "</div> \n"
					+ "<div class=\"navbar-nav ml-auto\">\n"
					+ "<div class=\"dropdown\">\n"
					+ "<button class=\"dropbtn\"><img src=\"pictures/adminLog.png\" alt=\"Administrator\" width=\"20\" height=\"20\"><span class=\"float-right\">Administrator</span> \n"
					+ "<i class=\"fa fa-caret-down\"></i>\n"
					+ "</button>\n"
					+ "<div class=\"dropdown-content\">\n"
					+ "<a href=\"login.jsp\">Login</a>\n"
					+ "<a href=\"adminCenter.jsp\">Admin Center</a>\n"
					+ "</div>\n"
					+ "</div>"
					+ "</div>\n"
					+ "</div> ");
		
		} else {
			out.print("<div class=\"btn-group\" role=\"group\">"
					+ "<div class=\"navbar-nav ml-auto\">"
					+ "<div class=\"dropdown\">"
					+ "<button class=\"dropbtn\"><img src=\"pictures/buyerIcon.png\" alt=\"Käufer\" width=\"20\" height=\"20\"><span class=\"float-right\">Käufer</span>\n"
					+ "<i class=\"fa fa-caret-down\"></i>"
					+ "</button>\n"
					+ "<div class=\"dropdown-content\">\n"
					+ "<a href=\"login.jsp\">Login</a>\n"
					+ "<a href=\"registrierung.jsp\">Registrierung</a>\n"
					+ "<a href=\"supportForm.jsp\">Support</a>"
					+ "</div>\n"
					+ "</div> \n"
					+ "</div> \n"
					+ "<div class=\"navbar-nav ml-auto\">\n"
					+ "<div class=\"dropdown\">\n"
					+ "<button class=\"dropbtn\"><img src=\"pictures/adminLog.png\" alt=\"Administrator\" width=\"20\" height=\"20\"><span class=\"float-right\">Administrator</span> \n"
					+ "<i class=\"fa fa-caret-down\"></i>\n"
					+ "</button>\n"
					+ "<div class=\"dropdown-content\">\n"
					+ "<a href=\"login.jsp\">Login</a>\n"
					+ "<a href=\"adminCenter.jsp\">Admin Center</a>\n"
					+ "</div>\n"
					+ "</div>"
					+ "</div>\n"
					+ "</div> ");
		}
		
	}
	
	
	
}
