package viwer;

import java.util.Scanner;

import control.CassaController;

public class Main {
	private static CassaController cassaCtrl;
	private static Scanner scan;
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		
		System.out.println("==== Cassa per cambio EUR & USD ====");
		
		cassaCtrl = new CassaController("Cassa Aeroporto", 2800);
		
		boolean mostra = true;
		while(mostra) {
			mostra = mostraMenu();
		}
	}
	private static boolean mostraMenu() {
		System.out.println("=== Menù principale lato Gestore ===");
		System.out.println("1. Esegui Cambio EUR/USD");
		System.out.println("2. Aggiungi fondi in dollari");
		System.out.println("3. Stampa storico cambi");
		System.out.println("4. Visualizza info cassa");
		System.out.println("5. Preleva fondi EUR"); //DA FARE
		System.out.println("6. Esci"); //DA FARE
		
		int scelta = scan.nextInt();
		scan.nextLine(); // per pulire
		switch(scelta) {
		case 1:
			eseguiCambio();
			break;
		case 2:
			aggiungiDollari();
			break;
		case 3:
			getStoricoCambi();
			break;
		case 4: 
			visualizzaInfoCassa();
			break;		
		case 5:
			prelevaEuro();
			break;
		case 6: 
			System.out.println("Arrivederci");
			return false;
		default:
				System.out.println("Opzione non valida");
		}
		return true;
	}
	
	public static void eseguiCambio() {
		System.out.println("Inserisci l'importo in EUR per il cambio");
		double importoEUR = scan.nextDouble();
		scan.nextLine();
		
		String risultato = cassaCtrl.eseguiCambio(importoEUR);
		System.out.println("\n" + risultato);
	}
	
	//AGGIUNTA GABRIEL
	public static void prelevaEuro() {
		System.out.println("Inserisci limporto EUR da prelevare");
		double importo = scan.nextDouble();
		scan.nextLine();
		
		String risultato = cassaCtrl.eseguiPrelievo(importo);
		System.out.println("\n" + risultato);
	}
	
	public static void aggiungiDollari() {
		System.out.println("Inserisci i dollari da versare");
		double importo = scan.nextDouble();
		scan.nextLine();
		
		if(cassaCtrl.aggiungiDollari(importo)) {
			System.out.println("Fondo dollari aggiunto con successo");
		}else {
			System.out.println("Error: importo non valido");
		}
	}
	
	public static void getStoricoCambi() {
		System.out.println(cassaCtrl.getStoricoCambi());
	}
	
	public static void visualizzaInfoCassa() {
		System.out.println(cassaCtrl.getInfoCassa());
	}
}
