package controller;

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
			case 2: modificaUtente();
				break;
			case 3: 
				System.out.println("Inserisci ID Utente");
				int idUtente = scan.nextInt();
				scan.nextLine();
				System.out.println(us.getSingoloUtente(idUtente)); 
				break;
			case 4:
				System.out.println("=== Lista Utenti ===");
				System.out.println(us.getAllUtenti());
				break;
			case 5:
				System.out.println("Inserisci ID Utente da eliminare: ");
				int elimina = scan.nextInt();
				scan.nextLine();
				us.eliminaUtente(elimina);
				break;
			case 0:
				System.out.println("-- Ritorno al menù generico...");
				continua = false;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + scelta);
			}
		} while(continua);
	}
	
	public void modificaUtente() {
		System.out.println("Quale utente vuoi modificare?");
		Utente modificato = scegliUtente();
		System.out.println("Laciare vuoti i campi che non si desidera modificare.");
		String nome, ruolo, email, password;
		System.out.println("Digita nuovo nome utente: ");
		nome = scan.nextLine();
		if(!nome.isBlank()) modificato.setNomeUtente(nome);
		System.out.println("Digita nuovo ruolo: ");
		ruolo = scan.nextLine();
		if(!ruolo.isBlank()) modificato.setRuolo(ruolo);
		System.out.println("Digita nuova email: ");
		email = scan.nextLine();
		if(!email.isBlank()) modificato.setEmail(email);
		System.out.println("Digita nuova password: ");
		password = scan.nextLine();
		if(!password.isBlank()) modificato.setPassword(password);
		us.modificaUtente(modificato);
	}

	public void aggiuntiUtente() {

		System.out.println("Inserisci nome utente: ");
		String nome = scan.next();
		System.out.println("Inserisci il ruolo dell'utente: ");
		String ruolo = scan.next();
		System.out.println("Inserisci email dell'utente: ");
		String email = scan.next();
		System.out.println("Inserisci password utente: ");
		String password = scan.next();

		us.aggiungiUtente(nome, ruolo, email, password);
	}

	public static Utente scegliUtente() {
		List<Utente> utenti = us.getAllUtenti();
		int contatore = 0;
		for (Utente u : utenti) {
			System.out.println(++contatore + ") " + u.getNomeUtente());
		}
		System.out.println("Seleziona un utente: ");
		int scelta = scan.nextInt();
		scan.nextLine();
		if(scelta == 0) return null;
		return utenti.get(scelta - 1);
	}

}
