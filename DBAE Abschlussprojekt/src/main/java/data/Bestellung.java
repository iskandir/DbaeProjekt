package data;

/**
 * @author clemensbeck
 *
 */
public class Bestellung {
	
	private Integer bestellnummer;
	private Double gesamtbetrag;
	private String[] produktnummern;
	private String vorname;
	private String nachname;
	private String strasse;
	private String hausnummer;
	private String postleitzahl;
	private String stadt;
	
	
	public Bestellung (Integer bestellnummer, Double gesamtbetrag, String[] produktnummern, String vorname, String nachname, String strasse, String hausnummer, String postleitzahl, String stadt) {
		this.bestellnummer = bestellnummer; 
		this.gesamtbetrag = gesamtbetrag; 
		this.produktnummern = produktnummern;
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.postleitzahl = postleitzahl;
		this.stadt = stadt;
	}


	public Integer getBestellnummer() {
		return bestellnummer;
	}


	public void setBestellnummer(Integer bestellnummer) {
		this.bestellnummer = bestellnummer;
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
