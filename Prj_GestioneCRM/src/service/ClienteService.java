package service;

import java.util.List;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import model.CategoriaMerceologica;
import model.Cliente;
import model.TipologiaCliente;

public class ClienteService {

	private final ClienteDAO clienteDAO;

	public ClienteService() {
		this.clienteDAO = new ClienteDAOImpl();
	}

	public boolean aggiungiCliente(String nomeAzienda, String referenteAzienda, CategoriaMerceologica cattMerceologica,
			TipologiaCliente tipoCliente, int utenteAssociato) {
		if (nomeAzienda == null || nomeAzienda.isBlank()) {
			// Il primo elemento NOT NULL in sql è il nome_azienda, se già in partenza è
			// sbagliato o mancante blocco tutto.
			throw new IllegalArgumentException("Il nome inserito risulta invalido, riprova!");
		}
		Cliente cliente = new Cliente(nomeAzienda, referenteAzienda, cattMerceologica, tipoCliente, utenteAssociato);
		return clienteDAO.create(cliente);
	}

	public Cliente getSingoloCliente(int idCliente) {
		if (idCliente < 0) {
			throw new IllegalArgumentException("L'ID cliente inserito non è valido");

		}
		Cliente trovato = clienteDAO.readByID(idCliente);

		if (trovato == null) {
			throw new IllegalStateException("Non è stato trovato alcun cliente con questo ID");
		}
		return trovato;

	}

	public List<Cliente> getAllClienti() {
		return clienteDAO.readAll();
	}

	public boolean eliminaCliente(int id) {
		if (id < 0) {
			throw new IllegalArgumentException("L' ID cliente inserito non è valido");
		}
		boolean eliminato = clienteDAO.deleteByID(id);

		if (!eliminato) {
			throw new IllegalStateException("Non è stato trovato alcun cliente da eliminare");
		} else {
			return eliminato;
		}
	}

	public boolean modificaCliente(Cliente modificato) {
		if (modificato == null) {
			throw new IllegalArgumentException("Errore: il cliente risulta essere inesistente!");
		}
		boolean aggiornato = clienteDAO.update(modificato);

		if (!aggiornato) {
			throw new IllegalStateException("Non è stato trovato alcun Cliente!");
		} else {
			return aggiornato;
		}
	}

	public List<Cliente> ricercaPerCategoria(String categoria) {
		if (categoria.isBlank()) {
			throw new IllegalArgumentException("Errore: Non esiste la categoria: " + categoria);
		}
		return clienteDAO.readByCategoria(categoria);
	}

	public List<Cliente> ricercaPerTipologia(String tipo) {
		if (tipo.isBlank()) {
			throw new IllegalArgumentException("Errore: Non esiste il tipo: " + tipo);
		}
		return clienteDAO.readByTipologia(tipo);
	}

	public List<Cliente> ricercaPerUtente(int idUtente) {
		if (idUtente < 0) {
			throw new IllegalArgumentException("Errore: ID Utente non valido, hai inserito: " + idUtente);
		}
		return clienteDAO.readByUtente(idUtente);
	}

}
