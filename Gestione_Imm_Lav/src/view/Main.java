
package view;

import java.util.Scanner;

import controller.CorsoController;
import controller.IstitutoController;
import controller.StudenteController;
import model.Corso;
import model.Studente;

public class Main {
	private static Scanner scan;
	private static CorsoController corsoCtrl = new CorsoController();
	private static StudenteController studCtrl = new StudenteController();
	private static IstitutoController istCtrl = new IstitutoController(corsoCtrl, studCtrl);

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
				flag = false;
				System.out.println("Chiusura in corso");
				return;
				
				
			default:
				throw new IllegalArgumentException("Non ho capito il comando:" + scan);
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
		System.out.println("7. Esci");
	}

	private static void aggiungiCorso() {
		System.out.println("Inserisci nome corso: ");
		String titolo = scan.next();
		System.out.println("Inserisci codice corso: ");
		String codCorso = scan.next();
		System.out.println("Inserisci il nome aula del corso: ");
		String aula = scan.next();
		corsoCtrl.addCorso(titolo, codCorso, aula);
	}
	
	private static void mostraCorsi() {
		System.out.println(corsoCtrl.visualizzaCorsi());
		mostraStudentiCorsi();
	}
	
	private static void mostraStudentiCorsi() {
		boolean flag = true;
		do {
			System.out.println("1. Visualizza gli studenti");
			System.out.println("2. Torna indietro");
			int scelta = scan.nextInt();
			switch(scelta) {
			case 1:
				System.out.println(istCtrl.mostraCorsiEStudenti());
				break;
			case 2:
				flag = false;
				System.out.println("Stai ritornando indietro...");
				break;
			}
		}while(flag);
		
	}
	
	private static void rimuoviCorso() {
		System.out.println("Inserisci codice corso che vuoi eliminare: ");
		String elimina = scan.next();
		corsoCtrl.removeCorso(elimina);
	}
	
	private static void rimuoviStudente() {
		System.out.println("Digita il codice fiscale dello studente da eliminare: ");
		String elimina = scan.next();
		studCtrl.removeStudente(elimina);
	}
	private static void mostraStudenti() {
		System.out.println(studCtrl.visualizzaStudenti());
	}
	private static void aggiungiStudente() {
				System.out.println("Inserisci il nome dello studente: ");
		String nome= scan.next();
		System.out.println("Inserisci il cognome dello studente: ");
		String cognome = scan.next();
		System.out.println("Inserisci il codice fiscale dello studente: ");
		String codFiscale= scan.next();
		// implementare logica per permettere l'aggiunta di molteplici corsi, magari ciclo while finchè riposta "no".
		System.out.println("Inserisci il nome del corso a cui è iscritto: ");
		String codCorsoIscritto = scan.next();
		istCtrl.aggiungiStudenteEIscrivi(nome, cognome, codFiscale, codCorsoIscritto);
	}
}
