package esercizi;

import java.util.Scanner;

public class Esercizio_07 {
	/*
	 * Scrivi un programma che mostri un menu con le seguenti opzioni:
- Saluta
- Mostra data
- Esci
Il programma deve continuare a mostrare il menu finché l'utente non sceglie l'opzione 3. Usa un ciclo do-while.
*/
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int scelta;

		do {
			System.out.println("\n--- MENU ---");
			System.out.println("1. Saluta");
			System.out.println("2. Mostra data");
			System.out.println("3. Esci");
			System.out.print("Scegli un'opzione: ");
			scelta = scan.nextInt();

			switch (scelta) {
			case 1:
				System.out.println("Ciao! 👋");
				break;
			case 2:
				String oggi = "07/10/2025";
				System.out.println("La data di oggi è: " + oggi);
				break;
			case 3:
				System.out.println("Uscita dal programma...");
				break;
			default:
				System.out.println("Opzione non valida. Riprova.");
			}
		} while (scelta != 3); // continua finché non scegli 3

		scan.close();
	}

}
