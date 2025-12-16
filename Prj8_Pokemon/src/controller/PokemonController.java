package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import factory.PokemonFactory;
import model.Pokemon;

public class PokemonController {

	private static Scanner scan = new Scanner(System.in);
	private static int nextID = 1;
	private static List<Pokemon> listaPokemon = new ArrayList<Pokemon>();
	private static Map<Integer, Pokemon> pokemons = new HashMap<>();

	public void lvlUp(Pokemon pokemon, int livelli) {
		pokemon.setLivello(pokemon.getLivello() + livelli);
	}

	public Pokemon creaPokemon(String specie, String genere, int livello, int hp, String shiny) {

		boolean eShiny = false;

		if (shiny.toLowerCase().equals("si")) {
			eShiny = true;
		}

		try {
			Pokemon pokemonCreato = PokemonFactory.create(specie, genere, livello, hp, eShiny);
			listaPokemon.add(pokemonCreato);
			pokemons.put(nextID++, pokemonCreato);
			return pokemonCreato;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public String mostraMosse(int idPokemon) {

		Pokemon pokemon = pokemons.get(idPokemon);
		if (pokemon == null)
			return "ID non valido.";

		if (pokemon.getMosse().isEmpty()) {
			return pokemon.getNome() + " non ha nessuna mossa";
		}

		StringBuilder sb = new StringBuilder();
		for (var entry : pokemon.getMosse().entrySet()) {
			sb.append("[").append(entry.getKey()).append(" dmg] ").append(entry.getValue()).append("\n");
		}
		return sb.toString();
	}

	public void addMossa(Pokemon pokemon, String nomeMossa, int dannoMossa) {
		pokemon.getMosse().put(dannoMossa, nomeMossa);
	}

	public void mostraPokemonMappa() {
		int contatore = 0;
		if (pokemons.size() == 0) {
			System.out.println("Nessun pokemon presente");
		}
		for (Pokemon pokemon : pokemons.values()) {
			System.out.println((++contatore) + ") " + pokemon.getNome() + " lvl: " + pokemon.getLivello());
		}
	}

	public Pokemon pokemonSelezionato(String messaggio) {
		
		mostraPokemonMappa();
		System.out.println(messaggio);
		int selettore = scan.nextInt();
		
		int contatore = 0;
		
		if (listaPokemon.size() == 0) {
			System.out.println("Non ci sono pokemon presenti");
			return null;
		}
//		for (Pokemon pokemon : listaPokemon) {
//			System.out.println((++contatore) + ") " + pokemon.getNome() + " lvl: " + pokemon.getLivello());
			if (pokemons.containsKey(selettore)) {
				return pokemons.get(selettore);
			}
//		}
		return null;
	}

}
