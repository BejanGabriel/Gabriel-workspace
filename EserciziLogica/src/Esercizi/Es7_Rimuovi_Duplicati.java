package Esercizi;

import java.util.Arrays;

public class Es7_Rimuovi_Duplicati {
	public static void main(String[] args) {

		int[] array = { 3, 5, 3, 8, 5, 1 };
		int[] arrayTemporaneo = new int [array.length];
		int siRipete = 0;

		//per ogni elemento dell'array originale, controllo se è presente in quello temporaneo
		for (int i = 0; i < array.length; i++) {
			boolean ripetuto = false;
			for (int j = 0; j < siRipete; j++) {

				if (arrayTemporaneo[j] == array[i]) {
					ripetuto = true;
					break;
				}
			}
			//se non è presente, allora lo inserisco nel temporaneo
			if(!ripetuto) {
				arrayTemporaneo[siRipete] = array[i];
				siRipete++;
			}
		}
		
		//copio gli elementi unici dall'array temporaneo in quello finale
		int[] arrayUnici = new int[siRipete];
		for (int i = 0; i < siRipete; i++) {
			arrayUnici[i] = arrayTemporaneo[i];
		}
		System.out.println("Array originale: " + Arrays.toString(array));
		System.out.println("Array completo: " + Arrays.toString(arrayUnici));
	}
}
