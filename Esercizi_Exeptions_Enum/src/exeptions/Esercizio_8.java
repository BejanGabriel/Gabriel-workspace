package exeptions;

public class Esercizio_8 {
	
	
	public static String primoMetodo() throws Exception {
		return "'primoMetodo()' sta richiamando 'secondoMetodo' \n" + secondoMetodo();
	}
	public static String secondoMetodo() throws Exception {
		return "'secondoMetodo()' sta richiamando 'terzoMetodo()'\n " + terzoMetodo();
	}
	public static String terzoMetodo() throws Exception {
		throw new Exception("Sono il cattivo 'terzoMetodo()' e ti sto lanciando una: ");
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(primoMetodo());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
