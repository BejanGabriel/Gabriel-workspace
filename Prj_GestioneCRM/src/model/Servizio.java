package model;

public class Servizio {

	private int idServizio;
	private String nomeServizio;
	private String descrizione;
	private double prezzo;
	public int getIdServizio() {
		return idServizio;
	}
	public void setIdServizio(int idServizio) {
		this.idServizio = idServizio;
	}
	public String getNomeServizio() {
		return nomeServizio;
	}
	public void setNomeServizio(String nomeServizio) {
		this.nomeServizio = nomeServizio;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		return "Servizio [idServizio=" + idServizio + ", nomeServizio=" + nomeServizio + ", descrizione=" + descrizione
				+ ", prezzo=" + prezzo + "]";
	}
	
}
