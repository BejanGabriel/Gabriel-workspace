package model;

import java.util.ArrayList;
import java.util.List;

public class Studente {
	private static int contatore = 0;
	private int id;
	private String nome;
	private String cognome;
	private String codFiscale;
	private String corsoIscritto;
	private List<Corso> listaCorsi;
	
	public Studente(String nome, String cognome, String codFiscale) {
		this.id = contatore++;
		this.nome = nome;
		this.cognome = cognome;
		this.codFiscale = codFiscale;
		this.corsoIscritto = corsoIscritto;
		this.listaCorsi = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public String getCorsoIscritto() {
		return corsoIscritto;
	}

	public List<Corso> getListaCorsi() {
		return listaCorsi;
	}
	
	public String getInfoStudente() {
		return "\nNome: " + nome + "\nCognome: " + "\nCodice Fiscale: " + codFiscale + "\nIscritto a " + listaCorsi.size() + " corsi.";
	}
	
	
	
	
}


