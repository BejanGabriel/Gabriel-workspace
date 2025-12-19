package model;

import java.sql.Date;

public class Utente {

	private int idUtente;
	private String nomeUtente;
	private String ruolo;
	private String email;
	private String password;
	private Date dataRegistrazione;
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public String getNomeUtente() {
		return nomeUtente;
	}
	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}
	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}
	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", nomeUtente=" + nomeUtente + ", ruolo=" + ruolo + ", email=" + email
				+ ", password=" + password + ", dataRegistrazione=" + dataRegistrazione + "]";
	}
	
}
