package control;

import java.util.ArrayList;
import java.util.List;

import model.Cambio;

public class RegistroCambio {
	private List<Cambio> listaCambi;

	public RegistroCambio() {
		this.listaCambi = new ArrayList<>();
	}
	
	public void registraCambio(Cambio cambio) {
		if(cambio != null) {
			this.listaCambi.add(cambio);
		}
	}
	
	public List<Cambio> getListaCambi() {
		return this.listaCambi;
	}
	
	public String getStoricoCambi() {
		if(listaCambi.size() != 0) {
		StringBuilder sb = new StringBuilder();
		sb.append("----Storico Cambi----");
		
		for (Cambio cambio : listaCambi) {
			sb.append(cambio.toString()).append("\n");
		}
		sb.append("Totale Cambi: " + listaCambi.size());
		return sb.toString();
		} else {
			return "Non ci sono cambi sulla seguenta cassa";
		}
	}
}
