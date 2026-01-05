package controller;

import java.util.List;
import java.util.Scanner;

import model.CategoriaMerceologica;
import model.Cliente;
import model.Utente;
import service.ClienteService;

public class ClienteMenu {

	private static Scanner scan = new Scanner(System.in);
	private static final ClienteService cs = new ClienteService();
	private static UtenteMenu um = new UtenteMenu();

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
			System.out.println("6. Fissa Appuntamento");
			System.out.println("7. Acquista un servizio");
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
				fissaAppuntamento();
				break;
			case 7:
				mostraAppuntamentiCliente();
				break;
			case 0:
				continua = false;
				break;
			default:
				throw new IllegalArgumentException("Non ho capito il comando, hai inserito: " + scelta);
			}
		} while (continua);
	}

	private void mostraAppuntamentiCliente() {
		// TODO Auto-generated method stub
		
	}

	private void fissaAppuntamento() {
		// TODO Auto-generated method stub
		
	}

	private void mostraClienti() {
		System.out.println("==== Lista Clienti ====");
		for (Cliente c : cs.getAllClienti()) {
			System.out.println(c);
		}
	}

	private void trovaCliente() {
		System.out.println("Inserisci ID Cliente da cercare: ");
		int idCliente = scan.nextInt();
		scan.nextLine();
		System.out.println(cs.getSingoloCliente(idCliente));
		
	}

	private void modificaCliente() {
		System.out.println("Quale cliente vuoi modificare?");
		Cliente c = scegliCliente();
		String nomeAzienda, referenteAzienda, tipologiaCliente;
		CategoriaMerceologica catt;
		Utente utenteAssociato;
		System.out.println("Digita nuvo nome azienda: ");
		nomeAzienda = scan.nextLine();
		if(!nomeAzienda.isBlank()) c.setNomeAzienda(nomeAzienda);
		System.out.println("Digita nuovo referente dell'azienda: ");
		referenteAzienda = scan.nextLine();
		if(!referenteAzienda.isBlank()) c.setRefereneAzienda(referenteAzienda);
//		catt = segliCategoria("Segli la sua nuovo categoria: "); NON LA FACCIO PERCHE LOGICAMENTE NON SERVE CAMBIARE MAI LA CATEGORIA DI UN CLIENTE
		// MA SE PROPRIO DOVESSI, BASTA AGGIUNGERE UN NUOVA VOCE NELL'ENUM 'INVARIATA' E AL SELEZIONAMENTO DI QUELLA ATTRAVERSO IL METODO 
		// segliCategoria() NON SI CAMBIA CATEGORIA, ALTRIMENTI SETTO LA NUOVA.
		System.out.println("Digitare nuova tipologia cliente: ");
		tipologiaCliente = scan.nextLine();
		if(!tipologiaCliente.isBlank()) c.setTipologiaCliente(tipologiaCliente);
		
		System.out.println("Digitare nuovo utente associato (0 per lasciare invariato): ");
		utenteAssociato = um.scegliUtente();
		if(utenteAssociato != null) c.setUtenteAssociato(utenteAssociato.getIdUtente());
	
		cs.modificaCliente(c);
		System.out.println("Cliente ID:" + c.getIdCliente() + " modificato con successo!");
	}
	
	public static Cliente scegliCliente() {
		List<Cliente> clienti = cs.getAllClienti();
		int contatore = 0;
		for (Cliente c : clienti) {
			System.out.println(++contatore + ") " + c.getRefereneAzienda());
		}
		System.out.println("Seleziona un cliente: ");
		int scelta = scan.nextInt();
		scan.nextLine();
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
		System.out.println("Segli l'utente associato:");
		int utenteAssociato = um.scegliUtente().getIdUtente();
		cs.aggiungiCliente(nomeAzienda, referenteAzienda, segliCategoria("Inserisci la sua categoria merceologica"), tipoCliente, utenteAssociato);

	}

	private CategoriaMerceologica segliCategoria(String msg) {
		System.out.println(msg);
		int indice = 0;
		for(CategoriaMerceologica cat : CategoriaMerceologica.values()) {
			System.out.println(++indice + ") " + cat.getNome());
		}
		int scelta = scan.nextInt();
		scan.nextLine();
		return CategoriaMerceologica.values()[scelta-1];
		
	}

	public void eliminaCliente() {
		System.out.println("Quale cliente vuoi eliminare?");
		int idCliente = scegliCliente().getIdCliente();
		cs.eliminaCliente(idCliente);
	}
	
}
