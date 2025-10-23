package control;

import java.util.ArrayList;
import java.util.List;

import model.Cambio;

public class RegistroCambio {
	List<Cambio> listaCambi;

	public RegistroCambio() {
		this.listaCambi = new ArrayList<>();
	}
	
	public void registraCambio(Cambio cambio) {
		this.listaCambi.add(cambio);
	}
	
	public List<Cambio> mostraListaCambi() {
		return new ArrayList<Cambio>(listaCambi);
	}

	@Override
	public String toString() {
		return "RegistroCambio [listaCambi=" + listaCambi + "]";
	}
	
	
	
}
