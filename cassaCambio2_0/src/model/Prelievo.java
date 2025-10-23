package model;

import java.util.Date;
// AGGIUNTA GABRIEL1
public class Prelievo {
	private int id;
	private double importoEuro;
	private Date data;
	
	public Prelievo(double importoEuro) {
		this.importoEuro = importoEuro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getImportoEuro() {
		return importoEuro;
	}

	public void setImportoEuro(double importoEuro) {
		this.importoEuro = importoEuro;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Prelievo [id=" + id + ", importoEuro=" + importoEuro + ", data=" + data + "]";
	}
	
}
