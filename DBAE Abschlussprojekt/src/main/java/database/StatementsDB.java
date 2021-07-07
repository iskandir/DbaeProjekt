package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import data.*;

public class StatementsDB {

	private static Connection con = null;
	//HochzÃ¤hlen der id Variable (keine SerialID, sondern bewusst 
	//einen Int genommen) 
	private static int benutzerid = 1;
	
	public static boolean benutzerHinzufuegen(Benutzer benutzer) {
		boolean erfolg = false;
		benutzerid++;
		System.out.println("Benutzerhinzufuegen startet");
		/**
		 * FÃ¼ge Values in die Datenbank. ?,?,?,?,?,?,?,?,?,? sind die Parameter die im Nachgang unter
		 * setString eingefÃ¼gt werden
		 */
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmtUser = con.prepareStatement("INSERT INTO userdata "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)");
			//Befehle zum einfÃ¼gen der einzelnen Werte in die entsprechende Datenbank
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
			
			/*Merke:Bei einem insert ist executeUpdate() notwendig
			AusfÃ¼hren der beiden oben definierten SQL Befehle zum schreiben in die Datenbank  
			*/
			int zeilen = pstmtUser.executeUpdate();
			
			if(zeilen > 0) 
			{
				erfolg = true;
				System.out.println("Erfolg beim hinzufÃ¼gen der Werte!");
				
			}
		} catch(SQLException e) {
			System.err.println("Fehler beim HinzufÃ¼gen der Benutzer mittels"
					+ " der Funktion benutzerHinzufuegen(Benutzer benutzer)" + 
					e.toString());
		}
		//abschlieÃend soll verbindung geschlossen werden, 
		//das wird in einem Try/Catch Block gelÃ¶st um mÃ¶gliche Fehler abzufangen.
				finally {
					try {
						con.close();
					} catch (SQLException e) {
						System.err.println("Fehler beim schlieÃen der Datenbank" 
					+ e.toString());
					}
				}

		//und return der variable erfolg als erfolgsmeldung
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
	
public static Benutzer[] getBenutzer() {
		
		List<Benutzer> benutzerListe = new ArrayList<Benutzer>();
		
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement what = con.prepareStatement("SELECT * FROM userdata");
			ResultSet rs = what.executeQuery();
			
			while(rs.next()) {
				Benutzer newBenutzer = new Benutzer(rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9)
						,rs.getString(10));
				benutzerListe.add(newBenutzer);
			}
		} catch (SQLException e) {
			System.err.println("SQL Fehler - WTF lol");
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				System.err.println("SQL Fehler - Verbindung konnte nicht "
						+ "geschlossen werden;");
			}
 		}
		
		return benutzerListe.toArray( new Benutzer[benutzerListe.size()]);
	}
	
	public static Produkt[] getHardware() {
		
		List<Produkt> produktListe = new ArrayList<Produkt>();
		
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement what = con.prepareStatement("SELECT * FROM hardware UNION SELECT * FROM software UNION SELECT * FROM peripherie");
			ResultSet rs = what.executeQuery();
			
			while(rs.next()) {
				Produkt newProdukt = new Produkt(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6));
				produktListe.add(newProdukt);
			}
		} catch (SQLException e) {
			System.err.println("SQL Fehler - WTF lol");
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				System.err.println("SQL Fehler - Verbindung konnte nicht "
						+ "geschlossen werden;");
			}
 		}
		
		return produktListe.toArray( new Produkt[produktListe.size()]);
	}
	public static Produkt[] getSoftware() {
		
		List<Produkt> produktListe = new ArrayList<Produkt>();
		
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement what = con.prepareStatement("SELECT * FROM software");
			ResultSet rs = what.executeQuery();
			
			while(rs.next()) {
				Produkt newProdukt = new Produkt(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6));
				produktListe.add(newProdukt);
			}
		} catch (SQLException e) {
			System.err.println("SQL Fehler - WTF lol");
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				System.err.println("SQL Fehler - Verbindung konnte nicht "
						+ "geschlossen werden;");
			}
 		}
		
		return produktListe.toArray( new Produkt[produktListe.size()]);
	}
	public static Produkt[] getPeripherie() {
		
		List<Produkt> produktListe = new ArrayList<Produkt>();
		
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement what = con.prepareStatement("SELECT * FROM peripherie");
			ResultSet rs = what.executeQuery();
			
			while(rs.next()) {
				Produkt newProdukt = new Produkt(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6));
				produktListe.add(newProdukt);
			}
		} catch (SQLException e) {
			System.err.println("SQL Fehler - WTF lol");
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				System.err.println("SQL Fehler - Verbindung konnte nicht "
						+ "geschlossen werden;");
			}
			}
		
		return produktListe.toArray( new Produkt[produktListe.size()]);
	}

	public static void ticketHinzufügen(Ticket ticket) throws SQLException {
		Connection con = DatabaseConnection.getConnection();
		con.setAutoCommit(false);
		PreparedStatement stTicket = con.prepareStatement("INSERT INTO supportdata (nachname, vorname, email, betreff, inhalt) VALUES (?, ?, ?, ?, ?);");
		stTicket.setString(1, ticket.getName());
		stTicket.setString(2, ticket.getVorname());
		stTicket.setString(3, ticket.getMail());
		stTicket.setString(4, ticket.getBetreff());
		stTicket.setString(5, ticket.getInhalt());
		stTicket.executeUpdate();
		
		con.commit();
		con.setAutoCommit(true);
		con.close();
	}
	
	
}
