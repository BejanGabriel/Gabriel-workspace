package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Corso {
	public static int contatore = 0;
	private int id;
	private String titolo;
	private String codCorso;
	private List<Studente> numPartecipanti;
	private Map<String, Studente> listaCorsiEPartecipanti;
	
	public Corso(String titolo, String codCorso) {
		this.id = contatore++;
		this.titolo = titolo;
		this.codCorso = codCorso;
		this.numPartecipanti = new ArrayList<>();
		this.listaCorsiEPartecipanti = new HashMap<>();
	}

	public String getTitolo() {
		return titolo;
	}

	public String getCodCorso() {
		return codCorso;
	}

	public List<Studente> getNumPartecipanti() {
		return numPartecipanti;
	}

	public Map<String, Studente> getListaCorsiEPartecipanti() {
		return listaCorsiEPartecipanti;
	}
	
	public String getInfoCorso() {
		return "\nNome corso: " + titolo + "\nCodice corso: " + codCorso +"\nPartecipanti: " + numPartecipanti.size();
	}

	/*
	AGGIUNTA CODICE FATA A SCUOLA
	
	public class Corso implements Comparable<Corso> {
	public static int contatore = 0;
	private int id;
	private String titolo;
	private String codCorso;
	private List<Corso> listaCorsi;

	public Corso(String titolo, String codCorso) {
		this.id = contatore++;
		this.titolo = titolo;
		this.codCorso = codCorso;
		this.listaCorsi = new ArrayList<>();

	}

	public String getTitolo() {
		return titolo;
	}

	public String getCodCorso() {
		return codCorso;
	}

	public List<Corso> getListaCorsi() {
		return listaCorsi;
	}

	//add e remove vanno messi nel controller

	public String getInfoCorso() {
		return "\nNome corso: " + titolo + "\nCodice corso: " + codCorso
				+ "\nPartecipanti: " + listaCorsi.size();
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
	}*/
	
}
