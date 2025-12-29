package service;

import java.util.List;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import model.Cliente;

public class ClienteService {

	private final ClienteDAO clienteDAO;

	public ClienteService() {
		this.clienteDAO = new ClienteDAOImpl();
	}

	public boolean aggiungiCliente(String nomeAzienda, String referenteAzienda, String cattMerceologica, String tipoCliente, int utenteAssociato) {
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
			System.out.println("Cliente trovato");
			return clienteDAO.readByID(idCliente);
		}
		System.out.println("Cliente non trovato!");
		return null;
	}

	public List<Cliente> getAllClienti() {
		if(!clienteDAO.readAll().isEmpty()) {
			return clienteDAO.readAll();
		}
		System.out.println("La lista dei clienti è vuota!");
		return null;
	}
	
	public void eliminaCliente(int id) {
		if(id > 0) {
			clienteDAO.deleteByID(id);
			System.out.println("Cliente eliminato.");
			return;
		}
		System.out.println("Cliente non trovato!");
	}

}
