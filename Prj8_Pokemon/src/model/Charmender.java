package model;

import utils.Evolvibile;
import utils.TipoFuoco;

public class Charmender extends Pokemon implements TipoFuoco, Evolvibile{

	private int livelloEvoluzione = 13;

	public Charmender(String genere, int livello, int HP, boolean shiny) {
		super("Charmender", genere, livello, HP, shiny);
		
		// Aggiunta mosse Charmender
		getMosse().put(5, "Azione");
		getMosse().put(3, "Carica");
		
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
		this.getMosse().put(9, nuovaMossa);
	}

	public String infoEvoluzione() {
		return "Charmender [livelloEvoluzione=" + livelloEvoluzione + "]";
	}

	@Override
	public void attacca(Pokemon pokemon, int sceltaMossa) {
		// TODO Auto-generated method stub
		
	}

}