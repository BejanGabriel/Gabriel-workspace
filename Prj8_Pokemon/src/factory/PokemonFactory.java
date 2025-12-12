package factory;

import model.Pikachu;
import model.Pokemon;
import model.Bulbasaur;
import model.Charmender;

public class PokemonFactory {

	
	public static Pokemon create(String specie, String genere, int livello, boolean shiny) {
		
		if(specie == null) {
			throw new IllegalArgumentException();
		}
		
		switch(specie.toLowerCase()) {
		
		case "pikachu":
			return new Pikachu(genere, livello, shiny);
		case "charmender":
			return new Charmender(genere, livello, shiny);
		case "bulbasaur":
			return new Bulbasaur(genere, livello, shiny);
		default:
			return null;
		}
	}
}
