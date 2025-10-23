package control;

import java.util.ArrayList;
import java.util.List;

import model.Prelievo;

public class RegistroPrelievo {
	private List<Prelievo> listaPrelievi; //AGGIUNTA GABRIEL

	//AGGIUNTA GABRIEL
		public RegistroPrelievo() {
			this.listaPrelievi = new ArrayList<>();
		}
		
		public void registraPrelievo(Prelievo prelievo) {
			if(prelievo != null) {
				this.listaPrelievi.add(prelievo);
			}
		}

		public List<Prelievo> getListaPrelievi() {
			return listaPrelievi;
		}
		
		public String getStoricoPrelievi() {
			if(listaPrelievi.size() != 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("----Storico Prelievi----\n");
			
			for (Prelievo prelievo : listaPrelievi) {
				sb.append(prelievo.toString()).append("\n");
			}
			sb.append("Totale prelievi: " + listaPrelievi.size());
			return sb.toString();
			} else {
				return "Non ci sono prelievi sulla seguenta cassa";
			}
		}
}
