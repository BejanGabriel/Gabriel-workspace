package esercizi;

import java.util.Scanner;

public class Esercizio_05 {
/*Scrivi tutti i numeri da 1 a 100. Per tutti i multipli di 3 stampa "Zoom",
 *  per tutti i multipli di 5 stampa "Boom". Per tutti i multipli di 3 e 5 stampa "Zoom Boom"*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numero = 0;
		for(int i = 0; i < 100; i++) {
			numero++;
			System.out.println(numero);
			if(numero % 3 == 0 && numero % 5 == 0) {
				System.out.println("^^^^^^ \n|||||| \nZOOM BOOM\n");
			}else if(numero % 3 == 0) {
				System.out.println("\n^^^^^ \n|||||| \nZOOM\n");
			}else if(numero % 5 == 0) {
				System.out.println("\n^^^^^ \n|||||| \nBOOM\n");
			}
		}
	}
}
