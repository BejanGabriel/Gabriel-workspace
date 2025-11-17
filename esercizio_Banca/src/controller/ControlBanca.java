package controller;

import java.util.ArrayList;
import java.util.List;

import model.Conto;
import model.Correntista;

public class ControlBanca {
		private Correntista correntista;
		private Conto conto;
		private List<Correntista> correntisti;
		private List<Conto> conti;
		
		public ControlBanca(String nome, String cognome) {
			this.correntisti = new ArrayList<>();
			this.conti = new ArrayList<>();
		}
		
		public String getinfoCorrentista() {
			return correntista.getInfoCorrentista();
		}
		
		public void nuovoConto(Conto conto) {
			conti.add(conto);
			conto.getCorrentista().aggiungiConto(conto);
		}
		
//		public String getInfoConto(int numConto) {
//			
//		}
		
		
	}
