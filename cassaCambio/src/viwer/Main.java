package viwer;

import java.util.Scanner;

import control.RegistroCambio;
import model.Cambio;
import model.Cassa;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int scelta = 0;
		RegistroCambio registro = new RegistroCambio();
		Cassa cassa = new Cassa("Porta Nuova", 1000.0, registro);
		
		while (scelta != 4) {
			System.out.println(
					"\n-----Benvenuto alla cassa " + cassa.nome + " -----" + "\nPerfavore segli l'operazione desiderata"
							+ "\n1. Cambio EUR USD" + "\n2. Visualizza Registro" + "\n3. Vedi info cassa" + "\n4. Esci");
			scelta = scan.nextInt();
			switch (scelta) {
			case 1:
				System.out.print("Perfavore inserisci importo EUR: ");
				int importoEUR = scan.nextInt();
				if (importoEUR > 0) {
					cassa.eseguiCambio(importoEUR);
				} else {
					System.out.println("Hai inserito un importo sbagliato, riprova");
				}
				break;
			case 2:
				System.out.println("\n--- Registro Cambi ---");
				for (Cambio c : registro.mostraListaCambi()) {
					System.out.println(c);
				}
				break;
			case 3:
				System.out.println(cassa.infoCassa());
				break;
			case 4:
				System.out.println("Uscita...");
				break;
			default:
				System.out.println("Scelta non valida, riprova.");

			}
		}
	}
}
