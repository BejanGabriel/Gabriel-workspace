package model;

import java.util.ArrayList;
import java.util.List;

import utils.TipoElettro;

public class Pikachu extends Pokemon implements TipoElettro{
	
	private int livelloEvoluzione;
	private List<String> mosse;

	public Pikachu(String nome, String genere, String mosseConosciute, String colore,
			double altezza, double peso, boolean shiny, int livello, int livelloEvoluzione) {
		super("Pikachu", genere, mosseConosciute, colore, altezza, peso, shiny, livello);
		this.livelloEvoluzione = livelloEvoluzione;
		this.mosse = new ArrayList<>();
	}

	@Override
	public boolean puoEvolvere() {
		if(getLivello() == livelloEvoluzione) {
			System.out.println(getNome() + " può evolvere");
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

	@Override
	public void evolve() {
		System.out.println(getNome() + " si stà evolvendo in " + getProssimaEvoluzione());
		String nuovaMossa = "TuonoShock";
		setNome(getProssimaEvoluzione());
		this.mosse.add(nuovaMossa);
	}

	@Override
	public String toString() {
		return "Pikachu [livelloEvoluzione=" + livelloEvoluzione + ", mosse=" + mosse + ", toString()="
				+  super.toString() + "]";
	}
	
	public void mostraMosse() {
		for (String mossa : mosse) {
			System.out.println(mossa);
		}
	}
	
	
	
	


}
