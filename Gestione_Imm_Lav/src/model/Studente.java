package model;

public class Studente implements Comparable<Studente> {
	private static int contatore = 0;
	private int id;
	private String nome;
	private String cognome;
	private String codFiscale;
	private String corsoIscritto;


	public Studente(String nome, String cognome, String codFiscale, String corsoIscritto) {
		this.id = contatore++;
		this.nome = nome;
		this.cognome = cognome;
		this.codFiscale = codFiscale;
		this.corsoIscritto = corsoIscritto;

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

	public String getCorsoIscritto() {
		return corsoIscritto;
	}



	public String getInfoStudente() {
		return "\nNome: " + nome + "\nCognome: " + "\nCodice Fiscale: " + codFiscale + "\nIscritto al corso:  "
				+ corsoIscritto;
	}

	// aggiungere la possibilita di poter vedere i corsi a cui lo studente è scritto
	// quando si visualizza getInfoStudente()

	@Override
	public int compareTo(Studente stud) {
		int confrontoCodFiscale = this.codFiscale.compareTo(stud.getCodFiscale());
		if (confrontoCodFiscale == 0) {
		}
		return confrontoCodFiscale;
	}

}