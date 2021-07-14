package database;


import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Timestamp;
import java.time.Instant;

import data.*;
/** Ansammlung von verschiedenen Statemens für die Zugriffe auf die Datenbank
 * 
 * @author dennishasselbusch, clemensbeck, martenkracke
 *
 */
public class StatementsDB {

	private static Connection con = null;
	//hochzählen der Benutzerid zum zählen der Nutzer / Identifikation der Nutzer
	private static int benutzerid = 0;
	
	/**Funktion wird benötigt um die Anzahl der Nutzer zu zählen und eine
	 * zuverlässige Zuordnung der BenutzerId zu gewährleisten
	 * erstellt von dennishasselbusch
	 * @return
	 */
	private static Integer countUser() {
		ResultSet rs = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    int numberOfRows = 0;
	    try {
	      conn = DatabaseConnection.getConnection();
	      String query = "select count(*) from userdata";
	      pstmt = conn.prepareStatement(query);
	      rs = pstmt.executeQuery();
	      if (rs.next()) {
	        numberOfRows = rs.getInt(1);
	        System.out.println("numberOfRows= " + numberOfRows);
	      } else {
	        System.out.println("Error: Konnte die Anzahl der User nicht auslesen");
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        rs.close();
	        pstmt.close();
	        conn.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
		return numberOfRows;
	  }
		
	/**Funktion wird benötigt um Benutzer zur Datenbank hinzuzufügen 
	 * erstellt von dennishasselbusch
	 * @param benutzer
	 * @return
	 */
	public static boolean benutzerHinzufuegen(Benutzer benutzer) {
		boolean erfolg = false;
		benutzerid = countUser() + 1;
		System.out.println("BenutzerId ist " + benutzerid);
		
		System.out.println("Benutzerhinzufuegen startet");
		/**
		 * FÃ¼ge Values in die Datenbank. ?,?,?,?,?,?,?,?,?,? sind die Parameter die im Nachgang unter
		 * setString eingefÃ¼gt werden
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
			
			//Merke:Bei einem insert ist executeUpdate() notwendig
			int zeilen = pstmtUser.executeUpdate();
			
			if(zeilen > 0) 
			{
				erfolg = true;
				System.out.println("Erfolg beim hinzufü¼gen der Werte!");
				
			}
		} catch(SQLException e) {
			System.err.println("Fehler beim Hinzufügen der Benutzer mittels"
					+ " der Funktion benutzerHinzufuegen(Benutzer benutzer)" + 
					e.toString());
		}
		//Abschließend muss DB wieder geschlossen werden	
			finally {
					try {
						con.close();
					} catch (SQLException e) {
						System.err.println("Fehler beim schließen der Datenbank" 
					+ e.toString());
					}
				}
		//und return der variable erfolg als erfolgsmeldung
		return erfolg;
	}
	/**Funktion die das Login des Benutzers durchführt in dem Nutzername und passwort abgefragt werden
	 * erstellt von dennishasselbusch
	 * @param benutzer
	 * @return
	 */
	public static Benutzer benutzerLogin(Benutzer benutzer) {
		Benutzer sqlBenutzer = new Benutzer(null, null);
		
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmtUserLogin = con.prepareStatement("SELECT *"
					+ " FROM userdata WHERE username LIKE ? and "
					+ "password LIKE ?");

			pstmtUserLogin.setString(1, benutzer.getUsername());
			pstmtUserLogin.setString(2, benutzer.getPassword());
			ResultSet rs = pstmtUserLogin.executeQuery();

			if(rs.next()) {
				sqlBenutzer = new Benutzer(rs.getString(2), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				System.out.println("User ist mit den Logindaten"
						+ " in der Datenbank vorhanden");
				System.out.println(sqlBenutzer.getFirstName() + sqlBenutzer.getLastName() + sqlBenutzer.getUsername());
				return sqlBenutzer;
			}
		} catch (SQLException e) {
			System.err.println("SQL Fehler - User nicht gefunden!");
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				System.err.println("SQL Fehler - Verbindung konnte nicht "
						+ "geschlossen werden");
			}
		}
		return null;
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
			PreparedStatement what = con.prepareStatement("SELECT * FROM hardware");
			ResultSet rs = what.executeQuery();
			
			while(rs.next()) {
				Produkt newProdukt = new Produkt(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), "hardware");
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
				Produkt newProdukt = new Produkt(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), "software");
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
				Produkt newProdukt = new Produkt(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), "peripherie");
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
	
	public static Produkt getProdukt(String produktnummer) throws SQLException {
		Produkt produkt = null;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM hardware WHERE produktnummer = '" + produktnummer
				+ "' UNION SELECT * FROM software WHERE produktnummer = '" + produktnummer
				+ "' UNION SELECT * FROM peripherie WHERE produktnummer = '" + produktnummer + "';"
		);
		ResultSet result = st.executeQuery();
		con.close();
		if (result.next()) {
			produkt = new Produkt(result.getString(1), result.getString(2), result.getDouble(3), result.getString(4), result.getString(5), result.getString(6));
		}
		return produkt;
	}
	
	public static Produkt getProdukt(String produktnummer, String art) throws SQLException {
		Produkt produkt = null;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM " + art + " WHERE produktnummer = '" + produktnummer + "';"
		);
		ResultSet result = st.executeQuery();
		con.close();
		if (result.next()) {
			produkt = new Produkt(result.getString(1), result.getString(2), result.getDouble(3), result.getString(4), result.getString(5), result.getString(6), art);
		}
		return produkt;
	}
	
	public static Produkt[] getTopProdukte() throws SQLException {
		Produkt[] produkte = null;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM (SELECT * FROM hardware UNION SELECT * FROM software UNION SELECT * from peripherie) allProducts ORDER BY kaufanzahl DESC LIMIT 10;"
			);
		ResultSet result = st.executeQuery();
		con.close();
		if (result.next()) {
			produkte = new Produkt[10];
			for (int i = 0; i < 10; i++) {
				produkte[i] = new Produkt(result.getString(1), result.getString(2), result.getDouble(3), result.getString(4), result.getString(5), result.getString(6), result.getInt(7));
				result.next();
			}
		}
		return produkte;
	}
	
	public static Produkt[] sucheProdukte(String suche) {
		
		System.out.println(suche);
		
		List<Produkt> produktListe = new ArrayList<Produkt>();
		
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement what = con.prepareStatement(
					"SELECT * FROM hardware WHERE titel ILIKE '%" + suche + "%' UNION "
					+ "SELECT * FROM software WHERE titel ILIKE '%" + suche + "%' UNION "
					+ "SELECT * FROM peripherie WHERE titel ILIKE '%" + suche + "%'"
					+ ";");
			ResultSet rs = what.executeQuery();
			
			while(rs.next()) {
				Produkt newProdukt = new Produkt(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6));
				produktListe.add(newProdukt);
			}
		} catch (SQLException e) {
			System.err.println("SQL Fehler - WTF lol: " + e.toString());
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

	public static void ticketHinzufuegen(Ticket ticket) throws SQLException {
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
	
	public static void bestellungHinzufuegen(Bestellung bestellung) {
		try {
			con = DatabaseConnection.getConnection();
			
			Array tempArray = con.createArrayOf("VARCHAR", bestellung.getProduktnummern());
			
			PreparedStatement stBestellung = con.prepareStatement("INSERT INTO bestellungen (bestellzeitpunkt, gesamtbetrag, produktnummern, vorname, nachname, strasse, hausnummer, postleitzahl, stadt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
			
			Instant instant = bestellung.getBestellzeitpunkt();
			Timestamp timestamp = instant != null ? new Timestamp(instant.toEpochMilli()) : null;
			
			stBestellung.setTimestamp(1, timestamp);
			stBestellung.setDouble(2, bestellung.getGesamtbetrag());
			stBestellung.setArray(3, tempArray);
			stBestellung.setString(4, bestellung.getVorname());
			stBestellung.setString(5, bestellung.getNachname());
			stBestellung.setString(6, bestellung.getStrasse());
			stBestellung.setString(7, bestellung.getHausnummer());
			stBestellung.setString(8, bestellung.getPostleitzahl());
			stBestellung.setString(9, bestellung.getStadt());
			
			stBestellung.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}
	
	public static Bestellung[] getBestellungen() {
		
		List<Bestellung> bestellungenList = new ArrayList<Bestellung>();
		
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement what = con.prepareStatement("SELECT * FROM bestellungen");
			ResultSet rs = what.executeQuery();
			
			while(rs.next()) {
				
				Timestamp timestamp = rs.getTimestamp(2);
				Instant instant = timestamp != null ? Instant.ofEpochMilli(timestamp.getTime()) : null;
				
				Array tempArray = (Array) rs.getArray(4);
				String[] produktnummern = (String[]) tempArray.getArray();
				
				Bestellung newBestellung = new Bestellung(rs.getInt(1), instant, rs.getDouble(3), produktnummern, rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				bestellungenList.add(newBestellung);
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
    
		//PreparedStatement stIncrement = con.prepareStatement("UPDATE () SET kaufanzahl = kaufanzahl + 1 WHERE produktnummer = pm_div");
    
		System.out.println(bestellungenList.size());
		return bestellungenList.toArray( new Bestellung[bestellungenList.size()]);
	}
}
