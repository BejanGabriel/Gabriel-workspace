package service;

import java.util.List;
import java.util.Scanner;

import dao.UtenteDAO;
import dao.UtenteDAOImpl;
import model.Utente;

public class UtenteService {

	private final UtenteDAO utenteDAO;
	private static Scanner scan = new Scanner(System.in);
	public UtenteService() {
		this.utenteDAO = new UtenteDAOImpl()	;
	}
	
	public boolean aggiungiUtente(String nome, String ruolo, String email, String password) {
		//nel sql, il primo parametro che non può essere null è il nome dell'utente, se quello è null, tutto il resto non ha senso, quindi blocco.
	    if (nome == null || nome.isBlank()) {
	    	System.out.println("Il nome inserito non è valido.");
	        return false;
	    }

	    Utente utente = new Utente(nome, ruolo, email, password);
	    return utenteDAO.create(utente);
	}
	
	public Utente getSingoloUtente(int idUtente) {
		if(idUtente > 0) {
			System.out.println("Utente trovato.");
			return utenteDAO.readByID(idUtente);
		}
		System.out.println("Utente non trovato!");
		return null;
	}
	
	public List<Utente> getAllUtenti(){
		if(utenteDAO.readAll().size() == 0) {
			System.out.println("La lista è vuota!");
			return null;
		}
		return utenteDAO.readAll();
	}
	
	public void eliminaUtente(int id) {
		if(id > 0) {
			utenteDAO.deleteByID(id);
			System.out.println("Utente eliminato.");
			return;
		}
		System.out.println("Utente non eliminato!");
	}
	
	public void modificaUtente(Utente utente) {
		if(utente != null) {
			utenteDAO.update(utente);
			System.out.println("Utente aggiornato");
			return;
		}
		System.out.println("Utente non aggiornato!");
	}
	
}
