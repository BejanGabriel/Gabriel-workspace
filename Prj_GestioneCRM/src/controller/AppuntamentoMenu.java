package controller;

import java.util.List;
import java.util.Scanner;

import model.Appuntamento;
import model.Cliente;
import model.Nota;
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

			int scelta = scan.nextInt();
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
			
		} while (continua);
	}

	private void eliminaAppuntamento() {
		System.out.println("Inserisci l'ID dell'appuntamento da eliminare");
		int idAppuntamento = scan.nextInt();
		scan.nextLine();
		as.eliminaAppuntamento(idAppuntamento);
		
	}

	private void mostraAppuntamentiCliente(Cliente clienteScelto) {
		System.out.println("---- Appuntamenti del cliente [" + clienteScelto.getNomeAzienda() + "] ----");
		for(Appuntamento a : as.getAppuntamentiCliente(clienteScelto.getIdCliente())) {
			System.out.println("| ID Appuntamento: " + a.getIdAppuntamento()
			+ "\n| Nome Azienda: " + a.getNomeCliente() + "\n| Data: " + a.getDataAppuntamento()
			+ "\n| Descrizione: " + a.getDescrizione() + "\n| Utente Incaricato: " + a.getNomeUtente());
			System.out.println("---------------------------------------------------------------------------\n");
		}
		
	}

	private void modificaAppuntamento(Cliente clienteScelto) {
		System.out.println("---- Modifica Appuntamento di [" + clienteScelto.getNomeAzienda() + "] ----");
		
		
		System.out.println("| Segli l'appuntamento da modificare");

		List<Appuntamento> listaAppuntCliente = as.getAppuntamentiCliente(clienteScelto.getIdCliente());

		int i = 0;

		for (Appuntamento a : listaAppuntCliente) {
			System.out.println(++i + ") ID-Appuntamento: " + a.getIdAppuntamento() + ", Descrizione: " + a.getDescrizione()
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
		
		boolean aggiornato = as.modificaAppuntamento(appuntScelto);
		if(aggiornato) {
			System.out.println("Aggiornato!");
		}else {
			System.out.println("Non aggiornato!");
		}
		
		
	}

	private void creaAppuntamento() {
		System.out.println("---- Creazione appuntamento ----");
		int idCliente = cm.scegliCliente("| Con quale cliente sarà l'appuntamento?").getIdCliente();
		String motivazione = scan.nextLine();
		int idUtente = um.scegliUtente("| Seleziona l'utente associato").getIdUtente();
		as.creaAppuntamento(idCliente, motivazione, idUtente);
		System.out.println("--------------------------------\n");
		
		
		
	}
	
}
