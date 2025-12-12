package utils;

public interface TipoElettro {
	String FORZA = "Acqua, Volante";
	String DEBOLEZZA = "Terra";
	String MOSSE = "Fulmine";
	
	default void mostraInfo() {
		System.out.println("Il tipo Elettro è forte contro i tipi: " + FORZA);
		System.out.println("Mentre è debole contro i tipi: " + DEBOLEZZA);
		System.out.println("I tipi Elettro conoscono di base le mosse: " + MOSSE);
	}
}
