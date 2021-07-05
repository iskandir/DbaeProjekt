package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data.Benutzer;

public class StatementsDB {

	private static Connection con = null;
	private static int benutzerid = 1;
	
	public static boolean benutzerHinzufuegen(Benutzer benutzer) {
		boolean erfolg = false;
		
		/**
		 * Füge Values in die Datenbank. ?,?,?,?,?,?,?,?,?,? sind die Parameter die im Nachgang unter
		 * setString eingefügt werden
		 */
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmtUser = con.prepareStatement("INSERT INTO userdata "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)");
			//Befehle zum einfügen der einzelnen Werte in die entsprechende Datenbank
			pstmtUser.setInt(1, benutzerid);
			pstmtUser.setString(2, benutzer.getUsername());
			pstmtUser.setString(3, benutzer.getPassword());
			pstmtUser.setString(4, benutzer.getStreet());
			pstmtUser.setString(5, benutzer.getHousenmb());
			pstmtUser.setString(6, benutzer.getPostalcode());
			pstmtUser.setString(7, benutzer.getCity());
			pstmtUser.setString(8, benutzer.getFirstName());
			pstmtUser.setString(9, benutzer.getLastName());
			pstmtUser.setString(10, benutzer.getEmail());
			
			/* Merke:Bei einem insert ist executeUpdate() notwendig
			Ausführen der beiden oben definierten SQL Befehle zum schreiben in die Datenbank  
			*/
			int zeilen = pstmtUser.executeUpdate();
		
			
			if(zeilen > 0) 
			{
				erfolg = true;
			}
		} catch(SQLException e) {
			System.err.println("Fehler beim Hinzufügen der Benutzer mittels"
					+ " der Funktion benutzerHinzufuegen(Benutzer benutzer)" + 
					e.toString());
		}
		// abschließend soll verbindung geschlossen werden, 
		//das wird in einem Try/Catch Block gelöst um mögliche Fehler abzufangen.
				finally {
					try {
						con.close();
					} catch (SQLException e) {
						System.err.println("Fehler beim schließen der Datenbank" 
					+ e.toString());
					}
				}
		//Hochzählen der id Variable (keine SerialID, sondern bewusst 
		//einen Int genommen) 
		//und return der variable erfolg als erfolgsmeldung
		benutzerid++;
		return erfolg;
	}
	
	public static Benutzer benutzerLogin(Benutzer benutzer) {
		Benutzer sqlBenutzer = new Benutzer(null, null);
		
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmtUserLogin = con.prepareStatement("SELECT *"
					+ " FROM userdata WHERE benutzer.email LIKE ? and "
					+ "password LIKE ?");
			pstmtUserLogin.setString(1, benutzer.getEmail());
			pstmtUserLogin.setString(2, benutzer.getPassword());
			ResultSet rs = pstmtUserLogin.executeQuery();
			
			if(rs.next()) {
				sqlBenutzer = new Benutzer(rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9)
						,rs.getString(10));
			}
		} catch (SQLException e) {
			System.err.println("SQL Fehler - User nicht gefunden!");
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				System.err.println("SQL Fehler - Verbindung konnte nicht "
						+ "geschlossen werden;");
			}
		}
		return sqlBenutzer;
	}
	
	
}
