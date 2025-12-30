package controller;

import java.util.List;
import java.util.Scanner;

import model.Cliente;
import service.ClienteService;

public class ClienteMenu {

	private Scanner scan = new Scanner(System.in);
	private final ClienteService cs = new ClienteService();
	private UtenteMenu um = new UtenteMenu();

	public ClienteMenu() {
	}

	public Cliente scegliCliente() {
		List<Cliente> clienti = cs.getAllClienti();
		int contatore = 0;
		for (Cliente c : clienti) {
			System.out.println(++contatore + ") " + c.getRefereneAzienda());
		}
		System.out.println("Seleziona un utente: ");
		int scelta = scan.nextInt();
		scan.nextLine();
		return clienti.get(scelta - 1);
	}

	public void aggiungiCliente() {

		System.out.println("Inserisci nome azienda: ");
		String nomeAzienda = scan.nextLine();
		System.out.println("Inserisci referente azienda: ");
		String referenteAzienda = scan.nextLine();
		System.out.println("Inserisci la sua categoria merceologica: ");
		String catMerceologica = scan.nextLine();
		System.out.println("Inserisci il tipo di cliente: ");
		String tipoCliente = scan.nextLine();
		System.out.println("Segli l'utente associato:");
		int utenteAssociato = um.scegliUtente().getIdUtente();
		cs.aggiungiCliente(nomeAzienda, referenteAzienda, catMerceologica, tipoCliente, utenteAssociato);

	}

	public void eliminaCliente() {
		System.out.println("Quale cliente vuoi eliminare?");
		int idCliente = scegliCliente().getIdCliente();
		cs.eliminaCliente(idCliente);
	}
}
