package data;

import java.time.Instant;;

/**
 * @author clemensbeck
 *
 */
public class Bestellung {
	
	private int bestellnummer;
	private Instant bestellzeitpunkt;
	private Double gesamtbetrag;
	private String[] produktnummern;
	private String vorname;
	private String nachname;
	private String strasse;
	private String hausnummer;
	private String postleitzahl;
	private String stadt;
	
	/**Konstruktor für das Abschließen einer Bestellung (ohne bestellnummer, die wird von der SQL Datenbank autmatisch generiert)
	 * @author clemensbeck
	 * @param bestellzeitpunkt
	 * @param gesamtbetrag
	 * @param produktnummern
	 * @param vorname
	 * @param nachname
	 * @param strasse
	 * @param hausnummer
	 * @param postleitzahl
	 * @param stadt
	 */
	public Bestellung (Instant bestellzeitpunkt, Double gesamtbetrag, String[] produktnummern, String vorname, String nachname, String strasse, String hausnummer, String postleitzahl, String stadt) {
		this.bestellzeitpunkt = bestellzeitpunkt;
		this.gesamtbetrag = gesamtbetrag; 
		this.produktnummern = produktnummern;
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.postleitzahl = postleitzahl;
		this.stadt = stadt;
	}
	
	/**Konstruktor für Bestellungen aus der Datenbank
	 * @author clemensbeck
	 * @param bestellnummer
	 * @param bestellzeitpunkt
	 * @param gesamtbetrag
	 * @param produktnummern
	 * @param vorname
	 * @param nachname
	 * @param strasse
	 * @param hausnummer
	 * @param postleitzahl
	 * @param stadt
	 */
	public Bestellung (int bestellnummer, Instant bestellzeitpunkt, Double gesamtbetrag, String[] produktnummern, String vorname, String nachname, String strasse, String hausnummer, String postleitzahl, String stadt) {
		this.bestellnummer = bestellnummer;
		this.bestellzeitpunkt = bestellzeitpunkt;
		this.gesamtbetrag = gesamtbetrag; 
		this.produktnummern = produktnummern;
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.postleitzahl = postleitzahl;
		this.stadt = stadt;
	}

	public int getBestellnummer() {
		return bestellnummer;
	}

	public Instant getBestellzeitpunkt() {
		return bestellzeitpunkt;
	}

	public Double getGesamtbetrag() {
		return gesamtbetrag;
	}

	public String[] getProduktnummern() {
		return produktnummern;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public String getStrasse() {
		return strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public String getPostleitzahl() {
		return postleitzahl;
	}

	public String getStadt() {
		return stadt;
	}
}
