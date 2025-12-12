package model;

import utils.Evolvibile;
import utils.TipoErba;

public class Bulbasaur extends Pokemon implements TipoErba, Evolvibile{

	private int livelloEvoluzione = 13;

	public Bulbasaur(String genere, int livello, boolean shiny) {
		super("Bulbasaur", genere, livello, shiny);
		
		// Aggiunta mosse Bulbasaur
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
		return "Ivysaur";
		
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
		return "Bulbasaur [livelloEvoluzione=" + livelloEvoluzione + "]";
	}



	@Override
	public void attacca() {
		System.out.println(this.getNome() + " usa Carica!");
		
	}

}