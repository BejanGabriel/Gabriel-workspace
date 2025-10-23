package model;

import java.util.Date;

public class Cambio {
	static int contatore = 0;
	int id;
	double importo;
	Date data;
	
	public Cambio(double importo) {
		this.id = contatore++;
		this.importo = importo;
		this.data = new Date();
	}

	@Override
	public String toString() {
		return "Cambio [id=" + id + ", importo=" + importo + ", data=" + data + "]";
	}
}
