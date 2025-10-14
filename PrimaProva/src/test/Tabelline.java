package test;

import java.util.Scanner;

public class Tabelline {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Inserisci numero ");
		int num = scan.nextInt();	
		int moltiplicatore = 0;
		for(int i = 0; i <= 10; i++) {
			int risultato = num * moltiplicatore;
			System.out.println(num + " * " + moltiplicatore + " = " + risultato);
			moltiplicatore++;
		}
	
	}
}
