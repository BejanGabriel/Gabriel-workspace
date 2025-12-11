package utils;

public interface TipoAcqua {
	String FORZA = "Fuoco, Terra";
	String DEBOLEZZA = "Elettro, Erba";
	String MOSSE = "Pistol'acqua, IdroPompa, Mulinello";
	
	default void mostraInfo() {
		System.out.println("Il tipo Acqua è forte contro i tipi: " + FORZA);
		System.out.println("Mentre è debole contro i tipi: " + DEBOLEZZA);
		System.out.println("I tipi Acqua conoscono di base le mosse: " + MOSSE);
	}
}
