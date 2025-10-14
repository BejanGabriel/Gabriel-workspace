package esercizi;

import java.util.Scanner;

public class Esercizio_04 {
/*Scrivi un programma che prenda in input il numero del mese (1-12) e stampi la stagione corrispondente:

- Dicembre, Gennaio, Febbraio: "Inverno"
- Marzo, Aprile, Maggio: "Primavera"
- Giugno, Luglio, Agosto: "Estate"
- Settembre, Ottobre, Novembre: "Autunno"*/
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Inserisci numero del mese: ");

		int mese = scan.nextInt();
		if(mese < 1 || mese > 12) {
			System.out.println("Caro utente, il numero da inserito non corrisponde ad alcun mese!!");
		}else if(mese == 12 || mese == 1 || mese == 2) {
			System.out.println("La stagione di questo me è: Inverno");
		}else if(mese >= 3 && mese <= 5) {
			System.out.println("La stagione di questo me è: Primavera");
		}else if(mese >= 6 && mese <= 8) {
			System.out.println("La stagione di questo me è: Estate");
		}else if(mese == 9 ||mese == 10 || mese == 11) {
			System.out.println("La stagione di questo me è: Autunno");
		}
}
}
