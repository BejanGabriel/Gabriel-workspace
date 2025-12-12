package view;

import java.util.Scanner;

import controller.PokemonController;
import model.Pikachu;
import model.Pokemon;

public class Tester {

	private static PokemonController pokeCtrl = new PokemonController();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		boolean flag = true;
		Pokemon pikachu = pokeCtrl.creaPokemon("pikachu","F",5,"no");
		Pokemon charmender = pokeCtrl.creaPokemon("charmender","M",1,"si");
		Pokemon bulbasaur = pokeCtrl.creaPokemon("bulbasaur","F",9,"no");
		Pokemon charmenderJR = pokeCtrl.creaPokemon("charmender","F",23,"no");
		Pokemon pikachuJR = pokeCtrl.creaPokemon("pikachu","M",10000,"si");

		do {
			mostraMenu();

			int scelta = scan.nextInt();

			switch (scelta) {
			case 1:
				creaPokemon();
				break;
			case 2:
				mostraMossePokemon();
				break;
			case 3:
				LevelUp();
				break;
			case 4:
				evoluzionePokemon();
				break;
			case 5:
				aggiungiRimuoviMosse();
				break;
			case 6:
				infoPokemon();
				break;
			case 0:
				flag = false;
				break;

			default:
				throw new IllegalArgumentException("Non ho capito il comando:" + scelta);
			}

		} while (flag);

	}

	private static void mostraMenu() {
		System.out.println("\n==== Benvenuto nel Pokedex ====");
		System.out.println("1. Crea Pokemon");
		System.out.println("2. Visualizza le mosse di un pokemon");
		System.out.println("3. Fai salire di livello un pokemon");
		System.out.println("4. Mostra evoluzione di un pokemon");
		System.out.println("5. Gestisci mosse  di un pokemon");
		System.out.println("6. Mostra info pokemon");
		System.out.println("0. Esci");

	}

	private static void creaPokemon() {

		System.out.println("Quale pokemon vuoi creare?");
		String nomePokemon = scan.next();
		System.out.println("Il pokemon è 'M' o 'F' ?");
		String genere = scan.next();
		System.out.println("Che livello avrà il pokemon?");
		int livello = scan.nextInt();
		System.out.println("Il pokemon è shiny?");
		String shiny = scan.next();

		Pokemon pikachu = pokeCtrl.creaPokemon(nomePokemon, genere, livello, shiny);

	}

	private static void infoPokemon() {
		pokeCtrl.mostraPokemon();
		System.out.println("Di quale pokemon vuoi sapere le informazioni?");
		int pokemon = scan.nextInt();
		Pokemon pokemonSelezionato = pokeCtrl.pokemonSelezionato(pokemon);
		System.out.println(pokemonSelezionato.infoPokemon());
	}

	private static void aggiungiRimuoviMosse() {
		pokeCtrl.mostraPokemon();
		System.out.println("A chi vuoi far imparare / dimenticare una mossa?");
		int pokemon = scan.nextInt();
		Pokemon pokemonSelezionato = pokeCtrl.pokemonSelezionato(pokemon);
		System.out.println("Hai selezionato: " + pokemonSelezionato.getNome() + "\nLe sue mosse sono: " + pokemonSelezionato.getMosse() );
		System.out.println("1. Aggiungi mossa");
		System.out.println("2. Rimuovi una mossa");
		int selettore = scan.nextInt();
		if(selettore == 1) {
			System.out.println("Quale mossa vuoi che " + pokemonSelezionato.getNome() + " impari?");
			String nomeMossa = scan.next();
			pokeCtrl.addMossa(pokemonSelezionato, nomeMossa);      
		}
		

	}

	private static void evoluzionePokemon() {
		System.out.println("Di chi vuoi sapre le info in base all'evoluzione");
		int pokemon = scan.nextInt();
		Pokemon pokemonSelezionato = pokeCtrl.pokemonSelezionato(pokemon);

	}

	private static void LevelUp() {
		// TODO Auto-generated method stub

	}

	private static void mostraMossePokemon() {
		// TODO Auto-generated method stub

	}

}
