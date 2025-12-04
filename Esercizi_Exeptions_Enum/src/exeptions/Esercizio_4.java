package exeptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Esercizio_4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Inserisci il nome del file da aprire: ");
		String nomeFile = scan.nextLine();
		try {
		System.out.println(leggiFile(nomeFile));
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String leggiFile(String nomeFile) throws FileNotFoundException {
		File file = new File(nomeFile);
		if (!file.exists()) {
			throw new FileNotFoundException("Non è stato trovato alcun file con questo nome: " + nomeFile);
		}
		return "Apertura file in corso...";
	}
}
