package model;

public enum CategoriaMerceologica {

	INFORMATICA("Informatica"),
	ALIMENTARE("Alimentare"),
	SERVIZI("Servizi"),
	EDILIZIA("Edilizia"),
	AUTOMOTIVE("Automotive"),
	LOGISTICA("Logistica"),
	ABBIGLIAMENTO("Abbigliamento");
	
	private String nome;
	
	private CategoriaMerceologica(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
