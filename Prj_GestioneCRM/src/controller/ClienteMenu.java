package controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.CategoriaMerceologica;
import model.Cliente;
import model.TipologiaCliente;
import model.Utente;
import service.ClienteService;

public class ClienteMenu {

	private static Scanner scan = new Scanner(System.in);
	private static final ClienteService cs = new ClienteService();
	private static final UtenteMenu um = new UtenteMenu();
	private static final NotaMenu nm = new NotaMenu();
	private static final AppuntamentoMenu am = new AppuntamentoMenu();
	private static final ServizioMenu sm = new ServizioMenu();

	public ClienteMenu() {
	}

	public void mostraMenu() {
		boolean continua = true;
		do {
			System.out.println("==== MENU CLIENTE ====");
			System.out.println("1. Crea Cliente");
			System.out.println("2. Modifica Cliente");
			System.out.println("3. Trova Cliente");
			System.out.println("4. Mostra lista Clienti");
			System.out.println("5. Elimina un Cliente");
			System.out.println("6. Gestione appuntamenti");
			System.out.println("7. Gestione Note");
			System.out.println("8. Gestione Servizi Cliente");
			System.out.println("0. Torna al menu Generico");
			
			try {

				int scelta = scan.nextInt();
				scan.nextLine();
				switch (scelta) {
				case 1:
					aggiungiCliente();
					break;
				case 2:
					modificaCliente();
					break;
				case 3:
					trovaCliente();
					break;
				case 4:
					mostraClienti();
					break;
				case 5:
					eliminaCliente();
					break;
				case 6:
					gestioneAppuntamenti();
					break;
				case 7:
					gestioneNote();
					break;
				case 8:
					gestioneServiziCliente();
					break;
				case 0:
					continua = false;
					break;
				default:
					throw new IllegalArgumentException("Non ho capito il comando, hai inserito: " + scelta);
				}
			} catch (InputMismatchException e) {
				System.out.println("Sono ammessi solo caratteri numerici");
			}
		} while (continua);
	}

	private void gestioneServiziCliente() {
		sm.mostraMenu();

	}

	private void gestioneNote() {
		nm.mostraMenu();

	}

	private void gestioneAppuntamenti() {
		am.mostraMenu();
	}

//	private void dashboard(Cliente cliente) {
//		System.out.println("=== Dati Cliente ===");
//		System.out.println(
//				"Nome Azienda: " + cliente.getNomeAzienda() + "\nNome Referente: " + cliente.getRefereneAzienda()
//						+ "\nCategoria Merceologica: " + cliente.getCategoriaMerceologica() + "\nTipo Cliente: "
//						+ cliente.getTipologiaCliente() + "\nUtente Associato: " + cliente.getUtenteAssociato());
//		System.out.println("=== Note Cliente ===");
//		
//		
//		System.out.println("=== Prossimi appuntamenti ===");
//	
//			HA DETTO CHE NON SERVE, MI FERMO DAL CONTINUARE QUESTO PEZZO
//	}

	private void mostraClienti() {
		// mostrare un piccolo menu navigazione che mostri i clienti in base a:
		// categoria, tipologia, utente assegnato
		boolean continua = true;
		do {
			System.out.println("==== Navigazione Mostra Clienti ====");
			System.out.println("1) Visualizza per Categoria Merceologica");
			System.out.println("2) Visualizza per tipologia cliente");
			System.out.println("3) Visualizza per utente associato");
			System.out.println("4) Visualizza tutti i clienti");
			System.out.println("0) Torna Indietro");
			int scelta = scan.nextInt();
			scan.nextLine();
			switch (scelta) {
			case 1:
				System.out.println("---- Ricerca per Categoria Merceologica ----");
				String categoria = scegliCategoria("Per quale categoria vuoi ricercare?").name();
				try {

					List<Cliente> clientiPerCategoria = cs.ricercaPerCategoria(categoria);

					if (clientiPerCategoria.size() == 0) {
						System.out.println("Non sono stati trovati clienti per questa categoria");
					} else {
						for (Cliente c : clientiPerCategoria) {
							System.out.println(c);
						}
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("--------------------------------------------\n");
				break;

			case 2:
				System.out.println("---- Ricerca per Tipologia ----");
				String tipologia = scegliTipologia("Per quale tipologia vuoi ricercare?").getNome();
				try {

					List<Cliente> clientiPerTipologia = cs.ricercaPerTipologia(tipologia);

					if (clientiPerTipologia.isEmpty()) {
						System.out.println("Non sono stati trovati clienti per questa tipologia!");
					} else {

						for (Cliente c : cs.ricercaPerTipologia(tipologia)) {
							System.out.println(c);
						}
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("--------------------------------\n");
				break;

			case 3:
				System.out.println("---- Ricerca Per UtenteAssociato ----");
				int idUtente = um.scegliUtente("Quale utente vuoi cercare?").getIdUtente();
				try {

					List<Cliente> clientiPerUtente = cs.ricercaPerUtente(idUtente);
					if (clientiPerUtente.isEmpty()) {
						System.out.println("Non sono stati trovati clienti legati a questo utente!");
					} else {
						for (Cliente c : cs.ricercaPerUtente(idUtente)) {
							System.out.println(c);
						}
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("-------------------------------------\n");
				break;

			case 4:
				System.out.println("---- Lista Completa ----");
				for (Cliente c : cs.getAllClienti()) {
					System.out.println(c);
				}
				System.out.println("------------------------\n");
				break;

			case 0:
				continua = false;
				break;

			default:
				throw new IllegalArgumentException("Non ho capito il comando, hai digitato: " + scelta);
			}
		} while (continua);

	}

	private void trovaCliente() {
		System.out.println("Inserisci ID Cliente da cercare: ");

		try {

			int idCliente = scan.nextInt();
			scan.nextLine();
			System.out.println(cs.getSingoloCliente(idCliente));

		} catch (InputMismatchException e) {
			System.out.println("Errore: sono ammessi solo caratteri numerici!");
			scan.nextLine();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}

	private void modificaCliente() {
		Cliente c = scegliCliente("Quale cliente vuoi modificare?");
		String nomeAzienda, referenteAzienda;
//		CategoriaMerceologica catt;
		TipologiaCliente tipologiaCliente;
		Utente utenteAssociato;
		System.out.println("Digita nuvo nome azienda: ");
		nomeAzienda = scan.nextLine();
		if (!nomeAzienda.isBlank())
			c.setNomeAzienda(nomeAzienda);
		System.out.println("Digita nuovo referente dell'azienda: ");
		referenteAzienda = scan.nextLine();
		if (!referenteAzienda.isBlank())
			c.setRefereneAzienda(referenteAzienda);
//		catt = segliCategoria("Segli la sua nuovo categoria: "); NON LA FACCIO PERCHE LOGICAMENTE NON SERVE CAMBIARE MAI LA CATEGORIA DI UN CLIENTE
		// MA SE PROPRIO DOVESSI, BASTA AGGIUNGERE UN NUOVA VOCE NELL'ENUM 'INVARIATA' E
		// AL SELEZIONAMENTO DI QUELLA ATTRAVERSO IL METODO
		// scegliCategoria() NON SI CAMBIA CATEGORIA, ALTRIMENTI SETTO LA NUOVA.
		tipologiaCliente = scegliTipologia("Segli la nuovo tipologia del cliente (0 per lasciare invariato):");
		if (tipologiaCliente != null)
			c.setTipologiaCliente(tipologiaCliente);

		utenteAssociato = um.scegliUtente("Digitare nuovo utente associato (0 per lasciare invariato)");
		if (utenteAssociato != null)
			c.setUtenteAssociato(utenteAssociato.getIdUtente());

		boolean modificato = cs.modificaCliente(c);

		if (modificato) {
			System.out.println("Cliente modificato con successo.");
		} else {
			System.out.println("Non è stato possibile modificare l'utente!");
		}

	}

	public static Cliente scegliCliente(String msg) {
		System.out.println(msg);

		List<Cliente> clienti = cs.getAllClienti();
		int contatore = 0;

		for (Cliente c : clienti) {
			System.out.println(++contatore + ") " + c.getRefereneAzienda());
		}

		int scelta;
		// validazione della scelta del cliente, nel caso inserisse un numero non
		// permesso.
		while(true) {
			System.out.println("Seleziona un cliente: ");

			scelta = scan.nextInt();
			scan.nextLine();

			if (scelta == 0)
				return null;

			if (scelta >= 1 && scelta <= clienti.size()) {
				return clienti.get(scelta - 1);
			}
			System.out.println("Numero non valido, hai inserito: " + scelta + ". Riprova");
		} //while (scelta < 0 && scelta > clienti.size());

	}

	public void aggiungiCliente() {

		System.out.println("Inserisci nome azienda: ");
		String nomeAzienda = scan.nextLine();
		System.out.println("Inserisci referente azienda: ");
		String referenteAzienda = scan.nextLine();

//		segliCategoria("Inserisci la sua categoria merceologica");  METODO PER SEGLIERE CATEGORIA
//		System.out.println("Inserisci la sua categoria merceologica: ");
//		String catMerceologica = scan.nextLine();

		int utenteAssociato = um.scegliUtente("Segli l'utente da associargli").getIdUtente();

		try {

			boolean aggiunto = cs.aggiungiCliente(nomeAzienda, referenteAzienda,
					scegliCategoria("Inserisci la sua categoria merceologica"),
					scegliTipologia("Inserisci la sua tipologia"), utenteAssociato);
			if (aggiunto) {
				System.out.println("Cliente creato con successo.");
			} else {
				System.out.println("Non è stata possibile la creazione!");
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}

	private CategoriaMerceologica scegliCategoria(String msg) {
		CategoriaMerceologica[] categorie = CategoriaMerceologica.values();
		System.out.println(msg);

		int indice = 0;
		for (CategoriaMerceologica cat : categorie) {
			System.out.println(++indice + ") " + cat.getNome());
		}
		// impedisco all'utente di inserire un numero che non è tra quelli stampati
		while (true) {
			try {
				int scelta = scan.nextInt();
				scan.nextLine();

				if (scelta >= 1 && scelta <= CategoriaMerceologica.values().length) {
					return CategoriaMerceologica.values()[scelta - 1];
				}

				System.out.println("Sono ammessi solo i caratteri numerici indicati!!");

			} catch (InputMismatchException e) {
				System.out.println("Hai inserito un carattere non ammesso!");
				scan.nextLine(); // per pulizia del parametro precedentemente inserito
			}
		}
	}

	private TipologiaCliente scegliTipologia(String msg) {
		TipologiaCliente[] tipologie = TipologiaCliente.values();
		System.out.println(msg);

		int indice = 0;
		for (TipologiaCliente tipo : tipologie) {
			System.out.println(++indice + ") " + tipo.getNome());
		}

		while (true) {
			try {
				int scelta = scan.nextInt();
				scan.nextLine();
				// uscita dal metodo quando non si vuole cambiare la tipologia
				if (scelta == 0) {
					return null;
				}

				if (scelta >= 1 && scelta <= tipologie.length) {
					return TipologiaCliente.values()[scelta - 1];
				}

				System.out.println("Sono ammessi solo i caratteri numerici indicati!");

			} catch (InputMismatchException e) {
				System.out.println("Hai inserito un carattere non ammesso!");
				scan.nextLine();
			}
		}
	}

	public void eliminaCliente() {

		int idCliente = scegliCliente("Quale cliente vuoi eliminare?").getIdCliente();

		try {

			boolean eliminato = cs.eliminaCliente(idCliente);

			if (eliminato) {
				System.out.println("Cliente eliminato con successo.");
			} else {
				System.out.println("Non è stata possibile l'eliminazione!");
			}

		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

}
