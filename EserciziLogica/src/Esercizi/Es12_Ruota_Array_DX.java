package Esercizi;

import java.util.Arrays;

public class Es12_Ruota_Array_DX {
	//Dato l'array [1,2,3,4,5] ruota ogni elemento di 2 posizioni a destra.
	//risultato: [4,5,1,2,3]
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,7};
		int[] arrayRuotato = new int[array.length];
		int indice = 2;
		for(int i = 0; i < array.length; i++) {
			if(indice >= array.length) {
				indice -= array.length;
			}
			arrayRuotato[indice] = array[i];
			indice ++;
			
		}
		System.out.println("Array ruotato: " + Arrays.toString(arrayRuotato));
	}
}
