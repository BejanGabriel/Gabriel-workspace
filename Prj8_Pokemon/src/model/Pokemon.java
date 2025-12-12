package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Pokemon {
	private String nome;
	private String genere;
	private int livello;
	private boolean shiny;
	// danni , nomeMossa
	private Map<Integer, String> mosse = new HashMap<>();
	private int HP;

	public Pokemon(String nome, String genere, int livello, int HP, boolean shiny) {
		this.nome = nome;
		this.genere = genere;
		this.livello = livello;
		this.HP = HP;
		this.shiny = shiny;
	}

	public abstract void attacca(Pokemon pokemon, int sceltaMossa);

	// questi sono metodi da mettere in controller, poiche è lui a occuparsi dei
	// dati.
	// public abstract void imparaUnaMossa();
	// public abstract void dimenticaUnaMossa();
	// public abstract String mostraMosse();

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
		return "Pokemon [nome=" + nome + ", genere=" + genere + ", livello=" + livello + ", shiny=" + shiny
				+ ", mosse disponibili: " + mostraMosse() + "]";
	}

	public Map<Integer, String> getMosse() {
		return mosse;
	}

	public void setMosse(Map<Integer, String> mosse) {
		this.mosse = mosse;
	}

	public String mostraMosse() {
		String output = "";
		if (this.getMosse().size() == 0) {
			return this.getNome() + " non ha nessuna mossa";
		}
		for (String mossa : mosse.values()) {
			output += mossa + ", ";
		}
		return output;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

}
