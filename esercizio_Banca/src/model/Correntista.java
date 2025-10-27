package model;

import java.util.ArrayList;
import java.util.List;

public class Correntista {
	private static int contatore = 0;
	private int id;
	private String nome;
	private String cognome;
	private List<Conto> conti;
	
	public Correntista(String nome, String cognome, String codFiscale) {
		this.id = contatore++;
		this.nome = nome;
		this.cognome = cognome;
		this.conti = new ArrayList<>();
	}
	
	public void aggiungiConto(Conto nuovoConto) {
		conti.add(nuovoConto);
	}
	
	public boolean rimuoviConto(String iban) {
	    for (Conto conto : conti) {
	        if (conto.getIban().equals(iban)) {
	            conti.remove(conto);
	            return true;
	        }
	    }
	    return false;
	}
	

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public List<Conto> getConti() {
		return conti;
	}

	public String getInfoCorrentista() {
		return "ID Correntista: " + id + "\nNome: " + nome + ", cognome: " + cognome ;
	}
	
	
}
