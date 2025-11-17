package view;

import java.util.Scanner;

import controller.CorsoController;

public class Main {
	private static Scanner scan;
	private static CorsoController corsoCtrl = new CorsoController();

	public static void main(String[] args) {

		scan = new Scanner(System.in);
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
				
			case 8:
				flag = false;
				System.out.println("Bhe fanculo anche a te");
				break;
				
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + scan);
			}
		} while (flag);

	}
	public static void mostraMenu() {
		System.out.println("\n==== Immaginazione e Lavoro ====");
		System.out.println("1. Aggiungi corso");
		System.out.println("2. Mostra tutti i corsi");
		System.out.println("3. Rimuovi un corso");
		System.out.println("4. Aggiungi studenti");
		System.out.println("5. Mostra tutti i studenti");
		System.out.println("6. Rimuovi uno studente");
		System.out.println("7. Aggiungi studenti");
		System.out.println("8. Esci");
	}

	private static void aggiungiCorso() {
		System.out.println("Inserisci nome corso: ");
		String titolo = scan.next();
		System.out.println("Inserisci codice corso: ");
		String codCorso = scan.next();
		corsoCtrl.addCorso(titolo, codCorso);
	}
	
	private static void mostraCorsi() {
		System.out.println(corsoCtrl.visualizzaCorsi());
	}
	
	private static void rimuoviCorso() {
		System.out.println("Inserisci codice corso che vuoi eliminare: ");
		String elimina = scan.next();
		corsoCtrl.removeCorso(elimina);
	}
	
	private static void rimuoviStudente() {
		// TODO Auto-generated method stub
		
	}
	private static void mostraStudenti() {
		// TODO Auto-generated method stub
		
	}
	private static void aggiungiStudente() {
		// TODO Auto-generated method stub
		
	}
}
