package factory;

import model.Pikachu;
import model.Pokemon;
import model.Bulbasaur;
import model.Charmender;

public class PokemonFactory {

	
	public static Pokemon create(String specie, String genere, int livello, int hp, boolean shiny) {
		
		if(specie == null) {
			throw new IllegalArgumentException();
		}
		
		switch(specie.toLowerCase()) {
		
		case "pikachu":
			return new Pikachu(genere, livello, hp, shiny);
		case "charmender":
			return new Charmender(genere, livello, hp, shiny);
		case "bulbasaur":
			return new Bulbasaur(genere, livello, hp, shiny);
		default:
			return null;
		}
	}
}
