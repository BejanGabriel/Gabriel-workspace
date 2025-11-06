package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Corso;
import model.Studente;

public class CorsoController {
	private Corso corso;
	private List<Corso> listaCorsi;
//	private Map<String, Studente> listaCorsiEPartecipanti;

	public CorsoController() {
		// this.corso = new Corso(nomeCorso, codCorso);
		this.listaCorsi = new ArrayList<>();
//		this.listaCorsiEPartecipanti = new HashMap<>();
	}

	public void addCorso(String nomeCorso, String codCorso) {
		Corso nuovoCorso = new Corso(nomeCorso, codCorso);
		listaCorsi.add(nuovoCorso);
	}
	
	public boolean removeCorso(String codCorso) {
		   return listaCorsi.removeIf(c -> c.getCodCorso().equals(codCorso));
	}

	public List<Corso> visualizzaCorsi() {
		return new ArrayList<>(listaCorsi);
	}
}
