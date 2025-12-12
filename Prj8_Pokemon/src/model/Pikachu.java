package model;

import java.util.ArrayList;
import java.util.List;

import utils.Evolvibile;
import utils.TipoElettro;

public class Pikachu extends Pokemon implements TipoElettro, Evolvibile {

	private int livelloEvoluzione = 13;
	private List<String> mosse;

	public Pikachu(String genere, int livello, boolean shiny, List<String> mosse) {
		super("Pikachu", genere, livello, shiny);
		this.mosse = new ArrayList<>();
	}


	@Override
	public boolean puoEvolvere() {
		if (this.getLivello() == livelloEvoluzione) {
			System.out.println(this.getNome() + " può evolvere");
			return true;
		} else {
			System.out.println(getNome() + " non è ancora pronto.");
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
		String nuovaMossa = "TuonoShock";
		setNome(getProssimaEvoluzione());
		this.mosse.add(nuovaMossa);
	}

	@Override
	public String toString() {
		return "Pikachu [livelloEvoluzione=" + livelloEvoluzione + ", mosse=" + mostraMosse() + ", toString()="
				+ super.toString() + "]";
	}

	public String mostraMosse() {
		
		if(mosse.size() == 0) {
			return this.getNome() + " non ha nessuna mossa";
		}
		for (String mossa : mosse) {
			return mossa;
		}
		return null;
	}


	@Override
	public void attacca() {
		System.out.println(this.getNome() + " usa fulmine!");
		
	}

}
