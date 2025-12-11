package utils;

public interface TipoVolante {
	String FORZA = "Erba";
	String DEBOLEZZA = "Elettro";
	String MOSSE = "Raffica, Volo";
	
	default void mostraInfo() {
		System.out.println("Il tipo Volante è forte contro i tipi: " + FORZA);
		System.out.println("Mentre è debole contro i tipi: " + DEBOLEZZA);
		System.out.println("I tipi Volante conoscono di base le mosse: " + MOSSE);
	}
}
