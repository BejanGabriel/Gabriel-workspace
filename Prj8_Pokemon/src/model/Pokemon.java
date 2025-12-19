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
    private List<Mossa> listaMosse;
    private int hp;

    public Pokemon(String nome, String genere, int livello, int hp, boolean shiny) {
        this.nome = nome;
        this.genere = genere;
        this.livello = livello;
        this.hp = hp;
        this.shiny = shiny;
        this.listaMosse = new ArrayList<>();
    }

    public abstract void attacca(Pokemon avversario, int indiceMossa);

    public void imparaMossa(Mossa mossa) {
        if (listaMosse.size() < 4) {
            listaMosse.add(mossa);
        }
    }

    public void dimenticaMossa(Mossa mossa) {
        listaMosse.remove(mossa);
    }

    public String mostraMosse() {
        if (listaMosse.isEmpty()) {
            return nome + " non ha nessuna mossa";
        }
        return listaMosse.stream()
                         .map(Mossa::getNome)
                         .reduce((a, b) -> a + ", " + b)
                         .orElse("");
    }

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

	public List<Mossa> getListaMosse() {
		return listaMosse;
	}

	public void setListaMosse(List<Mossa> listaMosse) {
		this.listaMosse = listaMosse;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String infoPokemon() {
		return "Pokemon [nome=" + nome + ", genere=" + genere + ", livello=" + livello + ", shiny=" + shiny
				+ ", mosse disponibili: " + mostraMosse() + "]";
	}
    
}
