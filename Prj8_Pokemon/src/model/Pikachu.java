package model;

import java.util.List;

import utils.Evolvibile;
import utils.TipoElettro;

public class Pikachu extends Pokemon implements TipoElettro, Evolvibile {

	private int livelloEvoluzione = 13;

	public Pikachu(String genere, int livello, boolean shiny) {
		super("Pikachu", genere, livello, shiny);
		
		// Aggiunta mosse pikachu
		getMosse().add("Azione");
		getMosse().add("Carica");
		
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
		String nuovaMossa = "TuonoShock";
		setNome(getProssimaEvoluzione());
		this.getMosse().add(nuovaMossa);
	}

	public String infoEvoluzione() {
		return "Pikachu [livelloEvoluzione=" + livelloEvoluzione + "]";
	}



	@Override
	public void attacca() {
		System.out.println(this.getNome() + " usa fulmine!");
		
	}

}
