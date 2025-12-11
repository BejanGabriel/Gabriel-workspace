package controller;

import model.Bulbasaur;
import model.Charmender;
import model.Pikachu;
import model.Pokemon;

public class PokemonController {

	public int lvlUp(Pokemon pokemon, int livelli) {
		return pokemon.getLivello() + livelli;
	}

	public Pokemon creaPokemon(String specie) {

		specie.toLowerCase();

		switch (specie) {

		case "pikachu":
			return new Pikachu(specie, specie, specie, specie, 0, 0, false, 0, 0);
			break;
			
		case "charmender":
			return new Charmender(specie, specie, specie, specie, 0, 0, false, 0);
			break;
			
		case "bulbasaur":
			return new Bulbasaur(specie, specie, specie, specie, 0, 0, false, 0);
			break;

		}

	}
}
