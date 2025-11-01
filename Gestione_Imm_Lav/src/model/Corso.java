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
	
	
}
