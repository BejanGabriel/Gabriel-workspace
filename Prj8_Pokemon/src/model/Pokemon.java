package model;


public abstract class Pokemon{
	private String nome;
	private String genere;
	private int livello;
	private boolean shiny;
	
	public Pokemon(String nome, String genere, int livello, boolean shiny) {
		this.nome = nome;
		this.genere = genere;
		this.livello = livello;
		this.shiny = shiny;
	}
	
	public abstract void attacca();
	
	// questi sono metodi da mettere in controller, poiche è lui a occuparsi dei dati.
//	public abstract void imparaUnaMossa();
//	public abstract void dimenticaUnaMossa();
//	public abstract String mostraMosse();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public int getLivello() {
		return livello;
	}

	public void setLivello(int livello) {
		this.livello = livello;
	}

	public boolean isShiny() {
		return shiny;
	}

	public void setShiny(boolean shiny) {
		this.shiny = shiny;
	}

	@Override
	public String toString() {
		return "Pokemon [nome=" + nome + ", genere=" + genere + ", livello=" + livello + ", shiny=" + shiny + "]";
	}
	
	
	
}
