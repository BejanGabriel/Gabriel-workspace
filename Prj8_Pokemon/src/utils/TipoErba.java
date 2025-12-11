package utils;

public interface TipoErba {
	String FORZA = "Acqua, Terra";
	String DEBOLEZZA = "Fuoco, Volante";
	String MOSSE = "Semi, Fioritura";
	
	default void mostraInfo() {
		System.out.println("Il tipo Volante è forte contro i tipi: " + FORZA);
		System.out.println("Mentre è debole contro i tipi: " + DEBOLEZZA);
		System.out.println("I tipi Volante conoscono di base le mosse: " + MOSSE);
	}
}
