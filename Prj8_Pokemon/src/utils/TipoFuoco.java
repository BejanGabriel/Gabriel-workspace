package utils;

public interface TipoFuoco {
	String FORZA = "Erba";
	String DEBOLEZZA = "Acqua, Terra";
	String MOSSE = "Lanciafiamme, Fiammata, Fuoco Pugno";
	
	default void mostraInfo() {
		System.out.println("Il tipo Fuoco è forte contro i tipi: " + FORZA);
		System.out.println("Mentre è debole contro i tipi: " + DEBOLEZZA);
		System.out.println("I tipi Fuoco conoscono di base le mosse: " + MOSSE);
	}
}
