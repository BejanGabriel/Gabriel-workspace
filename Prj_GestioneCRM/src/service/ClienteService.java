package service;

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
			System.out.println("Cliente non creato");
			return false;
		}
		Cliente cliente = new Cliente(nomeAzienda, referenteAzienda, cattMerceologica, tipoCliente, utenteAssociato);
		System.out.println("Cliente creato correttamente");
		return clienteDAO.create(cliente);
	}

	public Cliente getSingoloUtente(int idCliente) {
		if (idCliente > 0) {
			System.out.println("=== CLIENTE TROVATO ===");
			return clienteDAO.readByID(idCliente);
		}
		System.out.println("Cliente non trovato");
		return null;
	}

}
