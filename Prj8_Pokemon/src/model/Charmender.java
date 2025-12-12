package model;

import utils.Evolvibile;
import utils.TipoFuoco;

public class Charmender extends Pokemon implements TipoFuoco, Evolvibile{

	private int livelloEvoluzione = 13;

	public Charmender(String genere, int livello, boolean shiny) {
		super("Charmender", genere, livello, shiny);
		
		// Aggiunta mosse Charmender
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
		return "Charmeleon";
	}

	// Il pokemon evolve ed il suo nome cambia con quello della sua evoluzione
	@Override
	public void evolve() {
		System.out.println(this.getNome() + " si stà evolvendo in " + getProssimaEvoluzione());
		this.setNome(getProssimaEvoluzione());
		String nuovaMossa = "Scintilla";
		setNome(getProssimaEvoluzione());
		this.getMosse().add(nuovaMossa);
	}

	public String infoEvoluzione() {
		return "Charmender [livelloEvoluzione=" + livelloEvoluzione + "]";
	}



	@Override
	public void attacca() {
		System.out.println(this.getNome() + " usa azione!");
		
	}

}