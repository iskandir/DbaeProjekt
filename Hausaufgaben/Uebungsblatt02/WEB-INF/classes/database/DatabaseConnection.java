package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/** Allgemeine Daten für die Datenbank Zugriffe
 * 
 * @author Clemens Bleck, Dennis Hasselbusch, Marten Kracke
 *
 */
public class DatabaseConnection {
	/**Allgemeine Zugriffsdaten um auf die Datenbank zugreifen zu können
	 * 
	 */
	protected static Connection con;
	private static final String DB_SERVER = "127.0.0.1:5432";
	private static final String DB_NAME = "Uebung02";
	private static final String DB_USER= "postgres";
	private static final String DB_PASSWORD= "postgres";
	private static final String DB_DRIVER= "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://" + DB_SERVER + "/" + DB_NAME;
	/**Initialisierung der Verbindung
	 * 
	 * @return
	 * @throws SQLException
	 */
	private static Connection init() throws SQLException {
		try 
		{
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			System.out.println("Connection successfull!");
			return con;
		} 
		catch(ClassNotFoundException cfe) 
		{
			System.out.println("Driver not found");
			cfe.printStackTrace();
			System.out.println("Connection was not successfull!");
		}
		return null;
	}
	/**Rufe eine Verbindung auf
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException
	{
		try
		{
			return (con == null || con.isClosed()) ? init() : con;
		} 
		catch(SQLException e)
		{
			e.printStackTrace();
			return init();
		}
	}
	
}
