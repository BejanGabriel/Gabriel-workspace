package model;

import java.sql.Date;

public class Appuntamento {

	private int idAppuntamento;
	private int idCliente;
	private Date dataAppuntamento;
	private String descrizione;
	private int utenteAssociato;
	
	public int getIdAppuntamento() {
		return idAppuntamento;
	}
	public void setIdAppuntamento(int idAppuntamento) {
		this.idAppuntamento = idAppuntamento;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Date getDataAppuntamento() {
		return dataAppuntamento;
	}
	public void setDataAppuntamento(Date dataAppuntamento) {
		this.dataAppuntamento = dataAppuntamento;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getUtenteAssociato() {
		return utenteAssociato;
	}
	public void setUtenteAssociato(int utenteAssociato) {
		this.utenteAssociato = utenteAssociato;
	}
	
	@Override
	public String toString() {
		return "Appuntamento [idAppuntamento=" + idAppuntamento + ", idCliente=" + idCliente + ", dataAppuntamento="
				+ dataAppuntamento + ", descrizione=" + descrizione + ", utenteAssociato=" + utenteAssociato + "]";
	}
	
}
