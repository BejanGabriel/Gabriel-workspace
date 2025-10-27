package model;

public class Conto {
	private static int contatore = 0;
	private int id;
	private String iban;
	private double saldo = 0;
	private Correntista correntista;
	
	public Conto(String iban, double saldo, Correntista correntista) {
		this.id = contatore++;
		this.iban = iban;
		this.correntista = correntista;
	}

	public String getIban() {
		return iban;
	}

	public double getSaldo() {
		return saldo;
	}

	public Correntista getCorrentista() {
		return correntista;
	}

	public String getInfoConto() {
		return "ID conto: " + id + ", iban: " + iban + ", saldo: " + saldo ;
	}
	
	public double deposita(double importo) {
		return saldo += importo;
	}
	
	public double preleva(double importo) {
		return saldo -= importo;
	}
	
}
