package esercizi;

import java.util.Scanner;

public class Esercizio_03 {
/*Sono un docente devo assegnare dei voti. Se il voto è sotto il 70
assegno F, se il voro è sotto 80 assegno C, se il voto è sotto 90 assegno B,
se è maggiore di 90 assegno A*/
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Inserisci voto");
		int voto = scan.nextInt();
		if(voto < 70) {
			System.out.println("Hai assegnato una F al compito valutato");
		}else if(voto < 80) {
			System.out.println("Hai assegnato una C al compito valutato");
		}else if(voto < 90) {
			System.out.println("Hai assegnato una B al compito valutato");
			//in questo caso rientrano i voti sopra i 90.
		}else {
			System.out.println("Hai assegnato una A al compito valutato");
		}
	}
}
