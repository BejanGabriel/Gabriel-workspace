package Esercizi;

import java.util.Arrays;

public class Es11_Selection_Sort {
	public static void main(String[] args) {
		int[] array = {64,25,12,22,11};
		
		for(int i = 0; i < array.length; i++) {
			int indice = i;
			int min = array[i];
			for(int j = i+1; j < array.length; j++) {
				if(array[j] < min) {
					min = array[j];
					indice = j;
				}
			}
			int temp = array[i];
			array[i] = array[indice];
			array[indice] = temp;
		}
		System.out.println("Array Ordinato: " + Arrays.toString(array));
	}
}
