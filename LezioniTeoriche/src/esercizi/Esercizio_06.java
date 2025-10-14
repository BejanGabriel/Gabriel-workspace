package esercizi;

import java.util.Scanner;

public class Esercizio_06 {
/*Crea una calcolatrice che continui a chiedere all'utente:
- Due numeri
- Un'operazione (+, -, *, /)
Usa switch per gestire le operazioni e while per ripetere finché l'utente non digita "fine".*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String scelta = "";

		while (!scelta.equalsIgnoreCase("fine")) {
			System.out.print("Inserisci il primo numero: ");
			double num1 = scan.nextDouble();

			System.out.print("Inserisci il secondo numero: ");
			double num2 = scan.nextDouble();

			System.out.print("Scegli un'operazione (+, -, *, /): ");
			char operazione = scan.next().charAt(0);

			double risultato = 0;
			boolean operazioneValida = true;

			switch (operazione) {
			case '+':
				risultato = num1 + num2;
				break;
			case '-':
				risultato = num1 - num2;
				break;
			case '*':
				risultato = num1 * num2;
				break;
			case '/':
				if (num2 != 0) {
					risultato = num1 / num2;
				} else {
					System.out.println("Errore: divisione per zero!");
					operazioneValida = false;
				}
				break;
			default:
				System.out.println("Operazione non valida!");
				operazioneValida = false;
			}

			if (operazioneValida) {
				System.out.println("Risultato: " + risultato);
			}

			System.out.print("Scrivi 'fine' per uscire o premi invio per continuare: ");
			scelta = scan.next();
		}

		System.out.println("Calcolatrice terminata.");
		scan	.close();
	}

}
