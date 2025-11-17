package model;

import java.util.Date;

public class Corso implements Comparable<Corso> {
	public static int contatore = 0;
	private int id;
	private String titolo;
	private String codCorso;
	private Date dataCreazione;

	public Corso(String titolo, String codCorso, Date dataCreazione) {
		this.id = contatore++;
		this.titolo = titolo;
		this.codCorso = codCorso;
		this.dataCreazione = dataCreazione;

	}

	public String getTitolo() {
		return titolo;
	}

	public String getCodCorso() {
		return codCorso;
	}
	
	public Date getDataCreazione() {
		return dataCreazione;
	}
	
	//add, remove e lista, vanno messi nel controller

	public String getInfoCorso() {
		return "\nNome corso: " + titolo + "\nCodice corso: " + codCorso;
	}

	@Override
	public int compareTo(Corso corso) {
		int confrontoTitolo = this.titolo.compareTo(corso.getTitolo());
		if (confrontoTitolo == 0) {
			int confCodCorso = this.codCorso.compareTo(corso.getCodCorso());
			if (confCodCorso == 0) {
				return confCodCorso;
			}
		}
		return confrontoTitolo;
	}
	
	
	
}
