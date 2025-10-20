package Esercizi;

import java.util.Arrays;

public class Es9_Sposta_0 {
	/*
	 * Esercizio 9: Sposta zeri alla fine Dato l'array [0, 3, 0, 5, 8, 0, 2], sposta
	 * tutti gli zeri alla fine mantenendo l'ordine degli altri elementi. Risultato
	 * atteso: [3, 5, 8, 2, 0, 0, 0]
	 */
	public static void main(String[] args) {
		int[] array = { 0, 3, 0, 5, 8, 0, 2 };
		int pos = 0;
		/*
		 * La logica deve avere un indice che indica sempre la prossima posizione libera per un array != 0
		 */
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {

				int temp = array[pos];
				array[pos] = array[i];
				array[i] = temp;
				pos++;

			}
		}
		System.out.println("Array originale: " + Arrays.toString(array));


	}
}
