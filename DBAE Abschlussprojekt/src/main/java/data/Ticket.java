package data;

/**
 * 
 * @author martenkracke
 *
 */
public class Ticket {
	
	private int id; 
	private String vorname;
	private String name;
	private String betreff;
	private String mail;
	private String inhalt;
	

	/**Dieser Konstruktor für Ticket wird beim Erstellen des Tickets aufgerufen und erwartet daher keinen
	 * Parameter für die ID, da diese eine fortlaufende SERIAL Nummer in der Datenbank ist und daher nicht
	 * übergeben werden muss.
	 * @param vorname
	 * @param name
	 * @param betreff
	 * @param mail
	 * @param inhalt
	 */
	public Ticket(String vorname, String name, String betreff, String mail, String inhalt) {
		this.vorname = vorname;
		this.name = name;
		this.betreff = betreff;
		this.mail = mail;
		this.inhalt = inhalt;
	}
	
	/**Dieser Konstruktor wird aufgerufen, wenn Tickets aus der Datenbank geladen werden. Aus diesem Grund
	 * erwartet diese Methode einen Parameter für die ID.
	 * @param id
	 * @param vorname
	 * @param name
	 * @param betreff
	 * @param mail
	 * @param inhalt
	 */
	public Ticket(int id, String vorname, String name, String betreff, String mail, String inhalt) {
		this.id = id;
		this.vorname = vorname;
		this.name = name;
		this.betreff = betreff;
		this.mail = mail;
		this.inhalt = inhalt;
	}
	
	public int getId() {
		return id;
	}	
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
}
