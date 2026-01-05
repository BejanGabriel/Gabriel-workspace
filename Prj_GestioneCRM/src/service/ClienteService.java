package service;

import java.util.List;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import model.CategoriaMerceologica;
import model.Cliente;

public class ClienteService {

	private final ClienteDAO clienteDAO;

	public ClienteService() {
		this.clienteDAO = new ClienteDAOImpl();
	}

	public boolean aggiungiCliente(String nomeAzienda, String referenteAzienda, CategoriaMerceologica cattMerceologica, String tipoCliente, int utenteAssociato) {
		if (nomeAzienda == null || nomeAzienda.isBlank()) {
			//Il primo elemento NOT NULL in sql è il nome_azienda, se già in partenza è sbagliato o mancante blocco tutto.
			System.out.println("Cliente non creato!");
			return false;
		}
		Cliente cliente = new Cliente(nomeAzienda, referenteAzienda, cattMerceologica, tipoCliente, utenteAssociato);
		System.out.println("Cliente creato correttamente");
		return clienteDAO.create(cliente);
	}

	public Cliente getSingoloCliente(int idCliente) {
		if (idCliente > 0) {
			return clienteDAO.readByID(idCliente);
		}
		throw new IllegalArgumentException("Cliente non trovato!");
	}

	public List<Cliente> getAllClienti() {
		if(!clienteDAO.readAll().isEmpty()) {
			return clienteDAO.readAll();
		}
		throw new IllegalArgumentException("La lista dei clienti è vuota!");
	}
	
	public void eliminaCliente(int id) {
		if(id > 0) {
			clienteDAO.deleteByID(id);

		}
		throw new IllegalArgumentException("Cliente non trovato!");
	}
	
	public void modificaCliente(Cliente modificato) {
		if(modificato == null) {
			throw new IllegalArgumentException("Cliente non modificato!");
		}
		clienteDAO.update(modificato);
	}

}
