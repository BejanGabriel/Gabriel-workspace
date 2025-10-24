package model;

public class Conto {
	private static int contatore = 0;
	private int id;
	private String nomeBanca;
	private String filiale;
	private double saldo = 0;
	
	public Conto(String nomeBanca, String filiale, double saldo) {
		this.nomeBanca = nomeBanca;
		this.filiale = filiale;
		this.saldo = saldo;
	}
	
	
}
