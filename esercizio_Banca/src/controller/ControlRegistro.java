package controller;

import java.util.ArrayList;
import java.util.List;

import model.Conto;

public class ControlRegistro {
	private List<Conto> conti;
	
	public ControlRegistro() {
		this.conti = new ArrayList<>();
	}
	
	public void aggiungiConto(Conto conto) {
		conti.add(conto);
	}
	
	public void rimuovoConto(Conto conto) {
		conti.remove(conto);
	}
	
	public void listaConti() {
		if(conti.size() != 0) {
		for (Conto conto : conti) {
			System.out.println(conto + "\n");
		}
		}else {
			System.out.println("Nessun conto trovato.");
		}
	}
}

