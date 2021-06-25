package data;

/**
 * 
 * @author Clemens Bleck, Dennis Hasselbusch, Marten Kracke
 *
 */
public class Benutzer {
	/**Variablen die von unserer Registrierungsseite / unserer Loginseite abgeholt und verarbeitet werden sollen.
	 * 
	 */
	private String email;
	private String passwort;
	private int alter;
	private String vorname;
	private String nachname;
	private String rolle;
	/** Konstruktor für den Benutzer
	 * @param email
	 * @param passwort
	 * @param alter
	 * @param vorname
	 * @param nachname
	 * @param rolle
	 */
	public Benutzer(String email, String passwort, int alter, String vorname, String nachname, String rolle) {
		super();
		this.email = email;
		this.passwort = passwort;
		this.alter = alter;
		this.vorname = vorname;
		this.nachname = nachname;
		this.rolle = rolle;
	}
	/** Konstruktor, falls Benutzer "nur" das nötigste ausgewählt hat.
	 * 
	 * @param email
	 * @param passwort
	 */
	public Benutzer(String email, String passwort)
	{
		super();
		this.email = email;
		this.passwort = passwort;
	}

	/**Getter und Setter Methoden
	 * 
	 * @return
	 */
	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public String getPasswort() 
	{
		return passwort;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setPasswort(String passwort)
	{
		this.passwort = passwort;
	}
	
}
