package controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Appuntamento;
import model.Cliente;
import service.AppuntamentoService;

public class AppuntamentoMenu {

	private static AppuntamentoService as = new AppuntamentoService();
	private static Scanner scan = new Scanner(System.in);
	private static final ClienteMenu cm = new ClienteMenu();
	private static final UtenteMenu um = new UtenteMenu();

	public void mostraMenu() {

		boolean continua = true;
		System.out.println("---- Gestion Appuntamenti ----");
		Cliente clienteScelto = cm.scegliCliente("Su quale cliente vuoi operare?");

		do {
			System.out.println("\n1. Crea Appuntamento");
			System.out.println("2. Modifica Appuntamento");
			System.out.println("3. Mostra lista Appuntamenti del cliente");
			System.out.println("4. Elimina un Appuntamento");
			System.out.println("5. Cambia cliente");
			System.out.println("0. Torna al menu Generico.");
			int scelta;

			try {
				scelta = scan.nextInt();
				scan.nextLine();

				switch (scelta) {
				case 1:
					creaAppuntamento();
					break;
				case 2:
					modificaAppuntamento(clienteScelto);
					break;
				case 3:
					mostraAppuntamentiCliente(clienteScelto);
					break;
				case 4:
					mostraAppuntamentiCliente(clienteScelto);
					eliminaAppuntamento();
					break;
				case 5:
					clienteScelto = cm.scegliCliente("--Scegli un altro cliente");
					break;
				case 0:
					continua = false;
					break;

				default:
					throw new IllegalArgumentException("Unexpected value: " + scelta);
				}

			} catch (InputMismatchException e) {
				System.out.println("Hai inserito un carattere non ammesso!, riprova");
				scan.nextLine();
			}

		} while (continua);
	}

	private void eliminaAppuntamento() {
		System.out.println("Inserisci l'ID dell'appuntamento da eliminare");
		try {

			int idAppuntamento = scan.nextInt();
			scan.nextLine();

			boolean eliminato = as.eliminaAppuntamento(idAppuntamento);
			
			if(eliminato) {
				System.out.println("Appuntamento eliminato.");
			}else {
				System.out.println("Non è stato possibile eliminare l'appuntamento!");
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Errore: Sono ammessi solo caratteri numerici!");
			scan.nextLine();
			//questa volta uso la catch solo su runtime perche IllegalArgumentoExeption e IllegalStateExeption fanno parte di RuntimeExeption.
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}

	private void mostraAppuntamentiCliente(Cliente clienteScelto) {
		System.out.println("---- Appuntamenti del cliente [" + clienteScelto.getNomeAzienda() + "] ----");
		try {

			List<Appuntamento> appuntamentiCliente = as.getAppuntamentiCliente(clienteScelto.getIdCliente());
			
			if(appuntamentiCliente.isEmpty()) {
				System.out.println("Non ci sono appuntamenti per questo cliente");
				return;
			}

			for (Appuntamento a : appuntamentiCliente) {
				System.out.println("| ID Appuntamento: " + a.getIdAppuntamento() + "\n| Nome Azienda: "
						+ a.getNomeCliente() + "\n| Data: " + a.getDataAppuntamento() + "\n| Descrizione: "
						+ a.getDescrizione() + "\n| Utente Incaricato: " + a.getNomeUtente());
				System.out.println("---------------------------------------------------------------------------\n");
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}

	private void modificaAppuntamento(Cliente clienteScelto) {
		System.out.println("---- Modifica Appuntamento di [" + clienteScelto.getNomeAzienda() + "] ----");

		System.out.println("| Segli l'appuntamento da modificare");

		try {

			List<Appuntamento> listaAppuntCliente = as.getAppuntamentiCliente(clienteScelto.getIdCliente());
			
			if(listaAppuntCliente.isEmpty()) {
				System.out.println("Non ci sono appuntamenti per questo cliente!");
				return;
			}

			int i = 0;

			for (Appuntamento a : listaAppuntCliente) {
				System.out.println(
						++i + ") ID-Appuntamento: " + a.getIdAppuntamento() + ", Descrizione: " + a.getDescrizione()
								+ ", Utente Assegnato: " + a.getNomeUtente() + " | " + a.getUtenteAssociato());
			}
			System.out.println("Scegli Appuntamento");
			int sceltaNota = scan.nextInt();
			scan.nextLine();
			Appuntamento appuntScelto = listaAppuntCliente.get(sceltaNota - 1);

			System.out.println("| Inerisci i nuovi dati (lasciare vuoto per non modificare)");
			System.out.println("| Digita il nuovo testo");
			String descrizione = scan.nextLine();

			if (!descrizione.isBlank())
				appuntScelto.setDescrizione(descrizione);

			int utenteAssociato = um.scegliUtente("| Scegli nuovo utente registrante").getIdUtente();

			if (utenteAssociato != appuntScelto.getUtenteAssociato())
				appuntScelto.setUtenteAssociato(utenteAssociato);

			boolean modificato = as.modificaAppuntamento(appuntScelto);
			
			if(modificato) {
				System.out.println("Appuntamento modificato con successo.");
			}else {
				System.out.println("Non è stato possibile modificare l'appuntamento!");
			}
			
		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}

	private void creaAppuntamento() {
		System.out.println("---- Creazione appuntamento ----");
		int idCliente = cm.scegliCliente("| Con quale cliente sarà l'appuntamento?").getIdCliente();
		System.out.println("Inserisci la motivazione dell'appuntamento");
		String motivazione = scan.nextLine();
		int idUtente = um.scegliUtente("| Seleziona l'utente associato").getIdUtente();

		try {
			boolean creato = as.creaAppuntamento(idCliente, motivazione, idUtente);
			
			if(creato) {
				System.out.println("Appuntamento creato.");
			}else {
				System.out.println("Non è stato possibile creare l'appuntamento!");
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("--------------------------------\n");

	}

}
