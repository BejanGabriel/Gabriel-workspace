package model;

public enum TipologiaCliente {
	CLIENTEFIDELIZZATO("Cliente Fidelizzato"),
	NUOVOCLIENTE("Nuovo Cliente"),
	PREMIUM("Premium"),
	INACQUISIZIONE("In acquisizione"),
	PROSPECT("Prospect");
	
	private String nome;

	private TipologiaCliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	
}
