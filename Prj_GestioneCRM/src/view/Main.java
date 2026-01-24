package view;

import java.util.Scanner;

import controller.ClienteMenu;
import controller.ServizioMenu;
import controller.UtenteMenu;
import database.DBConnection;

// main troppo grosso, bisogna dividerlo in vari menu apositi.
// per ora lascio cosi, più avanti frammento la logica.

public class Main {

	private static Scanner scan = new Scanner(System.in);
	private static UtenteMenu um = new UtenteMenu();
	private static ClienteMenu cm = new ClienteMenu();
	private static ServizioMenu sm = new ServizioMenu();

	public static void main(String[] args) {

		// apertura della connessione all'avvio del main.
		DBConnection connessione = DBConnection.getInstance();
		connessione.getConnessione();

		boolean continua = true;
		do {
			mostraMenu();
			System.out.println("Quale operazione vuoi effettuare? ");
			int scelta = scan.nextInt();
			scan.nextLine();
				
			switch (scelta) {
			case 1:
				um.mostraMenu();
				break;
			case 2:
				cm.mostraMenu();
				break;
			case 3:
				sm.menuServiziGenerali();
				break;
			case 0:
				System.out.println("Chiusura in corso...");
				continua = false;
			}
			
		} while (continua);

		connessione.close();

	}

	private static void mostraMenu() {

		System.out.println("==== Menu Globale ====");
		System.out.println("1. Menu Utente");
		System.out.println("2. Menu Cliente");
		System.out.println("3. Gestisci Servizi");
		System.out.println("0. Esci");

	}

}
