package esercizi;

public class Esercizio_01 {
	
	/*
		 * Un negozio offre uno sconto speciale ai clienti che soddisfano almeno una di
		 * due condizioni: Sono membri del club fedeltà. Hanno speso più di 100 euro
		 * nell'ultimo acquisto.
		 */
	
	public static void main(String[] args) {
		String[] cliente = {"Gabriel", "Lauro", "Viviana", "Martina"};
		int[] costi = {100, 300, 90, 50};
		
		
		
		
		for(int i = 0; i < cliente.length; i++) {
			//verifica chi è nel club
            boolean clubFedelta = cliente[i].equals("Gabriel") || cliente[i].equals("Viviana");
            
			//verifica diritto sconto
			if(clubFedelta || costi[i] > 100) {
				System.out.println(cliente[i]+" Ha diritto allo sconto. Ha speso: "+costi[i]);
			}else {
				System.out.println(cliente[i]+" Non ai diritto allo sconto Ha speso: "+costi[i]);
			}
		}
		
	}
}
