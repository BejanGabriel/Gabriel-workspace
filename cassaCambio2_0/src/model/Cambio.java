package model;

import java.util.Date;

public class Cambio {
	private int id;
	private double importoEur, importoUsd, tassoCambio;
	private Date data;
	
	public Cambio(double importoEur, double importoUsd, double tassoCambio) {
		this.importoEur = importoEur;
		this.importoUsd = importoUsd;
		this.tassoCambio = tassoCambio;
	}
	
	//AGGIUNTA GABRIEL
	public Cambio(double importoEur) {
		this.importoEur = importoEur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getImportoEur() {
		return importoEur;
	}

	public double getImportoUsd() {
		return importoUsd;
	}

	public double getTassoCambio() {
		return tassoCambio;
	}

	public Date getData() {
		return data;
	}

	@Override
	public String toString() {
		return "\nCambio [id=" + id + ", importoEur=" + importoEur + ", importoUsd=" + importoUsd + ", tassoCambio="
				+ tassoCambio + "]"; 
	}
	
	
	
}
