/**
 * 
 */
package data;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** Benutzer Klasse zum speichern der Zugangsdaten.
 * @author dennishasselbusch
 *
 */
public class Benutzer {
	private String username;
	private String password;
	private String street;
	private String housenmb;
	private String postalcode;
	private String city;
	private String firstName;
	private String lastName;
	private String email;
	
	
	/** Konstruktor zum anlegen eines neuen Benutzers
	 * @author dennishasselbusch
	 * @param email
	 * @param password
	 * @param street
	 * @param housenmb
	 * @param postalcode
	 * @param city
	 * @param firstName
	 * @param lastName
	 */
	public Benutzer(String username, String password, String street, String housenmb, String postalcode, String city,
			String firstName, String lastName, String email) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.street = street;
		this.housenmb = housenmb;
		this.postalcode = postalcode;
		this.city = city;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	/** Konstruktor für Login eines Benutzers
	 * @author dennishasselbusch
	 * @param email
	 * @param password
	 */
	public Benutzer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		encryptPassword(password);
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHousenmb() {
		return housenmb;
	}

	public void setHousenmb(String housenmb) {
		this.housenmb = housenmb;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/** Funktion hasht das Passwort in SHA512 Format
	 * @author dennishasselbusch
	 * @param password
	 * @return
	 */
	public String encryptPassword(String password) 
	{
		try {
			//getInstance() wird mit SHA-512 Methode aufgerufen
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			
			//nun wird das passwort(eingegangen als String) in ein byte Array
			//konvertiert um weitere Berechnungen damit vornehmen zu können
			byte[] messageDigest = md.digest(password.getBytes());
			
			BigInteger no = new BigInteger(1,messageDigest);
			String hashText = no.toString(16);
			
			while(hashText.length() < 32) {
				hashText = "0" + hashText;
			}
			return hashText;
		}
		catch(NoSuchAlgorithmException e) {
			throw new RuntimeException (e);
		}
	}
	

}
