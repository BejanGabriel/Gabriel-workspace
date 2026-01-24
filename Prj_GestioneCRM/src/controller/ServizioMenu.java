package controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Servizio;
import service.ServizioService;

public class ServizioMenu {

	private static Scanner scan = new Scanner(System.in);
	private static final ServizioService ss = new ServizioService();
	private static final ClienteMenu cm = new ClienteMenu();

	public ServizioMenu() {

	}

	public void mostraMenu() {

		boolean continua = true;

		System.out.println("=== Gestione Servizio ===");
		Cliente clienteScelto = cm.scegliCliente("Su quale cliente vuoi operare?");

		do {
			System.out.println("1. Compra servizio");
			System.out.println("2. Rimuovi servizio");
			System.out.println("3. Mostra servizi cliente");
			System.out.println("4. Cambia cliente");
			System.out.println("0. Torna Indietro");
			
			try {

				int scelta = scan.nextInt();
				scan.nextLine();

				switch (scelta) {
				case 1:
					acquistaServizio(clienteScelto);
					break;
				case 2:
					rimuoviServizio(clienteScelto);
					break;
				case 3:
					vediServiziCliente(clienteScelto);
					break;
				case 4:
					clienteScelto = cm.scegliCliente("-- Cambia cliente");
				case 0:
					System.out.println("\nStai tornando al menu cliente...\n");
					continua = false;
					break;
				default:
					throw new IllegalArgumentException("Non ho capito il comando, hai inserito: " + scelta);
				}
			} catch (InputMismatchException e) {
				System.out.println("Errore: Sono ammessi solo caratteri numerici! riprova.");
				scan.nextLine();
			}

		} while (continua);
	}

	public void menuServiziGenerali() {
		boolean continua = true;
		System.out.println("---- Menu gestione generale servizi ----");
		do {
			try {

				System.out.println("Segli l'operazione da svolgere");
				System.out.println("1. Aggiungi Servizio");
				System.out.println("2. Modifica Servizio");
				System.out.println("3. Elimina Servizio");
				System.out.println("4. Mostra lista servizi");
				System.out.println("0. Torna indietro.");

				int scelta = scan.nextInt();
				scan.nextLine();
				switch (scelta) {
				case 1:
					aggiungiServizioAllaLista();
					break;
				case 2:
					modificaServizioDallaLista();
					break;
				case 3:
					rimuoviServizio();
					break;
				case 4:
					mostraListaServizi();
					break;
				case 0:
					continua = false;
					break;
				default:
					throw new IllegalArgumentException("Non ho capito il comando, hai inserito: " + scelta);

				}
			} catch (InputMismatchException e) {
				System.out.println("Errore: Sono ammessi solo caratteri numerici!  riprova.");
				scan.nextLine();
			}
		} while (continua);
	}

	private void rimuoviServizio() {
		try {
			mostraListaServizi();
			System.out.println("\n-- Inserisci ID del servizio da eliminare:");
			int idServizio = scan.nextInt();
			
			boolean rimosso = ss.cancellaServizio(idServizio);
			
			if(rimosso) {
				System.out.println("Servizio rimosso correttamente.");
			}else {
				System.out.println("Non è stato possibile modificare il servizio!");
			}

		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	public void mostraListaServizi() {
		System.out.println("==== Lista dei Servizi ====");
		try {

			List<Servizio> listaServizi = ss.getAllServizi();

			for (Servizio s : listaServizi) {
				System.out.println("| ID-Servizio: " + s.getIdServizio() + "\n| Nome Servizio: " + s.getNomeServizio()
						+ "\n| Descrizione: " + s.getDescrizione() + "\n| Prezzo: " + s.getPrezzo());
				System.out.println("--------------------------------");
			}

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}

	private void modificaServizioDallaLista() {
		Servizio servizioScelto = scegliServizio("Quale servizio vuoi modificare?");
		try {
			System.out.println("Lasciare in bianco per non modificare i parametri!");
			scan.nextLine();
			System.out.println("Inserisci il nuovo titolo del servizio");
			String nuovoTit = scan.nextLine();
			if (!nuovoTit.isBlank())
				servizioScelto.setNomeServizio(nuovoTit);
			System.out.println("Inserisci la nuova descrizione");
			String nuovaDesc = scan.nextLine();
			if (!nuovaDesc.isBlank())
				servizioScelto.setDescrizione(nuovaDesc);
			System.out.println("Inserisci il nuovo prezzo");
			// errore che per mancanza di voglia lascero perdere, nell'inserimento
			// bisognerebbe mettere un double scrivendolo con il ' . ' ma l'sql
			// non accetta il punto come carattere, accetta la virgola, ma il double no.
			// quindi bisognerebbe prendere il dato, trasformarlo in
			// stringa, sotituire il punto con la virgola, reimpostarlo a double e solo dopo
			// inviarlo ad DB.
			double nuovoPrezzo = scan.nextDouble();
			scan.nextLine();
			if (nuovoPrezzo != servizioScelto.getPrezzo())
				servizioScelto.setPrezzo(nuovoPrezzo);

			boolean modificato = ss.modificaServizio(servizioScelto);
			
			if(modificato) {
				System.out.println("Servizio modificato correttamente.");
			}else {
				System.out.println("Non è stato possibile modificare il servizio!");
			}

		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private void aggiungiServizioAllaLista() {
		System.out.println("Inserisci titolo");
		String titoloServ = scan.nextLine();
		System.out.println("Inserisci descrizione");
		String descrizioneServ = scan.nextLine();
		System.out.println("Inserisci prezzo");
		try {

			double prezzoServ = scan.nextDouble();
			
			boolean aggiunto = ss.aggiungiServizio(titoloServ, descrizioneServ, prezzoServ);
			
			if(aggiunto) {
				System.out.println("Servizio creato correttamente.");
			}else {
				System.out.println("Non è stato possibile creare il servizio.");
			}

		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}

	private void vediServiziCliente(Cliente clienteScelto) {
		System.out.println("---- Servizi acquistati da [" + clienteScelto.getNomeAzienda() + "] ----");
		try {

			List<Servizio> serviziCliente = ss.getServizioByClienteID(clienteScelto.getIdCliente());
			if (serviziCliente.isEmpty()) {
				System.out.println("Non sono stati trovati servizi associati a questo cliente!");
				return;
			}

			for (Servizio s : serviziCliente) {
				System.out
						.println("| Nome Servizio: " + s.getNomeServizio() + "\n| Descrizione: " + s.getDescrizione());
				System.out.println("----------------------------------------------------------------------");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private void rimuoviServizio(Cliente clienteScelto) {
		System.out.println("---- Rimozione Servizio ----");
		try {

			boolean eliminato = ss.cancellaServizio(clienteScelto.getIdCliente());
			
			if (eliminato) {
				System.out.println("Servizio eliminato correttamente.");
			}else {
				System.out.println("Non è stato possibile eliminare il servizio");
			}

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private void acquistaServizio(Cliente clienteScelto) {
		Servizio s = scegliServizio("Quale servizio vuoi aggiungere");
		try {

			boolean associato = ss.associaServizioCliente(clienteScelto.getIdCliente(), s.getIdServizio());
			if(associato) {
				System.out.println("Servizio acquistato correttamente");
			}else {
				System.out.println("Non è stato possibile acquistare il servizio.");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Servizio scegliServizio(String msg) {
		while (true) {

			try {

				List<Servizio> listaServizi = ss.getAllServizi();

				System.out.println(msg);
				System.out.println("---------------------------");

				for (Servizio s : listaServizi) {
					System.out.println("ID-Servizio: " + s.getIdServizio() + "\n| Nome Servizio: " + s.getNomeServizio()
							+ "\n| Descrizione: " + s.getDescrizione() + "\n| Prezzo: " + s.getPrezzo());
					System.out.println("--------------------------");
				}
				System.out.println("Seleziona il servizio:");
				int servizoScelto = scan.nextInt();
				return listaServizi.get(servizoScelto - 1);

			} catch (InputMismatchException e) {
				System.out.println("Errore: Sono ammessi solo caratteri numerici! riprova.");
				scan.nextLine();
			} catch (RuntimeException e) {
				System.out.println("Runtime Error: " + e.getMessage());
				scan.nextLine();
			}
		}
	}
}
