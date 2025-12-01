package model;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Corso implements Comparable<Corso> {
	public static int contatore = 0;
	private int id;
	private String titolo;
	private String codCorso;
	private String aula;
	private Date dataCreazione;
	private List<Studente> listaStudenti;

	public Corso(String titolo, String codCorso, String aula, Date dataCreazione) {
		this.id = contatore++;
		this.titolo = titolo;
		this.codCorso = codCorso;
		this.aula = aula;
		this.dataCreazione = dataCreazione;
		this.listaStudenti = new ArrayList<>();
	}

	public int getId() {
		return id;
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
	
	public String getAula() {
		return aula;
	}
	
	public List<Studente> getListaStudenti() {
		return listaStudenti;
	}

	//add, remove e lista, vanno messi nel controller

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

	public String getListaCorsoStudenti() {
		StringBuffer info = new StringBuffer();
		info.append("=== Lista Studenti del corso " + this.titolo + " ===");
		if(listaStudenti.size() == 0) {
			info.append("\nNessun studente iscritto!");
		}
		for (Studente studente : listaStudenti) {
			info.append("\nNome: " + studente.getNome() + "   |  Cognome: " + studente.getCognome() +
					"   |  Cod. Fiscale: " + studente.getCodFiscale());
		}
		return info.toString();
	}	
	
	
}