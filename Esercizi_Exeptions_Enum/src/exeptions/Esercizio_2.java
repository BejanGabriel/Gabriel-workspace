package exeptions;

import java.util.Scanner;

public class Esercizio_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
		String[] auto = { "Toyota", "BMW", "Audi", "Fiat", "Mercedes" };
	
		System.out.println("Buongiorno utente, quale marca di auto ti interessa conoscere?");
		
		int input = scan.nextInt();
		System.out.println("Ottima scelta, le auto " + auto[input] + " sono il meglio del meglio");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Mi dispiace, purtroppo non conosco il brand indicato");
		}

	}
}
