package gestioneRistorante;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Quanti Ordini vuoi effettuare?");
		int lunghezzaArray = scan.nextInt();

		Ordine[] ordini = new Ordine[lunghezzaArray];

		for (int i = 0; i < ordini.length; i++) {

			ordini[i] = new Ordine();
			Piatto[] lista = Piatto.values();
			int sceltaPiatto = 0;
			do {

				System.out.println("==== Piatti Disponibili ====\n");
				System.out.println("Segli il piatto da ordinare: \n");

				for (int j = 0; j < lista.length; j++) {
					System.out.println((j + 1) + ") " + lista[j].getNome() + " - " + lista[j].getPrezzo() + "€");
				}
				System.out.println("0) Basta Grazie \n");
				System.out.println("=============================");

				sceltaPiatto = scan.nextInt();

				if (sceltaPiatto > 0 && sceltaPiatto <= lista.length) {
					ordini[i].aggiungiPiatto(lista[sceltaPiatto - 1]);
				}

			} while (sceltaPiatto != 0);

			ordini[i].calcolaTotale();
			ordini[i].contaPiattiPerCategoria();
			ordini[i].isVegetariano();
			ordini[i].stampaOrdine();

			System.out.println("\n fine operazioni per Ordine " + (i + 1) + "\n");

		}

//	    Piatto[] lista = Piatto.values();
//	    for (int j = 0; j < lista.length; j++) {
//	        System.out.println((j) + 1 + ") " + lista[j].getNome() + " - " + lista[j].getPrezzo() + "€");
//	    }
//	    System.out.println("0) Basta Grazie \n");
//	}
//	
//    // Mostra elenco piatti
//    Piatto[] lista = Piatto.values();
//    for (int i = 0; i < lista.length; i++) {
//        System.out.println((i+1) + ") " + lista[i].getNome() + " - " + lista[i].getPrezzo() + "€");
//    }
//
//    System.out.print("Scegli piatto (numero): ");
//    int scelta = scan.nextInt();

//    // Aggiunta piatto selezionato
//    ordini[i].aggiungiPiatto(lista[scelta - 1]);
//
//    // Stampa ordine
//    ordini.stampaOrdine();
	}
}
