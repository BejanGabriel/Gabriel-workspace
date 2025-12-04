package exeptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Esercizio 1: Gestione base di eccezioni
Scrivi un programma che:

Chiede all'utente di inserire due numeri
Esegue la divisione tra i due numeri
Gestisce l'eccezione ArithmeticException (divisione per zero)
Gestisce l'eccezione InputMismatchException (input non numerico)
*/

public class Esercizio_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		try {

			System.out.println("Inserisci primo numero: ");
			int x = scan.nextInt();

			System.out.println("Inserisci secondo numero: ");
			int y = scan.nextInt();

			double r = x / y;
			System.out.println(r);
		} catch (ArithmeticException e) {
			System.out.println("Eccezione aritmetica, stai provando a fare un calcolo non concesso");
		} catch (InputMismatchException e) {
			System.out.println("Errore di inserimento, sono ammessi solo numeri");
		}

		
	}

}
