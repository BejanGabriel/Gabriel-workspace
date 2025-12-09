package gestioneRistorante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ordine {
	
	private List<Piatto> listaPiatti = new ArrayList<>();
	
	public void aggiungiPiatto(Piatto piatto) {
		listaPiatti.add(piatto);
	}
	
	public double calcolaTotale() {
		double totale = 0;
		
		for (Piatto piatto : listaPiatti) {
			totale += piatto.getPrezzo();
		}

		return totale;
	}
	
	public Map<CategoriaPiatto, Integer> contaPiattiPerCategoria() {
		
		Map<CategoriaPiatto, Integer> mappa = new HashMap<>();
		for (Piatto piatto : listaPiatti) {
			CategoriaPiatto categoria = piatto.getCategoria();
			mappa.put(categoria, mappa.getOrDefault(categoria, 0) + 1 );
		}
		
		return mappa;
	}
	
	public boolean isVegetariano() {
		
		for (Piatto piatto : listaPiatti) {
			if(!piatto.isVegetariano()) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public void stampaOrdine() {
		
		System.out.println("==== Ordine ====");
		for (Piatto piatto : listaPiatti) {
			System.out.println("- " + piatto.getNome() + "(" + piatto.getCategoria() + "): €" + piatto.getPrezzo());
		}
		System.out.println("Totale: €" + calcolaTotale());
		
		System.out.println("Piatti per categoria: " + contaPiattiPerCategoria());

		if(isVegetariano()) {
			System.out.println("Vegetariano: si");
		}else {
			System.out.println("Vegetariano: no");
		}
		System.out.println("================");
		
	}
}
