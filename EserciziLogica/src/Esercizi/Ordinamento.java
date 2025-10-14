package Esercizi;

import java.util.Arrays;

public class Ordinamento {
	// dato il seguente array inverti l'ordine degli elementi
	// [9, 3, 5, 7, 1] -> [1, 7, 5, 3, 9]

	// dato il seguente array ordinalo in modo crescente e decrescente
	// [5, 9, 11, 0, 1, 40]
	//ciao

	public static void main(String[] args) {
		invertiArray();
		crescente();
		decrescente();
		scambioValoriCrescente();
		scambioValoriDecrescente();
	}

	public static void invertiArray() {
		int[] array = { 9, 3, 5, 7, 1 };
		int[] arrayInverso = new int[5];
		for (int i = array.length - 1; i >= 0; i--) {
			arrayInverso[i] = array[array.length - 1 - i];
		}
		System.out.println("array originale: " + Arrays.toString(array));
		System.out.println("array invertito: " + Arrays.toString(arrayInverso));
	}

	public static void crescente() {
		int[] arrayDaOrdinare = { 5, 9, 11, 0, 1, 40 };
		System.out.println("\nArray Originale: " + Arrays.toString(arrayDaOrdinare));
		for (int i = 0; i < arrayDaOrdinare.length - 1; i++) {
			for (int j = i + 1; j < arrayDaOrdinare.length; j++) {
				if (arrayDaOrdinare[i] > arrayDaOrdinare[j]) {
					int temporaneo = arrayDaOrdinare[i];
					arrayDaOrdinare[i] = arrayDaOrdinare[j];
					arrayDaOrdinare[j] = temporaneo;
				}
			}

		}
		System.out.println("Array Crescente: " + Arrays.toString(arrayDaOrdinare));
	}

	public static void decrescente() {
		int[] arrayDaOrdinare = { 5, 9, 11, 0, 1, 40 };
		for (int i = 0; i < arrayDaOrdinare.length - 1; i++) {
			for (int j = i + 1; j < arrayDaOrdinare.length; j++) {
				if (arrayDaOrdinare[i] < arrayDaOrdinare[j]) {
					int temporaneo = arrayDaOrdinare[i];
					arrayDaOrdinare[i] = arrayDaOrdinare[j];
					arrayDaOrdinare[j] = temporaneo;
				}
			}

		}
		System.out.println("Array Decrescente: " + Arrays.toString(arrayDaOrdinare));
	}
	
	public static void scambioValoriCrescente() {
	    int[] array = {5, 9, 6, 10, 7, 11};
	    System.out.println("\nArray Originale = " + Arrays.toString(array));

	    for (int i = 0; i < array.length - 1; i++) { 
	        for (int j = 0; j < array.length - 1 - i; j++) {
	            if (array[j] > array[j + 1]) {
	                int temp = array[j];
	                array[j] = array[j + 1];
	                array[j + 1] = temp;
	            }
	        }
	    }

	    System.out.println("Array Crescente: " + Arrays.toString(array));
	}
	
	public static void scambioValoriDecrescente() {
	    int[] array = {5, 9, 6, 10, 7, 11};
	    System.out.println("\nArray Originale = " + Arrays.toString(array));

	    for (int i = 0; i < array.length - 1; i++) { 
	        for (int j = 0; j < array.length - 1 - i; j++) {
	            if (array[j] < array[j + 1]) {
	                int temp = array[j];
	                array[j] = array[j + 1];
	                array[j + 1] = temp;
	            }
	        }
	    }

	    System.out.println("Array Decrescente: " + Arrays.toString(array));
	}
}
