package exeptions;

import java.util.Scanner;

public class Esercizio_7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Perfavore inserisci la tua età:");
		int eta = scan.nextInt();
		
		try {
			System.out.println(verificaEta(eta));
			
		} catch (MieExeptions e) {
			System.out.println(e.getMessage());
		}
		
			
	}
	
	public static String verificaEta(int eta) throws MieExeptions{
		if(eta < 0 || eta > 120) {
			throw new MieExeptions();
		}
		return "Età corretta, puoi proseguire";
	}
}
