package exeptions;

public class Esercizio_3 {
	public static void main(String[] args) {
		try {
		int x = 4;
		int y = 0;
		
		
			
		System.out.println(Calcolatrice.dividi(x, y));
		}catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}
}
