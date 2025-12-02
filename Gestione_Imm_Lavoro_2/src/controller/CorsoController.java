package controller;

import java.util.List;

import model.Corso;
import model.Studente;

public class CorsoController {
	private List<Corso> listaCorsi;
	private Databases dbManager;
	
	public CorsoController(List<Corso> listaCorsi, Databases dbManager) {
		this.listaCorsi = listaCorsi;
		this.dbManager = dbManager;
	}	
	
	public void addCorso(int id, String titolo, String codCorso, String aula) {
		Corso nuovo = new Corso(id, titolo, codCorso, codCorso);
		for(Corso c : listaCorsi) {
			if(c.compareTo(nuovo) == 0) {
				System.out.println("Corso già presente nella lista!");
				return;
			}
		}
		listaCorsi.add(nuovo);
		dbManager.salvaListaCorsi(listaCorsi);
		System.out.println("Corso aggiunto");
	}
	
	public void removeCorso(int id) {
		boolean removed = listaCorsi.removeIf(corso -> corso.getId().equals(id));
		if(removed) {
			dbManager.salvaListaCorsi(listaCorsi);
			System.out.println("Corso rimosso con successo!");
		}else {
			System.out.println("Non è stato possibile rimuovere il corso!");
		}
	}

	public List<Corso> getListaCorsi() {
		return listaCorsi;
	}
	
	public String VisualizzaCorsi() {
		StringBuilder sb = new StringBuilder();
		for(Corso c : listaCorsi) {
			sb.append("==== Lista Corsi ====");
			sb.append("\n" + c.getId() + "  |  " + c.getTitoloCorso() + "  |  " + c.getCodCorso() + "  |  " + c.getAulaCorso());
			
		}
		return sb.toString();
	}
	
	public void associaStudenti(List<Studente> studenti) {
	    for (Studente s : studenti) {
	        for (Corso c : listaCorsi) {
	            if (s.getCodCorsoIscritto().equals(c.getCodCorso())) {
	                c.getListaStudenti().add(s);
	            }
	        }
	    }
	}
}
