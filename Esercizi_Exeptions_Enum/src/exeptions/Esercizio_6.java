package exeptions;

import java.util.Scanner;

public class Esercizio_6 {
	public static void main(String[] args) {
		boolean risorsaAperta;
		
		Scanner scan = new Scanner(System.in);
		
		String[] risorse = {
				"1. Pannello di Controllo",
				"2. Esplora Risorse",
				"3. Task Manager",
				"4. Prompt dei Comandi",
				"5. Gestione Disco",
				"6. Centro Sicurezza",
				"7. Windows Update"
		};
		
		for(String risorsa : risorse) {
			System.out.println(risorsa);
		}
		
		System.out.println("Seleziona una risorsa da aprire: ");
		int numero = Integer.parseInt(scan.next());
		
			
		try {
			risorsaAperta = true;
			
			System.out.println("Ricerca della risorsa..");
			
			System.out.println("Apertura risorsa in corso");
			
			System.out.println("Apertura dell risorsa '" + risorse[numero-1] + "' In corso");
		}catch (Exception e) {
			System.out.println("Hmm... Qualcosa è andato storto: " + e.getMessage());
		}finally {
			risorsaAperta = false;
			System.out.println("Chiusura della risorsa...");
		}
	}
}
