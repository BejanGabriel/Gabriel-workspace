package Esercizi;

import java.util.Arrays;

public class Es10_Array_Palindromo {
	/*
	 * Dato un array [1, 2, 3, 2, 1] dire se è palindromo: ossia che è uguale anche
	 * se letto al contrario. in questo caso il risultato deve essere TRUE
	 */
	// modifica opzionale, se l'array ha una lunghezza pari, allora aggiungi un
	// numero in centro identico a quello prima.
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 3, 2, 1 };
		int[] arrayContrario = new int[array.length];
		boolean palindromo = true;
		for(int i = 0; i < array.length; i++) {
			arrayContrario[i] = array[array.length-1-i];
		}
		for (int i = 0; i < array.length / 2; i++) {
			if (array[i] != array[array.length - 1 - i]) {
				System.out.println("Oops, il tuo array non è palindromo, i numeri diversi sono:" + "\n A sinistra: "
						+ array[i] + " e a destra " + array[array.length - 1 - i]);
				System.out.println("Array originale: " + Arrays.toString(array));
				System.out.println("Array Contrario: " + Arrays.toString(arrayContrario));
				palindromo = false;
				break;
			} 
		}
		
		if (palindromo == true) {
			System.out.println("Il tuo array è palindromo.");
			System.out.println("Array originale: " + Arrays.toString(array));
			System.out.println("Array Contrario: " + Arrays.toString(arrayContrario));
		}
	}
}
