package model;

import java.sql.Date;

public class Nota {

	private int idNota;
	private int idCliente;
	private String testoNota;
	private Date dataRegistrazione;
	private int utenteRegistrato;
	public int getIdNota() {
		return idNota;
	}
	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getTestoNota() {
		return testoNota;
	}
	public void setTestoNota(String testoNota) {
		this.testoNota = testoNota;
	}
	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}
	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}
	public int getUtenteRegistrato() {
		return utenteRegistrato;
	}
	public void setUtenteRegistrato(int utenteRegistrato) {
		this.utenteRegistrato = utenteRegistrato;
	}
	
	@Override
	public String toString() {
		return "Nota [idNota=" + idNota + ", idCliente=" + idCliente + ", testoNota=" + testoNota
				+ ", dataRegistrazione=" + dataRegistrazione + ", utenteRegistrato=" + utenteRegistrato + "]";
	}
	
	
}
