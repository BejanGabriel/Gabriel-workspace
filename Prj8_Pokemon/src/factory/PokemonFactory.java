package factory;

import model.Pikachu;
import model.Bulbasaur;
import model.Charmender;

public class PokemonFactory {

	public PokemonFactory create(String specie, String genere, int livello, boolean shiny) {
		
		if(specie == null) {
			throw new IllegalArgumentException();
		}
		
		switch(specie.toLowerCase()) {
		
		case "pikachu":
			return new Pikachu(genere, livello, genere, livello, shiny)
		}
	}
}
