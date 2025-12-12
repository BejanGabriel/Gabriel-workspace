package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon{
	private String nome;
	private String genere;
	private int livello;
	private boolean shiny;
	private List<String> mosse = new ArrayList<>();


	
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

	public String infoPokemon() {
		return "Pokemon [nome=" + nome + ", genere=" + genere + ", livello=" + livello +
				", shiny=" + shiny + ", mosse disponibili: " + mostraMosse()+"]";
	}

	public List<String> getMosse() {
		return mosse;
	}

	public void setMosse(List<String> mosse) {
		this.mosse = mosse;
	}
	
	public String mostraMosse() {
		String output = "";
		if(this.getMosse().size() == 0) {
			return this.getNome() + " non ha nessuna mossa";
		}
		for (String mossa : this.getMosse()) {
			output += "\n"+mossa;
		}
		return output;
	}


	
	
	
}
