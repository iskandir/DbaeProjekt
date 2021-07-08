package data;

/**
 * @author clemensbeck
 *
 */
public class Bestellung {
	
	private Integer bestellnummer;
	private Double gesamtbetrag;
	private String mail;
	private String[] produktnummern;
	
	public Bestellung (Integer bestellnummer, Double gesamtbetrag, String mail, String[] produktnummern ) {
		this.bestellnummer = bestellnummer; 
		this.gesamtbetrag = gesamtbetrag; 
		this.mail = mail;
		this.produktnummern = produktnummern;
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
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String useremail) {
		this.mail = useremail;
	}
	
	public String[] getProduktnummern() {
		return produktnummern;
	}
	
	public void setProduktnummern(String[] produktnummern) {
		this.produktnummern = produktnummern;
	}
}
