package controller;

import java.util.List;

import model.Studente;

public class StudenteController {
	private List<Studente> listaStudenti;
	private Databases dbManager;

	public StudenteController(List<Studente> listaStudenti, Databases dbManager) {
		this.listaStudenti = listaStudenti;
		this.dbManager = dbManager;
	}
	
	public void addStudente(int id, String nome, String cognome, String codFiscal, String codCorsoIscritto) {
		Studente nuovo = new Studente(id, nome, cognome, codFiscal, codCorsoIscritto);
		for(Studente s : listaStudenti) {
			if(s.compareTo(nuovo) == 0) {
				System.out.println("Studente già presente!");
				return;
			}
			listaStudenti.add(nuovo);
			dbManager.salvaListaStudenti(listaStudenti);
			System.out.println("Studente aggiunto correttamente");
		}
	}
	
	public void removeStudete(int id) {
		boolean removed = listaStudenti.removeIf(studente -> studente.getId().equals(id));
		if(removed) {
			dbManager.salvaListaStudenti(listaStudenti);
			System.out.println("Studente rimosso correttamente");
		}
		System.out.println("Non è stato possibile rimuovere lo studente!");
	}

	public List<Studente> getListaStudenti() {
		return listaStudenti;
	}
	
	public String VisualizzaStudenti() {
		StringBuilder sb = new StringBuilder();
		for(Studente s : listaStudenti) {
			sb.append("\n==== Lista Studenti ====");
			sb.append("\n" + s.getId() + "  |  " + s.getNome() + "  |  " + s.getCognome() + "  |  " + s.getCodFiscale() + "  |  " + s.getCodCorsoIscritto());
			
		}
		return sb.toString();
	}
}
