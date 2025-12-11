package model;

import utils.Evolvibile;

public abstract class Pokemon implements Evolvibile{
	private String nome;
	private String genere;
	private String mosseConosciute;
	private String colore;
	private double altezza;
	private double peso;
	private boolean shiny;
	private int livello;
	
	


	public Pokemon(String nome, String genere, String mosseConosciute, String colore,
			double altezza, double peso, boolean shiny, int livello) {
		super();
		this.nome = nome;
		this.genere = genere;
		this.mosseConosciute = mosseConosciute;
		this.colore = colore;
		this.altezza = altezza;
		this.peso = peso;
		this.shiny = shiny;
		this.livello = livello;
	}

	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public void setGenere(String genere) {
		this.genere = genere;
	}



	public void setMosseConosciute(String mosseConosciute) {
		this.mosseConosciute = mosseConosciute;
	}



	public void setColore(String colore) {
		this.colore = colore;
	}



	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}



	public void setShiny(boolean shiny) {
		this.shiny = shiny;
	}



	public void setLivello(int livello) {
		this.livello = livello;
	}



	public String getGenere() {
		return genere;
	}



	public String getMosseConosciute() {
		return mosseConosciute;
	}



	public String getColore() {
		return colore;
	}



	public double getAltezza() {
		return altezza;
	}



	public double getPeso() {
		return peso;
	}



	public boolean isShiny() {
		return shiny;
	}



	public int getLivello() {
		return livello;
	}



	public void infoPokemon() {
		System.out.println("Nome: " + nome + ", genere: " + genere + ", colore: "+ colore + ", altezza: "+ altezza + 
				", peso: " + peso + ", mosse: " + mosseConosciute + ", shiny: " + shiny + ", livello: " + livello );
	}
	
	
}
