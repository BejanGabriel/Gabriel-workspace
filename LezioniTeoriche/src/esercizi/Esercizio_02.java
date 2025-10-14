package esercizi;

import java.util.Scanner;

public class Esercizio_02 {
/*Scrivi un programma che chiede all'utente di inserire un numero compreso tra
10 e 20. Usa l'operatore ||*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Inserisci un numero tra 10 e 20");
		int num = scan.nextInt();
		if(num < 10 || num > 20) {
			System.out.println("Il numero inserito e fuori dal parametro richiesto");
		}else {
			System.out.println("Il numero inserito è corretto");
		}
	}
}
