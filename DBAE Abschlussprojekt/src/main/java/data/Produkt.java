/**
 * 
 */
package data;

/**
 * @author clemensbeck
 *
 */
public class Produkt {
	private String titel;
	private String beschreibung;
	private Double preis;
	private String bild;
	private String produktnummer;
	private String type;
	private String art;
	private int kaufanzahl;
	
	public Produkt(String titel, String beschreibung, Double preis, String bild, String produktnummer, String type) {
		this.titel = titel;
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.bild = bild;
		this.produktnummer = produktnummer;
		this.type = type;
	}
	
	public Produkt(String titel, String beschreibung, Double preis, String bild, String produktnummer, String type, String art) {
		this.titel = titel;
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.bild = bild;
		this.produktnummer = produktnummer;
		this.type = type;
		this.art = art;
	}
	
	public Produkt(String titel, String beschreibung, Double preis, String bild, String produktnummer, String type, int kaufanzahl) {
		this.titel = titel;
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.bild = bild;
		this.produktnummer = produktnummer;
		this.type = type;
		this.kaufanzahl = kaufanzahl;
	}
	
	public String getTitel() {
		return titel;
	}
	
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	public String getBeschreibung() {
		return beschreibung;
	}
	
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	public Double getPreis() {
		return preis;
	}
	
	public void setPreis(Double preis) {
		this.preis = preis;
	}
	
	public String getBild() {
		return bild;
	}
	
	public void setBild(String bild) {
		this.bild = bild;
	}
	
	public String getProduktnummer() {
		return produktnummer;
	}
	
	public void setProduktnummer(String produktnummer) {
		this.produktnummer = produktnummer;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public int getKaufanzahl() {
		return kaufanzahl;
	}

	public void setKaufanzahl(int kaufanzahl) {
		this.kaufanzahl = kaufanzahl;
	}
}
