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


	public void setBestellnummer(int bestellnummer) {
		this.bestellnummer = bestellnummer;
	}


	public Instant getBestellzeitpunkt() {
		return bestellzeitpunkt;
	}


	public void setBestellzeitpunkt(Instant bestellzeitpunkt) {
		this.bestellzeitpunkt = bestellzeitpunkt;
	}


	public Double getGesamtbetrag() {
		return gesamtbetrag;
	}


	public void setGesamtbetrag(Double gesamtbetrag) {
		this.gesamtbetrag = gesamtbetrag;
	}


	public String[] getProduktnummern() {
		return produktnummern;
	}


	public void setProduktnummern(String[] produktnummern) {
		this.produktnummern = produktnummern;
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


	public String getStrasse() {
		return strasse;
	}


	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}


	public String getHausnummer() {
		return hausnummer;
	}


	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}


	public String getPostleitzahl() {
		return postleitzahl;
	}


	public void setPostleitzahl(String postleitzahl) {
		this.postleitzahl = postleitzahl;
	}


	public String getStadt() {
		return stadt;
	}


	public void setStadt(String stadt) {
		this.stadt = stadt;
	}
	
	
	
	
}
