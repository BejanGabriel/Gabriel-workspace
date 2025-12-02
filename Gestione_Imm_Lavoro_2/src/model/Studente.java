package model;

public class Studente implements Comparable<Studente>{
	private static int CONTATORE = 0;
	private Integer id;
	private String nome;
	private String cognome;
	private String codFiscale;
	private String codCorsoIscritto;
	public Studente(Integer id, String nome, String cognome, String codFiscale, String codCorsoIscritto) {
		this.id = CONTATORE++;
		this.nome = nome;
		this.cognome = cognome;
		this.codFiscale = codFiscale;
		this.codCorsoIscritto = codCorsoIscritto;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getCodFiscale() {
		return codFiscale;
	}
	public String getCodCorsoIscritto() {
		return codCorsoIscritto;
	}
	@Override
	public int compareTo(Studente altro) {
		return this.codFiscale.compareTo(altro.getCodFiscale());
	}
	
	
}
