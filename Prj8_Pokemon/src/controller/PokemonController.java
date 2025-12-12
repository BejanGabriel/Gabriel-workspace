package controller;

import factory.PokemonFactory;
import model.Pokemon;

public class PokemonController {

	public void lvlUp(Pokemon pokemon, int livelli) {
		pokemon.setLivello(pokemon.getLivello()+livelli);
	}

	public Pokemon creaPokemon(String specie, String genere, int livello, String shiny) {
		
		boolean eShiny = false;
		
		if(shiny.toLowerCase().equals("si")) {
			eShiny = true;
		}
		
		try {
			return PokemonFactory.create(specie, genere, livello, eShiny);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
