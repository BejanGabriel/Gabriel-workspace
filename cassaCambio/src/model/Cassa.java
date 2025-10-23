package model;

import control.RegistroCambio;

public class Cassa {
	public String nome;
	double fondoIniziale = 0.0;
	double saldoEUR;
	RegistroCambio registro;


	public Cassa(String nome, double fondoIniziale, RegistroCambio registro) {
		this.nome = nome;
		this.fondoIniziale = fondoIniziale;
		this.registro = registro;
	}

	public void aggiungiFondi(double fondoDollari) {
		if (fondoDollari > 0) {
			this.fondoIniziale += fondoDollari;
			System.out.println("Hai correttamente aggiunto " + fondoDollari + " $");
		}else {
			System.out.println("Importo inserito non valido, riprova");
		}
	}
	
	public void eseguiCambio(double importoEUR) {
		double tassoCambio = 0.85;
		double cambioEUR_USD = importoEUR / tassoCambio;
		if(cambioEUR_USD < fondoIniziale) {
			this.fondoIniziale -= cambioEUR_USD;
			this.saldoEUR += importoEUR;
			
			//appena effettuo il cambio, lo registro immediatamente nel registro
			Cambio cambio = new Cambio(importoEUR);
		    registro.registraCambio(cambio);
		    
			System.out.println("Saldo USD: " + cambioEUR_USD + " $"
					+"\nSaldo EUR: " + importoEUR
					+"\nTasso di cambio: " + tassoCambio);
		}else {
			System.out.println("Fondi non sufficienti, riprovare più tardi.");
		}
	}

	public double[] fondi() {
		double[] fondi = new double[2];
		fondi[0] = this.fondoIniziale;
		fondi[1] = this.saldoEUR;
		return fondi;
	}
	
	public String infoCassa() {
		double[] restanti = fondi();
		return "Euro in cassa:" + restanti[1] + "\nDollare in cassa: " + restanti[0];
	}
}
