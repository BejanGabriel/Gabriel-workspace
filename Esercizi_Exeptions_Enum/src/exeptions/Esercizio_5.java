package exeptions;

import java.util.Scanner;

public class Esercizio_5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] citta = { 
	            "1. Torino", "2. Milano", "3. Roma", "4. Napoli", "5. Firenze",
	            "6. Bologna", "7. Venezia", "8. Genova", "9. Palermo", "10. Cagliari"
	        };
		try {
			for(String elemento : citta) {
				System.out.println(elemento);
			}
		System.out.println("Inserisci un numero per identificare la tua città: ");
		String numStringa = scan.nextLine();
		
		int numero = Integer.parseInt(numStringa);
		
		System.out.println("Il città selezionata è " + citta[numero-1]);
		}catch (NumberFormatException e) {
			System.out.println("Mi dispiace, sono ammessi solo caratteri numerici.");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Mi dispiace, non ho capito la città selezionata");
		}catch (NullPointerException e) {
			System.out.println("Mi dispiace, non ho capito");
		}
		
	}


}
