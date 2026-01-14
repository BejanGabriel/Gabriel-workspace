package controller;

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
	private static UtenteMenu um = new UtenteMenu();
	private static NotaMenu nm = new NotaMenu();
	private static AppuntamentoMenu am = new AppuntamentoMenu();

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
			System.out.println("8. Vedi lista appuntamenti del cliente");
			System.out.println("9. Vedi servizi Cliente");
			System.out.println("0. Torna al menu Generico");
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
				Cliente dash = scegliCliente("Di quale cliente vuoi vedere la Dashboard?");
				dashboard(dash);
				break;
			case 0:
				continua = false;
				break;
			default:
				throw new IllegalArgumentException("Non ho capito il comando, hai inserito: " + scelta);
			}
		} while (continua);
	}

	private void gestioneNote() {
		nm.mostraMenu();
		
	}

	private void gestioneAppuntamenti() {
		am.mostraMenu();
	}

	private void dashboard(Cliente cliente) {
		System.out.println("=== Dati Cliente ===");
		System.out.println(
				"Nome Azienda: " + cliente.getNomeAzienda() + "\nNome Referente: " + cliente.getRefereneAzienda()
						+ "\nCategoria Merceologica: " + cliente.getCategoriaMerceologica() + "\nTipo Cliente: "
						+ cliente.getTipologiaCliente() + "\nUtente Associato: " + cliente.getUtenteAssociato());
		System.out.println("=== Note Cliente ===");
		
		
		System.out.println("=== Prossimi appuntamenti ===");

	}

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
				for (Cliente c : cs.ricercaPerCategoria(categoria)) {
					System.out.println(c);
				}
				System.out.println("--------------------------------\n");
				break;
			case 2:
				System.out.println("---- Ricerca per Tipologia ----");
				String tipologia = scegliTipologia("Per quale tipologia vuoi ricercare?").getNome();
				for(Cliente c : cs.ricercaPerTipologia(tipologia)) {
					System.out.println(c);
				}
				System.out.println("--------------------------------\n");
				break;

			case 3:
				System.out.println("---- Ricerca Per UtenteAssociato ----");
				int idUtente = um.scegliUtente("Quale utente vuoi cercare?").getIdUtente();
				for(Cliente c : cs.ricercaPerUtente(idUtente)) {
					System.out.println(c);
				}
				System.out.println("--------------------------------\n");
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
		int idCliente = scan.nextInt();
		scan.nextLine();
		System.out.println(cs.getSingoloCliente(idCliente));

	}

	private void modificaCliente() {
		Cliente c = scegliCliente("Quale cliente vuoi modificare?");
		String nomeAzienda, referenteAzienda;
		CategoriaMerceologica catt;
		TipologiaCliente tipologiaCliente;
		Utente utenteAssociato;
		System.out.println("Digita nuvo nome azienda: ");
		nomeAzienda = scan.nextLine();
		if(!nomeAzienda.isBlank()) c.setNomeAzienda(nomeAzienda);
		System.out.println("Digita nuovo referente dell'azienda: ");
		referenteAzienda = scan.nextLine();
		if(!referenteAzienda.isBlank()) c.setRefereneAzienda(referenteAzienda);
//		catt = segliCategoria("Segli la sua nuovo categoria: "); NON LA FACCIO PERCHE LOGICAMENTE NON SERVE CAMBIARE MAI LA CATEGORIA DI UN CLIENTE
		// MA SE PROPRIO DOVESSI, BASTA AGGIUNGERE UN NUOVA VOCE NELL'ENUM 'INVARIATA' E AL SELEZIONAMENTO DI QUELLA ATTRAVERSO IL METODO 
		// scegliCategoria() NON SI CAMBIA CATEGORIA, ALTRIMENTI SETTO LA NUOVA.
		tipologiaCliente = scegliTipologia("Segli la nuovo tipologia del cliente (0 per lasciare invariato):");
		if(tipologiaCliente != null) c.setTipologiaCliente(tipologiaCliente);
		
		utenteAssociato = um.scegliUtente("Digitare nuovo utente associato (0 per lasciare invariato)");
		if(utenteAssociato != null) c.setUtenteAssociato(utenteAssociato.getIdUtente());
	
		cs.modificaCliente(c);
		System.out.println("Cliente ID:" + c.getIdCliente() + " modificato con successo!");
	}

	public static Cliente scegliCliente(String msg) {
		System.out.println(msg);
		List<Cliente> clienti = cs.getAllClienti();
		int contatore = 0;
		for (Cliente c : clienti) {
			System.out.println(++contatore + ") " + c.getRefereneAzienda());
		}
		System.out.println("Seleziona un cliente: ");
		int scelta = scan.nextInt();
		scan.nextLine();
		if(scelta == 0) return null;
		return clienti.get(scelta - 1);
	}

	public void aggiungiCliente() {

		System.out.println("Inserisci nome azienda: ");
		String nomeAzienda = scan.nextLine();
		System.out.println("Inserisci referente azienda: ");
		String referenteAzienda = scan.nextLine();

//		segliCategoria("Inserisci la sua categoria merceologica");  METODO PER SEGLIERE CATEGORIA
//		System.out.println("Inserisci la sua categoria merceologica: ");
//		String catMerceologica = scan.nextLine();

		System.out.println("Inserisci il tipo di cliente: ");
		String tipoCliente = scan.nextLine();
		int utenteAssociato = um.scegliUtente("Segli l'utente associato").getIdUtente();
		cs.aggiungiCliente(nomeAzienda, referenteAzienda, scegliCategoria("Inserisci la sua categoria merceologica"),
				scegliTipologia("Inserisci la sua tipologia"), utenteAssociato);

	}

	private CategoriaMerceologica scegliCategoria(String msg) {
		System.out.println(msg);
		int indice = 0;
		for (CategoriaMerceologica cat : CategoriaMerceologica.values()) {
			System.out.println(++indice + ") " + cat.getNome());
		}
		int scelta = scan.nextInt();
		scan.nextLine();
		return CategoriaMerceologica.values()[scelta - 1];

	}

	private TipologiaCliente scegliTipologia(String msg) {
		System.out.println(msg);
		int indice = 0;
		for (TipologiaCliente tipo : TipologiaCliente.values()) {
			System.out.println(++indice + ") " + tipo.getNome());
		}
		int scelta = scan.nextInt();
		scan.nextLine();
		if (scelta == 0) {
			return null;
		}
		return TipologiaCliente.values()[scelta - 1];
	}

	public void eliminaCliente() {
		int idCliente = scegliCliente("Quale cliente vuoi eliminare?").getIdCliente();
		cs.eliminaCliente(idCliente);
	}

}
