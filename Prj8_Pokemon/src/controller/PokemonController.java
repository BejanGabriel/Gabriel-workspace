package controller;

import java.util.ArrayList;
import java.util.List;

import factory.PokemonFactory;
import model.Pokemon;

public class PokemonController {

	private static List<Pokemon> listaPokemon = new ArrayList<Pokemon>();

	public void lvlUp(Pokemon pokemon, int livelli) {
		pokemon.setLivello(pokemon.getLivello() + livelli);
	}

	public Pokemon creaPokemon(String specie, String genere, int livello, String shiny) {

		boolean eShiny = false;

		if (shiny.toLowerCase().equals("si")) {
			eShiny = true;
		}

		try {
			Pokemon pokemonCreato = PokemonFactory.create(specie, genere, livello, eShiny);
			listaPokemon.add(pokemonCreato);
			return pokemonCreato;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void mostraMosse(String nomePokemon) {
		for (Pokemon pokemon : listaPokemon) {
			if (pokemon.getNome().equalsIgnoreCase(nomePokemon)) {
				if (pokemon.getMosse().size() == 0) {
					System.out.println(pokemon.getNome() + " non ha nessuna mossa");
					
				}
				System.out.println("==== Mosse Disponibili");
				for (String mossa : pokemon.getMosse()) {
					System.out.println(mossa);
				}
				System.out.println("======================");
			}
		}
	}
	public void addMossa(Pokemon pokemon, String nomeMossa) {
		pokemon.getMosse().add(nomeMossa);
	}
	
	public void mostraPokemon() {
		int contatore = 0;
		if(listaPokemon.size() == 0) {
			return;
		}
		for (Pokemon pokemon : listaPokemon) {
			System.out.println((++contatore) + ") " + pokemon.getNome() + " lvl: " +pokemon.getLivello());
		}
	}
	public Pokemon pokemonSelezionato(int selettore) {
		int contatore = 0;
		if(listaPokemon.size() == 0) {
			System.out.println("Non ci sono pokemon presenti");
			return null;
		}
		for (Pokemon pokemon : listaPokemon) {
			System.out.println((++contatore) + ") " + pokemon.getNome() + " lvl: " +pokemon.getLivello());
			if(contatore == selettore) {
				return pokemon;
			}
		}
		return null;
	}

}
