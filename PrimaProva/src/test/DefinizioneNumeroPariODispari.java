package test;

import java.util.Scanner;

/*
 * Dati 3 numeri, calcolane la media e definisci se è maggiore di 10
 */

public class DefinizioneNumeroPariODispari {
	public static void main (String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Inserisci primo numero: ");
			int num1 = scanner.nextInt();
			System.out.print("Inserisci secondo numero: ");
			int num2 = scanner.nextInt();
			System.out.print("Inserisci terzo numero: ");
			int num3 = scanner.nextInt();
			
			int somma = num1 + num2 + num3;
			double media = (double) somma / 3;
			String output = (somma > 10) ? "La Somma è maggiore di 10 " : "La somma è inferiore a 10";
			if(somma%2 == 0) {
				output = "La somma dei numeri è pari";
			}else {
				output = "La somma dei numeri è dispari";
			}
			
			
			System.out.println(output + "\nLa somma dei 3 numeri è: " + somma 
					+ "\nLa media è: " + media);
		}
	}
}
