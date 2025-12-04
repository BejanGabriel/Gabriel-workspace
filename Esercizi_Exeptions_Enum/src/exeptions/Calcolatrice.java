package exeptions;

public class Calcolatrice {

	public static double dividi(int a, int b) {
		if(b == 0) {
			throw new ArithmeticException("Attenzione, stai provando a dividere per 0.");
		}

		double risultato = a / b;
		return risultato;
	}
}
