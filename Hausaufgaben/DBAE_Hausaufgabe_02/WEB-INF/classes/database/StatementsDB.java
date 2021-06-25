package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.Benutzer;
/** Classe für die einzelnen Datenbank Statements (benutzerHinzufügen / benutzerLogin)
 * 
 * @author Clemens Bleck, Dennis Hasselbusch, Marten Kracke
 *
 */
public class StatementsDB {
	//Variable für die Verbindung zur Datenbank und Zählvariable für die Benutzerid 
	private static Connection con = null;
	private static int benutzerid = 1;
	/**Füge Benutzer anhand Email, Passwort und weiteren Variablen in der Datenbank hinzu
	 * 
	 * @param benutzer
	 * @return
	 */
	public static boolean benutzerHinzufuegen(Benutzer benutzer) {
		boolean erfolg = false;
		/**
		 * Füge Values in die Datenbank. ?,?,?,?,?,? sind die Parameter die im Nachgang unter
		 * setString eingefügt werden
		 */
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO benutzer VALUES(?,?,?,?,?,?);");
			PreparedStatement pstmtpw = con.prepareStatement("INSERT INTO passwoerter VALUES(?,?);");
			
			//Values für benutzer input
			pstmt.setInt(1, benutzerid);
			pstmt.setString(2, benutzer.getEmail());
			pstmt.setString(3, benutzer.getVorname());
			pstmt.setString(4, benutzer.getNachname());
			pstmt.setInt(5, benutzer.getAlter());
			pstmt.setString(6, benutzer.getRolle());
			System.out.println("Datenbank Statement für benutzer ist: " + pstmt.toString());
			//Füge die Values BenutzerID und das Passwort in die Datenbank unter Tabelle passwoerter
			pstmtpw.setInt(1, benutzerid);
			pstmtpw.setString(2, benutzer.getPasswort());
			System.out.println("Datenbank Statement für passwoerter ist : " + pstmtpw.toString());
			/* Merke:Bei einem insert ist executeUpdate() notwendig
			Ausführen der beiden oben definierten SQL Befehle zum schreiben in die Datenbank  
			*/
			int zeilen = pstmt.executeUpdate();
			int zeilen1 = pstmtpw.executeUpdate();
	
			// Wenn update erfolgreich, setzte erfolg auf true
			if (zeilen + zeilen1 > 0) {
				erfolg = true;
			}
		} catch (SQLException e) {
			System.err.println("Fehler beim Hinzufügen der Benutzer- benutzerHinzufuegen()" + e.toString());
		}
		// abschließend soll verbindung geschlossen werden, das wird in einem Try/Catch Block gelöst um mögliche Fehler abzufangen.
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("Fehler beim schließen der Datenbank" + e.toString());
			}
		}
		//Hochzählen der id Variable (keine SerialID, sondern bewusst einen Int genommen) 
		//und return der variable erfolg als erfolgsmeldung
		benutzerid++;
		return erfolg;
	}
	/**Prüfe Login anhand von Email und Passwort und ob ein Benutzer in der Datenbank existiert
	 * 
	 * @param benutzer
	 * @return
	 */
	/*public static boolean benutzerLogin(Benutzer benutzer)
	{
		boolean erfolg = false;
		/**Try and Catch Block um mögliche Fehler (SQLException) abzufangen
		 * 
		 */
		/*try
		{
			//ähnlich wie oben, Aufbau der Verbindung, Deklaration des SQL Befehls und ausführen.
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM benutzer JOIN passwoerter ON benutzer.benutzerid=passwoerter.benutzerid WHERE benutzer.email LIKE ? AND passwoerter.passwort LIKE ?");
			pstmt.setString(1, benutzer.getEmail());
			pstmt.setString(2, benutzer.getPasswort());
			ResultSet rs = pstmt.executeQuery();
			System.out.println(rs.toString());
			//Wenn Eintrag gefunden wird = Eingabe korrekt -> ERFOLGREICHER LOGIN
			if(rs.next())
			{
				erfolg = true;
			}
		} catch (SQLException e)
		{
			System.err.println("SQL Fehler bei Benutzer Login!");
		} finally 
		{
			try {
				con.close();
			} catch(SQLException e)
			{
				System.err.println("SQL Fehler bei Benutzer Login - Verbindung konnte nicht geschlossen werden");
			}
		}
		*/

	public static Benutzer benutzerLogin(Benutzer benutzer)
	{
		Benutzer sqlBenutzer = new Benutzer(null, null, benutzerid, null, null, null);
		try
		{
			//ähnlich wie oben, Aufbau der Verbindung, Deklaration des SQL Befehls und ausführen.
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM benutzer JOIN passwoerter ON benutzer.benutzerid=passwoerter.benutzerid WHERE benutzer.email LIKE ? AND passwoerter.passwort LIKE ?");
			pstmt.setString(1, benutzer.getEmail());
			pstmt.setString(2, benutzer.getPasswort());
			ResultSet rs = pstmt.executeQuery();
			//Wenn Eintrag gefunden wird = Eingabe korrekt -> ERFOLGREICHER LOGIN
			if(rs.next())
			{
				sqlBenutzer = new Benutzer(rs.getString(1), rs.getString(7),rs.getInt(4), rs.getString(2), rs.getString(3), rs.getString(5));
			}
		} catch (SQLException e)
		{
			System.err.println("SQL Fehler bei Benutzer Login!");
		} finally 
		{
			try {
				con.close();
			} catch(SQLException e)
			{
				System.err.println("SQL Fehler bei Benutzer Login - Verbindung konnte nicht geschlossen werden");
			}
		}
		return sqlBenutzer;
	}
}
