package model;

import java.util.List;

import utils.Evolvibile;
import utils.TipoElettro;

public class Pikachu extends Pokemon implements TipoElettro, Evolvibile {

	private int livelloEvoluzione = 13;

	public Pikachu(String genere, int livello, int HP, boolean shiny) {
		super("Pikachu", genere, livello, HP, shiny);
		
		// Aggiunta mosse pikachu
			getListaMosse().add(new Mossa("Azione", 5, "normale"));
			getListaMosse().add(new Mossa("Carica", 3, "normale"));
	}

	public int getLivelloEvoluzione() {
		return livelloEvoluzione;
	}



	public void setLivelloEvoluzione(int livelloEvoluzione) {
		this.livelloEvoluzione = livelloEvoluzione;
	}



	@Override
	public boolean puoEvolvere() {
		if (this.getLivello() == livelloEvoluzione) {
			System.out.println(this.getNome() + " può evolvere");
			return true;
		} else {
			System.out.println(getNome() + " non è ancora pronto. Deve raggiungere il livello " + livelloEvoluzione);
			return false;
		}
	}

	@Override
	public String getProssimaEvoluzione() {
		return "Raichu";
	}

	// Il pokemon evolve ed il suo nome cambia con quello della sua evoluzione
	@Override
	public void evolve() {
		System.out.println(this.getNome() + " si stà evolvendo in " + getProssimaEvoluzione());
		this.setNome(getProssimaEvoluzione());
		Mossa nuovaMossa = new Mossa("Fulmine", 9, "elettro");
		this.getListaMosse().add(nuovaMossa);
	}

	public String infoEvoluzione() {
		return "Pikachu si evolverà al lvl: " + livelloEvoluzione;
	}



	@Override
	public void attacca(Pokemon pokemonAttaccato, int mossaScelta) {
		System.out.println("Che mossa vuoi fare a " + this.getNome());
		int contatore = 0;
			String output = "";
			if (this.getListaMosse().size() == 0) {
			 System.out.println(this.getNome() + " non ha nessuna mossa");	
			}
			for (Mossa mossa : getListaMosse()) {
				output += (++contatore) + ") " + mossa + "\n";
			}
			System.out.println(output);
		}
		
	}

