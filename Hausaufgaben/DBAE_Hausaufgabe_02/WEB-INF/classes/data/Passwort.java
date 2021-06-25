package data;

/**
 * 
 * @author Clemens Bleck, Dennis Hasselbusch, Marten Kracke
 *
 */
public class Passwort {
	/**Variable passwort für getter und setter
	 * 
	 */
	private String passwort;
	/** Konstruktor für Passwort
	 * @param passwort
	 */
	public Passwort(String passwort) {
		super();
		this.passwort = passwort;
	}
	/** Getter und Setter
	 * 
	 * @return
	 */
	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
	
	
}
