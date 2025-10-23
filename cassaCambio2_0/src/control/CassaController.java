package control;

import java.util.List;

import model.Cambio;
import model.Cassa;
import model.Prelievo;

public class CassaController {
	private Cassa cassa;
	private RegistroCambio registro;
	private RegistroPrelievo registroPrelievo;

	public CassaController(String nome, double fondoDollari) {
		this.cassa = new Cassa(nome, fondoDollari);
		this.registro = new RegistroCambio();
		this.registroPrelievo = new RegistroPrelievo();
	}

	public boolean aggiungiDollari(double importoDollari) {
		return cassa.aggiungiDollari(importoDollari);
	}

	public String eseguiCambio(double importoEuro) {
		if (importoEuro <= 0) {
			return "Errore: l'importo deve essere positivo";
		}
		// verifico se c'è disponibilità
		if (!cassa.verificaDispo(importoEuro)) {
			return "Mi dispiace, fondi insuficienti per il cambio";
		}
		Cambio cambio = cassa.eseguiCambio(importoEuro);
		if (cambio != null) {
			registro.registraCambio(cambio);
			return "Cambio Eseguito. Importo dollari " + cambio.getImportoUsd() 
			+ "\nImporto Euro versato "+ cambio.getImportoEur();
		}
		return "Non è stato possibile eseguire il cambio";

	}

	// AGGIUNTA GABRIEL
	public String eseguiPrelievo(double importoEuro) {
		if (importoEuro <= 0) {
			return "Errore: l'importo deve essere positivo";
		}
		if (!cassa.verificaDispoEuro(importoEuro)) {
			return "Mi dispiace, fondi insuficienti per il cambio";
		}
		Prelievo prelievo = cassa.eseguiPrelievo(importoEuro);
		if (prelievo != null) {
			registroPrelievo.registraPrelievo(prelievo);
			return "Prelievo eseguito. Euro prelevati " + prelievo.getImportoEuro() + " € \nEuro restanti " + cassa.getSaldoEur() + " €";
		}
		return "Non è stato possibile eseguire il prelievo";
	}

	public String getInfoCassa() {
		return cassa.getInfoCassa();
	}

	public String getStoricoCambi() {
		return registro.getStoricoCambi();
	}
	
	public String getStoricoPrelievi() {
		return registroPrelievo.getStoricoPrelievi();
	}

	public String getStoricoCambi2() {
		List<Cambio> listaCambi = registro.getListaCambi();
		StringBuilder sb = new StringBuilder();
		for (Cambio cambio : listaCambi) {
			sb.append(cambio.toString() + "\n");
		}
		return sb.toString();
	}
	public String getStoricoPrelievi2() {
		List<Prelievo> listaPrelievi = registroPrelievo.getListaPrelievi();
		StringBuilder sb = new StringBuilder();
		for (Prelievo prelievo : listaPrelievi) {
			sb.append(prelievo.toString() + "\n");
		}
		return sb.toString();
	}

}
