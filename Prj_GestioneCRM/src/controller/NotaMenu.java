package controller;

import java.util.InputMismatchException;
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

		System.out.println("=== Gestione Nota ===");
		Cliente clienteScelto = cm.scegliCliente("Su quale cliente vuoi operare?");

		boolean continua = true;
		do {
			System.out.println("1. Crea nota");
			System.out.println("2. Modifica nota");
			System.out.println("3. Elimina nota");
			System.out.println("4. Mostra note");
			System.out.println("5. Cambia cliente");
			System.out.println("0. Torna indietro");
			try {

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
					System.out.println("Non ho capito il comando!");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Errore: Sono ammessi solo caratteri numerici!");
				scan.nextLine();
			}
		} while (continua);

	}

	private void listaNoteCliente(Cliente clienteScelto) {

		System.out.println("---- Note del cliente [" + clienteScelto.getNomeAzienda() + "] ----");
		try {

			List<Nota> noteCliente = ns.getNoteCliente(clienteScelto.getIdCliente());
			
			if(noteCliente.isEmpty()) {
				System.out.println("Non ci sono note per questo cliente!");
				return;
			}
			
			for (Nota n : noteCliente) {
				System.out.println(
						"| ID Nota: " + n.getIdNota() + "\n| Contenuto: " + n.getTestoNota() + "\n| Registrata il: "
								+ n.getDataRegistrazione() + "\n| Utente incaricato: " + n.getNomeUtente());
				System.out.println("-----------------------------------------------------------------\n");
			}

		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}

	private void eliminaNota() {
		try {
			int idNota = scan.nextInt();
			scan.nextLine();
			
			boolean eliminato = ns.eliminaNota(idNota);
			
			if(eliminato) {
				System.out.println("Nota eliminata correttamente.");
			}else {
				System.out.println("Non è stato possibile eliminare la nota!");
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Errore: Sono ammessi solo caratteri numerici!");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}

	private void modificaNota(Cliente clienteScelto) {
		System.out.println("---- Modifica Note del cliente [" + clienteScelto.getNomeAzienda() + "] ----");
		System.out.println("Segli la nota da modificare");
		
		try {

			List<Nota> listaNoteCliente = ns.getNoteCliente(clienteScelto.getIdCliente());

			if(listaNoteCliente.isEmpty()) {
				System.out.println("Non ci sono note per questo cliente!");
				return;
			}
			
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
			if (utenteRegistrante != clienteScelto.getUtenteAssociato())
				notaScelta.setUtenteRegistrato(utenteRegistrante);
			
			boolean modificato = ns.modificaNota(notaScelta);
			
			if(modificato) {
				System.out.println("Nota modificata con successo.");
			}else {
				System.out.println("Non è stato possibile modificare la nota!");
			}

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}

	private void creaNota(Cliente clienteScelto) {
		System.out.println("---- Creazione Nota ----");
		try {
			
		int idCliente = cm.scegliCliente("| Quale cliente è l'intestatario della nota??").getIdCliente();
		int utenteRegistrante = um.scegliUtente("| Segli utente incaricato").getIdUtente();
		System.out.println("| Inserisci testo della nota: ");
		String testo = scan.nextLine();
		
		boolean creato = ns.creaNota(idCliente, testo, utenteRegistrante);
		
		if(creato) {
			System.out.println("Nota creata correttamente.");
		}else {
			System.out.println("Non è stato possibile creare la nota!");
		}
		
		System.out.println("-------------------------\n");
		
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}
