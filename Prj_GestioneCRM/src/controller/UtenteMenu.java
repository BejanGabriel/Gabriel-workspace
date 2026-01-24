package controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Utente;
import service.UtenteService;

public class UtenteMenu {

	private static Scanner scan = new Scanner(System.in);
	private static final UtenteService us = new UtenteService();

	public UtenteMenu() {
	}

	public void mostraMenu() {
		boolean continua = true;
		do {
			System.out.println("1. Crea Utente");
			System.out.println("2. Modifica Utente");
			System.out.println("3. Trova Utente");
			System.out.println("4. Mostra lista Utenti");
			System.out.println("5. Elimina un Utente");
			System.out.println("0. Torna al menu Generico");
			int scelta = scan.nextInt();
			scan.nextLine();
			switch (scelta) {
			case 1:
				aggiuntiUtente();
				break;
			case 2:
				modificaUtente();
				break;
			case 3:
				trovaUtente();
				break;
			case 4:
				mostraListaUtenti();
				break;
			case 5:
				eliminaUtente();
				break;
			case 0:
				System.out.println("-- Ritorno al menù generico...");
				continua = false;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + scelta);
			}
		} while (continua);
	}

	public void aggiuntiUtente() {
		try {
			System.out.println("Inserisci nome utente: ");
			String nome = scan.nextLine();
			System.out.println("Inserisci il ruolo dell'utente: ");
			String ruolo = scan.next();
			System.out.println("Inserisci email dell'utente: ");
			String email = scan.next();
			System.out.println("Inserisci password utente: ");
			String password = scan.next();

			boolean aggiunto = us.aggiungiUtente(nome, ruolo, email, password);
			
			if (aggiunto) {
				System.out.println("Utente aggiunto con successo!");
			} else {
				System.out.println("Utente non aggiunto...");
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void modificaUtente() {
		try {
			Utente utenteScelto = scegliUtente("Quale utente vuoi modificare?");
			System.out.println("Laciare vuoti i campi che non si desidera modificare.");
			String nome, ruolo, email, password;
			System.out.println("Digita nuovo nome utente: ");
			nome = scan.nextLine();
			if (!nome.isBlank())
				utenteScelto.setNomeUtente(nome);
			System.out.println("Digita nuovo ruolo: ");
			ruolo = scan.nextLine();
			if (!ruolo.isBlank())
				utenteScelto.setRuolo(ruolo);
			System.out.println("Digita nuova email: ");
			email = scan.nextLine();
			if (!email.isBlank())
				utenteScelto.setEmail(email);
			System.out.println("Digita nuova password: ");
			password = scan.nextLine();
			if (!password.isBlank())
				utenteScelto.setPassword(password);
			
			//output di verifica
			boolean modificato = us.modificaUtente(utenteScelto);
			
			if(modificato) {
				System.out.println("Utente modificato con successo.");
			}else {
				System.out.println("Non è stato possibile modificare l'utente!");
			}
			
		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private void trovaUtente() {
		System.out.println("Inserisci ID Utente");
		try {
			int idUtente = scan.nextInt();
			scan.nextLine();
			
			Utente singoloUtente = us.getSingoloUtente(idUtente);
			
			if (singoloUtente == null) {
				System.out.println("Utente non trovato!!");
			} else {
				System.out.println(singoloUtente);
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Errore: Sono ammessi solo caratteri numerici! riprova");
			scan.nextLine();
		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private void mostraListaUtenti() {
		System.out.println("=== Lista Utenti ===");
		try {
			List<Utente> listaUtenti = us.getAllUtenti();
			if (listaUtenti.size() == 0) {
				System.out.println("Non è stato trovato nessun Utente!! Lista Vuota!");
			} else {

				for (Utente u : listaUtenti) {
					System.out.println(u);
				}
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private void eliminaUtente() {
		
		try {
			
			System.out.println("Inserisci ID Utente da eliminare: ");
			int elimina = scan.nextInt();
			scan.nextLine();
			
			boolean eliminato = us.eliminaUtente(elimina);
			
			if(eliminato) {
				System.out.println("Utente eliminato con successo.");
			}else {
				System.out.println("Non è stato possibile eliminare l'utente!");
			}

		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(e.getMessage());

		} catch (RuntimeException e) {
			System.out.println(e.getMessage() + "ERRORE NEL DATABASE!!!");
		}
	}

	public static Utente scegliUtente(String msg) {
		List<Utente> utenti = us.getAllUtenti();
		int contatore = 0;
		int scelta;
		
		do {
			System.out.println(msg);

			for (Utente u : utenti) {
				System.out.println(++contatore + ") " + u.getNomeUtente());
			}
			// selta del utente attraverso l'inserimento dell'indice.
			System.out.println("Seleziona un utente: ");
			scelta = scan.nextInt();
			scan.nextLine();

			if (scelta < 0 && scelta > utenti.size()) {
				System.out.println("Comando non valido, puoi scegliere solo gli utenti della lista!");
				contatore = 0; // Reset indice stampato.
			}
			// eccezione per uscire dal metodo quando bisogna modificare l'utente assegnato
			// o selezionato, in modo da lasciare quello attuale.
			// usato per tutto cio che richiede il selezionar eun nuovo utente.
			if (scelta == 0)
				return null;

		} while (scelta >=1 && scelta <= utenti.size());

		return utenti.get(scelta - 1);
	}

}
