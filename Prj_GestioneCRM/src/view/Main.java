package view;

import java.util.List;
import java.util.Scanner;
import database.DBConnection;
import model.Cliente;
import model.Utente;
import service.ClienteService;
import service.UtenteService;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	private static UtenteService us = new UtenteService();
	private static ClienteService cs = new ClienteService();
	public static void main(String[] args) {
		
		// apertura della connessione all'avvio del main.
		DBConnection connessione = DBConnection.getInstance();
		connessione.getConnessione();
//		aggiuntiUtente();
		aggiungiCliente();
//		System.out.println(us.getAllUtenti());
		
		//TESTING UTENTE -> OK!
//		Utente utente = new Utente();
//		utente.setNomeUtente("MARCO");
//		utente.setRuolo("PAZZO");
//		utente.setEmail("PAZZ.MARC@mail.com");
//		utente.setPassword("123");
		
//		GenericDAO<Utente> gdU = new UtenteDAOImpl();
//		Utente u = gdU.readByID(1);
//		System.out.println(u);
		//TESTING CLIENTE -> OK!
//		Cliente cliente = new Cliente();
//		cliente.setNomeAzienda("Pippo.s.r.l");
//		cliente.setRefereneAzienda("Luca Marconi");
//		cliente.setCategoriaMerceologica("Sviluppatore");
//		cliente.setTipologiaCliente("In Acquisizione");
		
		// UPDATING utente_assegnato FK -> OK!
//		ClienteDAO gdC = new ClienteDAOImpl();
//		//gdU.create(cliente);
//		List<Cliente> listaClienti = gdC.readAll();
//		Cliente c = gdC.readByID(1);
//		
//		System.out.println("=== Cliente Singolo ===\n" + c);
//		System.out.println("=== Lista Clienti ===\n" + listaClienti);
//		
//		gdC.assegnazioneByID(3, 4);
		
		
		
		
		
		
		
		
		//questa verrà avviato solo dopo aver finito tutto quello che volevo fare.
		connessione.close();
		
	}

	private static void aggiuntiUtente() {

		System.out.println("Inserisci nome utente: ");
		String nome = scan.next();
		System.out.println("Inserisci il ruolo dell'utente: ");
		String ruolo = scan.next();
		System.out.println("Inserisci email dell'utente: ");
		String email = scan.next();
		System.out.println("Inserisci password utente: ");
		String password = scan.next();
		
		us.aggiungiUtente(nome,ruolo,email,password);
	}
	
	private static int segliUtente() {
		List<Utente> utenti = us.getAllUtenti();
		int contatore = 0;
		for(Utente u : utenti) {
			System.out.println(++contatore + ") " + u.getNomeUtente());
		}
		System.out.println("Seleziona un utente: ");
		int scelta = scan.nextInt();
		scan.nextLine();
		return utenti.get(scelta-1).getIdUtente();
	}
	
	private static void aggiungiCliente() {
		
		System.out.println("Inserisci nome azienda: ");
		String nomeAzienda = scan.nextLine();
		System.out.println("Inserisci referente azienda: ");
		String referenteAzienda = scan.nextLine();
		System.out.println("Inserisci la sua categoria merceologica: ");
		String catMerceologica = scan.nextLine();
		System.out.println("Inserisci il tipo di cliente: ");
		String tipoCliente = scan.nextLine();
		System.out.println("Segli l'utente associato:");
		int utenteAssociato = segliUtente();
		cs.aggiungiCliente(nomeAzienda, referenteAzienda, catMerceologica, tipoCliente, utenteAssociato);

	}
}
