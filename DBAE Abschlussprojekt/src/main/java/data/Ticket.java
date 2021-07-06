package data;

public class Ticket {
	private String vorname;
	private String name;
	private String betreff;
	private String mail;
	private String inhalt;
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBetreff() {
		return betreff;
	}
	public void setBetreff(String betreff) {
		this.betreff = betreff;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getInhalt() {
		return inhalt;
	}
	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}
	public Ticket(String vorname, String name, String betreff, String mail, String inhalt) {
		this.vorname = vorname;
		this.name = name;
		this.betreff = betreff;
		this.mail = mail;
		this.inhalt = inhalt;
	}
}
