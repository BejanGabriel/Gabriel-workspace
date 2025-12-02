package view;

import java.util.Scanner;

import controller.CorsoController;
import controller.Databases;
import controller.StudenteController;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	private static Databases dbManager = new Databases();
	private static CorsoController corsoCtrl = new CorsoController(dbManager.caricaListaCorsi(), dbManager);
	private static StudenteController studenteCtrl = new StudenteController(dbManager.caricaListaStudenti(), dbManager);

	public static void main(String[] args) {
		boolean flag = true;

		do {
			mostraMenu();

			int scelta = scan.nextInt();

			switch (scelta) {
			case 1:
				aggiungiCorso();
				break;
			case 2:
				mostraCorsi();
				break;
			case 3:
				rimuoviCorso();
				break;
			case 4:
				aggiungiStudente();
				break;
			case 5:
				mostraStudenti();
				break;
			case 6: 
				rimuoviStudente();
				break;
			case 7:
				flag = false;
				System.out.println("Chiusura in corso");
				return;
				
				
			default:
				throw new IllegalArgumentException("Non ho capito il comando:" + scan);
			}
		} while (flag);

	}
	
	private static void rimuoviStudente() {
		System.out.println("Inserisci l'id dello studente da rimuovere: ");
		int id = scan.nextInt();
		studenteCtrl.removeStudete(id);
		
	}

	private static void mostraStudenti() {
		System.out.println(studenteCtrl.VisualizzaStudenti());
	}

	private static void aggiungiStudente() {
		System.out.print("Nome studente: ");
        String nome = scan.nextLine();
        System.out.print("Cognome studente: ");
        String cognome = scan.nextLine();
        System.out.print("Codice fiscale: ");
        String cf = scan.nextLine();
        System.out.print("Codice corso: ");
        String codCorso = scan.nextLine();
        studenteCtrl.addStudente(0,nome, cognome, cf, codCorso);
	}

	private static void rimuoviCorso() {
		System.out.println("Inserisci l'id del corso da rimuovere: ");
		int id = scan.nextInt();
		corsoCtrl.removeCorso(id);
	}

	private static void mostraCorsi() {
		System.out.println(corsoCtrl.VisualizzaCorsi());
	}

	public static void mostraMenu() {
		System.out.println("\n==== Immaginazione e Lavoro ====");
		System.out.println("1. Aggiungi corso");
		System.out.println("2. Mostra tutti i corsi");
		System.out.println("3. Rimuovi un corso");
		System.out.println("4. Aggiungi studenti");
		System.out.println("5. Mostra tutti i studenti");
		System.out.println("6. Rimuovi uno studente");
		System.out.println("7. Esci");
	}

	private static void aggiungiCorso() {
		System.out.println("Inserisci nome corso: ");
		String titolo = scan.next();
		System.out.println("Inserisci codice corso: ");
		String codCorso = scan.next();
		System.out.println("Inserisci il nome aula del corso: ");
		String aula = scan.next();
		corsoCtrl.addCorso(0, titolo, codCorso, aula);
	}
	
}
