package view;

import java.util.Scanner;

import controller.PokemonController;
import model.Pikachu;
import model.Pokemon;

public class Tester{

	private static PokemonController pokeCtrl = new PokemonController();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Quale pokemon vuoi creare?");
		String nomePokemon = scan.next();
		System.out.println("Il pokemon è 'M' o 'F' ?");
		String genere = scan.next();
		System.out.println("Che livello avrà il pokemon?");
		int livello = scan.nextInt();
		System.out.println("Il pokemon è shiny?");
		String shiny = scan.next();
		
		
		Pokemon pikachu = pokeCtrl.creaPokemon(nomePokemon, genere, livello, shiny);
		
		System.out.println(pikachu.infoPokemon());
		
}

}
