package gestione_Traffico_Semaforico;

import java.util.Random;

/*	--Considerazioni aggiuntive--
  
  Si può pensare di creare un'array list di tutti i veicoli, e per ogni indice dell'array creare l'oggetto veicolo nuovo,
  	e attraverso un variabile rendom che va da 0 a fine array, e cosi facendo seleziona il veicolo da far passare, siccome
  	viene chiesto di farne passare almeno 3 tipi diversi di veicoli. */

public class Main {
	public static void main(String[] args) {
		Semaforo semaforo = new Semaforo();
		TipoVeicolo[] veicolo = { TipoVeicolo.AUTO, TipoVeicolo.AMBULANZA, TipoVeicolo.AUTOBUS, TipoVeicolo.BICICLETA,
				TipoVeicolo.MOTO };
		int contatoreCambioSemaforo = 0;
		int veicoliPassati = 3;

		System.out.println("==== SIMULAZIONE SEMAFORO ====\n");

		do {
			String output = semaforo.stampaStato() + "\n";
			

			Random rand = new Random();

			for (int i = 0; i < veicoliPassati; i++) {
				
				int numero = rand.nextInt(veicolo.length);
		
				output += veicolo[numero] + " può passare? ";
				if(veicolo[numero].getPriorita() == 5) {
					output += "Si (veicolo di emergenza)\n";
				}else if (semaforo.verificaPassaggio(veicolo[numero])) {
					output += "Si\n";
				}else  {
					output += "No\n";
				}

			}

			System.out.println(output);
			
			if(contatoreCambioSemaforo < 4) {
				System.out.println("\n---- Cambio stato ----\n");
			}
			
			semaforo.cambiaStato();
			contatoreCambioSemaforo++;

		} while (contatoreCambioSemaforo != 5);

	}
}
