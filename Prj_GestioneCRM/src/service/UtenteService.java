package service;

import java.util.List;

import dao.UtenteDAO;
import dao.UtenteDAOImpl;
import model.Utente;

public class UtenteService {

	private final UtenteDAO utenteDAO;

	public UtenteService() {
		this.utenteDAO = new UtenteDAOImpl();
	}

	public boolean aggiungiUtente(String nome, String ruolo, String email, String password) {
		// nel sql, il primo parametro NOT NULL è il nome dell'utente, se quello è null,
		// tutto il resto non ha senso, quindi blocco.
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Il nome dell'utente è ILLEGALE, ricontrolla");
		}

		Utente utente = new Utente(nome, ruolo, email, password);
		
		return utenteDAO.create(utente);
		
	}

	public Utente getSingoloUtente(int idUtente) {
		if (idUtente < 0) {
			throw new IllegalArgumentException("ID inserito non è valido!");
		}
		Utente u = utenteDAO.readByID(idUtente);

		if (u == null) {
			throw new IllegalStateException("Utente non trovato!");
		}
		return u;
	}

	public List<Utente> getAllUtenti() {
		return utenteDAO.readAll();
	}

	public boolean eliminaUtente(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID non valido!");
		}
		boolean eliminato = utenteDAO.deleteByID(id);

		if (!eliminato) {
			throw new IllegalStateException("Utente non trovato!");
		}
		return eliminato;

	}

	public boolean modificaUtente(Utente utente) {
		if (utente == null) {
			throw new IllegalArgumentException("L'Utente è null!");
		}

		boolean aggiornato = utenteDAO.update(utente);

		if (!aggiornato) {
			throw new IllegalStateException("Utente non trovato!");
		} else {
			return aggiornato;
		}
	}

}
