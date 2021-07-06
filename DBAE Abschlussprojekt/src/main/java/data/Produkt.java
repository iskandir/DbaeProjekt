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
}
