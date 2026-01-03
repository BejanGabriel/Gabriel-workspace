package controller;

import java.util.Scanner;

import service.AppuntamentoService;

public class AppuntamentoMenu {
	
	private static AppuntamentoService as = new AppuntamentoService();
	private static Scanner scan = new Scanner(System.in);
	
	public void mostraMenu() {
		
		boolean continua = true;
		
		do {
			System.out.println("1. Crea Appuntamento");
			System.out.println("2. Modifica Appuntamento");
			System.out.println("3. Trova Appuntamento");
			System.out.println("4. Mostra lista Appuntamenti");
			System.out.println("5. Elimina un Appuntamento");
			System.out.println("0. Torna al menu Generico.");

			int scelta = scan.nextInt();
			switch (scelta) {
			case 1:
				creaAppuntamento();
				break;
			case 2: 
				modificaAppuntamento();
				break;
			case 3: 
				trovaAppuntamento();
				break;
			case 4: 
				mostraAppuntamenti();
				break;
			case 5:
				eliminaAppuntamento();
				break;
			case 0:
				continua = false;
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + scelta);
			}
			
		} while (continua);
	}

	private void eliminaAppuntamento() {
		// TODO Auto-generated method stub
		
	}

	private void mostraAppuntamenti() {
		// TODO Auto-generated method stub
		
	}

	private void trovaAppuntamento() {
		// TODO Auto-generated method stub
		
	}

	private void modificaAppuntamento() {
		// TODO Auto-generated method stub
		
	}

	private void creaAppuntamento() {
		// TODO Auto-generated method stub
		
	}
	
}
