package controller;

import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Nota;
import service.NotaService;

public class NotaMenu {

	private static Scanner scan = new Scanner(System.in);
	private static final NotaService ns = new NotaService();
	private static final ClienteMenu cm = new ClienteMenu();
	private static final UtenteMenu um = new UtenteMenu();

	public NotaMenu() {

	}
	// per come l'ho pensato io, decido di scegliere prima un cliente sulla quale
	// fare operazioni, qui nella gestione nota, poi ci opero.
	// vi sarà anche un metodo per poter segliere un altro utente, o anzi tutto
	// dentro un solo metodo che verra chiamato al momento opportuno.

	public void mostraMenu() {
		boolean continua = true;
		
		System.out.println("=== Gestione Nota ===");
		Cliente clienteScelto = cm.scegliCliente("Su quale cliente vuoi operare?");

		do {
			System.out.println("1. Crea nota");
			System.out.println("2. Modifica nota");
			System.out.println("3. Elimina nota");
			System.out.println("4. Mostra note");
			System.out.println("5. Cambia cliente");
			System.out.println("0. Torna indietro");
			int scelta = scan.nextInt();
			scan.nextLine();
			switch (scelta) {
			case 1:
				creaNota(clienteScelto);
				break;
			case 2:
				modificaNota(clienteScelto);
				break;
			case 3:
				System.out.println("---- Eliminazione Nota ----");
				listaNoteCliente(clienteScelto);
				eliminaNota();
				break;
			case 4:
				listaNoteCliente(clienteScelto);
				break;
			case 5:
				clienteScelto = cm.scegliCliente("--Stai cambiando Cliente");
				break;
			case 0:
				continua = false;
				break;

			default:
				throw new IllegalArgumentException("Non ho capito il comando inserito, hai inserito: " + scelta);
			}
		} while (continua = false);

	}

	private void listaNoteCliente(Cliente clienteScelto) {

		System.out.println("---- Note del cliente [" + clienteScelto.getNomeAzienda() + "] ----");
		for (Nota n : ns.getNoteCliente(clienteScelto.getIdCliente())) {
			System.out.println("| ID Nota: " + n.getIdNota() + "\n| Contenuto: " + n.getTestoNota()
			+ "\n| Registrata il: " + n.getDataRegistrazione() + "\n| Utente incaricato: " + n.getNomeUtente());
			System.out.println("-----------------------------------------------------------------\n");
		}

	}

	private void eliminaNota() {
		int idNota = scan.nextInt();
		scan.nextLine();
		ns.eliminaNota(idNota);

	}

	private void modificaNota(Cliente clienteScelto) {
		System.out.println("---- Modifica Note del cliente [" + clienteScelto.getNomeAzienda() + "] ----");
		System.out.println("Segli la nota da modificare");

		List<Nota> listaNoteCliente = ns.getNoteCliente(clienteScelto.getIdCliente());

		int i = 0;

		for (Nota n : listaNoteCliente) {
			System.out.println(++i + ")" + " ID-Cliente: " + n.getIdCliente() + ", Descrizione: " + n.getTestoNota()
					+ ", Utente Assegnato: " + n.getNomeUtente() + " | " + n.getUtenteRegistrato());
		}
		int sceltaNota = scan.nextInt();
		scan.nextLine();
		Nota notaScelta = listaNoteCliente.get(sceltaNota - 1);

		System.out.println("Inerisci i nuovi dati (lasciare vuoto per non modificare)");
		System.out.println("Digita il nuovo testo");
		String testoNota = scan.nextLine();
		if (!testoNota.isBlank())
			notaScelta.setTestoNota(testoNota);
		int utenteRegistrante = um.scegliUtente("Scegli nuovo utente registrante").getIdUtente();
		if (utenteRegistrante != clienteScelto.getUtenteAssociato()) notaScelta.setUtenteRegistrato(utenteRegistrante);
		ns.modificaNota(notaScelta);

	}

	private void creaNota(Cliente clienteScelto) {
		System.out.println("---- Creazione Nota ----");
		int idCliente = cm.scegliCliente("| Quale cliente è l'intestatario della nota??").getIdCliente();
		int utenteRegistrante = um.scegliUtente("| Segli utente incaricato").getIdUtente();
		System.out.println("| Inserisci testo della nota: ");
		String testo = scan.nextLine();
		ns.creaNota(idCliente, testo, utenteRegistrante);
		System.out.println("-------------------------\n");
	}
}
