package model;

public class Correntista {
	private static int contatore = 0;
	private int id;
	private String nome;
	private String cognome;
	private String codFiscale;
	
	public Correntista(String nome, String cognome, String codFiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.codFiscale = codFiscale;
		this.id = contatore++;
	}
	
	
}
