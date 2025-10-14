package esercizi;

import java.util.Scanner;

public class Switch_Statement {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Inserisci numero giorno");
		int giornoDellaSettimana = scan.nextInt();
		
		switch(giornoDellaSettimana) {
		case 1:
			System.out.println("Lunedì");
			break;
		case 2:
			System.out.println("Martedì");
			break;
		case 3:
			System.out.println("Mercoledì");
			break;
		case 4:
			System.out.println("Giovedì");
			break;
		case 5:
			System.out.println("Venerdì");
			break;
		case 6:
			System.out.println("Sabato");
			break;
		case 7:
			System.out.println("Domenica");
			break;
		default: 
			System.out.println("Non riconosco il valore");
			break;
		}
		
		System.out.println("Inserisci il nome del giorno della settimana: ");
		scan.nextLine(); // pulisci il buffer lasciato da nextInt()
		String giorno = scan.nextLine();

		switch (giorno) {
		    case "Lunedi":
		        System.out.println("Inizio settimana");
		        break;
		    default:
		        System.out.println("Giorno non riconosciuto");
		        break;
		}

	}
}
