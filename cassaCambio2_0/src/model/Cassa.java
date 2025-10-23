package model;

public class Cassa {
	private String nome;
	private double fondoDollari = 0.0;
	private double saldoEur;
	private static final double TASSO_CAMBIO = 0.85;

	public Cassa(String nome, double fondoDollari) {
		this.nome = nome;
		this.fondoDollari = fondoDollari;
		this.saldoEur = saldoEur;
	}

	public String getNome() {
		return nome;
	}

	public double getFondoDollari() {
		return fondoDollari;
	}

	public void setFondoDollari(double fondoDollari) {
		this.fondoDollari = fondoDollari;
	}

	public double getSaldoEur() {
		return saldoEur;
	}

	public void setSaldoEur(double saldoEur) {
		this.saldoEur = saldoEur;
	}

	public static double getTassoCambio() {
		return TASSO_CAMBIO;
	}

	public boolean aggiungiDollari(double importo) {
		if (importo > 0) {
			this.fondoDollari += importo;
			return true;
		}
		return false;
	}
	
	//AGGIUNTA GABRIEL
	public boolean verificaDispoEuro(double importoEuro) {
		if(this.saldoEur >= importoEuro) {
			return true;
		}
		return false;
	}
	

	public Cambio eseguiCambio(double importoEuro) {
		double dollariDaScambiare = importoEuro / TASSO_CAMBIO;
		if (dollariDaScambiare <= fondoDollari) {
			this.fondoDollari -= dollariDaScambiare;
			this.saldoEur += importoEuro;
			return new Cambio(importoEuro, dollariDaScambiare, TASSO_CAMBIO);
		}
		return null;
	}
	
	public boolean verificaDispo(double importoEuro) {
		double dollariNecessari = importoEuro / TASSO_CAMBIO;
		if(fondoDollari >= dollariNecessari) {
			return true;
		}
		return false;
	}

	public String getInfoCassa() {
		return "Cassa: " + nome + "\nFondo Dollari: " + fondoDollari + "\nFondo Euro: " + saldoEur;
	}

	//AGGIUNTA GABRIEL
	public Prelievo eseguiPrelievo(double importoEuro) {
		double euroDaPrelevare = importoEuro;
		if(euroDaPrelevare <= saldoEur) {
			this.saldoEur -= euroDaPrelevare;
			return new Prelievo(euroDaPrelevare);
		}
		return null;
	}

}
